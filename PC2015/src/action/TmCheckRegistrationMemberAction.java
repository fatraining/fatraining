package action;

import java.util.Date;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.MembersMasterDao;
import model.MemberInfo;
import model.MembersMaster;
import model.ResultMemberInfo;

@Results( {
@Result(name = "back", value = "tmRegistrationMember.action", type = ServletRedirectResult.class),
@Result(name = "next", value = "tmRegistrationConfirm.action", type = ServletRedirectResult.class)
})
public class TmCheckRegistrationMemberAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	//======================
	// フィールド宣言
	//======================
	/**
	 * 顧客情報クラス
	 */
	private ResultMemberInfo memberInfo;

	//======================
	// setter/getter
	//======================
	/**
	 * 顧客情報クラス
	 * @param memberInfo
	 */
	public void setMemberInfo(ResultMemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	/**
	 * 顧客情報クラス
	 * @return
	 */
	public ResultMemberInfo getMemberInfo() {
		return this.memberInfo;
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
		// 前画面で入力した会員情報を取得
		setMemberInfo((ResultMemberInfo)super.sessionMap.get("memberInfo"));
		return "success";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		// 会員登録
		registrationMember();

		// 登録した会員IDでログイン状態にする
		super.sessionMap.put("memberId", memberInfo.getMemberId());
		return "next";
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
	 * 会員登録処理
	 * @throws Exception
	 */
	private void registrationMember() throws Exception {
		setMemberInfo((ResultMemberInfo)super.sessionMap.get("memberInfo"));
		Date date = new Date();

		//------------------------
		// 登録情報の設定
		//------------------------
		// 顧客マスタ
		MembersMaster membersMaster = new MembersMaster();
		String a = memberInfo.getMemberId();
		membersMaster.setMemberId(memberInfo.getMemberId());
		membersMaster.setPassword(memberInfo.getPassword());
		membersMaster.setLastLoginDate(date);
		membersMaster.setPasswordChangeDate(date);
		membersMaster.setDeleteFlag("0");
		membersMaster.setRegistrationUserID("system");
		membersMaster.setRegistrationDate(date);
		membersMaster.setUpdateUserID("system");
		membersMaster.setUpdateDate(date);

		// 顧客情報テーブル
		MemberInfo info = new MemberInfo();
		info.setMemberID(memberInfo.getMemberId());
		info.setLastName(memberInfo.getLastName());
		info.setFirstName(memberInfo.getFirstName());
		info.setLastNameKana(memberInfo.getLastNameKana());
		info.setFirstNameKana(memberInfo.getFirstNameKana());
		info.setSex(memberInfo.getSex());
		info.setBirthday(memberInfo.getBirthday());
		info.setAge(memberInfo.getAge());
		info.setPostalCode(memberInfo.getPostalCode());
		info.setAddress(memberInfo.getAddress());
		info.setBuilding(memberInfo.getBuilding());
		info.setTelKind(memberInfo.getTelKind());
		info.setTelNumber(memberInfo.getTelNumber());
		info.setDeleteFlag("0");
		info.setRegistrationUserID("system");
		info.setRegistrationDate(date);
		info.setUpdateUserID("system");
		info.setUpdateDate(date);

		//------------------------
		// 登録処理
		//------------------------
		MembersMasterDao masterDao = new MembersMasterDao();
		masterDao.insert(membersMaster, info);
	}
}
