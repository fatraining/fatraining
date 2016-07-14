package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.AquariumDao;
import training2016.model.Aquarium;
import training2016.model.AquariumArea;

@Results({
	@Result(name ="aquariumSearch" , value ="aquariumSearch.action" , type = ServletRedirectResult.class)
})
public class AquariumDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title = "削除画面";

	/**削除id*/
	private String delete;

	/**メッセージ*/
	private String message;

	/**検索リスト*/
	public List<Aquarium> aquariumTable = new ArrayList<Aquarium>(); //ちゃんとnewして



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
		AquariumDao dao = new AquariumDao();
//		this.aquariumTable = dao.selectForDelete(deleteId);
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.aquariumTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Aquarium> resultTrans(List<?> resultTable) {
		ArrayList<Aquarium> tempTable = new ArrayList<Aquarium>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Aquarium temp = new Aquarium();
				obj = (Object[]) resultTable.get(i);
				Aquarium a = (Aquarium) obj[0];
				AquariumArea aa = (AquariumArea) obj[1];
				temp.setId(a.getId());
				temp.setAquariumAreaId(a.getAquariumAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setPrice(a.getPrice());
				temp.setHours(a.getHours());
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
		AquariumDao dao = new AquariumDao();
		dao.delete(this.delete);
		this.message = "削除しました";
		this.sessionMap.put("message", this.message);
		return "aquariumSearch";
	}


	/**
	 *
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Aquarium> getAquariumTable() {
		return this.aquariumTable;
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
