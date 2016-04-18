package training2016.model;

import java.util.function.BiPredicate;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;

/**
 * 飲食店検索条件モデル
 *
 * @author harasan
 */
public class RestaurantSearchCondition extends AbstractSearchCondition {

	private String id;
	private String name;
	private String areaId;
	private String stars;

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 *
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * areaIdを返す
	 *
	 * @return areaId
	 */
	public String getAreaId() {
		return this.areaId;
	}

	/**
	 * areaIdをセットする
	 *
	 * @param areaId セットする areaId
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * starsを返す
	 *
	 * @return stars
	 */
	public String getStars() {
		return this.stars;
	}

	/**
	 * starsをセットする
	 *
	 * @param stars セットする stars
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}

	/**
	 * 検索条件が一つでもセットされていればtrue
	 */
	@Override
	public boolean hasCondition() {
		return this.hasId() || this.hasName() || this.hasAreaId() || this.hasStars();
	}

	/**
	 * クエリ文字列を組み立てて返す
	 */
	@Override
	public String generateQueryString() {
		StringBuilder sb = new StringBuilder();

		// テーブル名（対応するモデルを完全修飾名で記述）
		sb.append(" from training2016.model.Restaurant as restaurant left join fetch restaurant.area ");

		// 条件がセットされてればwhere句以降も生成する
		if (this.hasCondition()) {
			sb.append(" where ");
		} else {
			return sb.toString();
		}

		// andをつける必要があるか判定するために一旦保存
		// もしここで対比した文字列長より長くなっていれば、複数条件なのでAndが必要
		int qStrLen = sb.length();
		// 長さ判定用関数型インターフェース
		BiPredicate<Integer, Integer> isNeedAnd = (q1, q2) -> q1 < q2;

		// クエリ文字列を組み立てる
		// クエリ文字列は関数型インターフェースで渡す
		// ID
		this.appendQueryString(this.id,
								sb,
								isNeedAnd.test(qStrLen, sb.length()),
								param -> param != null && param.length() > 0,
								() -> " id = :id ");

		// 店名
		this.appendQueryString(this.name,
								sb,
								isNeedAnd.test(qStrLen, sb.length()),
								param -> param != null && param.length() > 0,
								() -> " name like :name ");

		// エリアID
		this.appendQueryString(this.areaId,
								sb,
								isNeedAnd.test(qStrLen, sb.length()),
								param -> param != null && param.length() > 0,
								() -> " area_id = :areaId ");

		// 星の数（評価）
		this.appendQueryString(this.stars,
								sb,
								isNeedAnd.test(qStrLen, sb.length()),
								param -> param != null && param.length() > 0,
								() -> " stars = :stars ");

		return sb.toString();
	}

	/**
	 * クエリパラメータをセットして返す
	 *
	 * @param Query クエリオブジェクト
	 * @return Query クエリパラメータをセットしたクエリオブジェクト
	 */
	@Override
	public Query setQueryParams(Query query) {
		if (this.hasId()) {
			query.setInteger("id", Integer.parseInt(this.id));
		}
		if (this.hasName()) {
			query.setString("name", this.name);
		}
		if (this.hasAreaId()) {
			query.setInteger("areaId", Integer.parseInt(this.areaId));
		}
		if (this.hasName()) {
			query.setInteger("stars", Integer.parseInt(this.stars));
		}
		return query;
	}

	/**
	 * IDがセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasId() {
		return this.id != null;
	}

	/**
	 * 名称がセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasName() {
		return StringUtils.isNotEmpty(this.name);
	}

	/**
	 * エリアIDがセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasAreaId() {
		return this.areaId != null;
	}

	/**
	 * 星がセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasStars() {
		return this.stars != null;
	}
}
