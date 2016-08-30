package training2016.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.apache.struts2.dispatcher.StreamResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import training2016.dao.ShipDao;
import training2016.model.Country;
import training2016.model.Ships;
@Results({
@Result(name="search", value="inputStream", type=StreamResult.class),
@Result(name = "update", value = "updateShip.action", type = ServletRedirectResult.class)
})
public class ShipFinderAction extends AbstractAction {
	private static final long serialVersionUID = 1L;   /**出力したオブジェクトがどのクラスを元に作成されたのかを検証するための番号。*/

	/** 画面タイトル */
	private String title = "艦艇検索";
	/** 国ID */
	private String countryID;
	/** 国名 */
	private String countryName;
	/** 艦名 */
	private String shipName;
	/** クラス */
	private String shipClass;
	/** 画像へのパス */
	private String imagePath;
	/** 解体ID */
	private String delete;
	/** 国名プルダウン用マップ */
	private Map<String, String> countryMap;
	/** クラスプルダウン用マップ */
	private Map<String,String> shipClassMap = new LinkedHashMap<String, String>();  	/**マップの生成*/
	/** 検索結果リスト */
	public ArrayList<Ships> resultTable = new ArrayList<Ships>();

	/** JSON文字列返却用inputstream */
	private InputStream inputStream;

	/**セッションを設定*/
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMsg() {
		return (String) this.sessionMap.get("msg");
	}

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	/**fieldInitを実行される*/
	@Override
	public String execute() {
		this.fieldInit();
		return "success";
	}

//	/**
//	 * resetメソッド。 画面の初期表示に戻す。
//	 *JSであれこれやったんで不要になった。
//	 * @return 結果
//	 */
//	public String reset() {
//		this.fieldInit();
//		return "success";
//	}
	/**それぞれセットする*/
	private void fieldInit() {
		this.setCountryMap();
		this.setShipClassMap();
		this.countryID = "";
		this.shipName = "";
		this.shipClass = "";
	}

	// 検索ボタンを押したとき ↓↓
	/*------------------------------------------------------*/
	public String search() throws JsonProcessingException, UnsupportedEncodingException {
		ShipDao dao = new ShipDao();
		List<Ships> resultTable = null;
		/** フォームがnullの場合 */
		if (StringUtils.isEmpty(countryID) && StringUtils.isEmpty(shipName)
				&& StringUtils.isEmpty(shipClass)) {
			resultTable = dao.resultList();
		} else {
			countryID = this.countryID.trim();
			shipName = this.shipName.trim();
			shipClass = this.shipClass.trim();
			resultTable = dao.resultList(countryID, shipName, shipClass);
		}
		this.sessionMap.put("msg", null);
		this.resultTable.addAll(resultTrans(resultTable));
		this.setCountryMap();
		this.setShipClassMap();

		ObjectMapper mapper = new ObjectMapper();					//マッピング
		// resultTableをJSON形式にしてinputstreamに乗せる。			//json   テキストデータにする
		String json = mapper.writeValueAsString(resultTable);
		System.out.println(json);
		inputStream = new ByteArrayInputStream(json.getBytes("utf-8"));
		return "search";
	}

	// 選択されたフォームのパラメータをセットして返す
	/*------------------------------------------------------*/
	public ArrayList<Ships> resultTrans(List<?> resultTable) {
		ArrayList<Ships> tempTable = new ArrayList<Ships>();
		Object[] obj;
		try {
			for (int i=0; i < resultTable.size(); i++) {
				Ships temp = new Ships();
				obj = (Object[]) resultTable.get(i);
				Country c = (Country) obj[0];
				Ships s = (Ships) obj[1];
				temp.setShipID(s.getShipID());
				temp.setCountryID(s.getCountryID());
				temp.setCountryName(c.getCountryName());
				temp.setShipName(s.getShipName());
				temp.setShipClass(s.getShipClass());
				temp.setYear(s.getYear());
				temp.setComment(s.getComment());
				temp.setImagePath(s.getImagePath());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ShipFinderActionを見よ");
		}
		return tempTable;
	}

	// 追加ボタンを押したとき//
	/*------------------------------------------------------*/
	public String update() {
		this.sessionMap.put("deleteID", null);
		return "update";
	}

	// 解体ボタンクリック時、チェックありなら updateShip へ飛ばす//
	/*------------------------------------------------------*/
	public String delete() throws JsonProcessingException, UnsupportedEncodingException {
		this.sessionMap.put("deleteID", this.delete);										//deleteIDというキーでthis.deleteを呼び出す

		if (this.delete != null) {
			return "update";
		} else {
			addActionError("解体する項目を選択してください");								//addActionErrorでエラー用のメッセージを追加
			search();				//初期化されないようにする
			return "error";
		}
	}

	// get,setメソッド//↓↓
	/*------------------------------------------------------*/
	public String getCountryID() {
		return countryID;
	}
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipClass() {
		return shipClass;
	}

	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getTitle() {
		return this.title;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return countryMap
	 */
	public Map<String, String> getCountryMap() {
		return countryMap;
	}

	/**
	 * @param countryMap
	 *            セットする countryMap
	 */
	public void setCountryMap() {							//Countrymapにデータを格納
		ShipDao dao = new ShipDao();
		List<?> resultTable = dao.getCountryList();			//国のリストを取得しresultTableへ格納
		this.countryMap = tableTrans(resultTable);			//リストからマップに型を変える
	}


	/**
	 * @return shipClassMap
	 */
	public Map<String, String> getShipClassMap() {
		return shipClassMap;
	}

	/**
	 * @param shipClassMap セットする shipClassMap
	 */
	public void setShipClassMap() {							//ShipClassMapにデータを格納
		this.shipClassMap.put("","クラスを選択");
		this.shipClassMap.put("戦艦","戦艦");
		this.shipClassMap.put("空母","空母");
		this.shipClassMap.put("巡洋艦","巡洋艦");
		this.shipClassMap.put("駆逐艦","駆逐艦");
	}
	/*------------------------------------------------------*/
	// 国名プルダウン用マップを返す //
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {				//resultTable(リスト)をmap型にtrans
		Map<String, String> tempMap = new LinkedHashMap<String, String>();       //tempMapというキーに関連づけデータを格納
		tempMap.put("", "国を選択");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Country country = (Country) resultTable.get(i);
				tempMap.put(country.getID(), country.getCountryName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}

	/**
	 * JSON文字列返却用inputstreamを返す				//inputStreamとは入力元つまりshipFinder.jspへ返す
	 * @return
	 */
	public InputStream getInputStream() {
		return this.inputStream;
	}

}
