package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.AreaDao;
import training2016.dao.RestaurantDao;
import training2016.model.Restaurant;
import training2016.model.RestaurantSearchCondition;

@Result(name = "update", value = "restaurantUpdate.action", type = ServletRedirectResult.class)
public class RestaurantSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "お酒飲ませてクレメンス";

	/** 店舗名 */
	private String name;
	/** 店舗エリア */
	private String area;
	/** 検索結果マップ */
	private Map<String, String> areaMap;
	/** 店舗評価 */
	private String stars;
	/** 削除ID */
	private String[] deleteId;
	/** エラーメッセージ */
	private String errorMsg;
	/** 検索結果リスト */
	private List<Restaurant> resultList;


	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	@Override
	public String execute() {
		this.fieldInit();
		return "success";
	}

	/**
	 * resetメソッド。
	 * 画面の初期表示に戻す。
	 *
	 * @return 結果
	 */
	public String reset() {
		this.fieldInit();
		return "success";
	}

	private void fieldInit() {
		this.name  = "";
		this.area  = "";
		this.stars = "";
		this.setAreaMap();
	}

	/**
	 * 検索ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String search() {
		RestaurantDao dao = new RestaurantDao();

		if (StringUtils.isEmpty(this.name)
			&& StringUtils.isEmpty(this.area)
			&& StringUtils.isEmpty(this.stars)) {
			this.resultList = dao.getAll();
		} else {
			RestaurantSearchCondition cond = new RestaurantSearchCondition();
			cond.setName(this.name);
			cond.setAreaId(this.area);
			cond.setStars(this.stars);
			this.resultList = dao.getByCondition(cond);
		}

		// 作っとく
		this.setAreaMap();

		return "success";
	}

	/**
	 * 追加ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String update() {
		this.sessionMap.put("delete_id", null);
		return "update";
	}

	/**
	 * 削除ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String delete_id() {
		this.sessionMap.put("deleteId", this.deleteId);

		if (this.deleteId != null && this.deleteId.length == 0) {
			return "update";
		}else{
			return "error";
		}
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
		this.areaMap.put("", "");
	}

	/**
	 * エリアマップを返す
	 *
	 * @return エリアマップ
	 */
	public Map<String, String> getAreaMap() {
		return this.areaMap;
	}

	/**
	 * エラーメッセージを返す
	 *
	 * @return エラーメッセージ
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

	/**
	 * 画面タイトルを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 店舗名を返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 店舗名をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 店舗エリアを返す
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * 店舗エリアをセットする
	 * @param area セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 店舗評価を返す
	 * @return stars
	 */
	public String getStars() {
		return this.stars;
	}

	/**
	 * 店舗評価をセットする
	 * @param stars セットする stars
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}

	/**
	 * 削除IDを返す
	 * @return deleteId
	 */
	public String[] getDeleteId() {
		return this.deleteId;
	}

	/**
	 * 削除IDをセットする
	 * @param deleteId セットする deleteId
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	/**
	 * 検索結果リストを返す
	 * @return resultList
	 */
	public List<Restaurant> getResultList() {
		return this.resultList;
	}
}
