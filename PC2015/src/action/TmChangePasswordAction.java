package action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.MembersMasterDao;
import model.MembersMaster;

@Results( {
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class),
@Result(name = "change", value = "tmChangePasswordConfirm.action", type = ServletRedirectResult.class)
})
public class TmChangePasswordAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//======================
	// フィールド宣言
	//======================
	/**
	 * 会員マスタクラス
	 */
	private MembersMaster membersMaster = new MembersMaster();
	/**
	 * 会員ID
	 */
	private String memberId;
	/**
	 * 変更前のパスワード
	 */
	private String oldPassword;
	/**
	 * 新しいのパスワード
	 */
	private String newPassword;
	/**
	 * 新しいのパスワード確認用
	 */
	private String newPassword2;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;

	//======================
	// setter/getter
	//======================
	/**
	 * 会員マスタクラス
	 * @param membersMaster
	 */
	public void setMembersMaster(MembersMaster membersMaster) {
		this.membersMaster = membersMaster;
	}
	/**
	 * 会員マスタクラス
	 * @return membersMaster
	 */
	public MembersMaster getMembersMaster() {
		return membersMaster;
	}
	/**
	 * 会員ID
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 会員ID
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 変更前のパスワード
	 * @param oldPassword
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**
	 * 変更前のパスワード
	 * @return oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * 新しいのパスワード
	 * @param newPassword
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * 新しいのパスワード
	 * @return newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * 新しいのパスワード確認用
	 * @param newPassword
	 */
	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
	/**
	 * 新しいのパスワード確認用
	 * @return newPassword
	 */
	public String getNewPassword2() {
		return newPassword2;
	}
	/**
	 * エラーメッセージ
	 * @param errMessage
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	/**
	 * エラーメッセージ
	 * @return errMessage
	 */
	public String getErrMessage() {
		return this.errMessage;
	}

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		setMemberId((String)super.sessionMap.get("memberId"));
		return "init";
	}

	/**
	 * 変更ボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String change() throws Exception {
		// パスワード変更処理
		if (!changePassword()) {
			return "init";
		}
		return "change";
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		return "back";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * パスワード変更処理
	 * @return
	 */
	private boolean changePassword() {
		// 会員ID取得
		this.setMemberId((String)super.sessionMap.get("memberId"));

		// 入力チェック
		if (!inputCheck()) {
			return false;
		}

		// パスワードの変更
		updatePassword();

		return true;
	}

	/**
	 * 入力チェック
	 * @return
	 */
	private boolean inputCheck() {
		//----------------------
		// 未入力チェック
		//----------------------
		// 現在のパスワード
		if (!inputIsEmpty(this.getOldPassword())) {
			this.setErrMessage("「現在のパスワード」が入力されていません！");
			return false;
		}

		// 新しいパスワード
		if (!inputIsEmpty(this.getNewPassword())) {
			this.setErrMessage("「新しいパスワード」が入力されていません！");
			return false;
		}

		// 新しいパスワード確認用
		if (!inputIsEmpty(this.getNewPassword2())) {
			this.setErrMessage("「新しいパスワード確認用」が入力されていません！");
			return false;
		}

		//----------------------
		// パスワード文字数チェック
		//----------------------
		// 現在のパスワード
		if (oldPassword.length() < 4 || oldPassword.length() > 12) {
			this.setErrMessage("「現在のパスワード」は半角英数字4文字以上12文字以内で入力してください。");
			return false;
		}

		// 新しいパスワード
		if (newPassword.length() < 4 || newPassword.length() > 12) {
			this.setErrMessage("「新しいパスワード」は半角英数字4文字以上12文字以内で入力してください。");
			return false;
		}

		//----------------------
		// パスワード整合性チェック
		//----------------------
		// 現在のパスワード
		MembersMasterDao dao = new MembersMasterDao();
		List<?> resultTable = dao.memberSelect(memberId, oldPassword);
		if (resultTable == null || resultTable.size() == 0) {
			this.setErrMessage("「現在のパスワード」の入力内容が正しくありません。");
			return false;
		}
		// 取得結果を格納
		setMembersMaster((MembersMaster)resultTable.get(0));

		// 新しいパスワード
		if (!newPassword.equals(newPassword2)) {
			this.setErrMessage("「新しいパスワード」と「新しいパスワード確認用」が一致していません。もう一度入力してください。");
			return false;
		}

		//----------------------
		// パスワード新旧の比較
		//----------------------
		if (oldPassword.equals(newPassword)) {
			this.setErrMessage("「新しいパスワード」に「現在のパスワード」と同じパスワードは設定できません。");
			return false;
		}
		return true;
	}

	/**
	 * 未入力チェック
	 * @param input
	 * @return true:入力あり　false:未入力
	 */
	private boolean inputIsEmpty(String input) {
		if (input == null || input.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 会員マスタ（パスワード）の更新
	 */
	private void updatePassword() {
		// 更新内容の設定
		Date date = new Date();
		this.membersMaster.setMemberId(memberId);
		this.membersMaster.setPassword(newPassword);
		this.membersMaster.setPasswordChangeDate(date);
		this.membersMaster.setUpdateUserID("system");
		this.membersMaster.setUpdateDate(date);

		MembersMasterDao dao = new MembersMasterDao();
		dao.updatePassword(this.membersMaster);
	}
}
