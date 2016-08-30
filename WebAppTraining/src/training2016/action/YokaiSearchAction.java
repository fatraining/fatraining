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

import training2016.dao.YokaiDao;
import training2016.model.Yokai;
import training2016.model.Yokaifrom;


/*
 * ここでは妖怪アップデートアクションをアップデートとする
 * ここでは妖怪デリートアクションをデリートとする
 */
@Results({
	@Result(name = "update", value ="yokaiUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="yokaiDelete.action", type = ServletRedirectResult.class)
})

public class YokaiSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;


	//使う項目の宣言
	/*画面タイトル*/
	private String title = "妖怪を探せ";

	/*ブラウザからの入力項目*/

	/*生息地ID*/
	private String yokaifromId;

	/*妖怪の名前*/
	private String name;

	/*r特徴*/
	private String type;

	/*削除ID*/
	private String delete;
	/*更新ID*/
	private String updateId;

	/*生息地プルダウン用マップ*/
	private Map<String,String> yokaifromMap = new HashMap<String,String>();//HashMapでマップを生成
	/*特徴プルダウン用マップ*/
	private Map<String, String> typeMap = new LinkedHashMap<String, String>();
	/*検索リスト*/
	public ArrayList<Yokai> yokaiTable = new ArrayList<Yokai>();

	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// イニシャライザ（初期化子）
	//最初の入力項目(生息地を選択してください)をはずすために初期化
	{
		this.setYokaifromMap();
	}


	/*初期値の設定*/
	private String getDefaultYokaifrom() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultType() {
		return "";
	}

	/*executeメソッド*/
	//jspから一番最初に実行する
	@Override
	public String execute() {
		this.yokaifromId = getDefaultYokaifrom();
		this.name = getDefaultName();
		this.type = getDefaultType();
		this.setYokaifromMap();
		this.setTypeMap();
		return "success";
	}

	/*リセットボタンを押したとき*/
	public String reset () {
		this.yokaifromId = getDefaultYokaifrom();
		this.name = getDefaultName();
		this.type = getDefaultType();
		this.setYokaifromMap();
		this.setTypeMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	public String search() {
		YokaiDao Dao = new YokaiDao();
		//全部、空だったら
		List<?> resultTable = null;
		if(StringUtils.isEmpty(yokaifromId) &&
		   StringUtils.isEmpty(name) &&
		   StringUtils.isEmpty(type)) {
			resultTable = Dao.YokaiList(); //nullのとき
		} else {
			/*
			 *文字列に空があればそれを取り除く
			 */
			yokaifromId = this.yokaifromId.trim();
			name = this.name.trim();
			type = this.type.trim();
			resultTable = Dao.resultList(yokaifromId, name, type); //条件あり
		}
		this.sessionMap.put("message", null);
		this.yokaiTable.addAll(resultTrans(resultTable));
		this.setYokaifromMap();
		this.setTypeMap();
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Yokai> resultTrans(List<?> resultTable) {//決められない数
		ArrayList<Yokai> tempTable = new ArrayList<Yokai>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Yokai temp = new Yokai();
				obj = (Object[]) resultTable.get(i);
				Yokai a = (Yokai) obj[0];
				Yokaifrom aa = (Yokaifrom) obj[1];
				temp.setId(a.getId());
				temp.setYokaifromId(a.getYokaifromId());
				temp.setYokaifrom(aa.getYokaifrom());
				temp.setName(a.getName());
				temp.setType(a.getType());
				temp.setComment(a.getComment());
				temp.setLink(a.getLink());
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
			this.response.sendRedirect("yokaiUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならyokaiDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");//strutsの仕様
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("yokaiDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*setter・getter*/
	/*
	 * 生息地をセットする
	 * @param youkaifrom セットする youkaifromt
	 */
	public void setYokaifrom(String yokaifrom) {
		this.yokaifromId = yokaifrom;
	}

	/*
	 * 生息地を返す
	 * @return youkaifrom
	 */
	public String getYokaifrom(){
		return this.yokaifromId;
	}

	/*
	 * 妖怪の名前をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 妖怪の名前を返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * 特徴をセットする
	 * @param type セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * 特徴を返す
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/*
	 * 削除idをsetする
	 * @param delete セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/*
	 * 削除idを返す
	 * @return delete
	 */
	public String getDelete() {
		return this.delete;
	}

	/*
	 * 更新idをセットする
	 * @param updateId セットする update
	 */
	public void setUpdateId(String updateId) {

		this.updateId = updateId;
	}

	/*
	 * 更新idを返す
	 * @return update
	 */
	public String getUpdateId() {
		return this.updateId;
	}

	/*
	 * 画面タイトルを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/*
	 * youkaifromマップを返す
	 * @return YokaifromMap
	 */
	public Map<String, String> getYokaifromMap() {
		return this.yokaifromMap;
	}

	/*
	 * Yokaifromプルダウン用マップを返す
	 *
	 */
	public void setYokaifromMap() {
		YokaiDao dao = new YokaiDao();
		List<?> resultTable = dao.getYokaifromList();
		this.yokaifromMap = tableTrans(resultTable);
	}

	/*
	 *typeマップを返す
	 * @return typeMap
	 */
	public Map<String, String> getTypeMap() {
		return this.typeMap;
	}

	/*
	 * typeプルダウン用マップをセットする
	 *
	 */
	public void setTypeMap() {
		this.typeMap.put("", "特徴を選択");
		this.typeMap.put("無害", "無害");
		this.typeMap.put("危険", "危険");

	}

	/*------------------------------------------------*/
	// 生息地プルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			yokaifromMap.put("","生息地を選択");
			for(int i = 0; i < resultTable.size(); i++) {
				Yokaifrom aa = (Yokaifrom) resultTable.get(i);
				yokaifromMap.put(aa.getId(), aa.getYokaifrom());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yokaifromMap;
	}

}
