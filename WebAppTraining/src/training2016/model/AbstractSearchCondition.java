/**
 *
 */
package training2016.model;

import java.util.function.Predicate;
import java.util.function.Supplier;

import org.hibernate.Query;

/**
 * 検索条件モデルの抽象クラス
 * @author harasan
 */
public abstract class AbstractSearchCondition {

	/**
	 * 検索条件が一つでもセットされていればtrueを返すよう実装すること
	 */
	public abstract boolean hasCondition();

	/**
	 * クエリを組み立てて返す
	 */
	public abstract String generateQueryString();

	/**
	 * クエリパラメータをセットする
	 */
	public abstract Query setQueryParams(Query query);

	/**
	 * 値を持っていることをさすフラグがtrueなら<br>
	 * 引数で渡された関数をStringBuilderにappendする
	 *
	 * @param p パラメータ
	 * @param sb StringBuilder
	 * @param isNeedAnd andが必要か
	 * @param pred パラメータがセットされているかチェックする関数型インターフェース
	 * @param queryString クエリ文字列を返す関数型インターフェース
	 */
	public <P> void appendQueryString(P p, StringBuilder sb, boolean isNeedAnd, Predicate<P> pred, Supplier<String> queryString) {
		if (pred.test(p)) {
			sb.append(queryString.get());
			if (isNeedAnd) {
				sb.append(" and ");
			}
		}
	}
}
