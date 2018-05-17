package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.MaiwaifuDao;
import training2016.model.Maiwaifu;
import training2016.model.MaiwaifuArea;

@Results({
	@Result(name ="maiwaifuSearch" , value ="maiwaifuSearch.action" , type = ServletRedirectResult.class)
})
public class GeininDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title = "破局";

	/**削除id*/
	private String delete;

	/**メッセージ*/
	private String message;

	/**検索リスト*/
	public List<Maiwaifu> maiwaifuTable = new ArrayList<Maiwaifu>(); //ちゃんとnewして



	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override //削除するデータを表示
	public String execute() throws Exception {
		//deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(" , ");
		// 削除対象のレコードを取得する
		MaiwaifuDao dao = new MaiwaifuDao();
//		this.aquariumTable = dao.selectForDelete(deleteId);
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.maiwaifuTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Maiwaifu> resultTrans(List<?> resultTable) {
		ArrayList<Maiwaifu> tempTable = new ArrayList<Maiwaifu>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Maiwaifu temp = new Maiwaifu();
				obj = (Object[]) resultTable.get(i);
				Maiwaifu a = (Maiwaifu) obj[0];
				MaiwaifuArea aa = (MaiwaifuArea) obj[1];
				temp.setId(a.getId());
				temp.setMaiwaifuAreaId(a.getMaiwaifuAreaId());
				temp.setArea(aa.getArea());
				temp.setImage(a.getImage());
				temp.setName(a.getName());
				temp.setGenre(a.getGenre());
				temp.setAge(a.getAge());
				temp.setComment(a.getComment());
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
		MaiwaifuDao dao = new MaiwaifuDao();
		dao.delete(this.delete);
		this.message = "お別れしました。";
		this.sessionMap.put("message", this.message);
		return "maiwaifuSearch";
	}


	/**
	 *
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Maiwaifu> getMaiwaifuTable() {
		return this.maiwaifuTable;
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
