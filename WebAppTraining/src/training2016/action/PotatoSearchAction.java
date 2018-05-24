package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.PotatoDao;
import training2016.model.PotatoMaker;
import training2016.model.PotatoProduct;

@Results({ @Result(name = "update", value = "potatoUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "potatoDelete.action", type = ServletRedirectResult.class) })

public class PotatoSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "ポテトチップス検索";

	// ブラウザからの入力項目
	/*----------------------------------------------
	*/

	/* メーカー */
	private String makerName;

	/* 商品名 */
	private String name;

	/* 商品タイプ */
	private String type;

	/* 更新ID */
	private String updateId;

	/* 削除ID */
	private String delete;

	// プルダウン用マップ
	/* メーカー */
	private Map<String, String> makerMap = new HashMap<>(); // DBからマッピング

	/* 商品タイプ */
	private Map<String, String> typeMap = new LinkedHashMap<>(); // 配列を取得

	/* 検索リスト */
	public List<PotatoProduct> potatoTable = new ArrayList<>();

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

	private String getDefaultType() {
		return "";
	}

	/* executeメソッド */
	@Override
	public String execute() {
		this.makerName = getDefaultMakerName();
		this.name = getDefaultName();
		this.type = getDefaultType();

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
		this.setTypeMap();
		return "success";
	}


	// 各種ボタンクリック時の処理
	/*----------------------------------------------
	*/

	/* リセットボタンクリック時 */
	public String reset() {
		this.makerName = getDefaultMakerName();
		this.name = getDefaultName();
		this.type = getDefaultType();
		this.sessionMap.put("completeMessage", null);
		this.setMakerMap();
		this.setTypeMap();
		return "success";
	}

	/* 検索ボタンクリック時 */
	public String search() {
		PotatoDao dao = new PotatoDao();
		List<?> resultTable = null;

		if (StringUtils.isEmpty(makerName) && StringUtils.isEmpty(name) && StringUtils.isEmpty(type)) {
			resultTable = dao.potatoList(); // nullのとき
		} else {
			makerName = this.makerName.trim();
			name = this.name.trim();
			type = this.type.trim();
			resultTable = dao.resultList(makerName, name, type);
			// 条件が指定されているとき
		}
		this.potatoTable.addAll(resultTrans(resultTable));
		this.setMakerMap();
		this.setTypeMap();
		this.sessionMap.put("message", null);
		this.sessionMap.put("completeMessage", null);
		return "success";
	}

	/* テーブル作成 */
	public List<PotatoProduct> resultTrans(List<?> resultTable) {
		List<PotatoProduct> table = new ArrayList<>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				PotatoProduct temp = new PotatoProduct();
				obj = (Object[]) resultTable.get(i);
				PotatoProduct pp = (PotatoProduct) obj[0];
				PotatoMaker pm = (PotatoMaker) obj[1];
				temp.setId(pp.getId());
				temp.setMakerId(pp.getMakerId());
				temp.setMakerName(pm.getMakerName());
				temp.setName(pp.getName());
				temp.setType(pp.getType());
				temp.setVolume(pp.getVolume());
				temp.setPrice(pp.getPrice());
				temp.setComment(pp.getComment());
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
			addActionError("食べきるポテチを選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("potatoDelete.action");
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
			this.response.sendRedirect("potatoUpdate.action");
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
		PotatoDao dao = new PotatoDao();
		List<?> resultTable = dao.getMakerNameList();
		this.makerMap = tableTrans(resultTable);
	}

	public Map<String, String> getTypeMap() {
		return this.typeMap;
	}

	// 商品タイププルダウン用マップをセット
	private void setTypeMap() {
		this.typeMap.put("", "");
		this.typeMap.put("通常販売", "通常販売");
		this.typeMap.put("地域限定", "地域限定");
		this.typeMap.put("期間限定", "期間限定");
		this.typeMap.put("その他", "その他");
	}

	// メーカープルダウン用マップを返す
	/*----------------------------------------------
	*/

	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.makerMap.put("", "");

			for (int i = 0; i < resultTable.size(); i++) {
				PotatoMaker pm = (PotatoMaker) resultTable.get(i);
				this.makerMap.put(pm.getId(), pm.getMakerName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.makerMap;
	}

}
