package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dao.SoccerPlayerDao;
import model.NationalTeam;
import model.NationalTeamPlayer;
import model.PlayerSearchResult;

public class SoccerPlayerSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String userId;

	// 入力項目
	private int id; // ID
	private String name;  // 代表名
	private String number; // 背番号

	private String delete;
	private String do_search;
	private String errormsg;
	private String delete_id;

	public ArrayList<PlayerSearchResult> outputTable;

	// 初期値の設定
	private String getDefaultName() {
		return null;
	}
	private String getDefaultNumber() {
		return null;
	}

	// executeメソッド
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.number = getDefaultNumber();
		this.delete = "false";
		return "success";
	}

	// resetメソッド
	public String reset() {
		this.name = getDefaultName();
		this.number = getDefaultNumber();
		return "success";
	}

	// 検索ボタンを押したとき
	public String search() {
		// インスタンス化
		SoccerPlayerDao dao = new SoccerPlayerDao();
		List<?> resultTable = null;

		if (StringUtils.isEmpty(this.name)
			&& StringUtils.isEmpty(this.number)
		) {
			resultTable = dao.resultList();
		} else {
			resultTable = dao.resultList( this.name, this.number);
		}

		if (resultTable.size() == 0) {
			// 結果を表示しない
			this.do_search = "false";
			// 削除ボタンを表示しない
			this.delete = "false";

		} else {
			this.outputTable = this.tableTrans(resultTable);
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
			this.response.sendRedirect("/PC2015/soccerPlayerUpdate.action");
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
				this.response.sendRedirect("/PC2015/soccerPlayerUpdate.action");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "success";
		}else{
			return "error";
		}
	}

	public String getUserId(){
		return (String) this.sessionMap.get("userId");
	}

	public int getId() {
		return id;
	}
	public void setd(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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

	public ArrayList<PlayerSearchResult> getOutputTable() {
		return outputTable;
	}
	public void setOutputTable(ArrayList<PlayerSearchResult> outputTable) {
		this.outputTable = outputTable;
	}

	private ArrayList<PlayerSearchResult> tableTrans(List<?> resultTable) {
		ArrayList<PlayerSearchResult> tempTable = new ArrayList<PlayerSearchResult>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				PlayerSearchResult temp = new PlayerSearchResult();
				obj = (Object[]) resultTable.get(i);
				NationalTeam team = (NationalTeam) obj[0];
				NationalTeamPlayer player = (NationalTeamPlayer) obj[1];

				temp.setId(player.getId());
				temp.setName(player.getName());
				temp.setNumber(String.valueOf(player.getNumber()));
				temp.setTeamName(team.getName());
				temp.setPosition(player.getPosition());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

}
