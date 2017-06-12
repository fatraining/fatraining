package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.TabacoDao;
import training2016.model.Tabaco;
import training2016.model.TabacoArea;

@Results({
	@Result(name ="tabacoSearch" , value ="tabacoSearch.action" , type = ServletRedirectResult.class)
})
public class TabacoDeleteAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	
	/**画面タイトル*/
	private String title = "削除画面";
	
	/**削除id*/
	private String delete;
	
	/**メッセージ */
	private String message;
	
	/**検索リスト*/
	private List<Tabaco> tabacoTable = new ArrayList<Tabaco>(); //newするの大事
	
	
	public String getUserID() {
		return (String)this.sessionMap.get("userId");
	}
	
	@Override //削除するデータの表示
	public String execute() throws Exception {
		//deleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		//カンマ区切りの削除IDをカンマで分割して配列にする
		String[] deleteId = this.delete.split(" , ");
		//削除対象のレコードを取得する
		TabacoDao dao = new TabacoDao();
		
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.tabacoTable.addAll(resultTrans(resultTable));
		return "succcess";
	}
	
	/** テーブルの作成*/
	//Arrayは数が決まってない
	public ArrayList<Tabaco> resultTrans(List<?> resultTable) {
		ArrayList<Tabaco> tempTable = new ArrayList<Tabaco>();
		Object[] obj;
		try{
			for(int i = 0; i < resultTable.size(); i++){
				Tabaco temp = new Tabaco();
				obj = (Object[])resultTable.get(i);
				Tabaco a = (Tabaco) obj[0];
				TabacoArea aa = (TabacoArea) obj[1];
				temp.setId(a.getId());
				temp.setTabacoAreaId(a.getTabacoAreaId());
				temp.setArea(aa.getArea());//えｒa---------
				temp.setNamePhoto(a.getNamePhoto());
				temp.setName(a.getName());
				temp.setTar(a.getTar());
				temp.setNicotine(a.getNicotine());
				temp.setPrice(a.getPrice());
				temp.setComment(a.getComment());
				
				tempTable.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return tempTable;
	}
	
	/**
	 * 削除メソッド
	 * 削除完了したら検索画面へ遷移へ
	 */
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");
		TabacoDao  dao = new TabacoDao();
		dao.delete(this.delete);
		this.message = "データを削除しました";
		this.sessionMap.put("message", this.message);
		return "tabacoSearch";
	}
	
	/**:
	 *セッター、ゲッターを作成
	 */
	
	public String getTitle() {
		return title;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Tabaco> getTabacoTable() {
		return tabacoTable;
	}

}
