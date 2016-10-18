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

import training2016.dao.NorrisDao;
import training2016.model.Norris;
import training2016.model.NorrisSeries;

//Actionクラスのreturn値と出力先を設定する。
@Results({ @Result(name = "update", value = "norrisUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "norrisDelete.action", type = ServletRedirectResult.class) })

public class NorrisSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L; // シリアルバージョンUID

	/* 画面タイトル */
	private String title = "チャック・ノリス検索";

	/** ブラウザからの入力項目 */
	private String message;

	/* エリア */
	private String series;
	/* 温泉名 */
	private String name;
	/* いいねＩＤ */
	private String iineId;
	/*いいね！*/
	private int iine;

	/* 削除ID */
	private String delete;

	/* 更新ID */
	private String updateId;

	/* エリアプルダウン用マップ */
	private Map<String, String> norrisSeriesMap = new HashMap<String, String>();// マップを生成するときに使うもの

	/* 検索リスト */
	public ArrayList<Norris> norrisTable = new ArrayList<Norris>();

	// ～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	// イニシャライザ
	{
		this.setNorrisSeriesMap();
	}

	/* 初期値の設定 */
	private String getDefaultSeries() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	/* executeメソッド→SQLTextプロパティに設定したSQL文をサーバプログラムに対して実行する １番最初に実行 */
	@Override
	public String execute() {
		this.series = getDefaultSeries();
		this.name = getDefaultName();

		this.setNorrisSeriesMap();

		return "success";
	}

	/* リセットボタンを押したとき */
	public String reset() {
		this.series = getDefaultSeries();
		this.name = getDefaultName();
		this.setNorrisSeriesMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/* 検索ボタンを押したとき */
	public String search() {
		NorrisDao Dao = new NorrisDao();
		List<?> resultTable = null; // ワイルドカード「参照するものならなんでも」何かの型のオブジェクトの格納が出来るリスト。その型が何かは分からない。
		if (StringUtils.isEmpty(series) && StringUtils.isEmpty(name)) {
			resultTable = Dao.norrisList(); // nullのとき
		} else {
			series = this.series.trim(); // trim入力時に先頭または後ろに空白がある場合はそれを取り除いて認識する
			name = this.name.trim();

			resultTable = Dao.resultList(series, name); // 条件あり
		}
		this.sessionMap.put("message", null);
		this.norrisTable.addAll(resultTrans(resultTable));
		this.setNorrisSeriesMap();

		return "success";
	}

	/* テーブルの作成 選択されたフォームのパラメータをセットして返す */
	public ArrayList<Norris> resultTrans(List<?> resultTable) {
		ArrayList<Norris> tempTable = new ArrayList<Norris>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Norris temp = new Norris();
				obj = (Object[]) resultTable.get(i);
				Norris a = (Norris) obj[0];
				NorrisSeries aa = (NorrisSeries) obj[1];
				temp.setId(a.getId());
				temp.setIine(a.getIine());
				temp.setSeriesId(a.getSeriesId());
				temp.setSeries(aa.getSeries());
				temp.setName(a.getName());
				temp.setYear(a.getYear());
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
		// セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("norrisUpdate.action"); // 追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/* 削除ボタンを押したとき チェックアリならonsenDelete.actionにとばす */
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("norrisDelete.action"); // チェック項目があれば
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/* setter・getter */
	/**
	 * エリアをセットする
	 *
	 * @param area
	 *            セットする area
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * エリアを返す
	 *
	 * @return area
	 */
	public String getSeries() {
		return this.series;
	}

	/**
	 * 温泉名をセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 温泉名を返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 削除idをsetする
	 *
	 * @param delete
	 *            セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * 削除idを返す
	 *
	 * @return delete
	 */
	public String getDelete() {
		return this.delete;
	}

	/**
	 * 更新idをセットする
	 *
	 * @param updateId
	 *            セットする update
	 */
	public void setUpdateId(String updateId) {

		this.updateId = updateId;
	}

	/**
	 * 更新idを返す
	 *
	 * @return update
	 */
	public String getUpdateId() {
		return this.updateId;
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
	 * エリアマップを返す
	 *
	 * @return OnsenAreaMap
	 */
	public Map<String, String> getNorrisSeriesMap() {
		return this.norrisSeriesMap;
	}

	/**
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setNorrisSeriesMap() {
		NorrisDao dao = new NorrisDao();
		List<?> resultTable = dao.getNorrisSeriesList();
		this.norrisSeriesMap = tableTrans(resultTable); // ListをMapに変換
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			norrisSeriesMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				NorrisSeries aa = (NorrisSeries) resultTable.get(i);
				norrisSeriesMap.put(aa.getId(), aa.getSeries());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return norrisSeriesMap;
	}

	public String getIineId() {
		return this.iineId;
	}

	public void setIineId(String iineId) {
		this.iineId = iineId;
	}

	public String iine() {
		NorrisDao dao = new NorrisDao();
		String[] value=this.iineId.split("/");
		String iineId2=value[0];
		Norris target = dao.select(Integer.parseInt(iineId2), Norris.class);
	    Norris norris=new Norris();
		norris.setId(target.getId());
		iine=(target.getIine()+1);
		norris.setIine(iine);
		norris.setComment(target.getComment());
		norris.setName(target.getName());
		norris.setYear(target.getYear());
		norris.setSeriesId(target.getSeriesId());
		// 更新したテーブルを上書き
		dao.update(norris);
		this.message = "いいね！しました";
		this.sessionMap.put("message", this.message);

		return "success";

	}



}
