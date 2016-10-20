package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.ChocolateDao;
import training2016.model.Chocolate;
import training2016.model.ChocolateCountry;

@Results({ @Result(name = "chocolateSearch", value = "chocolateSearch.action", type = ServletRedirectResult.class) })
public class ChocolateDeleteAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "Delete";

	/** 削除id */
	private String delete;

	/** メッセージ */
	private String message;

	/** 検索リスト */
	public List<Chocolate> chocolateTable = new ArrayList<Chocolate>(); // ちゃんとnewして

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override // 削除するデータを表示
	public String execute() throws Exception {
		// deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(" , ");
		// 削除対象のレコードを取得する Daoクラスのdaoインスタンスを生成して、selectForDelete()を呼び出す
		ChocolateDao dao = new ChocolateDao();
		// this.chocolateTable = dao.selectForDelete(deleteId);
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.chocolateTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/* テーブルの作成 */
	public ArrayList<Chocolate> resultTrans(List<?> resultTable) {
		ArrayList<Chocolate> tempTable = new ArrayList<Chocolate>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Chocolate temp = new Chocolate();
				obj = (Object[]) resultTable.get(i);
				Chocolate a = (Chocolate) obj[0];
				ChocolateCountry aa = (ChocolateCountry) obj[1];
				temp.setId(a.getId());
				temp.setImage(a.getImage());
				temp.setCountryid(a.getCountryid());
				temp.setCountry(aa.getCountry());
				temp.setShopName(a.getShopName());
				temp.setChef(a.getChef());
				temp.setComment(a.getComment());
				temp.setPrice(a.getPrice());

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
		ChocolateDao dao = new ChocolateDao();
		dao.delete(this.delete);
		this.message = "削除しました";
		this.sessionMap.put("message", this.message);
		return "chocolateSearch";
	}


}
