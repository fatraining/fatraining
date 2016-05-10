package training2016.model;

import org.apache.commons.lang3.StringUtils;

import training2016.annotations.ArrayCondition;
import training2016.annotations.SimpleCondition;
import training2016.annotations.ToInteger;
import training2016.annotations.ToString;

/**
 * 飲食店検索条件モデル
 *
 * @author harasan
 */
public class RestaurantSearchCondition extends AbstractSearchCondition {

	@ToInteger
	@SimpleCondition(name="id", operator="=")
	private String id;

	@ToInteger
	@ArrayCondition(name="id", operator="=")
	private String[] ids;

	@ToString
	@SimpleCondition(name="name", operator="=")
	private String name;

	@ToInteger
	@SimpleCondition(name="areaId", operator="=")
	private String areaId;

	@ToInteger
	@SimpleCondition(name="stars", operator="=")
	private String stars;

	/**
	 * コンストラクタ
	 */
	public RestaurantSearchCondition() {
		super(Restaurant.class);
	}

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
	 * idsを返す
	 *
	 * @return ids
	 */
	public String[] getIds() {
		return this.ids;
	}

	/**
	 * idsをセットする
	 *
	 * @param ids セットする ids
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
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
		return this.hasId() || this.hasIds() || this.hasName() || this.hasAreaId() || this.hasStars();
	}

	/**
	 * join fetchするのでこちらから返す
	 *
	 * @return 検索対象文字列
	 */
	@Override
	protected String generateTableName() {
		return  modelClass.getName() +
				" as " +
				modelClass.getSimpleName().toLowerCase() +
				" left join fetch restaurant.area";
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
	 * IDSがセットされているか
	 *
	 * @return されていればtrue
	 */
	private boolean hasIds() {
		return this.ids != null && this.ids.length > 0;
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
