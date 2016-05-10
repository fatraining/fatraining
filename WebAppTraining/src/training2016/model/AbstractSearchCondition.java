/**
 *
 */
package training2016.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.hibernate.Query;

import training2016.annotations.ArrayCondition;
import training2016.annotations.SimpleCondition;
import training2016.annotations.ToInteger;
import training2016.annotations.ToString;

/**
 * 検索条件モデルの抽象クラス
 * @author harasan
 */
public abstract class AbstractSearchCondition {

	/**
	 * 対応するモデル名（完全修飾名）=テーブル名に使われる
	 */
	protected Class<?> modelClass;

	/**
	 * コンストラクタ。テーブル名をセットする。<br>
	 * サブクラスでは、このコンストラクタで検索対象モデルのクラスをセットすること
	 */
	public <C> AbstractSearchCondition(Class<C> cls) {
		this.modelClass = cls;
	}

	/**
	 * 検索条件が一つでもセットされていればtrueを返すよう実装すること
	 */
	public abstract boolean hasCondition();

	/**
	 * 検索条件用のモデル名(テーブル名ではない)を返す。
	 * もしjoin fetch等したい場合、オーバーライドしてそちらから返すこと
	 *
	 * @return モデル名
	 */
	protected String generateTableName() {
		return  this.modelClass.getName() + " as " + this.modelClass.getSimpleName().toLowerCase();
	}

	/**
	 * クエリ文字列を組み立てて返す<br>
	 * シンプルな検索条件しか組み立てられないので、<br>
	 * From-To条件など作りたい場合はオーバーライドすること
	 */
	public String generateQueryString() {
		StringBuilder sb = new StringBuilder();

		// テーブル名（対応するモデルを完全修飾名で記述）
		sb.append(" from " + this.generateTableName());

		// カラム名の接頭辞
		String columnPrefix = this.modelClass.getSimpleName().toLowerCase();

		// 条件がセットされてればwhere句以降も生成する
		if (this.hasCondition()) {
			sb.append(" where ");
		} else {
			return sb.toString();
		}

		// andをつける必要があるか判定するために一旦保存
		// もしここで比較した文字列長より長くなっていれば、複数条件なのでAndが必要
		final int qStrLen = sb.length();
		// 長さ判定用関数型インターフェース
//		BiPredicate<Integer, Integer> isNeedAnd = (q1, q2) -> q1 < q2;

		// 条件がセットされている場合の処理
		// フィールドのリストを取得してループしながら条件を組み立てる
		Arrays.stream(this.getClass().getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true);
				// RetentionPolicy.RUNTIME以外だとここがnullになる
				if(f.getAnnotation(SimpleCondition.class) != null){
					sb.append(this.generateSimpleValueQueryString(f, columnPrefix, qStrLen, sb.length()));
				} else 	if(f.getAnnotation(ArrayCondition.class) != null){
					sb.append(this.generateMultiValueQueryString(f, columnPrefix, qStrLen, sb.length()));
				}
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
				// ここでは特に何もしない
			}
		});
		return sb.toString();
	}

	/**
	 * 単一カラムに対して、単一の値を条件とするクエリ文字列を生成する
	 *
	 * @param f
	 * @param columnPrefix
	 * @param qStrLen
	 * @param sbLen
	 * @return
	 * @throws IllegalAccessException
	 */
	private String generateSimpleValueQueryString(Field f, String columnPrefix,
					int qStrLen, int sbLen) throws IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		final SimpleCondition element =
				f.getAnnotation(SimpleCondition.class);
		// クエリ文字列を組み立てる
		// クエリ文字列は関数型インターフェースで渡す
		this.appendQueryString((String)f.get(this),
								sb,
								qStrLen < sbLen,
								this.getEmptyTester(),
								() -> " " + columnPrefix + "." + element.name() + " " + element.operator() + " :" + element.name() + " ");
		return sb.toString();
	}

	/**
	 * 単一カラムに対して、複数の値を条件とする(in句)クエリ文字列を生成する
	 *
	 * @param f
	 * @param columnPrefix
	 * @param qStrLen
	 * @param sbLen
	 * @return
	 * @throws IllegalAccessException
	 */
	private String generateMultiValueQueryString(Field f, String columnPrefix,
					int qStrLen, int sbLen) throws IllegalAccessException {
		StringBuilder sb = new StringBuilder();
		final ArrayCondition element =
				f.getAnnotation(ArrayCondition.class);
		// クエリ文字列を組み立てる
		// クエリ文字列は関数型インターフェースで渡す
		this.appendQueryString((String[])f.get(this),
								sb,
								qStrLen < sbLen,
								this.getEmptyArrayTester(),
								(array) -> {
									StringBuilder query = new StringBuilder(" " + columnPrefix + "." + element.name() + " in (");
									int queryLength = query.length();
									for (int i = 0; i < array.length; i++) {
										if (query.length() > queryLength) {
											query.append(",");
										}
										query.append(":" + element.name() + "_" + i);
									}
									query.append(") ");
									return query.toString();
								}
							);
		return sb.toString();
	}

	/**
	 * クエリパラメータをセットする<br>
	 * シンプルな検索条件にしか対応していないので、<br>
	 * From-To条件など作りたい場合はオーバーライドすること
	 */
	public Query setQueryParameters(Query query) {
		Arrays.stream(this.getClass().getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true);
				if(f.getAnnotation(SimpleCondition.class) != null){
					this.setSimpleValueParameter(f, query);
				} else 	if(f.getAnnotation(ArrayCondition.class) != null){
					this.setMultiValueParameter(f, query);
				}
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
				// ここでは特に何もしない
			}
		});
		return query;
	}

	/**
	 * 単一のパラメータをセットする
	 *
	 * @param f
	 * @param q
	 * @throws IllegalAccessException
	 */
	private void setSimpleValueParameter(Field f, Query q) throws IllegalAccessException {
		final SimpleCondition element =
				f.getAnnotation(SimpleCondition.class);
		String value = (String)f.get(this);
		if(f.getAnnotation(ToString.class) != null &&
			this.getEmptyTester().test(value)) {
			// クエリ文字列を組み立てる
			if (element.fuzzy()) {
				q.setString(element.name(), "%" + value + "%");
			} else {
				q.setString(element.name(), value);
			}
		} else if (f.getAnnotation(ToInteger.class) != null &&
			 this.getEmptyTester().test(value)) {
			// クエリ文字列を組み立てる
			q.setInteger(element.name(), Integer.parseInt(value));
		}
	}

	/**
	 * in句で使用される複数のパラメータをセットする
	 *
	 * @param f
	 * @param q
	 * @throws IllegalAccessException
	 */
	private void setMultiValueParameter(Field f, Query q) throws IllegalAccessException {
		final ArrayCondition element =
				f.getAnnotation(ArrayCondition.class);
		String[] value = (String[])f.get(this);
		if(f.getAnnotation(ToString.class) != null &&
			this.getEmptyArrayTester().test(value)) {
			// クエリ文字列を組み立てる
			for (int i = 0; i < value.length; i++) {
				q.setString(element.name() + "_" + i, value[i]);
			}
		} else if (f.getAnnotation(ToInteger.class) != null &&
			 this.getEmptyArrayTester().test(value)) {
			// クエリ文字列を組み立てる
			for (int i = 0; i < value.length; i++) {
				q.setInteger(element.name() + "_" + i, Integer.parseInt(value[i]));
			}
		}
	}

	/**
	 * 文字列が空か検証する関数型インターフェースを返す
	 *
	 * @return Predicate<String>
	 */
	private Predicate<String> getEmptyTester() {
		return param -> param != null && param.length() > 0;
	}

	/**
	 * 配列が空か検証する関数型インターフェースを返す
	 *
	 * @return Predicate<String>
	 */
	private Predicate<String[]> getEmptyArrayTester() {
		return param -> param != null && param.length > 0;
	}

	/**
	 * 値を持っていることをさすフラグがtrueなら<br>
	 * 引数で渡された関数型インターフェースの結果をStringBuilderにappendする
	 *
	 * @param p パラメータ
	 * @param sb StringBuilder
	 * @param isNeedAnd andが必要か
	 * @param pred パラメータがセットされているかチェックする関数型インターフェース
	 * @param queryString クエリ文字列を返す関数型インターフェース
	 */
	public <P> void appendQueryString(P p, StringBuilder sb, boolean isNeedAnd, Predicate<P> pred, Supplier<String> queryString) {
		if (pred.test(p)) {
			if (isNeedAnd) {
				sb.append(" and ");
			}
			sb.append(queryString.get());
		}
	}

	/**
	 * 値を持っていることをさすフラグがtrueなら<br>
	 * 引数で渡された関数型インターフェースの結果をStringBuilderにappendする
	 *
	 * @param p パラメータ配列
	 * @param sb StringBuilder
	 * @param isNeedAnd andが必要か
	 * @param pred パラメータ配列がセットされているかチェックする関数型インターフェース
	 * @param queryString クエリ文字列を返す関数型インターフェース
	 */
	public <P> void appendQueryString(P[] p, StringBuilder sb, boolean isNeedAnd, Predicate<P[]> pred, Function<P[], String> queryString) {
		if (pred.test(p)) {
			if (isNeedAnd) {
				sb.append(" and ");
			}
			sb.append(queryString.apply(p));
		}
	}
}
