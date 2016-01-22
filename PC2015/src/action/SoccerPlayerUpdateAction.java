package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.SoccerPlayerDao;
import model.NationalTeam;

@Result(name = "search", value = "soccerPlayerSearch.action", type = ServletRedirectResult.class)
public class SoccerPlayerUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 追加画面時の入力項目
	private String userId;
	public String number;
	public String name;
	public int nationalTeamId;
	public String position;

	private Map<Integer,String> nationalTeams = new HashMap<Integer, String>();

	// エラー表示
	public String errormsg;
	// 削除画面時の表示項目
	public String delete_id;

	//会社リスト取得
	{
		this.setNationalTeams();
	}

	public String execute() throws Exception {
		// delete_idを取り出し
		this.delete_id = (String) this.sessionMap.get("delete_id");
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
		if ( StringUtils.isEmpty(this.number)
				|| StringUtils.isEmpty(this.name)
				|| StringUtils.isEmpty(this.position)) {
			this.errormsg = "全項目入力してください。";

			return "errormsg";
		}

		// インスタンス化
		SoccerPlayerDao insert = new SoccerPlayerDao();

		// insertメソッド
		insert.insert(this.number, this.name, this.nationalTeamId, this.position, RegisteredUserID);

		return "search";
	}

	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// インスタンス化
		SoccerPlayerDao delete = new SoccerPlayerDao();

		// deleteのdeleteメソッドを参照
		delete.delete(this.delete_id);

		return "search";
	}

	public String getUserID(){
		return (String) this.sessionMap.get("userId");
	}

	public void setNationalTeams(){
		this.nationalTeams = new HashMap<Integer,String>();

		SoccerPlayerDao dao = new SoccerPlayerDao();
		List<?> resultTable = dao.getNationalTeamList();
		this.nationalTeams = tableTrans(resultTable);

	}
	public Map<Integer,String> getNationalTeams(){
		return nationalTeams;
	}


	private Map<Integer,String> tableTrans(List<?> resultTable) {
		Map<Integer,String> tempMap = new HashMap<Integer,String>();
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				NationalTeam entity = (NationalTeam)resultTable.get(i);
				tempMap.put(entity.getId(),entity.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}
}
