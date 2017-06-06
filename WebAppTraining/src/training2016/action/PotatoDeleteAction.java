package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.PotatoDao;
import training2016.model.PotatoMaker;
import training2016.model.PotatoProduct;

@Results({ @Result(name = "potatoSearch", value = "potatoSearch.action", type = ServletRedirectResult.class) })

public class PotatoDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "削除画面";

	/* 削除ID */
	private String delete;

	/* メッセージ */
	private String message;

	private List<PotatoProduct> potatoTable = new ArrayList<>();

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

		PotatoDao dao = new PotatoDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.potatoTable.addAll(resultTrans(resultTable));

		// 削除するデータが複数ある場合、表示する文を変更する
		if (this.potatoTable.size() == 1) {
			this.message = "このポテチを食べきります";
		} else {
			this.message = "これらのポテチを食べきります";
		}
		sessionMap.put("message", this.message);

		return "success";
	}

	/* テーブル作成 */
	private List<PotatoProduct> resultTrans(List<?> resultTable) {
		List<PotatoProduct> table = new ArrayList<>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				PotatoProduct temp = new PotatoProduct();
				obj = (Object[]) resultTable.get(i);
				PotatoProduct pp = (PotatoProduct) obj[0];
				PotatoMaker pm = (PotatoMaker) obj[1];
				temp.setId(pp.getId());
				temp.setMakerId(pp.getMakerId());
				temp.setMakerName(pm.getMakerName());
				temp.setName(pp.getName());
				temp.setType(pp.getType());
				temp.setVolume(pp.getVolume());
				temp.setPrice(pp.getPrice());
				temp.setComment(pp.getComment());
				table.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	// 食べきるボタンクリック時
	/*----------------------------------------------
	*/

	public String delete() {
		// セッションマップからdeleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");

		PotatoDao dao = new PotatoDao();
		dao.delete(delete);

		// 削除完了メッセージを入れる
		this.sessionMap.put("completeMessage", "食べきりました");

		// 削除アクションから来たことを設定
		this.sessionMap.put("from", "delete");

		return "potatoSearch";
	}

	// setter&getter
	/*----------------------------------------------
	*/

	public String getTitle() {
		return title;
	}

	public List<PotatoProduct> getPotatoTable() {
		return potatoTable;
	}

}
