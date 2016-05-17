package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.HpiventDao;
import training2016.model.GroupName;
import training2016.model.Iventcontents;

public class HpiventSearchAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "H!Pイベント検索";

	// 入力項目 ↓↓
	/*------------------------------------------------------*/
	/** グループ名 */
	private String groupName;
	/** 分類 */
	private String category;
	/** 名称 */
	private String iventName;
	/** 場所 */
	private String place;
	/** 日時1 */
	private String day1;
	/** 日時2 */
	private String day2;
	/** 備考 */
	private String comment;
	/** 削除 */
	private String delete;
	/** 検索結果リスト */
	public ArrayList<Iventcontents> outputTable = new ArrayList<Iventcontents>();


	public String getMsg(){
		return (String) this.sessionMap.get("msg");
	}

	// 初期値の設定 ↓↓
	/*------------------------------------------------------*/
	private String getDefaultGroupName(){
		return "";
	}
	private String getDefaultCategory(){
		return "";
	}
	private String getDefaultIventName(){
		return "";
	}
	private String getDefaultPlace(){
		return "";
	}
	private String getDefaultDay1(){
		return "";
	}
	private String getDefaultDay2(){
		return "";
	}
	private String getDefaultComment(){
		return "";
	}

	// executeメソッド ↓↓
	/*------------------------------------------------------*/
	public String execute(){
		this.groupName = getDefaultGroupName();
		this.category = getDefaultCategory();
		this.iventName = getDefaultIventName();
		this.place = getDefaultPlace();
		this.day1 = getDefaultDay1();
		this.day2 = getDefaultDay2();
		this.comment = getDefaultComment();
		return "success";
	}

	// resetメソッド ↓↓
		/*------------------------------------------------------*/
	public String reset(){
		this.groupName = getDefaultGroupName();
		this.category = getDefaultCategory();
		this.iventName = getDefaultIventName();
		this.place = getDefaultPlace();
		this.day1 = getDefaultDay1();
		this.day2 = getDefaultDay2();
		this.comment = getDefaultComment();
		this.sessionMap.put("msg", null);
		return "success";
	}

	// searchメソッド ↓↓
	/*------------------------------------------------------*/
	public String search(){
		HpiventDao Dao = new HpiventDao();
		List<?> resultTable = null;
		if(StringUtils.isEmpty(groupName) && StringUtils.isEmpty(category) && StringUtils.isEmpty(iventName)
			&& StringUtils.isEmpty(place) && StringUtils.isEmpty(day1) && StringUtils.isEmpty(day2)
			&& StringUtils.isEmpty(comment)){
				resultTable = Dao.resultList();
			}else{
				groupName = this.groupName.trim();
				category = this.category.trim();
				iventName = this.iventName.trim();
				place = this.place.trim();
				comment = this.comment.trim();
				resultTable = Dao.resultList(groupName,category,iventName,place,day1,day2,comment);
			}
			this.sessionMap.put("msg", null);
			this.outputTable.addAll(tableTrans(resultTable));
			this.setDelete("true");
			return "success";
	}
	// テーブルの作成 //
	/*------------------------------------------------------*/
	public ArrayList<Iventcontents> tableTrans(List<?> resultTable) {
		ArrayList<Iventcontents> tempTable = new ArrayList<Iventcontents>();
		Object[] obj;
		try{
			for(int j = 0; j < resultTable.size(); j++) {
				Iventcontents temp = new Iventcontents();
				obj = (Object[]) resultTable.get(j);
				GroupName g = (GroupName) obj[0];
				Iventcontents i = (Iventcontents) obj[1];
				temp.setID(i.getID());
				temp.setGroupID(i.getGroupID());
				temp.setGroupName(g.getGroupName());
				temp.setCategory(i.getCategory());
				temp.setIventName(i.getIventName());
				temp.setPlace(i.getPlace());
				temp.setDay(i.getDay());
				temp.setComment(i.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
		}
		return tempTable;
	}

	// 追加ボタンを押したとき//
	/*------------------------------------------------------*/
	public String update() {
		this.sessionMap.put("deleteID", null);
		try {
			this.response.sendRedirect("hpiventUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	// 削除ボタンクリック時、チェックありなら hpiventUpdate へ飛ばす//
		/*------------------------------------------------------*/
	public String delete(){
		this.sessionMap.put("deleteID", this.delete);
		if(delete == null){
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try{
			this.response.sendRedirect("hpiventUpdate.action");
			}catch (IOException e){
				e.printStackTrace();
			}
			return "success";
			}
	}

	// get,setメソッド//↓↓
	/*------------------------------------------------------*/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setIventName(String iventName) {
		this.iventName = iventName;
	}

	public String getIventName() {
		return iventName;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
		return place;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getDay2() {
		return day2;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDelete() {
		return delete;
	}

	public String getTitle() {
		return this.title;
	}
	/*------------------------------------------------------*/


}