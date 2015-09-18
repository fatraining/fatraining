package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Busyo;
import model.Kaisya;
import model.KaisyaResultTable;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.KaisyaDao;

@Result(name = "kaisyaAdd", value = "kaisyaAdd.action", type = ServletRedirectResult.class)
public class KaisyaSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// テーブルで作ったカラム　検索画面にて検索をかけたいカラム名
	public String syamei;
	public String name;
	public String busyo;
	// メソッドを起こすための変数
	public String delete_id;
	public String do_search;
	public String delete;
	public String userId;
	public String errormsg;

	public ArrayList<KaisyaResultTable> outputTable;

	// 変数に値を代入
	private String getDefaultSyamei() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultBusyo() {
		return "";
	}

	// executeメソッド　メソッドが呼ばれたとき変数に代入した値が表示
	@Override
	public String execute() {
		this.syamei = getDefaultSyamei();
		this.name = getDefaultName();
		this.busyo = getDefaultBusyo();
		this.delete = "false";
		return "success";
	}

	// resetメソッド　メソッドが呼ばれたとき最初の状態にする。(executeメソッドが呼ばれた時の状態)
	public String reset() {
		this.syamei = getDefaultSyamei();
		this.name = getDefaultName();
		this.busyo = getDefaultBusyo();
		return "success";
	}

	// searchメソッド
	public String search() {

		this.sessionMap.put("syamei", this.syamei);
		this.sessionMap.put("name", this.name);
		this.sessionMap.put("busyo", this.busyo);

		KaisyaDao kaisyaManager = new KaisyaDao();
		List<?> resultTable;

		if (this.syamei.isEmpty() && this.name.isEmpty()
				&& this.busyo.isEmpty()) {
			resultTable = kaisyaManager.resultList();

		} else {
			resultTable = kaisyaManager.resultList(this.syamei, this.name,
					this.busyo);
		}
		this.outputTable = tableTrans(resultTable);

		this.do_search = "true";
		this.delete = "true";
		return "success";
	}

	// 　updateメソッド
	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/kaisyaAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// delete_idメソッド
	public String delete_id() {
		this.sessionMap.put("delete_id", this.delete_id);

		if (this.delete_id == null) {

			KaisyaDao kaisyaManager = new KaisyaDao();

			this.syamei = (String) this.sessionMap.get("syamei");
			this.name = (String) this.sessionMap.get("name");
			this.busyo = (String) this.sessionMap.get("busyo");

			List<?> resultTable;

			if (this.syamei.isEmpty() && this.name.isEmpty()
					&& this.busyo.isEmpty()) {
				resultTable = kaisyaManager.resultList();

			} else {
				resultTable = kaisyaManager.resultList(this.syamei, this.name,
						this.busyo);
			}
			this.outputTable = tableTrans(resultTable);

			this.errormsg = "true";
			this.do_search = "true";
			this.delete = "true";
			return "success";
		}

		try {
			this.response.sendRedirect("/PC2015/kaisyaAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// 　検索結果の表示
	private ArrayList<KaisyaResultTable> tableTrans(List<?> resultTable) {
		ArrayList<KaisyaResultTable> tempTable = new ArrayList<KaisyaResultTable>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				KaisyaResultTable temp = new KaisyaResultTable();
				obj = (Object[]) resultTable.get(i);
				Busyo busyo = (Busyo) obj[0];
				Kaisya kaisya = (Kaisya) obj[1];
				temp.setId(kaisya.getId());
				temp.setSyamei(kaisya.getSyamei());
				temp.setName(kaisya.getName());
				temp.setNyusyabi(kaisya.getNyusyabi());
				temp.setBusyo(busyo.getBusyo());
				temp.setComment(kaisya.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}