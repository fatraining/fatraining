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

import training2016.dao.MaiwaifuDao;
import training2016.model.Maiwaifu;
import training2016.model.MaiwaifuArea;

//actionにとぶように指定。
@Results({
	@Result(name = "update", value ="maiwaifuUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="maiwaifuDelete.action", type = ServletRedirectResult.class)
})

public class MaiwaifuSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "お嫁さん検索";

	/*ブラウザからの入力項目*/

	/*エリア*/
	private String area;

	/*名前*/
	private String name;

	/*ジャンル*/
	private String genre;

	/*削除ID*/
	private String delete;

	/*更新ID*/
	private String updateId;

	/*エリアプルダウン用マップ*/
	private Map<String,String> maiwaifuAreaMap = new HashMap<String,String>();
	/*入場料プルダウン用マップ*/
	private Map<String, String> genreMap = new LinkedHashMap<String, String>();
	/*検索リスト*/
	public ArrayList<Maiwaifu> maiwaifuTable = new ArrayList<Maiwaifu>();

	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// イニシャライザ
	{
		this.setMaiwaifuAreaMap();
	}


	/*初期値の設定*/
	private String getDefaultArea() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultGenre() {
		return "";
	}

	/*executeメソッド*/
	//一番最初に呼び出されて実行される。

	@Override
	public String execute() {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.genre = getDefaultGenre();
		this.setMaiwaifuAreaMap();
		this.setGenreMap();
		return "success";
	}

	/*リセットボタンを押したとき*/
	public String reset () {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.genre = getDefaultGenre();
		this.setMaiwaifuAreaMap();
		this.setGenreMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	//データベース生成。
	public String search() {
		MaiwaifuDao Dao = new MaiwaifuDao();
		List<?> resultTable = null;  //ワイルドカード(曖昧な文字列)

		if(StringUtils.isEmpty(area) &&
		   StringUtils.isEmpty(name) &&
		   StringUtils.isEmpty(genre)) {
			resultTable = Dao.maiwaifuList(); //nullのとき
		} else {
			//trim（文字列のコピーを返す。）この場合DBからコピーして持ってくる。
			//空だった場合何も持ってこないし、空欄の枠も消しちゃう。
			area = this.area.trim();
			name = this.name.trim();
			genre = this.genre.trim();
			resultTable = Dao.resultList(area, name, genre); //条件あり
		}
		//thisで準備してる。

		this.sessionMap.put("message", null);
		this.maiwaifuTable.addAll(resultTrans(resultTable));
		this.setMaiwaifuAreaMap();
		this.setGenreMap();
		this.setDelete("true");  //消してみても大丈夫かも
		return "success";
	}

	/*テーブルの作成*/
	//Listが何個あるか分からないので（？）にしてる。リストを生成して回してobjの箱に入れる。

	public ArrayList<Maiwaifu> resultTrans(List<?> resultTable) {
		ArrayList<Maiwaifu> tempTable = new ArrayList<Maiwaifu>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Maiwaifu temp = new Maiwaifu();
				obj = (Object[]) resultTable.get(i);
				Maiwaifu a = (Maiwaifu) obj[0];
				MaiwaifuArea aa = (MaiwaifuArea) obj[1];
				temp.setId(a.getId());
				temp.setMaiwaifuAreaId(a.getMaiwaifuAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setGenre(a.getGenre());
				temp.setAge(a.getAge());
				temp.setComment(a.getComment());
				temp.setImage(a.getImage());
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
			this.response.sendRedirect("maiwaifuUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならmaiwaifuDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("maiwaifuDelete.action");
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
	 * ジャンルをセットする
	 * @param genre セットする genre
	 */
	public void setGenre(String genre) {
		this.genre= genre;
	}

	/**
	 * ジャンルを返す
	 * @return genre
	 */
	public String getGenre() {
		return this.genre;
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
	 * @return MaiwaifuAreaMap
	 */
	public Map<String, String> getMaiwaifuAreaMap() {
		return this.maiwaifuAreaMap;
	}

	/**
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setMaiwaifuAreaMap() {
		MaiwaifuDao dao = new MaiwaifuDao();
		List<?> resultTable = dao.getMaiwaifuAreaList();
		this.maiwaifuAreaMap = tableTrans(resultTable);
	}

	/**
	 * ジャンルマップを返す
	 * @return genreMap
	 */
	public Map<String, String> getGenreMap() {
		return this.genreMap;
	}

	/**
	 * ジャンルプルダウン用マップをセットする
	 *
	 */
	public void setGenreMap() {
		this.genreMap.put("", "");
		this.genreMap.put("cute", "cute");
		this.genreMap.put("beauty", "beauty");
		this.genreMap.put("sexy", "sexy");
		this.genreMap.put("cool", "cool");
		this.genreMap.put("mako", "mako");
		this.genreMap.put("married woman", "marrid woman");
		this.genreMap.put("maniac", "maniac");
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			maiwaifuAreaMap.put("","");
			for(int i = 0; i < resultTable.size(); i++) {
				MaiwaifuArea aa = (MaiwaifuArea) resultTable.get(i);
				maiwaifuAreaMap.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maiwaifuAreaMap;
	}

}