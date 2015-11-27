package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import java.util.*;

import dao.GameDao;
import model.GameCompany;
import model.GameTitle;
import model.Result13Table;

@Result(name = "main13", value = "main13.action", type = ServletRedirectResult.class)
public class Update13Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	// 追加画面時の入力項目
	private String UserID;
	public String Name;
	public int CompanyID;
	public String Genre;
	public String Hardware;
	public String Comment;

	private Map<Integer,String> Companies;
    private List<String> Genres = Arrays.asList("RPG","アクション","パズル","サウンドノベル","シミュレーション","アドベンチャー");
	private List<String> Hardwares = Arrays.asList("FC","SFC","N64","GC","Wii","WiiU","PS","PS2","PS3","SS","DC");
	
	// エラー表示
	public String errormsg;
	// 削除画面時の表示項目
	public String delete_id;

	//会社リスト取得
	{
		this.setCompanies();
	}
	
	public String execute() throws Exception {
		// Main12Actionのdelete_idを呼び出し
		this.delete_id = (String) this.sessionMap.get("delete_id");
		this.setCompanies();
		return "success";
	}
// 追加ボタンを押したとき
	
	public String insert() {
		String RegisteredUserID = null;
		
		//ユーザーＩＤがない場合
		if((String) this.sessionMap.get("userId") == null){
			this.errormsg = "ログインしてください。";
			return "errormsg";
		}else{
			RegisteredUserID = (String) this.sessionMap.get("userId");
		}
		
		// 未入力の項目があるときにエラーを返す
		if ( this.Name.isEmpty() 
			|| this.Comment.isEmpty()) {
			this.errormsg = "全項目入力してください。";
			
			return "errormsg";
		}

		// インスタンス化
		GameDao insert = new GameDao();

		// GameDao()のinsertメソッドを参照
		insert.insert(this.Name, this.CompanyID, this.Genre, this.Hardware, this.Comment, RegisteredUserID);

		return "main13";
	}

	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// インスタンス化
		GameDao delete = new GameDao();

		// deleteのdeleteメソッドを参照
		delete.delete(this.delete_id);

		return "main13";
	}
	
	public String getUserID(){
		return (String) this.sessionMap.get("userId");
	}
	
	public void setCompanies(){
		this.Companies = new HashMap<Integer,String>();

		GameDao game = new GameDao();
		List<?> resultTable = game.CompanyList();
		this.Companies = tableTrans(resultTable);

	}
	public Map<Integer,String> getCompanies(){
		return Companies;
	}
	
	public List<String> getGenres(){
		return this.Genres;
	}
	
	public List<String> getHardwares(){
		return this.Hardwares;
	}
	
	private Map<Integer,String> tableTrans(List<?> resultTable) {
		Map<Integer,String> tempMap =new HashMap<Integer,String>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result13Table temp = new Result13Table();
				GameCompany gamecompany = (GameCompany)resultTable.get(i);
				System.out.println(gamecompany);		
				tempMap.put(gamecompany.getID(),gamecompany.getCompany());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}
}
