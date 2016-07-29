package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.AquariumDao;
import training2016.model.Aquarium;
import training2016.model.AquariumArea;

@Results({
	@Result(name = "update", value ="aquariumUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="aquariumDelete.action", type = ServletRedirectResult.class)
})

public class AquariumSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "水族館検索";

	/**ブラウザからの入力項目*/

	/*エリア*/
	private String area;

	/*水族館名*/
	private String name;

	/*入場料*/
	private String price;

	/*削除ID*/
	private String delete;

	/*更新ID*/
	private String updateId;

	/*エリアプルダウン用マップ*/
	private Map<String,String> aquariumAreaMap = new HashMap<String,String>();
	/*入場料プルダウン用マップ*/
	private Map<String, String> priceMap = new LinkedHashMap<String, String>();
	/*検索リスト*/
	public ArrayList<Aquarium> aquariumTable = new ArrayList<Aquarium>();

	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// イニシャライザ
	{
		this.setAquariumAreaMap();
	}


	/*初期値の設定*/
	private String getDefaultArea() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultPrice() {
		return "";
	}

	/*executeメソッド*/
	@Override
	public String execute() {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.price = getDefaultPrice();
		this.setAquariumAreaMap();
		this.setPriceMap();
		return "success";
	}

	/*リセットボタンを押したとき*/
	public String reset () {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.price = getDefaultPrice();
		this.setAquariumAreaMap();
		this.setPriceMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	public String search() {
		AquariumDao Dao = new AquariumDao();
		List<?> resultTable = null;  //ワイルドカード
		if(StringUtils.isEmpty(area) &&
		   StringUtils.isEmpty(name) &&
		   StringUtils.isEmpty(price)) {
			resultTable = Dao.aquariumList(); //nullのとき
		} else {
			area = this.area.trim();
			name = this.name.trim();
			price = this.price.trim();
			resultTable = Dao.resultList(area, name, price); //条件あり
		}
		this.sessionMap.put("message", null);
		this.aquariumTable.addAll(resultTrans(resultTable));
		this.setAquariumAreaMap();
		this.setPriceMap();
		this.setDelete("true");  //消してみても大丈夫かも
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Aquarium> resultTrans(List<?> resultTable) {
		ArrayList<Aquarium> tempTable = new ArrayList<Aquarium>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Aquarium temp = new Aquarium();
				obj = (Object[]) resultTable.get(i);
				Aquarium a = (Aquarium) obj[0];
				AquariumArea aa = (AquariumArea) obj[1];
				temp.setId(a.getId());
				temp.setAquariumAreaId(a.getAquariumAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setPrice(a.getPrice());
				temp.setHours(a.getHours());
				temp.setComment(a.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/*追加ボタンを押したとき*/
	public String update() {
		//セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("aquariumUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならaquariumDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("aquariumDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*setter・getter*/
	/**
	 * エリアをセットする
	 * @param area セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * エリアを返す
	 * @return area
	 */
	public String getArea(){
		return this.area;
	}

	/**
	 * 水族館名をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 水族館名を返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 入場料をセットする
	 * @param price セットする price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 入場料を返す
	 * @return price
	 */
	public String getPrice() {
		return this.price;
	}

	/**
	 * 削除idをsetする
	 * @param delete セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * 削除idを返す
	 * @return delete
	 */
	public String getDelete() {
		return this.delete;
	}

	/**
	 * 更新idをセットする
	 * @param updateId セットする update
	 */
	public void setUpdateId(String updateId) {

		this.updateId = updateId;
	}

	/**
	 * 更新idを返す
	 * @return update
	 */
	public String getUpdateId() {
		return this.updateId;
	}

	/**
	 * 画面タイトルを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * エリアマップを返す
	 * @return AquariumAreaMap
	 */
	public Map<String, String> getAquariumAreaMap() {
		return this.aquariumAreaMap;
	}

	/**
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setAquariumAreaMap() {
		AquariumDao dao = new AquariumDao();
		List<?> resultTable = dao.getAquariumAreaList();
		this.aquariumAreaMap = tableTrans(resultTable);
	}

	/**
	 * 入場料マップを返す
	 * @return priceMap
	 */
	public Map<String, String> getPriceMap() {
		return this.priceMap;
	}

	/**
	 * 入場料プルダウン用マップをセットする
	 *
	 */
	public void setPriceMap() {
		this.priceMap.put("", "");
		this.priceMap.put("300", "300円");
		this.priceMap.put("500", "500円");
		this.priceMap.put("1000", "1000円");
		this.priceMap.put("1200", "1200円");
		this.priceMap.put("1400", "1400円");
		this.priceMap.put("1600", "1600円");
		this.priceMap.put("1800", "1800円");
		this.priceMap.put("2800", "2800円");
		this.priceMap.put("3000", "3000円");
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			aquariumAreaMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				AquariumArea aa = (AquariumArea) resultTable.get(i);
				aquariumAreaMap.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aquariumAreaMap;
	}

}
