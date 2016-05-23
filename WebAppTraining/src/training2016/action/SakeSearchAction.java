package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SakeinfoDao;
import training2016.model.Sakearea;
import training2016.model.Sakeinfo;

@Result(name = "update", value = "updateSake", type = ServletRedirectResult.class)
public class SakeSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル **/
	private String title = "渋谷の美味しい日本酒のお店検索";

	// ブラウザからの入力項目
	/*------------------------------------------------------*/
	private String area;
	private String price;

	/** 削除ID */
	private String delete;

	/** エリアプルダウン用マップ */
	private Map<String, String> areaMap;

	/** 予算プルダウン用マップ */
	private Map<String, String> priceMap = new LinkedHashMap<String, String>();

	/** 検索結果リスト */
	public ArrayList<Sakeinfo> resultTable = new ArrayList<Sakeinfo>();

	public String getUserID() {
		return (String) this.sessionMap.get("userID");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	// 初期値の設定
	/*------------------------------------------------------*/
	private String getDefaultArea() {
		return "";
	}

	private String getDefaultPrice() {
		return "";
	}

	// executeメソッド
	/*------------------------------------------------------*/
	@Override
	public String execute() {
		this.area = getDefaultArea();
		this.price = getDefaultPrice();
		this.setAreaMap();
		this.setPriceMap();
		return "success";
	}

	// リセット
	/*------------------------------------------------------*/
	public String reset() {
		this.area = getDefaultArea();
		this.price = getDefaultPrice();
		this.sessionMap.put("message", null);
		this.setAreaMap();
		this.setPriceMap();
		return "success";
	}

	// 検索ボタンを押したとき
	/*------------------------------------------------------*/
	public String search() {
		SakeinfoDao Dao = new SakeinfoDao();
		List<Sakeinfo> resultTable = null;
		/** フォームがnullの場合 */
		if (StringUtils.isEmpty(area) && StringUtils.isEmpty(price)) {
			resultTable = Dao.resultList(); // 検索結果を表示？？
		} else {
			area = this.area.trim();
			price = this.price.trim();
			resultTable = Dao.resultList(area, price);
		}
		this.sessionMap.put("message", null);
		this.resultTable.addAll(resultTrans(resultTable));
		this.setDelete("true");
		this.setAreaMap();
		this.setPriceMap();
		return "success";
	}

	// テーブルの作成
	/*------------------------------------------------------*/
	public ArrayList<Sakeinfo> resultTrans(List<?> resultTable) {
		ArrayList<Sakeinfo> tempTable = new ArrayList<Sakeinfo>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Sakeinfo temp = new Sakeinfo();
				obj = (Object[]) resultTable.get(i);
				Sakearea a = (Sakearea) obj[0];
				Sakeinfo in = (Sakeinfo) obj[1];
				temp.setId(in.getId());
				temp.setAreaId(in.getAreaId());
				temp.setArea(a.getArea());
				temp.setShopName(in.getShopName());
				temp.setHours(in.getHours());
				temp.setPrice(in.getPrice());
				temp.setRecommend(in.getRecommend());
				temp.setComment(in.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	// 追加ボタンを押したとき//
	/*------------------------------------------------------*/
	public String update() {
		this.sessionMap.put("deleteID", null);
		return "update";
	}

	// 削除ボタンクリック時、チェックありなら UpdateSakeAction へ飛ばす//
	/*------------------------------------------------------*/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);

		if (StringUtils.isEmpty(this.delete)) {
			addActionError("削除する店を選択してください");
			search();
			return "error";
		} else {
			return "update";
		}
	}

	// get,setメソッド
	/*------------------------------------------------------*/
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return areaMap
	 */
	public Map<String, String> getAreaMap() {
		return areaMap;
	}

	/**
	 * @param areaMap
	 *
	 */
	public void setAreaMap() {
		SakeinfoDao dao = new SakeinfoDao();
		List<?> resultTable = dao.getSakeareaList();
		this.areaMap = tableTrans(resultTable);
	}

	/**
	 * @return priceMap
	 */
	public Map<String, String> getPriceMap() {
		return priceMap;
	}

	/**
	 * @param priceMap セットする priceMap
	 */
	public void setPriceMap() {
		this.priceMap.put("","予算を選択");
		this.priceMap.put("3000円","3000円");
		this.priceMap.put("4000円","4000円");
		this.priceMap.put("5000円","5000円");
		this.priceMap.put("6000円","6000円");
		this.priceMap.put("7000円","7000円");
		this.priceMap.put("8000円","8000円");
	}

	/*------------------------------------------------------*/
	// エリアプルダウン用マップを返す //
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "エリアを選択");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Sakearea area = (Sakearea) resultTable.get(i);
				tempMap.put(area.getID(), area.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMap;
	}

}