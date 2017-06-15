package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SkyLineDao;
import training2016.model.SkyLineAge;
import training2016.model.SkyLineData;

@Results({ @Result(name = "skyLineSearch", value = "skyLineSearch.action", type = ServletRedirectResult.class) })
public class SkyLineDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "削除画面";

	/** 削除id */
	private String delete;

	/** メッセージ */
	private String message;

	/** 検索リスト */
	public List<SkyLineData> skyLineTable = new ArrayList<SkyLineData>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override // 削除するデータを表示
	public String execute() throws Exception {
		// deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(",");
		// 削除対象のレコードを取得する
		SkyLineDao dao = new SkyLineDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.skyLineTable.addAll(resultTrans(resultTable));
		return "success";
	}

	// テーブル作成
	public ArrayList<SkyLineData> resultTrans (List<?> resultTable) {
		ArrayList<SkyLineData> tempTable = new ArrayList<SkyLineData>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				SkyLineData temp = new SkyLineData();
				obj = (Object[]) resultTable.get(i);
				SkyLineData d = (SkyLineData) obj[0];
				SkyLineAge a = (SkyLineAge) obj[1]; // 値入力の順番気を付ける
				temp.setId(d.getId());
				temp.setDate(d.getDate());
				temp.setModel(d.getModel());
				temp.setNickname(d.getNickname());
				temp.setAgeId(a.getAge());
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
		SkyLineDao dao = new SkyLineDao();
		dao.delete(this.delete);
		this.message = "削除が完了しました";
		this.sessionMap.put("message", this.message);
		return "skyLineSearch";
	}

	// setter getter

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
