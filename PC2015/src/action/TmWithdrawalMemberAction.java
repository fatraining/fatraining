package action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.MemberInfoDao;
import dao.MembersMasterDao;
import model.MemberInfo;
import model.MembersMaster;
import util.TmNoDataFoundException;

@Results( {
@Result(name = "quit", value = "tmWithdrawalCompletion.action", type = ServletRedirectResult.class),
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class)
})
public class TmWithdrawalMemberAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 会員マスタクラス
	 */
	private MembersMaster membersMaster;
	/**
	 * 会員情報テーブルクラス
	 */
	private MemberInfo memberInfo;
	/**
	 * 会員ID
	 */
	private String memberId;
	/**
	 * パスワード
	 */
	private String password;
	/**
	 * パスワード確認用
	 */
	private String password2;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;

	//=============================
	// setter/getter
	//=============================
	/**
	 * 会員マスタクラス
	 * @return membersMaster
	 */
	public MembersMaster getMembersMaster() {
		return membersMaster;
	}
	/**
	 * 会員マスタクラス
	 * @param membersMaster
	 */
	public void setMembersMaster(MembersMaster membersMaster) {
		this.membersMaster = membersMaster;
	}
	/**
	 * 会員情報テーブルクラス
	 * @return memberInfo
	 */
	public MemberInfo getMemberInfo() {
		return memberInfo;
	}
	/**
	 * 会員情報テーブルクラス
	 * @param memberInfo
	 */
	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	/**
	 * 会員ID
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 会員ID
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * パスワード
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * パスワード
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * パスワード確認用
	 * @return password
	 */
	public String getPassword2() {
		return password2;
	}
	/**
	 * パスワード確認用
	 * @param password
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	/**
	 * エラーメッセージ
	 * @return errMessage
	 */
	public String getErrMessage() {
		return errMessage;
	}
	/**
	 * エラーメッセージ
	 * @param errMessage
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute()
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		setMemberId((String)super.sessionMap.get("memberId"));
		return "init";
	}

	/**
	 * 退会しますボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String quit() throws Exception {
		setMemberId((String)super.sessionMap.get("memberId"));
		// 入力チェック
		if (!inputCheck()) {
			return "init";
		}

		// 退会処理
		withdrawal();
		return "quit";
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
	 * 入力チェック
	 */
	private boolean inputCheck() {
		// パスワード
		if (this.getPassword() == null || this.getPassword().isEmpty()) {
			setErrMessage("「パスワード」が入力されていません！");
			return false;
		}
		// パスワード確認用
		if (this.getPassword2() == null || this.getPassword2().isEmpty()) {
			setErrMessage("「パスワード確認用」が入力されていません！");
			return false;
		}

		if (!this.getPassword().equals(this.getPassword())) {
			setErrMessage("「パスワード」と「確認用パスワード」が一致していません！");
			return false;
		}

		MembersMasterDao dao = new MembersMasterDao();
		// 会員IDとパスワードで会員マスタを検索
		List<?> resultTable = dao.memberSelect(this.memberId, this.password);
		if (resultTable == null || resultTable.size() == 0) {
			// 該当データが存在しない場合、エラー
			setErrMessage("「パスワード」が誤っています！");
			return false;
		}
		setMembersMaster((MembersMaster)resultTable.get(0));
		return true;
	}

	/**
	 * 退会処理
	 */
	private void withdrawal() throws TmNoDataFoundException {
		Date date = new Date();
		MemberInfoDao infoDao = new MemberInfoDao();
		List<?> resultTabl = infoDao.memberInfoSelect(this.memberId);
		if (resultTabl.size() == 0) {
			// 該当データが存在しない場合はデータセットアップ例外をスロー
			String error = "顧客マスタと顧客情報の整合性が取れていません。";
			Throwable throwable = new  Throwable();
			throw new TmNoDataFoundException(error, throwable.getCause());
		}

		// 会員情報テーブルから退会する会員情報を取得
		setMemberInfo((MemberInfo)resultTabl.get(0));

		// 更新内容の設定
		// 会員マスタ
		membersMaster.setDeleteFlag("1");
		membersMaster.setUpdateUserID("system");
		membersMaster.setUpdateDate(date);

		// 会員情報テーブル
		memberInfo.setDeleteFlag("1");
		memberInfo.setUpdateUserID("system");
		memberInfo.setUpdateDate(date);

		// 顧客論理削除
		MembersMasterDao masterDao = new MembersMasterDao();
		masterDao.updateDeleteFlag(membersMaster, memberInfo);
	}
}
