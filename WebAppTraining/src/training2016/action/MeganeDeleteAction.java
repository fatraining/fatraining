package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.MeganeDao;
import training2016.model.Megane;
import training2016.model.MeganeArea;

@Results({ @Result(name = "meganeSearch", value = "meganeSearch.action", type = ServletRedirectResult.class) })
public class MeganeDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "削除画面";

	/** 削除id */
	private String delete;

	/** メッセージ */
	private String message;

	/** 検索リスト */
	public List<Megane> meganeTable = new ArrayList<Megane>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override // 削除するデータを表示
	public String execute() throws Exception {//一番最初に実行
		// deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// カンマ区切りの購入IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(" , ");
		// 削除対象のレコードを取得する
		MeganeDao dao = new MeganeDao();

		List<?> resultTable = dao.selectForDelete(deleteId);
		this.meganeTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/** テーブルの作成 */
	//Arrayは数が決まってない
	public ArrayList<Megane> resultTrans(List<?> resultTable) {
		ArrayList<Megane> tempTable = new ArrayList<Megane>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {

				Megane temp = new Megane();
				obj = (Object[]) resultTable.get(i);
				Megane a = (Megane) obj[0];
				MeganeArea aa = (MeganeArea) obj[1];
				temp.setId(a.getId());
				temp.setMeganeAreaId(a.getMeganeAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setColor(a.getColor());
				temp.setLink(a.getLink());
				temp.setKingaku(a.getKingaku());
				temp.setSyousai(a.getSyousai());
				temp.setGazou(a.getGazou());

				tempTable.add(temp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/* 削除確定ボタンを押したらmeganeKesita.jspに飛ばす */
	/* 戻るボタンならmeganeSerch.actionに飛ばす */
	/**
	 * public String kesita() { this.putValueToSession("kesitaId",
	 * this.kesita());// 削除ありがとう画面へ try {
	 * this.response.sendRedirect("meganeKesita.jsp"); } catch (IOException e) {
	 * e.printStackTrace(); } return "success"; }
	 */

	/**
	 * 削除メソッド 削除完了したら削除しましたよー画面へ遷移する
	 */
	public String delete() {
		try {
			/**this.putValueToSession("deleteId", this.delete());*/

			this.delete = (String) this.sessionMap.get("deleteId");

			MeganeDao dao = new MeganeDao();

			//DBと入力したものを参照してあげる
			dao.delete(this.delete);

			this.sessionMap.put("message", this.message);
			this.message = "削除しました";


			this.response.sendRedirect("meganeKesita.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}


	public String getTitle() {
		return this.title;
	}

	public List<Megane> getMeganeTable() {
		return this.meganeTable;
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
