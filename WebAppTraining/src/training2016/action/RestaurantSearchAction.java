package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.annotations.ActionField;
import training2016.dao.AreaDao;
import training2016.dao.RestaurantDao;
import training2016.model.Restaurant;
import training2016.model.RestaurantSearchCondition;

/**
 * 飲み屋検索Action
 *
 * @author harasan
 */
@Results({
	@Result(name = "update", value = "restaurantUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value = "restaurantDelete.action", type = ServletRedirectResult.class)
})
public class RestaurantSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "お酒クレメンス";

	/** 店舗名 */
	@ActionField(name="name")
	private String name;
	/** 店舗エリア */
	@ActionField(name="area")
	private String area;
	/** 検索結果マップ */
	private Map<String, String> areaMap;
	/** 店舗評価 */
	@ActionField(name="stars")
	private String stars;
	/** 更新ID */
	private String updateId;
	/** 削除ID */
	private String[] deleteId;
	/** 検索結果リスト */
	private List<Restaurant> resultList;

	// イニシャライザ
	{
		this.setAreaMap();
	}

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

	/**
	 * フィールド初期化
	 */
	private void fieldInit() {
		this.name  = "";
		this.area  = "";
		this.stars = "";
		this.setIsSearched(false);
	}

	/**
	 * 検索ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String search() {
		this.doSearch();
		return "success";
	}

	/**
	 * 検索を行う。
	 */
	private void doSearch() {
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
		this.setIsSearched(true);
	}

	/**
	 * 追加ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String update() {
		this.putValueToSession("updateId", this.updateId);
		// 退避
		this.backUp(this);
		return "update";
	}

	/**
	 * 削除ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String delete() {
		if (this.deleteId != null && this.deleteId.length > 0) {
			this.sessionMap.put("deleteId", this.deleteId);
			// 退避
			this.backUp(this);
			return "delete";
		}else{
			this.addActionError("削除のとこ一つくらいはチェック入れないと");
			return "error";
		}
	}

	/**
	 * 画面再描画。
	 * リセットではなく、他画面から戻ってくる時に呼び出す。
	 *
	 * @return
	 */
	public String redisplay() {
		// 退避
		this.restore(this);
		if (this.getIsSearched()) {
			this.doSearch();
		}
		return "success";
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
	 * エリアマップを返す
	 *
	 * @return エリアマップ
	 */
	public Map<String, String> getAreaMap() {
		return this.areaMap;
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
	 * 更新IDを返す
	 * @return updateId
	 */
	public String getUpdateId() {
		return this.updateId;
	}

	/**
	 * 更新IDをセットする
	 * @param updateId セットする updateId
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
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
