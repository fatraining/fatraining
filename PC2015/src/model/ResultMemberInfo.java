package model;

/**
 * 顧客情報
 * （画面表示用）
 * @author t.makino
 *
 */
public class ResultMemberInfo {

	//===============================
	// フィールド宣言
	//===============================
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
	 * 誕生年
	 */
	private String bornYear;
	/**
	 * 誕生月
	 */
	private String bornMonth;
	/**
	 * 誕生日
	 */
	private String bornDay;
	/**
	 * 年齢
	 */
	private String age;
	/**
	 * 郵便番号（先頭３桁）
	 */
	private String postalCode1;
	/**
	 * 郵便番号（末尾４桁）
	 */
	private String postalCode2;
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
	 * 電話番号１
	 */
	private String telNumber1;
	/**
	 * 電話番号２
	 */
	private String telNumber2;
	/**
	 * 電話番号３
	 */
	private String telNumber3;
	/**
	 * 備考
	 */
	private String remarks;	
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
	
	//===============================
	// コンストラクタ
	//===============================
	/**
	 * コンストラクタ
	 * 顧客情報の初期設定（データなし）
	 */
	public ResultMemberInfo() {
		// 処理なし
	}

	/**
	 * コンストラクタ
	 * 顧客情報の初期設定（データあり）
	 * @param lastName
	 * @param firstName
	 * @param lastNameKana
	 * @param firstNameKana
	 * @param sex
	 * @param birthday
	 * @param age
	 * @param postalCode
	 * @param address
	 * @param building
	 * @param telKind
	 * @param telNumber
	 */
	public ResultMemberInfo(String lastName, String firstName, String lastNameKana, String firstNameKana, int sex,
							String birthday, String age, String postalCode, String address, String building,
							int telKind, String telNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.lastNameKana = lastNameKana;
		this.firstNameKana = firstNameKana;
		this.sex = sex;
		this.bornYear = birthday.substring(0, birthday.indexOf('/'));
		this.bornMonth = birthday.substring(birthday.indexOf('/') + 1, birthday.lastIndexOf('/'));
		this.bornDay = birthday.substring(birthday.lastIndexOf('/') + 1);
		this.birthday = birthday;
		this.age = age;
		this.postalCode1 = postalCode.substring(0, postalCode.indexOf('-'));
		this.postalCode2 = postalCode.substring(postalCode.indexOf('-') + 1);
		this.postalCode = postalCode;
		this.address = address;
		this.building = building;
		this.telKind = telKind;
		this.telNumber1 = telNumber.substring(0, telNumber.indexOf('-'));
		this.telNumber2 = telNumber.substring(telNumber.indexOf('-') + 1, telNumber.lastIndexOf('-'));
		this.telNumber3 = telNumber.substring(telNumber.lastIndexOf('-') + 1);
		this.telNumber = telNumber;
		this.remarks = null;
	}

	//===============================
	// setter
	//===============================
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
	 * 誕生年
	 * @param bornYear
	 */
	public void setBornYear(String bornYear) {
		this.bornYear = bornYear;
		setBirthday();
	}

	/**
	 * 誕生月
	 * @param bornMonth
	 */
	public void setBornMonth(String bornMonth) {
		if (bornMonth.length() == 1) {
			this.bornMonth = "0" + bornMonth;
		} else {
			this.bornMonth = bornMonth;
		}
		setBirthday();
	}

	/**
	 * 誕生日
	 * @param bornDay
	 */
	public void setBornDay(String bornDay) {
		if (bornDay.length() == 1) {
			this.bornDay = "0" + bornDay;
		} else {
			this.bornDay = bornDay;

		}
		setBirthday();
	}

	/**
	 * 年齢
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 郵便番号（先頭３桁）
	 * @param postalCode1
	 */
	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
		setPostalCode();
	}

	/**
	 * 郵便番号（末尾４桁）
	 * @param postalCode2
	 */
	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
		setPostalCode();
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
	 * 電話番号１
	 * @param telNumber1
	 */
	public void setTelNumber1(String telNumber1) {
		this.telNumber1 = telNumber1;
		setTelNumber();
	}

	/**
	 * 電話番号２
	 * @param telNumber2
	 */
	public void setTelNumber2(String telNumber2) {
		this.telNumber2 = telNumber2;
		setTelNumber();
	}

	/**
	 * 電話番号３
	 * @param telNumber3
	 */
	public void setTelNumber3(String telNumber3) {
		this.telNumber3 = telNumber3;
		setTelNumber();
	}

	/**
	 * 備考
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 誕生年月日
	 * @param birthday (yyyy/MM/dd形式)
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 郵便番号
	 * @param postalCode (999-9999形式)
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 電話番号
	 * @param telNumber (999-999-9999形式)
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
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
	 * パスワード確認用
	 * @param password2
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	//===============================
	// getter
	//===============================
	/**
	 * 姓
	 * @return　lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 名
	 * @return　firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 姓（カナ）
	 * @return　lastNameKana
	 */
	public String getLastNameKana() {
		return this.lastNameKana;
	}

	/**
	 * 名（カナ）
	 * @return　firstNameKana
	 */
	public String getFirstNameKana() {
		return this.firstNameKana;
	}

	/**
	 * 性別
	 * @return　sex
	 */
	public int getSex() {
		return this.sex;
	}

	/**
	 * 誕生年
	 * @return　bornYear
	 */
	public String getBornYear() {
		return this.bornYear;
	}

	/**
	 * 誕生月
	 * @return　bornMonth
	 */
	public String getBornMonth() {
		return this.bornMonth;
	}

	/**
	 * 誕生日
	 * @return　bornDay
	 */
	public String getBornDay() {
		return this.bornDay;
	}

	/**
	 * 年齢
	 * @return　age
	 */
	public String getAge() {
		return this.age;
	}

	/**
	 * 郵便番号（先頭３桁）
	 * @return　postalCode1
	 */
	public String getPostalCode1() {
		return this.postalCode1;
	}

	/**
	 * 郵便番号（末尾４桁）
	 * @return　postalCode2
	 */
	public String getPostalCode2() {
		return this.postalCode2;
	}

	/**
	 * 住所
	 * @return　address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 建物名
	 * @return　building
	 */
	public String getBuilding() {
		return this.building;
	}

	/**
	 * 電話種別
	 * @return　telKind
	 */
	public int getTelKind() {
		return this.telKind;
	}

	/**
	 * 電話番号１
	 * @return　telNumber1
	 */
	public String getTelNumber1() {
		return this.telNumber1;
	}

	/**
	 * 電話番号２
	 * @return　telNumber2
	 */
	public String getTelNumber2() {
		return this.telNumber2;
	}

	/**
	 * 電話番号３
	 * @return　telNumber3
	 */
	public String getTelNumber3() {
		return this.telNumber3;
	}

	/**
	 * 備考
	 * @return　telNumber3
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * 誕生年月日
	 * @return　birthday (yyyy/MM/dd形式)
	 */
	public String getBirthday() {
		if (birthday == null || birthday.isEmpty()) {
			return this.bornYear + "/" + this.bornMonth + "/" + this.bornDay;
		} else {
			return this.birthday;
		}
	}

	/**
	 * 郵便番号
	 * @return　postalCode　(999-9999形式)
	 */
	public String getPostalCode() {
		if (postalCode == null || postalCode.isEmpty()) {
			return this.postalCode1 + "-" + this.postalCode2;
		} else {
			return this.postalCode;
		}
	}

	/**
	 * 電話番号
	 * @return　telNumber　(999-999-9999形式)
	 */
	public String getTelNumber() {
		if (telNumber == null || telNumber.isEmpty()) {
			return this.telNumber1 + "-" + this.telNumber2 + "-" + this.telNumber3;
		} else {
			return this.telNumber;
		}
	}

	/**
	 * 会員ID
	 * @return memberId
	 */
	public String getMemberId() {
		return this.memberId;
	}

	/**
	 * パスワード
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * パスワード確認用
	 * @return password2
	 */
	public String getPassword2() {
		return this.password2;
	}

	//===============================
	// プライベートメソッド
	//===============================
	/**
	 * 生年月日の設定
	 */
	private void setBirthday() {
		if (this.bornYear != null && this.bornMonth != null && this.bornDay != null &&
			!this.bornYear.isEmpty() && !this.bornMonth.isEmpty() && !this.bornDay.isEmpty()) {
			this.setBirthday(bornYear + "/" + bornMonth + "/" + bornDay);
		}
	}

	/**
	 * 郵便番号の設定
	 */
	private void setPostalCode() {
		if (this.postalCode1 != null && this.postalCode2 != null &&
			!this.postalCode1.isEmpty() && !this.postalCode2.isEmpty()) {
			this.setPostalCode(postalCode1 + "-" + postalCode2);
		}
	}

	/**
	 * 電話番号の設定
	 */
	private void setTelNumber() {
		if (this.telNumber1 != null && this.telNumber2 != null && this.telNumber3 != null &&
			!this.telNumber1.isEmpty() && !this.telNumber2.isEmpty() && !this.telNumber3.isEmpty()) {
			this.setTelNumber(telNumber1 + "-" + telNumber2 + "-" + telNumber3);
		}
	}

}
