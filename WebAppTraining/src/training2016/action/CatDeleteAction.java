package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.CatDao;
import training2016.model.CatFrom;
import training2016.model.CatInfo;

@Results({
	@Result(name ="catSearch" , value ="catSearch.action" , type = ServletRedirectResult.class)
})
public class CatDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* 画面タイトル */
	private String title = "削除";
	/* 削除ID */
	private String deleteId;
	/*メッセージ*/
	private String message;
	/* 検索結果リスト */
	public List<CatInfo> resultTable = new ArrayList<CatInfo>();

	/* セッションの設定 */
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	/* 削除項目の表示 */
	@Override
	public String execute() throws Exception {
		this.deleteId = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.deleteId.split(" , ");
		// 削除対象のレコードを取得する
		CatDao dao = new CatDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.resultTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/* テーブルの作成 */
	public ArrayList<CatInfo> resultTrans(List<?> resultTable) {
		ArrayList<CatInfo> tempTable = new ArrayList<CatInfo>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				CatInfo temp = new CatInfo();
				obj = (Object[]) resultTable.get(i);
				CatInfo in = (CatInfo) obj[0];
				CatFrom f = (CatFrom) obj[1];
				temp.setId(in.getId());
				temp.setFromId(in.getFromId());
				temp.setName(in.getName());
				temp.setComment(in.getComment());
				temp.setCountry(f.getCountry());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/* deleteメソッド */
	public String delete() {
		this.deleteId = (String) this.sessionMap.get("deleteId");
		CatDao dao = new CatDao();
		dao.delete(this.deleteId);
		this.message = "削除しました";
		this.sessionMap.put("message", this.message);
		return "catSearch";
	}

	/* get,setメソッド */
	public String getTitle() {
		return title;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<CatInfo> getResultTable() {
		return resultTable;
	}

}