package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.SimDao;
import training2016.model.Sim;
import training2016.model.SimOpe;

public class SimFinderAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "SIM検索";

	// 入力項目 ↓↓
	/*------------------------------------------------------*/
	private String simOpeID;
	private String simService;
	private String charge;
	private String GB;
	/** SimOpe名プルダウン用マップ */
	private Map<String, String> simOpeMap = new HashMap<String, String>();
//	/** 検索結果リスト */
//	public ArrayList<Sim> resultTable = new ArrayList<Sim>();

//	private String simOpeID;


	private String delete;

	public ArrayList<Sim> outputTable = new ArrayList<Sim>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMsg() {
		return (String) this.sessionMap.get("msg");
	}

	/* イニシャライズ 何回でもsetするよ！*/
	/*------------------------------------------------------*/
	{
		this.setSimOpeMap();
	}

	// 初期値の設定 ↓↓
		/*------------------------------------------------------*/
		private String getDefaultSimOpeName() {
			return "";
		}

		private String getDefaultSimService() {
			return "";
		}

		private String getDefaultCharge() {
			return "";
		}

		private String getDefaultGB() {
			return "";
		}
//		private String getDefaultsimOpeID() {
//			return "";
//		}

		// executeメソッド
		/*------------------------------------------------------*/
		@Override
		public String execute() {
			this.simService = getDefaultSimService();
			this.charge = getDefaultCharge();
			this.GB = getDefaultGB();
			this.setSimOpeMap();
//			this.simOpeID = getDefaultsimOpeID();

			return "success";
		}

		private void setSimOpeMap() {
			SimDao dao = new SimDao();
			List<SimOpe> resultTable = (List<SimOpe>) dao.getSimOpeNameList();
			this.simOpeMap.put("", "");
			for (SimOpe simOpe : resultTable) {
				this.simOpeMap.put(simOpe.getID(), simOpe.getSimOpeName());
			}
		}

		// リセットボタンを押したとき ↓↓
		/*------------------------------------------------------*/
		public String reset() {
			this.simOpeID = getDefaultSimOpeName();
			this.simService = getDefaultSimService();
			this.charge = getDefaultCharge();
			this.GB = getDefaultGB();
//			this.simOpeID = getDefaultsimOpeID();
			this.sessionMap.put("msg", null);
			return "success";
		}
		// 検索ボタンを押したとき ↓↓
		/*------------------------------------------------------*/
		public String search() {
			SimDao Dao = new SimDao();
			List<?> resultTable = null;
			if (StringUtils.isEmpty(simOpeID) && StringUtils.isEmpty(simService) && StringUtils.isEmpty(charge)
					&& StringUtils.isEmpty(GB)) {
				resultTable = Dao.resultList();
			} else {
				simOpeID = this.simOpeID.trim();
				simService = this.simService.trim();
				charge = this.charge.trim();
				GB = this.GB.trim();
				resultTable = Dao.resultList(simService, charge, GB,simOpeID);
			}
			this.sessionMap.put("msg", null);
			this.outputTable.addAll(tableTrans1(resultTable));
			this.setDelete("true");
			return "success";
		}
		// テーブルの作成 //
		/*------------------------------------------------------*/
		public ArrayList<Sim> tableTrans1(List<?> resultTable) {
			ArrayList<Sim> tempTable = new ArrayList<Sim>();
			Object[] obj;
			try {
				for (int i = 0; i < resultTable.size(); i++) {
					Sim temp = new Sim();
					obj = (Object[]) resultTable.get(i);
					SimOpe o = (SimOpe) obj[0];
					Sim s = (Sim) obj[1];
					temp.setID(s.getID());
					temp.setSimService(s.getSimService());
					temp.setSimOpeName(o.getSimOpeName());
					temp.setCharge(s.getCharge());
					temp.setGB(s.getGB());
					temp.setComment(s.getComment());
					tempTable.add(temp);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SimFinderActionを見よ");
			}
			return tempTable;
		}
		// 追加ボタンを押したとき//
		/*------------------------------------------------------*/
		public String update() {
			this.sessionMap.put("deleteID", null);
			try {
				this.response.sendRedirect("updateSim.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
		// 削除ボタンクリック時、チェックありなら updatePhones へ飛ばす//
		/*------------------------------------------------------*/
		public String delete() {
			this.sessionMap.put("deleteID", this.delete);
			if (delete == null) {
				addActionError("削除する項目を選択してください");
				search();
				return "error";
			} else {
				try {
					this.response.sendRedirect("updateSim.action");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "success";
			}
		}
		// get,setメソッド//↓↓
		/*------------------------------------------------------*/
		public void setSimOpeID(String simOpeID) {
			this.simOpeID = simOpeID;
		}

		public String getSimOpeID() {
			return simOpeID;
		}

		public String getSimService() {
			return simService;
		}

		public void setSimService(String simService1) {
			simService = simService1;
		}

		public String getCharge() {
			return charge;
		}

		public void setCharge(String charge) {
			this.charge = charge;
		}

		public String getGB() {
			return GB;
		}

		public void setGB(String GB) {
			this.GB = GB;
		}

		public void setsimOpeID(String simOpeID) {
			this.simOpeID = simOpeID;
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
		 * @return simOpeMap
		 */
		public Map<String, String> getSimOpeMap() {
			return this.simOpeMap;
		}

		/*------------------------------------------------------*/

}
