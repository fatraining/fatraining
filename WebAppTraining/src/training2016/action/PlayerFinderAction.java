package training2016.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.PlayerDao;
import training2016.model.Players;
import training2016.model.Team;

@Result(name = "update", value = "updatePlayer.action", type = ServletRedirectResult.class)
public class PlayerFinderAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "J3選手検索";
	/** チームID */
	private String teamID;
	/** チーム名 */
	private String teamName;
	/** 選手名 */
	private String playerName;
	/** ポジション */
	private String position;
	/** 削除ID */
	private String delete;
	/** チーム名プルダウン用マップ */
	private Map<String, String> teamMap;
	/** ポジションプルダウン用マップ */
	private Map<String,String> positionMap = new LinkedHashMap<String, String>();
	/** 検索結果リスト */
	public ArrayList<Players> resultTable = new ArrayList<Players>();


	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMsg() {
		return (String) this.sessionMap.get("msg");
	}

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	@Override
	public String execute() {
		this.fieldInit();
		return "success";
	}

	/**
	 * resetメソッド。 画面の初期表示に戻す。
	 *
	 * @return 結果
	 */
	public String reset() {
		this.fieldInit();
		return "success";
	}

	private void fieldInit() {
		this.setTeamMap();
		this.setPositionMap();
		this.teamID = "";
		this.playerName = "";
		this.position = "";
	}

	// 検索ボタンを押したとき ↓↓
	/*------------------------------------------------------*/
	public String search() {
		PlayerDao dao = new PlayerDao();
		List<Players> resultTable = null;
		/** フォームがnullの場合 */
		if (StringUtils.isEmpty(teamID) && StringUtils.isEmpty(playerName)
				&& StringUtils.isEmpty(position)) {
			resultTable = dao.resultList();
		} else {
			teamID = this.teamID.trim();
			playerName = this.playerName.trim();
			position = this.position.trim();
			resultTable = dao.resultList(teamID, playerName, position);
		}
		this.sessionMap.put("msg", null);
		this.resultTable.addAll(resultTrans(resultTable));
		this.setDelete("true");
		this.setTeamMap();
		this.setPositionMap();
		return "success";
	}

	// 選択されたフォームのパラメータをセットして返す
	/*------------------------------------------------------*/
	public ArrayList<Players> resultTrans(List<?> resultTable) {
		ArrayList<Players> tempTable = new ArrayList<Players>();
		Object[] obj;
		try {
			for (int i=0; i < resultTable.size(); i++) {
				Players temp = new Players();
				obj = (Object[]) resultTable.get(i);
				Team t = (Team) obj[0];
				Players p = (Players) obj[1];
				temp.setPlayerID(p.getPlayerID());
				temp.setTeamID(p.getTeamID());
				temp.setTeamName(t.getTeamName());
				temp.setPlayerName(p.getPlayerName());
				temp.setPosition(p.getPosition());
				temp.setAge(p.getAge());
				temp.setComment(p.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PlayerFinderActionを見よ");
		}
		return tempTable;
	}

	// 追加ボタンを押したとき//
	/*------------------------------------------------------*/
	public String update() {
		this.sessionMap.put("deleteID", null);
		return "update";
	}

	// 削除ボタンクリック時、チェックありなら updatePlayer へ飛ばす//
	/*------------------------------------------------------*/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);

		if (this.delete != null) {
			return "update";
		} else {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		}
	}

	// get,setメソッド//↓↓
	/*------------------------------------------------------*/
	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getTitle() {
		return this.title;
	}

	/**
	 * @return teamMap
	 */
	public Map<String, String> getTeamMap() {
		return teamMap;
	}

	/**
	 * @param teamMap
	 *            セットする teamMap
	 */
	public void setTeamMap() {
		PlayerDao dao = new PlayerDao();
		List<?> resultTable = dao.getTeamList();
		this.teamMap = tableTrans(resultTable);
	}


	/**
	 * @return positionMap
	 */
	public Map<String, String> getPositionMap() {
		return positionMap;
	}

	/**
	 * @param positionMap セットする positionMap
	 */
	public void setPositionMap() {
		this.positionMap.put("","ポジションを選択");
		this.positionMap.put("FW","FW");
		this.positionMap.put("MF","MF");
		this.positionMap.put("DF","DF");
		this.positionMap.put("GK","GK");
	}
	/*------------------------------------------------------*/
	// チーム名プルダウン用マップを返す //
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "チームを選択");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Team team = (Team) resultTable.get(i);
				tempMap.put(team.getID(), team.getTeamName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}

}
