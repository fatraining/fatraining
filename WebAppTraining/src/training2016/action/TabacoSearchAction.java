package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.TabacoDao;
import training2016.model.Tabaco;
import training2016.model.TabacoArea;

@Results({ @Result(name = "update", value = "tabacoUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "tabacoDelete.action", type = ServletRedirectResult.class) })

public class TabacoSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル画面 */
	private String title = "たばこ検索";

	/** ブラウザからの入力項目 */

	/* 銘柄名 */
	private String area;

	/* 商品名 */
	private String name;

	/* タール数 */
	private String tar;

	/* 更新ID */
	private String updateId;

	/* 削除ID */
	private String delete;

	/* エリアプルダウン用マップ */
	private Map<String, String> tabacoAreaMap = new HashMap<String, String>();/* DBとマッピング */

	/* 検索リスト */
	public ArrayList<Tabaco> tabacoTable = new ArrayList<Tabaco>();

	/** ～さんのところ */
	public String getUserId() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	/** イニシャライザ */
	{
		this.setTabacoAreaMap();
	}

	/* 初期値の設定 */
	private String getDefaultArea() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultTar() {
		return "";
	}

	/* executeメソッド 一番最初に実行 */
	@Override
	public String execute() {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.tar = getDefaultTar();
//		this.setTabacoAreaMap();
		return "success";
	}

	/* リセットボタンを押したとき */
	public String reset() {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.tar = getDefaultTar();
//		this.setTabacoAreaMap();
		this.sessionMap.put("message", null);
		return "success";
	}

	/* 検索ボタンを押したとき */
	public String search() {
		TabacoDao dao = new TabacoDao();
		List<?> resultTable = null;// ワイルドカード【検索する際にどんなパターンにもマッチする特殊文字。】
		if (StringUtils.isEmpty(area) && // Empty == 空(NULL)ってこと
				StringUtils.isEmpty(tar) && StringUtils.isEmpty(name)) {
			resultTable = dao.tabacoList(); // 検索がnullのとき
		} else {
			area = this.area.trim();
			tar = this.tar.trim();
			name = this.name.trim();
			resultTable = dao.resultList(area, tar, name); // 検索条件ありの時
		}
		this.sessionMap.put("message", null);
		this.tabacoTable.addAll(resultTrans(resultTable));
		this.setTabacoAreaMap();

		return "success";
	}

	/* テーブルの作成 選択されたフォームのパラメータをセットにして返す */
	public ArrayList<Tabaco> resultTrans(List<?> resultTable) {
		ArrayList<Tabaco> tempTable = new ArrayList<Tabaco>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Tabaco temp = new Tabaco();
				obj = (Object[]) resultTable.get(i);
				Tabaco a = (Tabaco) obj[0];
				TabacoArea aa = (TabacoArea) obj[1];
				temp.setId(a.getId());
				temp.setTabacoAreaId(a.getTabacoAreaId());
				temp.setArea(aa.getArea());// えｒa---------
				temp.setNamePhoto(a.getNamePhoto());
				temp.setName(a.getName());
				temp.setTar(a.getTar());
				temp.setNicotine(a.getNicotine());
				temp.setPrice(a.getPrice());
				temp.setComment(a.getComment());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/* 追加ボタンを押したとき */
	public String update() {
		// セッションマップに指定されたキーでvalueをputする
		this.putValueToSession("updateId", this.updateId);// 同じ名前を使っているobjと結びつける。
		try {
			this.response.sendRedirect("tabacoUpdate.action");// 追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/* 削除ボタンを押したとき、チェックありならtabacoDeleteActionにとばす */
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除したいデータにチェック!!!");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("tabacoDelete.action");// チェック項目があれば
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/**
	 * エリア(銘柄名)プルダウン用マップをセットする
	 */
	public void setTabacoAreaMap() {
		TabacoDao dao = new TabacoDao();
		List<?> resultTable = dao.getTabacoAreaList();// ワイルドカード
		this.tabacoAreaMap = tableTrans(resultTable);
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			tabacoAreaMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				TabacoArea tt = (TabacoArea) resultTable.get(i);
				tabacoAreaMap.put(tt.getId(), tt.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabacoAreaMap;
	}

	/* セッターゲッター */

	/**
	 * エリアマップを返す
	 */
	public Map<String, String> getTabacoAreaMap() {
		return this.tabacoAreaMap;
	}

	/* setter・getter */
	/**
	 * エリア【銘柄名】をセットする
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * tar【タール数】をセットする
	 */
	public void setTar(String tar) {
		this.tar = tar;
	}

	/**
	 * name【商品名】をセットする
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 更新idを返す
	 *
	 * @return update
	 */
	public void setUpdateId(String updateId){
		this.updateId = updateId;
	}
	
	public String getUpdateId() {
		return this.updateId;
	}

	/**
	 * 削除idをセットする
	 *
	 */
	public void setDelete(String delete) {

		this.delete = delete;
	}

	/**
	 * 削除idを返す
	 *
	 */
	public String getDelete() {
		return this.delete;
	}

	/**
	 * 画面タイトルを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * エリアを返す
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * nameを返す
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * tarを返す
	 */
	public String getTar() {
		return this.tar;
	}
}
