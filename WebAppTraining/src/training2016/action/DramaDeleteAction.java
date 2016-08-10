package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.DramaDao;
import training2016.model.Drama;
import training2016.model.DramaGenre;


@Results({
	@Result(name ="dramaSearch" , value ="dramaSearch.action" , type = ServletRedirectResult.class)
})
public class DramaDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title = "削除画面";

	/**削除id*/
	private String delete;

	/**メッセージ*/
	private String message;


	/**検索リスト*/
	public List<Drama> dramaTable = new ArrayList<Drama>(); //ちゃんとnewして



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
		DramaDao dao = new DramaDao();
//		this.dramaTable = dao.selectForDelete(deleteId);
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.dramaTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Drama> resultTrans(List<?> resultTable) {
		ArrayList<Drama> tempTable = new ArrayList<Drama>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Drama temp = new Drama();
				obj = (Object[]) resultTable.get(i);
				Drama a = (Drama) obj[0];
				DramaGenre aa = (DramaGenre) obj[1];
				temp.setId(a.getId());
				temp.setDramaGenreId(a.getDramaGenreId());
				temp.setGenre(aa.getGenre());
				temp.setName(a.getName());
				temp.setCast(a.getCast());
				temp.setTvStation(a.getTvStation());
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
		DramaDao dao = new DramaDao();
		dao.delete(this.delete);
		this.message = "削除完了ニダ";
		this.sessionMap.put("message", this.message);
		return "dramaSearch";
	}


	/**
	 *
	 * setter・getter
	 */

	public String getTitle() {
		return this.title;
	}

	public List<Drama> getDramaTable() {
		return this.dramaTable;
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
