package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GalgameDao;
import training2016.model.GalgameMaker;
import training2016.model.GalgameProduct;


@Results({ @Result(name = "potatoSearch", value = "potatoSearch.action", type = ServletRedirectResult.class) })

public class GalgameDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "削除画面";

	/* 削除ID */
	private String delete;

	/* メッセージ */
	private String message;

	private List<GalgameProduct> galgameTable = new ArrayList<>();

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	/* executeメソッド */
	public String execute() throws Exception {
		// セッションマップからdeleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// 削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		String[] deleteId = this.delete.split(",");

		GalgameDao dao = new GalgameDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.galgameTable.addAll(resultTrans(resultTable));

		// 削除するデータが複数ある場合、表示する文を変更する
		if (this.galgameTable.size() == 1) {
			this.message = "このタイトルを削除します";
		} else {
			this.message = "これらのタイトルを削除します";
		}
		sessionMap.put("message", this.message);

		return "success";
	}

	/* テーブル作成 */
	private List<GalgameProduct> resultTrans(List<?> resultTable) {
		List<GalgameProduct> table = new ArrayList<>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				GalgameProduct temp = new GalgameProduct();
				obj = (Object[]) resultTable.get(i);
				GalgameProduct gp = (GalgameProduct) obj[0];
				GalgameMaker gm = (GalgameMaker) obj[1];
				temp.setId(gp.getId());
				temp.setMakerId(gp.getMakerId());
				temp.setMakerName(gm.getMakerName());
				temp.setName(gp.getName());
				temp.setScore(gp.getScore());
				temp.setYear(gp.getYear());
				temp.setComment(gp.getComment());
				table.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	//削除ボタンクリック時
	/*----------------------------------------------
	*/

	public String delete() {
		// セッションマップからdeleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");

		GalgameDao dao = new GalgameDao();
		dao.delete(delete);

		// 削除完了メッセージを入れる
		this.sessionMap.put("completeMessage", "削除しました");

		// 削除アクションから来たことを設定
		this.sessionMap.put("from", "delete");

		return "galgameSearch";
	}

	// setter&getter
	/*----------------------------------------------
	*/

	public String getTitle() {
		return title;
	}

	public List<GalgameProduct> getGalgameTable() {
		return galgameTable;
	}

}
