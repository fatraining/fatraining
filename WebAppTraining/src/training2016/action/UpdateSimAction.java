package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SimDao;
import training2016.model.SimOpe;

@Result(name = "simFinder", value = "simFinder.action", type = ServletRedirectResult.class)
public class UpdateSimAction extends AbstractAction{

	/** 画面タイトル */
	private String title = "Sim追加";
	private static final long serialVersionUID = 1L;
	public String ID;
	public String simService;
	public String charge;
	public String GB;
	public String comment;
	public String msg;
	/** SimOpe名プルダウン用マップ */
	private Map<String, String> simOpeMap = new HashMap<String, String>();

	// エラー表示
	public String errormsg;
	// 削除画面時の表示項目
	public String delete;
	private String simOpeID;


	public String execute() throws Exception {
		this.setSimOpeMap();

		// deleteを取り出し
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	/* イニシャライズ 何回でもsetするよ！*/
	/*------------------------------------------------------*/
	{
		this.setSimOpeMap();

	}
	/* 削除メソッド */
	/*------------------------------------------------------*/
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		SimDao Sim = new SimDao();
		Sim.delete(this.delete);
		this.msg = "削除が完了しました";
		this.sessionMap.put("msg",this.msg);
		return "simFinder";
	}

	/* 追加メソッド */
	/*------------------------------------------------------*/
	public String insert() {
		if (this.isEmptyParam(this.simService)){
			addActionError("Simサービス名が未入力です");
		}
		if (this.isEmptyParam(this.charge)) {
			addActionError("料金が未入力です");
		}
		if (this.isEmptyParam(this.GB)) {
			addActionError("GBが未入力です");
		}
		if (this.isEmptyParam(this.simOpeID)) {
			addActionError("会社名が未入力です");
		}
		if (this.getActionErrors().size() > 0) {
			return "error";
		}


		SimDao insert = new SimDao();
		insert.insert(this.ID, this.simService, this.charge, this.GB, this.comment,this.simOpeID);

		this.msg = "登録しました";
		sessionMap.put("msg", this.msg);
		return "simFinder";
	}

	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}
	//	マップ
	public void setSimOpeMap() {
		SimDao dao = new SimDao();
		List<SimOpe> resultTable = (List<SimOpe>) dao.getSimOpeNameList();
		this.simOpeMap.put("", "");
		for (SimOpe simOpe : resultTable) {
			this.simOpeMap.put(simOpe.getID(), simOpe.getSimOpeName());
		}
	}

	public Map<String, String> getSimOpeMap() {
		return simOpeMap;
	}


	/* 事業者のプルダウン作成 */
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new HashMap<String, String>();
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				SimOpe simOpe = (SimOpe) resultTable.get(i);
				tempMap.put(simOpe.getID(), simOpe.getSimOpeName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}
	/*------------------------------------------------------*/
	public String getTitle() {
		return this.title;
	}
	public String getSimOpeID() {
		return simOpeID;
	}
	public void setSimOpeID(String simOpeID) {
		this.simOpeID = simOpeID;
	}

}