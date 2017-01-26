package training2016.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.CryingMovieDao;
import training2016.model.CryingMovie;

@Results({
	@Result(name = "cryingMovieSearch", value = "cryingMovieSearch.action", type = ServletRedirectResult.class)
	})
public class CryingMovieEntryUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*ボタンの表示名 */
	private String entryBtnTitle = "登録";

	/* id(更新時のみ) */
	private int movieId;

	/* 国内外フラグ */
	private int countryFlg;
	/* ジャンル */
	private int jenre;
	/* 作品名 */
	private String title;
	/* 主な出演者 */
	private String mainCast;
	/* あらすじ */
	private String story;
	/*メッセージ */
	private String message;
	/* エラーメッセージ */
	private String errorMessage;

	@Override // 更新
	public String execute() throws Exception {
		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.movieId = this.getValueFromSession("updateId");

		//更新データを取得
		CryingMovieDao dao = new CryingMovieDao();
		CryingMovie target = null;

		// 更新対象idがあればデータの更新をする
		if (this.movieId != 0) {
			target = dao.select(this.movieId, CryingMovie.class);
			if (target != null) {
				this.movieId = target.getMovieId();
				this.jenre = target.getGenre();
				this.title = target.getTitle();
				this.mainCast = target.getMainCast();
				this.story = target.getStory();
				this.entryBtnTitle = "更新";
			}
		} else {
			// 新規
			this.movieId = 0;
		}
		return "success";
	}

	/*
	 * 必須項目が全部入力済みか確認する
	 */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/*
	 * updateメソッド idがあれば更新、なければ追加になる 更新・追加し終わったら検索画面にもどる
	 */
	public String update() {
		if (this.isEmptyParam(title)) {
			addActionError("タイトルを入力してください");
		}

		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {

			//チェックされたIDを入れる
			CryingMovieDao dao = new CryingMovieDao();
			CryingMovie target = null;

			// 更新対象idがあればデータの更新をする
			if (this.movieId != 0) {
				target = dao.select(this.movieId, CryingMovie.class);
				if (target != null) {
					this.entryBtnTitle = "更新"; // ボタンのvalueを更新
				}
			}
			return "error";
		}

		CryingMovieDao dao = new CryingMovieDao();

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		if (this.movieId != 0) {//更新の場合
			CryingMovie target = dao.select(this.movieId, CryingMovie.class);
			//更新したテーブル上書きする
			dao.update(this.generateCryingMovieModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else { //新規の場合
			dao.insert(this.movieId, this.countryFlg, this.jenre, this.title, this.mainCast, this.story);
			this.message = "映画を登録しました";
			this.sessionMap.put("message", this.message);
		}

		return "cryingMovieSearch";
	}

	/*
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 */
	private CryingMovie generateCryingMovieModel(CryingMovie target) {
		target.setMovieId(this.movieId);
		target.setCountryFlg(this.countryFlg);
		target.setGenre(this.jenre);
		target.setTitle(this.story);
		target.setMainCast(this.mainCast);
		target.setStory(this.story);

		return target;
	}

	/* メッセージをセットする
	 * @param message
	 *    セットする messagge
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* メッセージを返す
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/*エラーメッセージを返す
	 *
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/* @return updateBtnTitle
	 */
	public String getEntryBtnTitle() {
		return entryBtnTitle;
	}

}
