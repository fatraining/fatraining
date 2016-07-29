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

import training2016.dao.SneakersDao;
import training2016.model.Sneakers;
import training2016.model.SneakersMaker;

@Results({
	@Result(name = "update", value ="sneakersUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="sneakersDelete.action", type = ServletRedirectResult.class)
})

public class SneakersSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "スニーカーサーチ";

	/*↓ブラウザからの入力項目↓*/
	/*メーカー*/
	private String maker;
	/*シリーズ*/
	private String series;
	/*発売年*/
	private String year;
	/*削除ID*/
	private String delete;
	/*更新ID*/
	private String updateId;


	/*メーカープルダウン用マップ*/
	private Map<String,String> sneakersMakerMap = new HashMap<String,String>();
	/*発売年プルダウン用マップ*/
	private Map<String, String> sneakersYearMap = new LinkedHashMap<String, String>();
	/*検索リスト*/
	public ArrayList<Sneakers> sneakersTable = new ArrayList<Sneakers>();


	/*ログイン名表示 userIdさん */
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

//	/*メッセージ表示 message */
//	public String getMessage() {
//		return (String) this.sessionMap.get("message");
//	}

	/*イニシャライザ*/
	{
		this.setSneakersMakerMap();
	}

	/*初期値の設定 "(空文字)"*/
	private String getDefaultMaker() {
		return "";
	}
	private String getDefaultSeries() {
		return "";
	}
	private String getDefaultYear() {
		return "";
	}



	/*executeメソッド*/
	@Override
	public String execute() {
		this.maker = getDefaultMaker();
		this.series = getDefaultSeries();
		this.year = getDefaultYear();
		this.setSneakersMakerMap();
		this.setSneakersYearMap();
		return "success";
	}

	/*resetメソッド（リセットボタン押下時）*/
	public String reset () {
		this.maker = getDefaultMaker();
		this.series = getDefaultYear();
		this.year = getDefaultSeries();
		this.setSneakersMakerMap();
		this.setSneakersYearMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*searchメソッド（検索ボタン押下時）*/
	public String search() {
		SneakersDao Dao = new SneakersDao();
		List<?> resultTable = null;  //ワイルドカード
		if(StringUtils.isEmpty(maker) &&
		   StringUtils.isEmpty(series) &&
		   StringUtils.isEmpty(year)) {
			resultTable = Dao.sneakersList(); //nullのとき（フォーム未入力時）
		} else {
			maker = this.maker.trim(); //空白をトリム
			series = this.series.trim();
			year = this.year.trim();
			resultTable = Dao.resultList(maker, series, year); //条件あり（フォームに入力値あり）
		}
		this.sessionMap.put("message", null);
		this.sneakersTable.addAll(resultTrans(resultTable));
		this.setSneakersMakerMap();
		this.setSneakersYearMap();
		this.setDelete("true");  //消してみても大丈夫かも
		return "success";
	}

	/*resultTransメソッド（テーブルを生成）*/
	public ArrayList<Sneakers> resultTrans(List<?> resultTable) {
		ArrayList<Sneakers> tempTable = new ArrayList<Sneakers>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Sneakers temp = new Sneakers();
				obj = (Object[]) resultTable.get(i);
				Sneakers a = (Sneakers) obj[0];
				SneakersMaker aa = (SneakersMaker) obj[1];
				temp.setId(a.getId());
				temp.setName(a.getName());
				temp.setSneakersMakerId(a.getSneakersMakerId());
				temp.setMaker(aa.getMaker());
				temp.setSeries(a.getSeries());
				temp.setYear(a.getYear());
				temp.setComment(a.getComment());
				temp.setImage(a.getImage());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/*updateメソッド（登録ボタン押下時）*/
	public String update() {
		/*セッションマップに指定されたキーでValueをputする*/
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("sneakersUpdate.action");  //追加登録画面へ遷移
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*deleteメソッド（削除ボタン押下時）*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {  //チェック無しのとき
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {  //チェックありのとき
			try {
				this.response.sendRedirect("sneakersDelete.action");  //削除画面へ遷移
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*↓セッター・ゲッター↓*/
	/** メーカーをセットする
	 * @param maker セットする maker */
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**メーカーを返す
	 * @return maker */
	public String getMaker(){
		return this.maker;
	}

	/** シリーズをセットする
	 * @param series セットする series */
	public void setSeries(String series) {
		this.series = series;
	}

	/** シリーズを返す
	 * @return series */
	public String getSeries() {
		return this.series;
	}

	/** 発売年をセットする
	 * @param year セットする year */
	public void setYear(String year) {
		this.year = year;
	}

	/** 発売年を返す
	 * @return year */
	public String getYear() {
		return this.year;
	}

	/** 削除idをsetする
	 * @param delete セットする delete */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/** 削除idを返す
	 * @return delete */
	public String getDelete() {
		return this.delete;
	}

	/** 更新idをセットする
	 * @param updateId セットする update */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/** 更新idを返す
	 * @return update */
	public String getUpdateId() {
		return this.updateId;
	}

	/** 画面タイトルを返す
	 * @return title */
	public String getTitle() {
		return this.title;
	}

	/** メーカーマップを返す
	 * @return sneakersMakerMap */
	public Map<String, String> getSneakersMakerMap() {
		return this.sneakersMakerMap;
	}

	/** メーカープルダウン用マップを返す */
	public void setSneakersMakerMap() {
		SneakersDao dao = new SneakersDao();
		List<?> resultTable = dao.getSneakersMakerList();
		this.sneakersMakerMap = tableTrans(resultTable);
	}

	/** 発売年マップを返す
	 * @return sneakersYearMap */
	public Map<String, String> getSneakersYearMap() {
		return this.sneakersYearMap;
	}

	/** 発売年プルダウン用マップをセットする */
	public void setSneakersYearMap() {
		this.sneakersYearMap.put("", "");
		this.sneakersYearMap.put("1917", "1917年");
		this.sneakersYearMap.put("1957", "1957年");
		this.sneakersYearMap.put("1966", "1966年");
		this.sneakersYearMap.put("1968", "1968年");
		this.sneakersYearMap.put("1969", "1969年");
		this.sneakersYearMap.put("1970", "1970年");
		this.sneakersYearMap.put("1971", "1971年");
		this.sneakersYearMap.put("1972", "1972年");
		this.sneakersYearMap.put("1973", "1973年");
		this.sneakersYearMap.put("1974", "1974年");
		this.sneakersYearMap.put("1975", "1975年");
		this.sneakersYearMap.put("1976", "1976年");
		this.sneakersYearMap.put("1977", "1977年");
		this.sneakersYearMap.put("1978", "1978年");
		this.sneakersYearMap.put("1979", "1979年");
		this.sneakersYearMap.put("1980", "1980年");
		this.sneakersYearMap.put("1981", "1981年");
		this.sneakersYearMap.put("1982", "1982年");
		this.sneakersYearMap.put("1983", "1983年");
		this.sneakersYearMap.put("1984", "1984年");
		this.sneakersYearMap.put("1985", "1985年");
		this.sneakersYearMap.put("1986", "1986年");
		this.sneakersYearMap.put("1987", "1987年");
		this.sneakersYearMap.put("1988", "1988年");
		this.sneakersYearMap.put("1989", "1989年");
		this.sneakersYearMap.put("1990", "1990年");
		this.sneakersYearMap.put("1991", "1991年");
		this.sneakersYearMap.put("1992", "1992年");
		this.sneakersYearMap.put("1993", "1993年");
		this.sneakersYearMap.put("1994", "1994年");
		this.sneakersYearMap.put("1995", "1995年");
		this.sneakersYearMap.put("1996", "1996年");
		this.sneakersYearMap.put("1997", "1997年");
		this.sneakersYearMap.put("1998", "1998年");
		this.sneakersYearMap.put("1999", "1999年");
		this.sneakersYearMap.put("2000", "2000年");
	}

	/*tebleTransメソッド（メーカープルダウン用マップ生成）*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			sneakersMakerMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				SneakersMaker aa = (SneakersMaker) resultTable.get(i);
				sneakersMakerMap.put(aa.getId(), aa.getMaker());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sneakersMakerMap;
	}
}
