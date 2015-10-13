package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.StaffDao;
import model.Company;
import model.Result11Table;
import model.Staff;



public class Main11Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**
	 * 検索ボックスの名前
	 */
	public String sName;
	/**
	 * 検索ボックスの都道府県(住所）
	 */
	public String prefecture;
	/**
	 * 検索ボックスの所属会社名
	 */
	public String cName;
	/**
	 * 削除チェックボックス
	 */
	public String delete_id;
	/**
	 * 削除エラーメッセージ表示フラグ
	 */
	public String errormsg;
	/**
	 * 検索結果表示フラグ
	 */
	public String do_search;
	/**
	 * 削除ボタン表示フラグ
	 */
	public String delete;
	
	public ArrayList<Result11Table> outputTable;
	/**
	 * 名前検索ボックス初期化
	 */
	public String getDefaultSName() {
		return "";
	}
	/**
	 * 都道府県(住所)検索ボックス初期化
	 */
	public String getDefaultPrefecture() {
		return "";
	}
	/**
	 * 所属会社名検索ボックス初期化
	 */
	public String getDefaultCName() {
		return "";
	}
	/**
	 * main11.actionアクセス時初期化処理
	 */
	public String execute() {
		this.sName = getDefaultSName();
		this.prefecture = getDefaultPrefecture();
		this.cName = getDefaultCName();
		return "success";
	}
	/**
	 * 検索ボックス初期化処理
	 */
	public String reset() {
		this.sName = getDefaultSName();
		this.prefecture = getDefaultPrefecture();
		this.cName = getDefaultCName();
		return "success";
	}
	/**
	 * 検索ボタンの処理<br>
	 * 取得した検索結果を<br>
	 * List&lt;[0]Staff(Object),[1]Company(Object)&gt;<br>
	 * →　ArrayList&lt;Result11Table&gt;に直して取得
	 */
	public String search() {
		//削除ボタンを押した際、エラーが発生した場合に検索結果を表示するための処理
		 this.sessionMap.put("sName",this.sName);
		 this.sessionMap.put("prefecture",this.prefecture);
		 this.sessionMap.put("cName",this.cName);
		
		 //検索結果取得リスト（Objectクラス)
		List<?> resultTable = null;
		StaffDao StaffController = new StaffDao();
		if (this.sName.isEmpty() && this.prefecture.isEmpty() && this.cName.isEmpty()) {
			resultTable = StaffController.searchResult();
		} else {
			resultTable = StaffController.searchResult(this.sName, this.prefecture, this.cName);
		}
		
		this.outputTable = tableTrans(resultTable);
		Map<Integer, String> lockMap = new HashMap<Integer, String>();
//		for(int i=0;i<outputTable.size();i++){
		for (Result11Table t : this.outputTable) {
			lockMap.put(t.getId(), t.getSUpdatedate());
//			this.sessionMap.put("id"+i,outputTable.get(i).getId());
//			this.sessionMap.put("updatedate"+i,outputTable.get(i).getSUpdatedate());
		}
		this.sessionMap.put("lockMap", lockMap);
		
		this.do_search = "true";
		this.delete = "true";
		return "success";
	}
	/**
	 * 追加ボタンの処理<br>
	 * 追加画面(更新画面)に移動
	 */
	public String update() {
		//追加画面を表示させるための事前処理
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update11.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * 削除ボタンの処理
	 */
	public String delete_id() {
		this.sessionMap.put("delete_id", this.delete_id);
		
		Map<Integer, String> lockMap = (Map) this.sessionMap.get("lockMap");
		
		//削除チェックがされていない場合
		if (this.delete_id == null) {
			
			//検索結果表示処理
			this.sName = (String) this.sessionMap.get("sName");
			this.prefecture = (String) this.sessionMap.get("prefecture");
			this.cName = (String) this.sessionMap.get("cName");
			List<?> resultTable = null;
			StaffDao StaffController = new StaffDao();
			if (this.sName.isEmpty() && this.prefecture.isEmpty() && this.cName.isEmpty()) {
				resultTable = StaffController.searchResult();
			} else {
				resultTable = StaffController.searchResult(this.sName, this.prefecture, this.cName);
			}
			this.outputTable = tableTrans(resultTable);
			
			this.errormsg = "true";
			this.do_search = "true";
			this.delete = "true";
			return "success";
		}
		try {
			this.response.sendRedirect("/PC2015/update11.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 検索取得データ（List&lt;?&gt;)を結果を表示する形式
	 * (ArraｙList&lt;Result11Table&gt;)に直して返す
	 */
	private ArrayList<Result11Table> tableTrans(List<?> resultTable) {
		ArrayList<Result11Table> tempTable = new ArrayList<Result11Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result11Table temp = new Result11Table();
				obj = (Object[]) resultTable.get(i);
				Staff staff = (Staff) obj[0];
				Company company = (Company) obj[1];
				temp.setId(staff.getId());
				temp.setSName(staff.getName());
				temp.setSPrefecture(staff.getPrefecture());
				temp.setSPhonenumber(staff.getPhoneNumber());
				temp.setSUpdatedate(staff.getUpdateDate());
				temp.setCName(company.getName());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

}
