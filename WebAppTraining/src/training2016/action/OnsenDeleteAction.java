package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.OnsenDao;
import training2016.model.Onsen;
import training2016.model.OnsenArea;

@Results({ @Result(name = "onsenSearch", value = "onsenSearch.action", type = ServletRedirectResult.class) })
public class OnsenDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "削除画面";

	/** 削除id */
	private String delete;

	/** メッセージ */
	private String message;

	/** 検索リスト */
	public List<Onsen> onsenTable = new ArrayList<Onsen>(); // ちゃんとnewして

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override // 削除するデータを表示
	public String execute() throws Exception {
		// deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(" , ");
		// 削除対象のレコードを取得する
		OnsenDao dao = new OnsenDao();
		// this.onsenTable = dao.selectForDelete(deleteId);
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.onsenTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/* テーブルの作成 */
	public ArrayList<Onsen> resultTrans(List<?> resultTable) {
		ArrayList<Onsen> tempTable = new ArrayList<Onsen>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Onsen temp = new Onsen();
				obj = (Object[]) resultTable.get(i);
				Onsen a = (Onsen) obj[0];
				OnsenArea aa = (OnsenArea) obj[1];
				temp.setId(a.getId());
				temp.setOnsenAreaId(a.getOnsenAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setEffect(a.getEffect());
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
	 * 削除メソッド 削除完了したら検索画面へ遷移する
	 */
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");
		OnsenDao dao = new OnsenDao();
		dao.delete(this.delete);
		this.message = "削除しました";
		this.sessionMap.put("message", this.message);
		return "onsenSearch";
	}

	/**
	 *
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Onsen> getOnsenTable() {
		return this.onsenTable;
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
