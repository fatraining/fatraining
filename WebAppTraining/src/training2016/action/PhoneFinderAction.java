package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import;
//import;
//import;
//import;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.PhoneDao;
import training2016.model.Operator;
import training2016.model.Phones;

public class PhoneFinderAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 入力項目 ↓↓
	/*------------------------------------------------------*/
	private String operatorName;
	private String phoneName;
	private String priceLow;
	private String priceHi;

	private String delete;

	public ArrayList<Phones> outputTable = new ArrayList<Phones>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMsg() {
		return (String) this.sessionMap.get("msg");
	}

	// 初期値の設定 ↓↓
	/*------------------------------------------------------*/
	private String getDefaultOperator() {
		return "";
	}

	private String getDefaultPhoneName() {
		return "";
	}

	private String getDefaultPriceLow() {
		return "";
	}

	private String getDefaultPriceHi() {
		return "";
	}

	// executeメソッド
	/*------------------------------------------------------*/
	@Override
	public String execute() {
		this.operatorName = getDefaultOperator();
		this.phoneName = getDefaultPhoneName();
		this.priceLow = getDefaultPriceLow();
		this.priceHi = getDefaultPriceHi();
		return "success";
	}

	// リセットボタンを押したとき ↓↓
	/*------------------------------------------------------*/
	public String reset() {
		this.operatorName = getDefaultOperator();
		this.phoneName = getDefaultPhoneName();
		this.priceLow = getDefaultPriceLow();
		this.priceHi = getDefaultPriceHi();
		this.sessionMap.put("msg", null);
		return "success";
	}

	// 検索ボタンを押したとき ↓↓
	/*------------------------------------------------------*/
	public String search() {
		PhoneDao Dao = new PhoneDao();
		List<?> resultTable = null;
		if (StringUtils.isEmpty(operatorName) && StringUtils.isEmpty(phoneName) && StringUtils.isEmpty(priceLow)
				&& StringUtils.isEmpty(priceHi)) {
			resultTable = Dao.resultList();
		} else {
			operatorName = this.operatorName.trim();
			phoneName = this.phoneName.trim();
			resultTable = Dao.resultList(operatorName, phoneName, priceLow, priceHi);
		}
		this.sessionMap.put("msg", null);
		this.outputTable.addAll(tableTrans(resultTable));
		this.setDelete("true");
		return "success";
	}

	// テーブルの作成 //
	/*------------------------------------------------------*/
	public ArrayList<Phones> tableTrans(List<?> resultTable) {
		ArrayList<Phones> tempTable = new ArrayList<Phones>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Phones temp = new Phones();
				obj = (Object[]) resultTable.get(i);
				Operator o = (Operator) obj[0];
				Phones p = (Phones) obj[1];
				temp.setID(p.getID());
				temp.setOperatorName(o.getOperatorName());
				temp.setPhoneName(p.getPhoneName());
				temp.setPrice(p.getPrice());
				temp.setSize(p.getSize());
				temp.setComment(p.getComment());
				temp.setDate(p.getDate());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PhoneFinderActionを見よ");
		}
		return tempTable;
	}

	// 追加ボタンを押したとき//
	/*------------------------------------------------------*/
	public String update() {
		this.sessionMap.put("deleteID", null);
		try {
			this.response.sendRedirect("/WebApp/training2016/updatePhones.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	// 削除ボタンクリック時、チェックありなら updatePhones へ飛ばす//
	/*------------------------------------------------------*/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("/WebApp/training2016/updatePhones.action");
				;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	// get,setメソッド//↓↓
	/*------------------------------------------------------*/
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName1) {
		phoneName = phoneName1;
	}

	public String getPriceLow() {
		return priceLow;
	}

	public void setPriceLow(String priceLow) {
		this.priceLow = priceLow;
	}

	public String getPriceHi() {
		return priceHi;
	}

	public void setPriceHi(String priceHi) {
		this.priceHi = priceHi;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	/*------------------------------------------------------*/

}
