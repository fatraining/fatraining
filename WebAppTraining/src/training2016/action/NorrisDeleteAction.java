package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.NorrisDao;
import training2016.model.Norris;
import training2016.model.NorrisSeries;

@Results({ @Result(name = "norrisSearch", value = "norrisSearch.action", type = ServletRedirectResult.class) })
public class NorrisDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "削除画面";

	/** 削除id */
	private String delete;

	/** メッセージ */
	private String message;

	/** 検索リスト */
	public List<Norris> norrisTable = new ArrayList<Norris>(); // ちゃんとnewして

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
		NorrisDao dao = new NorrisDao();
		// this.onsenTable = dao.selectForDelete(deleteId);
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.norrisTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/* テーブルの作成 */
	public ArrayList<Norris> resultTrans(List<?> resultTable) {
		ArrayList<Norris> tempTable = new ArrayList<Norris>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Norris temp = new Norris();
				obj = (Object[]) resultTable.get(i);
				Norris a = (Norris) obj[0];
				NorrisSeries aa = (NorrisSeries) obj[1];
				temp.setId(a.getId());
				temp.setSeriesId(a.getSeriesId());
				temp.setSeries(aa.getSeries());
				temp.setName(a.getName());
				temp.setYear(a.getYear());
				temp.setComment(a.getComment());

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
		NorrisDao dao = new NorrisDao();
		dao.delete(this.delete);
		this.message = "削除しました";
		this.sessionMap.put("message", this.message);
		return "norrisSearch";
	}

	/**
	 *
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Norris> getNorrisTable() {
		return this.norrisTable;
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
