package training2016.action;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.DramaDao;
import training2016.model.Drama;
import training2016.model.DramaGenre;


/**
 * 作品の追加・更新のあくしょん
 *
 */
@Results({
@Result(name = "dramaSearch", value ="dramaSearch.action", type = ServletRedirectResult.class)
})
public class DramaUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title;
	/**ボタンの表示名*/
	private String updateBtnTitle;

	/**id(更新時のみ)*/
	private String id;
	/**ジャンルid*/
	private String dramaGenreId;
	/**作品名*/
	private String name;
	/**キャスト*/
	private String cast;
	/**放送局*/
	private String tvStation;
	/**コメント*/
	private String comment;
	/**メッセージ*/
	private String message;
	/**エラーメッセージ*/
	private String errorMessage;

	/**ジャンルプルダウン用マップ*/
	private Map<String, String> dramaGenreMap = new HashMap<String, String>();

	/**キャストプルダウン用マップ*/
	private Map<String, String> castMap = new LinkedHashMap<String, String>();

	// イニシャライザ
	{
		this.setDramaGenreMap();
	}

	@Override //更新
	public String execute() throws Exception {
		this.setDramaGenreMap();
		this.setCastMap();
		//セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");
		DramaDao dao = new DramaDao();
		Drama target = null;
		//更新対象idがあればデータの更新をする
		if(StringUtils.isNotEmpty(this.id)) {

			target = dao.select(Integer.parseInt(this.id), Drama.class);
			if(target != null) {
				this.dramaGenreId = String.valueOf(target.getDramaGenreId());
				this.name = target.getName();
				this.cast = target.getCast();
				this.tvStation = target.getTvStation();
				this.comment = target.getComment();
				this.updateBtnTitle = "更新";  //ボタンのvalueを追加→更新
				this.title ="韓国ドラマを更新";
			}
		} else {
			//新規
			this.id = "";
			this.title = "韓国ドラマの追加";
			this.updateBtnTitle = "追加";
		}
		return "success";
	}


	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/**
	 * updateメソッド
	 * idがあれば更新、なければ追加になる
	 * 更新、追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setDramaGenreMap();
		this.setCastMap();

		if(StringUtils.isNotEmpty(this.id)) {
			this.title = "韓国ドラマの更新（リトライ）";
			this.updateBtnTitle = "更新";
		} else {
			this.title = "韓国ドラマの追加（リトライ）";
			this.updateBtnTitle = "追加";
		}

		if(this.isEmptyParam(dramaGenreId)) {
			addActionError("ジャンルを入力セヨ");
		}
		if(this.isEmptyParam(name)) {
			addActionError("作品名を入力セヨ");
		}
		if(this.isEmptyParam(cast)) {
			addActionError("キャストを入力セヨ");
		}
		if(this.isEmptyParam(tvStation)) {
			addActionError("放送局を入力セヨ");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("コメントを入力セヨ");
		}
		//一つでもエラーがあればだめ
		if(this.getActionErrors().size() > 0) {
			return "error";
		}

		//idがあれば更新なので、一度取得したモデルに入力値をセットする
		DramaDao dao = new DramaDao();
		if(StringUtils.isNotEmpty(this.id)) {
			Drama target = dao.select(Integer.parseInt(this.id), Drama.class);
			dao.update(this.generateDramaModel(target));
			this.message = "更新完了ニダ";
			this.sessionMap.put("message", this.message);
		} else {
			this.title = "韓国ドラマを追加";
			dao.insert(this.id,
					   this.dramaGenreId,
					   this.name,
					   this.cast,
					   this.tvStation,
					   this.comment);
			this.message = "追加完了ニダ";
			this.sessionMap.put("message", this.message);
		}

		return "dramaSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Drama generateDramaModel(Drama target) {
		target.setDramaGenreId(Integer.parseInt(this.dramaGenreId));
		target.setName(this.name);
		target.setCast(this.cast);
		target.setTvStation(this.tvStation);
		target.setComment(this.comment);

		return target;
	}

	/*setter・getter*/
	/**
	 * updateBtnTitleを返す
	 * @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}

	/**
	 * titleを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * idをセットする
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * idを返す
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * dramaGenreIdをセットする
	 * @param dramaGenreId セットする dramaGenreId
	 */
	public void setDramaGenreId(String dramaGenreId) {
		this.dramaGenreId = dramaGenreId;
	}

	/**
	 * dramaGenreIdを返す
	 * @return dramaGenreId
	 */
	public String getDramaGenreId() {
		return this.dramaGenreId;
	}

	/**
	 * nameをセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * nameを返す
	 * @return name
	 */
	public String getName() {
		return  this.name;
	}

	/**
	 * キャストをセットする
	 * @param cast セットする cast
	 */
	public void setCast(String cast) {
		this.cast = cast;
	}

	/**
	 * キャストを返す
	 * @return cast
	 */
	public String getCast() {
		return this.cast;
	}

	/**
	 * 放送局をセットする
	 * @param tvStation セットする tvStation
	 */
	public void setTvStation(String tvStation) {
		this.tvStation = tvStation;
	}

	/**
	 * 放送局を返す
	 * @return tvStation
	 */
	public String getTvStation() {
		return this.tvStation;
	}

	/**
	 * コメントをセットする
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * コメントを返す
	 * @return comment セットする comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * メッセージをセットする
	 * @param message セットする messagge
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * メッセージを返す
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * エラーメッセージを返す
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * ジャンルプルダウン用マップをセットする
	 *
	 */
	public void setDramaGenreMap() {
		DramaDao dao = new DramaDao();
		List<?> resultTable = dao.getDramaGenreList();
		this.dramaGenreMap = tableTrans(resultTable);
	}

	/**
	 * ジャンルマップを返す
	 * @return dramaGenreMap
	 */
	public Map<String, String> getDramaGenreMap() {
		return this.dramaGenreMap;
	}

	/**
	 * キャストプルダウン用マップをセットする
	 *
	 */
	public void setCastMap() {
		this.castMap.put("", "");
		this.castMap.put("ペ・ヨンジュン", "ペ・ヨンジュン");
		this.castMap.put("ユン・ウネ", "ユン・ウネ");
		this.castMap.put("イ・ビョンホン", "イ・ビョンホン");
		this.castMap.put("イ・スンギ", "イ・スンギ");
		this.castMap.put("チェ・ジウ", "チェ・ジウ");
		this.castMap.put("ハン・ヒョジュ", "ハン・ヒョジュ");
		this.castMap.put("パク・ユチョン", "パク・ユチョン");
		this.castMap.put("ユン・シユン", "ユン・シユン");
		this.castMap.put("ヒョンビン", "ヒョンビン");
		this.castMap.put("チャン・グンソク", "チャン・グンソク");

	}

	/**
	 * キャストマップを返す
	 * @return castMap
	 */
	public Map<String, String> getCastMap() {
		return this.castMap;
	}

	/*-----------------------------------*/
	//ジャンルプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			dramaGenreMap.put("", "");
			for(int i = 0; i < resultTable.size(); i++) {
				DramaGenre aa = (DramaGenre) resultTable.get(i);
				dramaGenreMap.put(aa.getId(), aa.getGenre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dramaGenreMap;
	}
}
