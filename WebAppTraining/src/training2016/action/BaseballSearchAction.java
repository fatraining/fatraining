package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.BaseballDao;
import training2016.model.BaseballPlayer;
import training2016.model.BaseballTeam;

public class BaseballSearchAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	/** 画面タイトル */
	private String title = "野球選手語録検索";

	// 入力項目
	/*------------------------------------------------------*/
	/** 球団ID */
	private String teamID;
	/** 球団プルダウン用マップ */
	private Map<String, String> teamMap = new LinkedHashMap<String, String>();
	/** 球団 */
	private String team;
	/** 選手名 */
	private String baseballPlayer;
	/** 語録 */
	private String comment;
	/** 対象 */
	private String target;
	/** 日付 */
	private String date;
	/** 備考 */
	private String note;
	/** 削除ID */
	private String delete;
	/** 検索結果リスト */
	public ArrayList<BaseballPlayer> baseballPlayerTable = new ArrayList<BaseballPlayer>();


	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// executeメソッド
	/*------------------------------------------------------*/
	@Override
	public String execute() {
		this.initial();
		return "success";
	}

	// リセットボタン押下
	/*------------------------------------------------------*/
	public String reset() {
		this.initial();
		return "success";
	}

	// 初期値の設定
	/*------------------------------------------------------*/
	public void initial() {
		this.team = "";
		this.baseballPlayer = "";
		this.comment = "";
		this.target = "";
		this.date = "";
		this.note = "";
		this.setTeamMap();
	}

	// 検索ボタン押下
	/*------------------------------------------------------*/
	public String search() {
		BaseballDao dao = new BaseballDao();
		List<?> resultTable  = null;
		/** フォームがnullの場合 */
		if (StringUtils.isEmpty(teamID)
				&& StringUtils.isEmpty(baseballPlayer)
				&& StringUtils.isEmpty(comment)
				&& StringUtils.isEmpty(target)
				&& StringUtils.isEmpty(date)
				&& StringUtils.isEmpty(note)) {
			resultTable = dao.BaseballPlayerList();
		} else {
			//条件を入れた場合
			teamID = this.teamID.trim();
			baseballPlayer = this.baseballPlayer.trim();
			comment = this.comment.trim();
			target = this.target.trim();
			date= this.date.trim();
			note = this.note.trim();
			resultTable = dao.resultList(teamID, baseballPlayer, comment, target, date, note);
		}
		this.sessionMap.put("message", null);
		this.baseballPlayerTable.addAll(tableTrans(resultTable));
		this.setDelete("true");
		this.setTeamMap();
		return "success";

	}

	// 選択されたフォームのパラメータをセットして返す（テーブルの作成）
	/*------------------------------------------------------*/
	public ArrayList<BaseballPlayer> tableTrans(List<?> resultTable) {
		ArrayList<BaseballPlayer> tempTable = new ArrayList<BaseballPlayer>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				BaseballPlayer temp = new BaseballPlayer();
				obj = (Object[]) resultTable.get(i);
				BaseballTeam a = (BaseballTeam) obj[0];
				BaseballPlayer c = (BaseballPlayer) obj[1];
				temp.setID(c.getID());
				temp.setTeam(a.getTeam());
				temp.setBaseballPlayer(c.getBaseballPlayer());
				temp.setComment(c.getComment());
				temp.setTarget(c.getTarget());
				temp.setDate(c.getDate());
				temp.setNote(c.getNote());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	// 追加ボタン押下//
	/*------------------------------------------------------*/
	public String update() {
		this.sessionMap.put("deleteID", null);
		try {
			this.response.sendRedirect("baseballUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	// 削除ボタン押下時、チェックありなら baseballUpdate へ飛ばす//
	/*------------------------------------------------------*/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選んでください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("baseballUpdate.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	// getter, setter//
	/*------------------------------------------------------*/
	public String getTitle() {
		return title;
	}

	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	public String getBaseballPlayer() {
		return baseballPlayer;
	}
	public void setBaseballPlayer(String baseballPlayer) {
		this.baseballPlayer = baseballPlayer;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return teamMap
	 */
	public Map<String, String> getTeamMap() {
		return this.teamMap;
	}

	public void setTeamMap() {
		BaseballDao dao = new BaseballDao();
		List<?> resultTable = dao.getBaseballTeamList();
		this.tableTransPull(resultTable);
	}

	//チーム名プルダウン用マップを返す
	/*------------------------------------------------------*/
	public Map<String, String> tableTransPull(List<?> resultTable) {
		try {
			teamMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				BaseballTeam team = (BaseballTeam) resultTable.get(i);
				teamMap.put( team.getID(), team.getTeam());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teamMap;
	}
}
