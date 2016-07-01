package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.BeerbrandsDao;
import training2016.model.Beerbrands;
import training2016.model.Birthplace;

public class BeerbrandsSearchAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	private String title = "ビール銘柄検索";

	private Map<String, String> countryMap = new HashMap<String, String>();
	private String country;
	private String beerbrands;
	private String categories;
	private String comment;
	private String delete;

	/** 検索結果リスト */
	public ArrayList<Beerbrands> beerbrandsTable = new ArrayList<Beerbrands>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	@Override
	public String execute() {
		this.initial();
		return "success";
	}

	public void initial() {
		this.country = "";
		this.beerbrands = "";
		this.categories = "";
		this.comment = "";

		BeerbrandsDao dao = new BeerbrandsDao();
		List<?> resultTable = dao.getBirthplaceList();
		this.tableTransPull(resultTable);
	}

	/**プルダウン**/
	public Map<String, String> tableTransPull(List<?> resultTable) {
		try {
			countryMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				Birthplace birthplace = (Birthplace) resultTable.get(i);
				countryMap.put(birthplace.getID(),birthplace.getCountry());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryMap;
	}

	/**リセット**/
	public String reset() {
		this.initial();
		return "success";
	}

	/**検索**/
	public String search() {
		BeerbrandsDao dao = new BeerbrandsDao();
		List<?> resultTable  = null;
		if (StringUtils.isEmpty(country)
				&& StringUtils.isEmpty(beerbrands)
				&& StringUtils.isEmpty(categories)) {

			resultTable = dao.beerbrandsList();

		} else {
			country = this.country.trim();
			beerbrands = this.beerbrands.trim();
			categories = this.categories.trim();

			resultTable = dao.resultList(country,beerbrands,categories);
		}
		this.sessionMap.put("message", null);
		this.beerbrandsTable.addAll(tableTrans(resultTable));
		this.setDelete("true");
		this.initial();
		return "success";

	}

	/**テーブル**/
	public ArrayList<Beerbrands> tableTrans(List<?> resultTable) {
		ArrayList<Beerbrands> tempTable = new ArrayList<Beerbrands>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Beerbrands temp = new Beerbrands();
				obj = (Object[]) resultTable.get(i);
				Birthplace a = (Birthplace) obj[0];
				Beerbrands c = (Beerbrands) obj[1];
				temp.setID(c.getID());
				temp.setCountry(a.getCountry());
				temp.setBeerbrands(c.getBeerbrands());
				temp.setCategories(c.getCategories());
				temp.setComment(c.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/**追加**/
	public String update() {
		this.sessionMap.put("deleteID", null);
		try {
			this.response.sendRedirect("beerbrandsUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**削除**/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選んでください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("beerbrandsUpdate.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/** getterとsetter**/
	public String getTitle() {
		return title;
	}

	public Map<String, String> getCountryMap() {
		return this.countryMap;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getBeerbrands() {
		return beerbrands;
	}
	public void setBeerbrands(String beerbrands) {
		this.beerbrands = beerbrands;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

}
