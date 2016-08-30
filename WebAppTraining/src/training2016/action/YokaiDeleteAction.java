package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.YokaiDao;
import training2016.model.Yokai;
import training2016.model.Yokaifrom;


/*
 * 妖怪成仏
 * ここでは妖怪サーチアクションを妖怪サーチとする
 */
@Results({
	@Result(name ="yokaiSearch" , value ="yokaiSearch.action" , type = ServletRedirectResult.class)
})
public class YokaiDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "削除画面";

	/*削除id*/
	private String delete;

	/*メッセージ*/
	private String message;

	/*検索リスト*/
	public List<Yokai> yokaiTable = new ArrayList<Yokai>();


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
		YokaiDao dao = new YokaiDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.yokaiTable.addAll(resultTrans(resultTable));
		return "success";
	}
	/*テーブルの作成*/
	public ArrayList<Yokai> resultTrans(List<?> resultTable) {
		ArrayList<Yokai> tempTable = new ArrayList<Yokai>();
		Object[] obj;//ここで使う用の配列を用意
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

	/*
	 * 削除メソッド
	 * 削除完了したら検索画面へ遷移する
	 */
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");
		YokaiDao dao = new YokaiDao();
		dao.delete(this.delete);
		this.message = "妖怪は成仏しました";
		this.sessionMap.put("message", this.message);
		return "yokaiSearch";
	}


	/*
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Yokai> getYokaiTable() {
		return this.yokaiTable;
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
