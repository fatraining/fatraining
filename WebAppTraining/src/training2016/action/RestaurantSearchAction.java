package training2016.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

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
	}

	/**
	 * 検索ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String search() {
		// インスタンス化
		RestaurantDao dao = new RestaurantDao();

		if (StringUtils.isEmpty(this.name)
			&& StringUtils.isEmpty(this.area)
			&& StringUtils.isEmpty(this.stars)) {
			this.resultList = dao.getAll();
		} else {
			RestaurantSearchCondition cond = new RestaurantSearchCondition();
			cond.setName(this.name);
			cond.setAreaId(Integer.parseInt(this.area));
			cond.setStars(Integer.parseInt(this.stars));
			this.resultList = dao.getByCondition(cond);
		}

		return "success";
	}

	/**
	 * 追加ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("restaurantUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	/**
	 * 削除ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String delete_id() {
		this.sessionMap.put("deleteId", this.deleteId);

		if (this.deleteId != null && this.deleteId.length == 0) {
			try {
				this.response.sendRedirect("restaurantUpdate.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}else{
			return "error";
		}
	}

	/**
	 * エラーメッセージを返す
	 *
	 * @return エラーメッセージ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 画面タイトルを返す
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 店舗名を返す
	 * @return name
	 */
	public String getName() {
		return name;
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
		return area;
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
		return stars;
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
		return deleteId;
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
		return resultList;
	}
}
