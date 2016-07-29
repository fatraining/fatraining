package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SneakersDao;
import training2016.model.Sneakers;
import training2016.model.SneakersMaker;

@Results({
	@Result(name ="sneakersSearch" , value ="sneakersSearch.action" , type = ServletRedirectResult.class)
})
public class SneakersDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "削除画面";

	/*削除id*/
	private String delete;

	/*メッセージ*/
	private String message;

	/*検索リスト*/
	public List<Sneakers> sneakersTable = new ArrayList<Sneakers>();


	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}


	@Override //executeメソッド（削除するデータを表示）
	public String execute() throws Exception {
		//deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(" , ");
		// 削除対象のレコードを取得する
		SneakersDao dao = new SneakersDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.sneakersTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/*resultTransメソッド（テーブルの作成）*/
	public ArrayList<Sneakers> resultTrans(List<?> resultTable) {
		ArrayList<Sneakers> tempTable = new ArrayList<Sneakers>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Sneakers temp = new Sneakers();
				obj = (Object[]) resultTable.get(i);
				Sneakers a = (Sneakers) obj[0];
				SneakersMaker aa = (SneakersMaker) obj[1];
				temp.setId(a.getId());
				temp.setSneakersMakerId(a.getSneakersMakerId());
				temp.setMaker(aa.getMaker());
				temp.setName(a.getName());
				temp.setSeries(a.getSeries());
				temp.setYear(a.getYear());
				temp.setComment(a.getComment());
				temp.setImage(a.getImage());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/* deleteメソッド
	 */
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");
		SneakersDao dao = new SneakersDao();
		dao.delete(this.delete);
		this.message = "削除完了！";
		this.sessionMap.put("message", this.message);
		return "sneakersSearch"; //メイン画面へ遷移
	}


	/* ↓セッター・ゲッター↓ */

	public String getTitle() {
		return this.title;
	}

	public List<Sneakers> getSneakersTable() {
		return this.sneakersTable;
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
