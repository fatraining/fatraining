package training2016.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.GalgameDao;
import training2016.model.GalgameMaker;
import training2016.model.GalgameProduct;

public class GalgameSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "〇□ゲー批評空間";

	// ブラウザからの入力項目
	/*----------------------------------------------
	*/

	/* メーカー */
	private String makerName;

	/* 商品名 */
	private String name;

	/* 更新ID */
	private String updateId;

	/* 削除ID */
	private String delete;

	// プルダウン用マップ
	/* メーカー */
	private Map<String, String> makerMap = new HashMap<>(); // DBからマッピング

	/* 検索リスト */
	public List<GalgameProduct> galgameTable = new ArrayList<>();

	/* 完了メッセージメッセージ取得 */
	public String getCompleteMessage() {
		return (String) this.sessionMap.get("completeMessage");
	}

	// ～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	// 初期値の設定
	/*----------------------------------------------
	*/

	private String getDefaultMakerName() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}


	/* executeメソッド */
	@Override
	public String execute() {
		this.makerName = getDefaultMakerName();
		this.name = getDefaultName();

		/*	削除または更新・追加のページから遷移した場合
		 * 	completeMessageをnullにしたくないため設定
		 * 	もっとうまいやり方があるはず
		*/
		if(this.sessionMap.get("from") == null) {
			this.sessionMap.put("completeMessage", null);
		} else {
			this.sessionMap.put("from", null);
		}
		this.setMakerMap();
		return "success";
	}


	// 各種ボタンクリック時の処理
	/*----------------------------------------------
	*/

	/* リセットボタンクリック時 */
	public String reset() {
		this.makerName = getDefaultMakerName();
		this.name = getDefaultName();
		this.sessionMap.put("completeMessage", null);
		this.setMakerMap();
		return "success";
	}

	/* 検索ボタンクリック時 */
	public String search() {
		GalgameDao dao = new GalgameDao();
		List<?> resultTable = null;

		if (StringUtils.isEmpty(makerName) && StringUtils.isEmpty(name)) {
			resultTable = dao.galgameList(); // nullのとき
		} else {
			makerName = this.makerName.trim();
			name = this.name.trim();
			resultTable = dao.resultList(makerName, name);
			// 条件が指定されているとき
		}
		this.galgameTable.addAll(resultTrans(resultTable));
		this.setMakerMap();
		this.sessionMap.put("message", null);
		this.sessionMap.put("completeMessage", null);
		return "success";
	}

	/* テーブル作成 */
	public List<GalgameProduct> resultTrans(List<?> resultTable) {
		List<GalgameProduct> table = new ArrayList<>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				GalgameProduct temp = new GalgameProduct();
				obj = (Object[]) resultTable.get(i);
				GalgameProduct gp = (GalgameProduct) obj[0];
				GalgameMaker gm = (GalgameMaker) obj[1];
				temp.setId(gp.getId());
				temp.setMakerId(gp.getMakerId());
				temp.setMakerName(gm.getMakerName());
				temp.setName(gp.getName());
				temp.setYear(gp.getYear());
				temp.setScore(gp.getScore());
				temp.setComment(gp.getComment());
				table.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	/* 削除ボタンクリック時 */
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除するゲームを選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("galgameDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}

	/* 追加ボタンクリック時 */
	public String update() {
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("galgameUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}


	// 各種メッセージ判定
	/*----------------------------------------------
	*/

	/* エラーメッセージ */
	public boolean getHasActionErrors() {
		if(hasActionErrors()) {
			return true;
		} else {
			return false;
		}
	}

	/* 完了メッセージ */
	public boolean getHasCompleteMessage() {
		if((String)this.sessionMap.get("completeMessage") != null) {
			return true;
		} else {
			return false;
		}
	}


	// setter&getter
	/*----------------------------------------------
	*/

	public String getTitle() {
		return this.title;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdateId() {
		return this.updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getDelete() {
		return this.delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public Map<String, String> getMakerMap() {
		return this.makerMap;
	}

	private void setMakerMap() {
		GalgameDao dao = new GalgameDao();
		List<?> resultTable = dao.getMakerNameList();
		this.makerMap = tableTrans(resultTable);
	}

	// メーカープルダウン用マップを返す
	/*----------------------------------------------
	*/

	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.makerMap.put("", "");

			for (int i = 0; i < resultTable.size(); i++) {
				GalgameMaker gm = (GalgameMaker) resultTable.get(i);
				this.makerMap.put(gm.getId(), gm.getMakerName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.makerMap;
	}

}
