package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GuraburuDao;
import training2016.model.GuraburuCharacter;
import training2016.model.GuraburuRace;

@Results({
	@Result(name ="guraburuCharacterSearch" , value ="guraburuCharacterSearch.action" , type = ServletRedirectResult.class)
})
public class GuraburuCharacterDeleteAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "削除画面";

	/* 削除ID */
	private String delete;

	/* メッセージ */
	private String deleteMessage;

	/* 検索リスト */
	public List<GuraburuCharacter> guraburuCharacterTable = new ArrayList<>();

	/* executeメソッド */
	public String execute() throws Exception {
		//セッションマップからデリートIDを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// 削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		System.out.println(delete);
		String[] deleteId = this.delete.split(", ");

		GuraburuDao dao = new GuraburuDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.guraburuCharacterTable.addAll(resultTrans(resultTable));

		//削除するデータが複数ある場合、表示する文を変更する
		if(this.guraburuCharacterTable.size() == 1) {
			this.setDeleteMessage("このキャラクターを削除します");
		} else {
			this.setDeleteMessage("これらのキャラクターを削除します");
		}

		return "success";
	}

	/*------------------------------------------------*/
	// テーブルの作成
	/*------------------------------------------------*/
	public ArrayList<GuraburuCharacter> resultTrans(List<?> resultTable) {
		ArrayList<GuraburuCharacter> tempTable = new ArrayList<>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				GuraburuCharacter temp = new GuraburuCharacter();
				obj = (Object[]) resultTable.get(i);
				GuraburuCharacter c = (GuraburuCharacter) obj[0];
				GuraburuRace r = (GuraburuRace) obj[1];
				temp.setId(c.getId());
				temp.setName(c.getName());
				temp.setSex(c.getSex());
				temp.setAttribute(c.getAttribute());
				temp.setRaceName(r.getName());
				temp.setComment(c.getComment());
				temp.setRegisterdData(c.getRegisterdData());
				temp.setDataUrl(c.getDataUrl());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}
	/*------------------------------------------------*/
	// 削除ボタンクリック時
	/*------------------------------------------------*/
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");

		GuraburuDao dao = new GuraburuDao();
		dao.delete(delete);

		this.sessionMap.put("message", "削除しました");

		return "guraburuCharacterSearch";
	}
	/*------------------------------------------------*/
	// setter,getterの作成
	/*------------------------------------------------*/

	public String getTitle() {
		return title;
	}

	public String getDelete() {
		return delete;
	}


	public List<GuraburuCharacter> getGuraburuCharacterTable() {
		return guraburuCharacterTable;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public void setGuraburuCharacterTable(List<GuraburuCharacter> guraburuCharacterTable) {
		this.guraburuCharacterTable = guraburuCharacterTable;
	}

	public String getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}


}
