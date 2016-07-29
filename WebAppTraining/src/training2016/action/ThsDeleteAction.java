package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.ThsDao;
import training2016.model.Ths;
import training2016.model.ThsSubject;

@Results({
	@Result(name ="thsSearch" , value ="thsSearch.action" , type = ServletRedirectResult.class)
})
public class ThsDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title = "削除画面";

	/**削除id*/
	private String delete;

	/**メッセージ*/
	private String message;

	/**検索リスト*/
	public List<Ths> thsTable = new ArrayList<Ths>();


	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override //削除するデータを表示
	public String execute() throws Exception {
		//deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(",");
		// 削除対象のレコードを取得する
		ThsDao dao = new ThsDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.thsTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Ths> resultTrans(List<?> resultTable) {
		ArrayList<Ths> tempTable = new ArrayList<Ths>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Ths temp = new Ths();
				obj = (Object[]) resultTable.get(i);
				Ths a = (Ths) obj[0];
				ThsSubject aa = (ThsSubject) obj[1];
				temp.setId(a.getId());
				temp.setThsSubjectId(a.getThsSubjectId());
				temp.setSubject(aa.getSubject());
				temp.setName(a.getName());
				temp.setLevel(a.getLevel());
				temp.setComment(a.getComment());
				temp.setLink(a.getLink());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/**
	 * 削除メソッド
	 * 削除完了したら検索画面へ遷移する
	 */
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");
		ThsDao dao = new ThsDao();
		dao.delete(this.delete);
		this.message = "削除が完了しました";
		this.sessionMap.put("message", this.message);
		return "thsSearch";
	}


	/**
	 *
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Ths> getThsTable() {
		return this.thsTable;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDelete() {
		return this.delete;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
