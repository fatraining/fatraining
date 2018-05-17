package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GeininDao;
import training2016.model.Geinin;
import training2016.model.GeininJenre;
import training2016.model.GeininJimusho;
import training2016.model.GeininNumber;
import training2016.model.GeininSex;

//actionにとぶように指定。
@Results({
	@Result(name = "update", value ="geininUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="geininDelete.action", type = ServletRedirectResult.class)
})

public class GeininSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "若手芸人検索";

	/*ブラウザからの入力項目*/

	/*データ類*/
	private String name;
	private String number;
	private String sex;
	private String jimusho;
	private String year;
	private String jenre;


	/*削除ID*/
	private String delete;

	/*更新ID*/
	private String updateId;

	/*人数プルダウン用マップ*/
	private Map<String,String> numberMap = new HashMap<String,String>();
	/*性別プルダウン用マップ*/
	private Map<String, String> sexMap = new HashMap<String, String>();
	/*事務所プルダウン用マップ*/
	private Map<String,String> jimushoMap = new HashMap<String,String>();
	/*ジャンルプルダウン用マップ*/
	private Map<String, String> jenreMap = new HashMap<String, String>();



	/*検索リスト*/
	public ArrayList<Geinin> geininTable = new ArrayList<Geinin>();

	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// イニシャライザ
	{
		this.setNumberMap();
	}
	{
		this.setSexMap();
	}
	{
		this.setJimushoMap();
	}
	{
		this.setJenreMap();
	}


	/*初期値の設定*/
	private String getDefaultName() {
		return "";
	}

	private String getDefaultNumber() {
		return "";
	}

	private String getDefaultSex() {
		return "";
	}
	private String getDefaultJimusho() {
		return "";
	}

	private String getDefaultYear() {
		return "";
	}

	private String getDefaultJenre() {
		return "";
	}

	/*executeメソッド*/
	//一番最初に呼び出されて実行される。

	@Override
	public String execute() {
		this.name = getDefaultName();
		this.number = getDefaultNumber();
		this.sex = getDefaultSex();
		this.jimusho = getDefaultJimusho();
		this.year = getDefaultYear();
		this.jenre = getDefaultJenre();
		this.setNumberMap();
		this.setSexMap();
		this.setJimushoMap();
		this.setJenreMap();
		return "success";
	}

	/*リセットボタンを押したとき*/
	public String reset () {
		this.name = getDefaultName();
		this.number = getDefaultNumber();
		this.sex = getDefaultSex();
		this.jimusho = getDefaultJimusho();
		this.year = getDefaultYear();
		this.jenre = getDefaultJenre();
		this.setNumberMap();
		this.setSexMap();
		this.setJimushoMap();
		this.setJenreMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	//データベース生成。
	public String search() {
		GeininDao Dao = new GeininDao();
		List<?> resultTable = null;  //ワイルドカード(曖昧な文字列)

		if(StringUtils.isEmpty(name) &&
		   StringUtils.isEmpty(number) &&
		   StringUtils.isEmpty(sex) &&
		   StringUtils.isEmpty(jimusho) &&
		   StringUtils.isEmpty(jenre) &&
		   StringUtils.isEmpty(year)) {
			resultTable = Dao.geininList(); //nullのとき
		} else {
			//trim（文字列のコピーを返す。）この場合DBからコピーして持ってくる。
			//空だった場合何も持ってこないし、空欄の枠も消しちゃう。
			name = this.name.trim();
			number = this.number.trim();
			sex = this.sex.trim();
			jimusho = this.jimusho.trim();
			year = this.year.trim();
			jenre = this.jenre.trim();
			resultTable = Dao.resultList(name, number, sex, jimusho, year, jenre); //条件あり
		}
		//thisで準備してる。

		this.sessionMap.put("message", null);
		this.geininTable.addAll(resultTrans(resultTable));
		this.setNumberMap();
		this.setSexMap();
		this.setJimushoMap();
		this.setJenreMap();
		this.setDelete("true");  //消してみても大丈夫かも
		return "success";
	}

	/*テーブルの作成*/
	//Listが何個あるか分からないので（？）にしてる。リストを生成して回してobjの箱に入れる。

	public ArrayList<Geinin> resultTrans(List<?> resultTable) {
		ArrayList<Geinin> tempTable = new ArrayList<Geinin>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Geinin temp = new Geinin();
				obj = (Object[]) resultTable.get(i);
				Geinin g = (Geinin) obj[0];
				GeininNumber gn = (GeininNumber) obj[1];
				GeininSex gs = (GeininSex) obj[2];
				GeininJimusho gji = (GeininJimusho) obj[3];
				GeininJenre gje = (GeininJenre) obj[4];
				temp.setId(g.getId());
				temp.setImage(g.getImage());
				temp.setNumberId(g.getNumberId());
				temp.setNumber(gn.getNumber());
				temp.setSexId(g.getSexId());
				temp.setSex(gs.getSex());
				temp.setJimushoId(g.getJimushoId());
				temp.setJimusho(gji.getJimusho());
				temp.setYear(g.getYear());
				temp.setJenreId(g.getJenreId());
				temp.setJenre(gje.getJenre());
				temp.setWork(g.getWork());
				temp.setMovieUrl(g.getMovieUrl());
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
			this.response.sendRedirect("geininUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならgeininDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("geininDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*setter・getter*/
	/**
	 * @return number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number セットする number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex セットする sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return jimusho
	 */
	public String getJimusho() {
		return jimusho;
	}

	/**
	 * @param jimusho セットする jimusho
	 */
	public void setJimusho(String jimusho) {
		this.jimusho = jimusho;
	}

	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return jenre
	 */
	public String getJenre() {
		return jenre;
	}

	/**
	 * @param jenre セットする jenre
	 */
	public void setJenre(String jenre) {
		this.jenre = jenre;
	}

	/**
	 * @return numberMap
	 */
	public Map<String, String> getNumberMap() {
		return numberMap;
	}

	/**
	 * @param numberMap セットする numberMap
	 */
	public void setNumberMap(Map<String, String> numberMap) {
		this.numberMap = numberMap;
	}

	/**
	 * @return sexMap
	 */
	public Map<String, String> getSexMap() {
		return sexMap;
	}

	/**
	 * @param sexMap セットする sexMap
	 */
	public void setSexMap(Map<String, String> sexMap) {
		this.sexMap = sexMap;
	}

	/**
	 * @return jimushoMap
	 */
	public Map<String, String> getJimushoMap() {
		return jimushoMap;
	}

	/**
	 * @param jimushoMap セットする jimushoMap
	 */
	public void setJimushoMap(Map<String, String> jimushoMap) {
		this.jimushoMap = jimushoMap;
	}

	/**
	 * @return geininTable
	 */
	public ArrayList<Geinin> getGeininTable() {
		return geininTable;
	}

	/**
	 * @param geininTable セットする geininTable
	 */
	public void setGeininTable(ArrayList<Geinin> geininTable) {
		this.geininTable = geininTable;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param jenreMap セットする jenreMap
	 */
	public void setJenreMap(Map<String, String> jenreMap) {
		this.jenreMap = jenreMap;
	}

	/**
	 * 名前をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 名前を返す
	 * @return name
	 */
	public String getName() {
		return this.name;
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
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setNumberMap() {
		GeininDao dao = new GeininDao();
		List<?> resultTable = dao.getGeininNumberList();
		this.numberMap = tableTransNumber(resultTable);
	}
	public void setSexMap() {
		GeininDao dao = new GeininDao();
		List<?> resultTable = dao.getGeininSexList();
		this.sexMap = tableTransSex(resultTable);
	}
	public void setJimushoMap() {
		GeininDao dao = new GeininDao();
		List<?> resultTable = dao.getGeininJimushoList();
		this.jimushoMap = tableTransJimusho(resultTable);
	}
	public void setJenreMap() {
		GeininDao dao = new GeininDao();
		List<?> resultTable = dao.getGeininJenreList();
		this.jenreMap = tableTransJenre(resultTable);
	}

	/**
	 * ジャンルマップを返す
	 * @return genreMap
	 */
	public Map<String, String> getJenreMap() {
		return this.jenreMap;
	}

	/**
	 * ジャンルプルダウン用マップをセットする
	 *
	 */
//	public void setGenreMap() {
//		this.genreMap.put("", "");
//		this.genreMap.put("cute", "cute");
//		this.genreMap.put("beauty", "beauty");
//		this.genreMap.put("sexy", "sexy");
//		this.genreMap.put("cool", "cool");
//		this.genreMap.put("mako", "mako");
//		this.genreMap.put("married woman", "marrid woman");
//		this.genreMap.put("maniac", "maniac");
//	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTransNumber(List<?> resultTable) {
		try {
			numberMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				GeininNumber gn = (GeininNumber) resultTable.get(i);
				numberMap.put(gn.getId(), gn.getNumber());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberMap;
	}

	public Map<String,String> tableTransSex(List<?> resultTable) {
		try {
			sexMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				GeininSex gs = (GeininSex) resultTable.get(i);
				sexMap.put(gs.getId(), gs.getSex());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sexMap;
	}

	public Map<String,String> tableTransJimusho(List<?> resultTable) {
		try {
			jimushoMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				GeininJimusho gji = (GeininJimusho) resultTable.get(i);
				jimushoMap.put(gji.getId(), gji.getJimusho());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jimushoMap;
	}

	public Map<String,String> tableTransJenre(List<?> resultTable) {
		try {
			jenreMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				GeininJenre gje = (GeininJenre) resultTable.get(i);
				jenreMap.put(gje.getId(), gje.getJenre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jenreMap;
	}

}