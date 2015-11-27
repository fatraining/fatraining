package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.GameDao;
import model.GameTitle;
import model.GameCompany;
import model.Result13Table;


import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Result(name = "update13", value = "update13.action", type = ServletRedirectResult.class)
public class Main13Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String UserID;
	
	// 入力項目
	private int ID; // ID
	private String Name; // ゲームタイトル
	private String Genre; // ゲームジャンル
	private String Hardware; //機種
	private String Comment; //ゲームコメント
	private String Company; //会社
	
	private String delete;
	private String do_search;
	private String errormsg;
	private String delete_id;

	public ArrayList<Result13Table> outputTable;

	// 初期値の設定
	private String getDefaultName() {
		return null;
//		return "ワリオの森";
	}
	private String getDefaultGenre() {
		return null;
//		return "パズル";
	}
	private String getDefaultHardware() {
		return null;
//		return "FC";
	}

	// executeメソッド
	@Override
	public String execute() {
		this.Name = getDefaultName();
		this.Genre = getDefaultGenre();
		this.Hardware = getDefaultHardware();
		this.delete = "false";
		return "success";
	}

	// resetメソッド
	public String reset() {
		this.Name = getDefaultName();
		this.Genre = getDefaultGenre();
		this.Hardware = getDefaultHardware();
		return "success";
	}

	// 検索ボタンを押したとき
	public String search() {
		// インスタンス化
		GameDao game = new GameDao();
		List<?> resultTable;

		if (StringUtils.isEmpty(this.Name)
			&& StringUtils.isEmpty(this.Genre)
			&& StringUtils.isEmpty(this.Hardware)
		) {
			resultTable = game.resultList();
			
		} else {
			resultTable = game.resultList( this.Name, this.Genre, this.Hardware);
		}
		
		if (resultTable.size() == 0) {
			// 結果を表示しない
			this.do_search = "false";
			// 削除ボタンを表示しない
			this.delete = "false";
			
		} else {
			this.outputTable = tableTrans(resultTable);
			this.do_search = "true";
			this.delete = "true";
		}
		
		return "success";
	}

	// 追加ボタンを押したとき
	// updateメソッド
	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update13.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	// 削除ボタンを押したとき
	// delete_idメソッド
	public String delete_id() {
		this.sessionMap.put("delete_id", this.delete_id);

		if (this.delete_id != null) {

			try {
				this.response.sendRedirect("/PC2015/update13.action");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "success";
		}else{
			return "error";
		}
	}
	
	public String getUserID(){
		return (String) this.sessionMap.get("userId");
	}

	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String Genre) {
		this.Genre = Genre;
	}

	public String getHardware() {
		return Hardware;
	}
	public void setHardware(String Hardware) {
		this.Hardware = Hardware;
	}
	
	public String getComment() {
		return Comment;
	}
	public void setComment(String Comment) {
		this.Comment = Comment;
	}
	
	public String getCompany() {
		return Company;
	}
	public void setCompany(String Company) {
		this.Company = Company;
	}

	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDo_search() {
		return do_search;
	}
	public void setDo_search(String do_search) {
		this.do_search = do_search;
	}

	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getDelete_id() {
		return delete_id;
	}
	public void setDelete_id(String delete_id) {
		this.delete_id = delete_id;
	}

	public ArrayList<Result13Table> getOutputTable() {
		return outputTable;
	}
	public void setOutputTable(ArrayList<Result13Table> outputTable) {
		this.outputTable = outputTable;
	}

	private ArrayList<Result13Table> tableTrans(List<?> resultTable) {
		ArrayList<Result13Table> tempTable = new ArrayList<Result13Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result13Table temp = new Result13Table();
				obj = (Object[]) resultTable.get(i);
				GameTitle gametitle = (GameTitle) obj[1];
				GameCompany gamecompany = (GameCompany) obj[0];
				
				temp.setID(gametitle.getID());
				temp.setName(gametitle.getName());
				temp.setGenre(gametitle.getGenre());
				temp.setHardware(gametitle.getHardware());
				temp.setComment(gametitle.getComment());
				temp.setCompany(gamecompany.getCompany());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

}
