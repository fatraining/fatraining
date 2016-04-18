package training2016.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.AreaDao;
import training2016.dao.RestaurantDao;
import training2016.model.Restaurant;

@Result(name = "search", value = "restaurantSearch.action", type = ServletRedirectResult.class)
public class RestaurantUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "いい店教えてクレメンス";

	/** 店舗名 */
	private String name;
	/** 店舗エリア */
	private String area;
	/** 検索結果マップ */
	private Map<String, String> areaMap;
	/** 店舗評価 */
	private String stars;
	/** コメント */
	private String comment;

	/** エラーメッセージ */
	private String errorMsg;

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	public String execute() throws Exception {
		this.setAreaMap();
		return "success";
	}

	/**
	 * insertメソッド。
	 * 画面の初期表示に戻す。
	 *
	 * @return 結果
	 */
	public String insert() {
		this.setAreaMap();

		// 未入力の項目があるときにエラーを返す
		if (!this.isValidate()) {
			this.errorMsg = "全項目入力してください。";
			return "error";
		}

		RestaurantDao dao = new RestaurantDao();
		dao.save(this.generateRestaurantModel());

		return "search";
	}

	/**
	 * 今フィールドに保持している値でRestaurantModelを生成して返す
	 *
	 * @return restaurant
	 */
	private Restaurant generateRestaurantModel() {
		Restaurant model = new Restaurant();
		model.setName(this.name);
		model.setStars(Short.parseShort(this.stars));
		model.setComment(this.comment);
		model.setAreaId(Integer.parseInt(this.area));
		Date registerDate = new Date();
		model.setCreateUser(this.getUserId());
		model.setCreateDate(new Timestamp(registerDate.getTime()));
		model.setUpdateUser(this.getUserId());
		model.setUpdateDate(new Timestamp(registerDate.getTime()));

		return model;
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 * @return 無問題ならtrue、ダメならfalse
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(this.name) ||
				StringUtils.isEmpty(this.area) ||
				StringUtils.isEmpty(this.stars) ||
				StringUtils.isEmpty(this.comment)) {
			return false;
		}
		return true;
	}

	/**
	 * DBから取得したエリア情報を元に
	 * プルダウン用エリアマップを作成してセットする
	 */
	private void setAreaMap() {
		AreaDao dao = new AreaDao();
		this.areaMap = dao.getAll().stream().collect(
			() -> new HashMap<String, String>(),
			(map, area) -> map.put(String.valueOf(area.getId()), area.getName()),
			(map, area) -> map.putAll(map)
		);
		// エリア未選択時用
		this.areaMap.put("", "エリアを選択する");
	}

	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * areaを返す
	 *
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * areaをセットする
	 *
	 * @param area セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * areaMapを返す
	 *
	 * @return areaMap
	 */
	public Map<String, String> getAreaMap() {
		return this.areaMap;
	}

	/**
	 * scoreとしてstarsを返す
	 *
	 * @return stars
	 */
	public String getScore() {
		return this.stars;
	}

	/**
	 * scoreをstarsにセットする
	 *
	 * @param score セットする score
	 */
	public void setScore(String score) {
		this.stars = score;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * commentをセットする
	 *
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * errorMsgを返す
	 *
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

}
