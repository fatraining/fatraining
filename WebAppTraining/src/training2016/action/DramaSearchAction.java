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

import training2016.dao.DramaDao;
import training2016.model.Drama;
import training2016.model.DramaGenre;

@Results({
	@Result(name = "update", value ="dramaUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="dramaDelete.action", type = ServletRedirectResult.class)
})

public class DramaSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "韓国ドラマ検索";

	/**ブラウザからの入力項目*/
	/*ジャンル*/
	private String genre;
	
	/*作品名*/
	private String name;
	
	/*キャスト*/
	String cast;

	/*削除ID*/
	private String delete;
	/*更新ID*/
	private String updateId;

	/*ジャンルプルダウン用マップ*/
	private Map<String,String> dramaGenreMap = new HashMap<String,String>();
	/*キャストプルダウン用マップ*/
	private Map<String, String> castMap = new LinkedHashMap<String, String>();
	/*検索リスト*/
	public ArrayList<Drama> dramaTable = new ArrayList<Drama>();

	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// イニシャライザ
	{
		this.setDramaGenreMap();
	}


	/*初期値の設定*/
	private String getDefaultGenre() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultCast() {
		return "";
	}

	/*executeメソッド*/
	@Override
	public String execute() {
		this.genre = getDefaultGenre();
		this.name = getDefaultName();
		this.cast = getDefaultCast();
		this.setDramaGenreMap();
		this.setCastMap();
		return "success";
	}

	/*リセットボタンを押したとき*/
	public String reset () {
		this.genre = getDefaultGenre();
		this.name = getDefaultName();
		this.cast = getDefaultCast();
		this.setDramaGenreMap();
		this.setCastMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	public String search() {
		DramaDao Dao = new DramaDao();
		List<?> resultTable = null;  //ワイルドカード
		if(StringUtils.isEmpty(genre) &&
		   StringUtils.isEmpty(name) &&
		   StringUtils.isEmpty(cast)) {
			resultTable = Dao.dramaList(); //nullのとき
		} else {
			genre = this.genre.trim();
			name = this.name.trim();
			cast = this.cast.trim();
			resultTable = Dao.resultList(genre, name, cast); //条件あり
		}
		this.sessionMap.put("message", null);
		this.dramaTable.addAll(resultTrans(resultTable));
		this.setDramaGenreMap();
		this.setCastMap();
		this.setDelete("true");  //消してみても大丈夫かも
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Drama> resultTrans(List<?> resultTable) {
		ArrayList<Drama> tempTable = new ArrayList<Drama>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Drama temp = new Drama();
				obj = (Object[]) resultTable.get(i);
				Drama a = (Drama) obj[0];
				DramaGenre aa = (DramaGenre) obj[1];
				temp.setId(a.getId());
				temp.setDramaGenreId(a.getDramaGenreId());
				temp.setGenre(aa.getGenre());
				temp.setName(a.getName());
				temp.setCast(a.getCast());
				temp.setTvStation(a.getTvStation());
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
			this.response.sendRedirect("dramaUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならdramaDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してくださいニダ");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("dramaDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*setter・getter*/
	/**
	 * ジャンルをセットする
	 * @param genre セットする genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * ジャンルを返す
	 * @return genre
	 */
	public String getGenre(){
		return this.genre;
	}

	/**
	 * 作品名をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 作品名を返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * キャストをセットする
	 * @param cast セットする cast
	 */
	public void setCast(String cast) {
		this.cast = cast;
	}

	/**
	 * キャストを返す
	 * @return cast
	 */
	public String getCast() {
		return this.cast;
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
	 * ジャンルマップを返す
	 * @return DramaGenreMap
	 */
	public Map<String, String> getDramaGenreMap() {
		return this.dramaGenreMap;
	}

	/**
	 * ジャンルプルダウン用マップを返す
	 *
	 */
	public void setDramaGenreMap() {
		DramaDao dao = new DramaDao();
		List<?> resultTable = dao.getDramaGenreList();
		this.dramaGenreMap = tableTrans(resultTable);
	}

	/**
	 * キャストマップを返す
	 * @return castMap
	 */
	public Map<String, String> getCastMap() {
		return this.castMap;
	}

	/**
	 * キャストプルダウン用マップをセットする
	 *
	 */
	public void setCastMap() {
		this.castMap.put("", "");
		this.castMap.put("ペ・ヨンジュン", "ペ・ヨンジュン");
		this.castMap.put("ユン・ウネ", "ユン・ウネ");
		this.castMap.put("イ・ビョンホン", "イ・ビョンホン");
		this.castMap.put("イ・スンギ", "イ・スンギ");
		this.castMap.put("チェ・ジウ", "チェ・ジウ");
		this.castMap.put("ハン・ヒョジュ", "ハン・ヒョジュ");
		this.castMap.put("パク・ユチョン", "パク・ユチョン");
		this.castMap.put("ユン・シユン", "ユン・シユン");
		this.castMap.put("ヒョンビン", "ヒョンビン");
		this.castMap.put("チャン・グンソク", "チャン・グンソク");

	}

	/*------------------------------------------------*/
	// ジャンルプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			dramaGenreMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				DramaGenre aa = (DramaGenre) resultTable.get(i);
				dramaGenreMap.put(aa.getId(), aa.getGenre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dramaGenreMap;
	}

}
