package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.annotations.ActionField;
import training2016.dao.CopyDao;
import training2016.dao.TitleDao;
import training2016.model.Copy;
import training2016.model.CopySearchCondition;

/**
 * コピー能力検索Action
 *
 * @author minoguchi
 */
@Results({ @Result(name = "update", value = "copyUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "copyDelete.action", type = ServletRedirectResult.class) })
public class CopySearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String titlename = "ピンクだま検索";

	/** コピー名 */
	@ActionField(name = "name")
	private String name;
	/** ゲームタイトル */
	@ActionField(name = "title")
	private String title;
	/** 検索結果マップ */
	private Map<String, String> titleMap;
	/** 更新ID */
	private String updateId;
	/** 削除ID */
	private String[] deleteId;
	/** 検索結果リスト */
	private List<Copy> resultList;

	// イニシャライザ
	{
		this.setTitleMap();
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

	/**
	 * フィールド初期化
	 */
	private void fieldInit() {
		this.name = "";
		this.title = "";
		this.setIsSearched(false);
	}

	/**
	 * 検索ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String search() {
		this.doSearch();
		return "success";
	}

	/**
	 * 検索を行う。
	 */
	private void doSearch() {
		CopyDao dao = new CopyDao();
		CopySearchCondition cond = new CopySearchCondition();
		if (StringUtils.isEmpty(this.name) && StringUtils.isEmpty(this.title)) {
			//消されていないものを
			cond.setDeleteFlag("0");
			this.resultList = dao.getByCondition(cond);
		} else {
			cond.setName(this.name);
			System.out.println(name);
			cond.setTitleid(this.title);
			//消されていないものを
			cond.setDeleteFlag("0");
			this.resultList = dao.getByCondition(cond);
		}
		this.setIsSearched(true);
	}

	/**
	 * 追加ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String update() {
		this.putValueToSession("updateId", this.updateId);
		// 退避
		this.backUp(this);
		return "update";
	}

	/**
	 * 削除ボタン押下時メソッド
	 *
	 * @return 結果
	 */
	public String delete() {
		if (this.deleteId != null && this.deleteId.length > 0) {
			this.sessionMap.put("deleteId", this.deleteId);
			// 退避
			this.backUp(this);
			return "delete";
		} else {
			this.addActionError("削除対象を決めてください");
			return "error";
		}
	}

	/**
	 * 画面再描画。 リセットではなく、他画面から戻ってくる時に呼び出す。
	 *
	 * @return
	 */
	public String redisplay() {
		// 退避
		this.restore(this);
		if (this.getIsSearched()) {
			this.doSearch();
		}
		return "success";
	}

	/**
	 * DBから取得したエリア情報を元に プルダウン用エリアマップを作成してセットする
	 */
	private void setTitleMap() {
		TitleDao dao = new TitleDao();
		this.titleMap = dao.getAll().stream().collect(() -> new LinkedHashMap<String, String>(),
				(map, title) -> map.put(String.valueOf(title.getId()), title.getName()), (map, title) -> map.putAll(map));
		// タイトル未選択時用
		this.titleMap.put("", "選択しない");
	}

	/**
	 * タイトルマップを返す
	 *
	 * @return タイトルマップ
	 */
	public Map<String, String> getTitleMap() {
		return this.titleMap;
	}

	/**
	 * 画面タイトルを返す
	 *
	 * @return pagetitle
	 */
	public String getTitleName() {
		return this.titlename;
	}

	/**
	 * 店舗名を返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 店舗名をセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 店舗エリアを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 店舗エリアをセットする
	 *
	 * @param title
	 *            セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 更新IDを返す
	 *
	 * @return updateId
	 */
	public String getUpdateId() {
		return this.updateId;
	}

	/**
	 * 更新IDをセットする
	 *
	 * @param updateId
	 *            セットする updateId
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * 削除IDを返す
	 *
	 * @return deleteId
	 */
	public String[] getDeleteId() {
		return this.deleteId;
	}

	/**
	 * 削除IDをセットする
	 *
	 * @param deleteId
	 *            セットする deleteId
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	/**
	 * 検索結果リストを返す
	 *
	 * @return resultList
	 */
	public List<Copy> getResultList() {
		return this.resultList;
	}
}
