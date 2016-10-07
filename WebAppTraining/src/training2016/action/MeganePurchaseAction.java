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
public class MeganePurchaseAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "購入カート画面";

	/** 購入id */
	private String purchase;

	/** メッセージ */
	private String message;


	private int kingaku;






	/** 合計 */
/**
	private String sum;*/

	/** 検索リスト */
	public List<Megane> meganeTable = new ArrayList<Megane>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	@Override // 購入するデータを表示
	public String execute() throws Exception {
		// purchaseを取り出す
		this.purchase = (String) this.sessionMap.get("purchaseId");
		// カンマ区切りの購入IDをカンマで分割して配列にする
		String[] purchaseId = this.purchase.split(" , ");
		// 購入対象のレコードを取得する
		MeganeDao dao = new MeganeDao();
		// this.meganeTable = dao.selectForPurchase(purchaseId);
		List<?> resultTable = dao.selectForPurchase(purchaseId);
		this.meganeTable.addAll(resultTrans(resultTable));
		return "success";
	}

	/* テーブルの作成 */
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

/**
	public int sum1;
	public int total() throws Exception{
		sum1  =(1+2);
		return total();

	}*/

	/* 購入確定ボタンを押したらmeganeBuy.jspに飛ばす */
	/* 戻るボタンならmeganeSerch.actionに飛ばす */
	public String buy() {
		this.putValueToSession("buyId", this.buy());// 購入ありがとう画面へ
		try {
			this.response.sendRedirect("meganeBuy.jsp");
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

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getPurchase() {
		return this.purchase;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setKingaku(int kingaku) {
		this.kingaku = kingaku;

	}

	public int getKingaku(){
		return kingaku;
	}
/**
	public void setSum(String sum) {
		this.sum = sum;

	}
	public int getSum() {
		double sum1=(kingaku1+kingaku1)*1.08;
		int sum2=(int)sum1;
		if(sum1-sum2!=0.0)return sum2+1;
		else return sum2;

	}*/
}
