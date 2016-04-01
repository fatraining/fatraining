package action;

import java.awt.im.InputContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.components.ActionError;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.SessionException;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import dao.GameDao;
import dao.PhoneDao;
import freemarker.template.utility.DateUtil;
import model.Phones;
import model.Operator;

@SuppressWarnings("unused")
@Result(name = "phoneFinder", value = "phoneFinder.action", type = ServletRedirectResult.class)
public class UpdatePhones extends AbstractAction {

	private static final long serialVersionUID = 1L;
	public Map<Integer, String> operators = new HashMap<Integer, String>();
	public String ID;
	public String operatorID;
	public String phoneName;
	public String price;
	public int priceN;
	public String size;
	public String comment;
	public String date;
	public String msg;
	
	// エラー表示
	public String errormsg;
	// 削除画面時の表示項目
	public String delete;
	private Map<String, String> operatorName;

	{
		this.setOperatorName();
	}

	public String execute() throws Exception {
		// deleteを取り出し
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	/* 削除メソッド */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		PhoneDao phone = new PhoneDao();
		phone.delete(this.delete);
		this.msg = "削除が完了しました";
		this.sessionMap.put("msg",this.msg);
		return "phoneFinder";
	}

	/* 追加メソッド */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public String insert() {
		if (this.isEmptyParam(this.phoneName)) {
			addActionError("機種名が未入力です");
		}
		if (this.isEmptyParam(this.price)) {
			addActionError("価格が未入力です");
		} 
		if (this.isEmptyParam(this.size)) {
			addActionError("サイズが未入力です");
		} 
		if (this.isEmptyParam(this.date)) {
			addActionError("日付が未入力です");
			return "error";
		} 
		// 日付の書式を指定する
		DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
		// 日付解析を厳密に行う設定にする
		df.setLenient(false);
		try {
			df.parse(this.date);
			PhoneDao insert = new PhoneDao();
			priceN = Integer.parseInt(this.price);
			insert.insert(this.ID, this.operatorID, this.phoneName, this.priceN, this.size, this.date, this.comment);
		} catch (SessionException |NumberFormatException | ParseException e) {
			addActionError("日付が不正です");
			return "error";
		}
		this.msg = "登録しました";
		sessionMap.put("msg", this.msg);
		return "phoneFinder";
	}

	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	private void setOperatorName() {
		PhoneDao phone = new PhoneDao();
		List<?> resultTable = phone.getOperatorList();
		this.operatorName = tableTrans(resultTable);
	}

	public Map<String, String> getOperatorName() {
		return operatorName;
	}

	/* 事業者のプルダウン作成 */
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new HashMap<String, String>();
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Operator operator = (Operator) resultTable.get(i);
				tempMap.put(operator.getOperatorID(), operator.getOperatorName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}
	/*------------------------------------------------------*/
}
