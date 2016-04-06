package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 顧客情報テーブル
 * @author t.makino
 *
 */
@Entity
@Table(name = "member_info")
public class MemberInfo {
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
	private String memberID;
	/**
	 * 姓
	 */
	private String lastName;
	/**
	 * 名
	 */
	private String firstName;
	/**
	 * 姓（カナ）
	 */
	private String lastNameKana;
	/**
	 * 名（カナ）
	 */
	private String firstNameKana;
	/**
	 * 性別
	 * （0:男性　1:女性）
	 */
	private int sex;
	/**
	 * 年齢
	 */
	private String age;
	/**
	 * 住所
	 */
	private String address;
	/**
	 * 建物名
	 */
	private String building;
	/**
	 * 電話種別
	 */
	private int telKind;
	/**
	 * 誕生年月日
	 */
	private String birthday;
	/**
	 * 郵便番号
	 */
	private String postalCode;
	/**
	 * 電話番号
	 */
	private String telNumber;

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
	 * @param memberID セットする memberID
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * 姓
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 名
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 姓（カナ）
	 * @param lastNameKana
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	/**
	 * 名（カナ）
	 * @param firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	/**
	 * 性別
	 * @param sex
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * 誕生年月日
	 * @param birthday (yyyy/MM/dd形式)
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 年齢
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 郵便番号
	 * @param postalCode (999-9999形式)
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 住所
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 建物名
	 * @param building
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * 電話種別
	 * @param telKind
	 */
	public void setTelKind(int telKind) {
		this.telKind = telKind;
	}

	/**
	 * 電話番号
	 * @param telNumber (999-999-9999形式)
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
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
	 * @return memberID
	 */
	@Column(name = "MemberID")
	public String getMemberID() {
		return this.memberID;
	}

	/**
	 * 姓
	 * @return　lastName
	 */
	@Column(name = "LastName")
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 名
	 * @return　firstName
	 */
	@Column(name = "FirstName")
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 姓（カナ）
	 * @return　lastNameKana
	 */
	@Column(name = "LastNameKana")
	public String getLastNameKana() {
		return this.lastNameKana;
	}

	/**
	 * 名（カナ）
	 * @return　firstNameKana
	 */
	@Column(name = "FirstNameKana")
	public String getFirstNameKana() {
		return this.firstNameKana;
	}

	/**
	 * 性別
	 * @return　sex
	 */
	@Column(name = "Sex")
	public int getSex() {
		return this.sex;
	}

	/**
	 * 誕生年月日
	 * @return　birthday (yyyy/MM/dd形式)
	 */
	@Column(name = "Birthday")
	public String getBirthday() {
		return this.birthday;
	}

	/**
	 * 年齢
	 * @return　age
	 */
	@Column(name = "Age")
	public String getAge() {
		return this.age;
	}

	/**
	 * 郵便番号
	 * @return　postalCode　(999-9999形式)
	 */
	@Column(name = "PostalCode")
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * 住所
	 * @return　address
	 */
	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	/**
	 * 建物名
	 * @return　building
	 */
	@Column(name = "Building")
	public String getBuilding() {
		return this.building;
	}

	/**
	 * 電話種別
	 * @return　telKind
	 */
	@Column(name = "TelKind")
	public int getTelKind() {
		return this.telKind;
	}

	/**
	 * 電話番号
	 * @return　telNumber　(999-999-9999形式)
	 */
	@Column(name = "TelNumber")
	public String getTelNumber() {
		return this.telNumber;
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
