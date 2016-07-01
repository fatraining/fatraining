package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.BeerbrandsDao;
import training2016.model.Birthplace;

@Result(name = "beerbrandsSearch", value = "beerbrandsSearch.action", type = ServletRedirectResult.class)
public class BeerbrandsUpdateAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	private String title = "ビール銘柄追加";

	private Map<String, String> countryMap = new HashMap<String, String>();
	private String ID;
	private String countryID;
	private String beerbrands;
	private String categories;
	private String comment;
	private String message;
	private String delete;

	private boolean isEmptyParam(String param){
		return StringUtils.isEmpty(param);
	}

	/**イニシャライズ**/
	{
		this.setCountryMap();
	}

	/**プルダウン**/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			countryMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				Birthplace birthplace = (Birthplace) resultTable.get(i);
				countryMap.put(birthplace.getID(), birthplace.getCountry());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryMap;
	}

	/**削除**/
	public String execute() throws Exception {
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		BeerbrandsDao dao = new BeerbrandsDao();
		dao.delete(this.delete);
		this.message = "削除が完了しました";
		this.sessionMap.put("message", this.message);
		return "beerbrandsSearch";
	}

	/**追加**/
	public String insert() {

		if(this.isEmptyParam(countryID)) {
			addActionError("国名が未入力です");
		}
		if(this.isEmptyParam(beerbrands)) {
			addActionError("銘柄が未入力です");
		}
		if(this.isEmptyParam(categories)) {
			addActionError("分類が未入力です");
		}
		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {
			return "error";
		}

		BeerbrandsDao insert = new BeerbrandsDao();
		insert.insert(this.ID,
				this.countryID,
				this.beerbrands,
				this.categories,
				this.comment);

		this.message = "登録しました";
		this.sessionMap.put("message", this.message);
		return "beerbrandsSearch";
	}

	/**getとset**/
	public String getTitle(){
		return title;
	}

	public Map<String, String> getCountryMap() {
		return countryMap;
	}

	public void setCountryMap() {
		BeerbrandsDao dao = new BeerbrandsDao();
		List<?> resultTable = dao.getBirthplaceList();
		this.countryMap = tableTrans(resultTable);
	}

	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCountryID() {
		return countryID;
	}
	public void setCountryID(String countryID) {
		this.countryID =countryID;
	}

	public String getBeerbrands() {
		return beerbrands;
	}
	public void setBeerbrands(String beerbrands) {
		this.beerbrands = beerbrands;
	}

	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

}
