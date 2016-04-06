package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会員マスタ
 * @author t.makino
 *
 */
@Entity
@Table(name = "members_master")
public class MembersMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	//===============================
	// フィールド宣言
	//===============================
	/**
	 * シーケンスNo
	 */
	private int sequenceNo;
	/**
	 * 会員ID
	 */
	private String memberId;
	/**
	 * パスワード
	 */
	private String password;
	/**
	 * 最終ログイン日付
	 */
	private Date lastLoginDate;
	/**
	 * パスワード変更日付
	 */
	private Date passwordChangeDate;
	/**
	 * 削除フラグ
	 */
	private String deleteFlag;
	/**
	 * 登録ユーザー
	 */
	private String registrationUserID;
	/**
	 * 登録日
	 */
	private Date registrationDate;
	/**
	 * 更新ユーザー
	 */
	private String updateUserID;
	/**
	 * 更新日
	 */
	private Date updateDate;

	//===============================
	// setter
	//===============================
	/**
	 * シーケンスNo
	 * @param sequenceNo
	 */
	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
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
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 最終ログイン日付
	 * @param lastLoginDate セットする lastLoginDate
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * パスワード変更日付
	 * @param passwordChangeDate
	 */
	public void setPasswordChangeDate(Date passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

	/**
	 * 削除フラグ
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 登録ユーザー
	 * @param registrationUserID
	 */
	public void setRegistrationUserID(String registrationUserID) {
		this.registrationUserID = registrationUserID;
	}

	/**
	 * 登録日
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * 更新ユーザー
	 * @param updateUserID セットする updateUserID
	 */
	public void setUpdateUserID(String updateUserID) {
		this.updateUserID = updateUserID;
	}

	/**
	 * 更新日
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	//===============================
	// getter
	//===============================
	/**
	 * シーケンスNo
	 * @return sequenceNo
	 */
	@Id
	@GeneratedValue
	@Column(name = "SequenceNo")
	public int getSequenceNo() {
		return sequenceNo;
	}

	/**
	 * 会員ID
	 * @return memberId
	 */
	@Column(name = "MemberID")
	public String getMemberId() {
		return memberId;
	}

	/**
	 * パスワード
	 * @return password
	 */
	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	/**
	 * 最終ログイン日付
	 * @return lastLoginDate
	 */
	@Column(name = "LastLoginDate")
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * パスワード変更日付
	 * @return passwordChangeDate
	 */
	@Column(name = "PasswordChangeDate")
	public Date getPasswordChangeDate() {
		return passwordChangeDate;
	}

	/**
	 * 削除フラグ
	 * @return deleteFlag
	 */
	@Column(name = "DeleteFlag")
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 登録ユーザー
	 * @return registrationUserID
	 */
	@Column(name = "RegistrationUserID")
	public String getRegistrationUserID() {
		return registrationUserID;
	}

	/**
	 * 登録日
	 * @return registrationDate
	 */
	@Column(name = "RegistrationDate")
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * 更新ユーザー
	 * @return updateUserID
	 */
	@Column(name = "UpdateUserID")
	public String getUpdateUserID() {
		return updateUserID;
	}

	/**
	 * 更新日
	 * @return updateDate
	 */
	@Column(name = "UpdateDate")
	public Date getUpdateDate() {
		return updateDate;
	}

}
