package apps.makino.entity;

/**
 * 顧客情報テーブル
 * @author makinotakuya
 *
 */
public class UserInfo {
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
	
	//===============================
	// setter/getter
	//===============================
	/**
	 * 姓
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 姓
	 * @return　lastName
	 */
	public String getLastName() {
		return this.lastName;
	}
	/**
	 * 名
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @param lastNameKana
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
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
	 * @param firstNameKana
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
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
	 * @param sex
	 */
	public void setSex(int sex) {
		this.sex = sex;
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
	 * @param bornYear
	 */
	public void setBornYear(String bornYear) {
		this.bornYear = bornYear;
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
	 * @param bornMonth
	 */
	public void setBornMonth(String bornMonth) {
		this.bornMonth = bornMonth;
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
	 * @param bornDay
	 */
	public void setBornDay(String bornDay) {
		this.bornDay = bornDay;
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
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
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
	 * @param postalCode1
	 */
	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
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
	 * @param postalCode2
	 */
	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
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
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @param building
	 */
	public void setBuilding(String building) {
		this.building = building;
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
	 * @param telKind
	 */
	public void setTelKind(int telKind) {
		this.telKind = telKind;
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
	 * @param telNumber1
	 */
	public void setTelNumber1(String telNumber1) {
		this.telNumber1 = telNumber1;
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
	 * @param telNumber2
	 */
	public void setTelNumber2(String telNumber2) {
		this.telNumber2 = telNumber2;
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
	 * @param telNumber3
	 */
	public void setTelNumber3(String telNumber3) {
		this.telNumber3 = telNumber3;
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
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * @param birthday (yyyy/MM/dd形式)
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
		this.bornYear = birthday.substring(0, 4);
		this.bornMonth = birthday.substring(6, 7);
		this.bornDay = birthday.substring(9);
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
	 * @param postalCode (999-9999形式)
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		this.postalCode1 = postalCode.substring(0,2);
		this.postalCode2 = postalCode.substring(4);
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
	 * @param telNumber (999-999-9999形式)
	 */
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
		this.telNumber1 = telNumber.substring(0, telNumber.indexOf('-') - 1);
		this.telNumber2 = telNumber.substring(telNumber.indexOf('-') + 1, telNumber.lastIndexOf('-') - 1);
		this.telNumber3 = telNumber.substring(telNumber.lastIndexOf('-') + 1);
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
	
	//===============================
	// コンストラクタ
	//===============================
	/**
	 * コンストラクタ
	 * 顧客情報初期化
	 */
	public UserInfo() {
		// 処理なし
	}
	/**
	 * コンストラクタ
	 * 顧客情報初期化
	 * @param lastName
	 * @param firstName
	 * @param lastNameKana
	 * @param firstNameKana
	 * @param sex
	 * @param bornYear
	 * @param bornMonth
	 * @param bornDay
	 * @param age
	 * @param postalCode1
	 * @param postalCode2
	 * @param address
	 * @param building
	 * @param telKind
	 * @param telNumber1
	 * @param telNumber2
	 * @param telNumber3
	 * @param remarks
	 */
	public UserInfo(String lastName, String firstName, String lastNameKana, String firstNameKana, int sex,
					String bornYear, String bornMonth, String bornDay, String age, String postalCode1, String postalCode2,
			        String address, String building, int telKind, String telNumber1, String telNumber2, 
			        String telNumber3, String remarks) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.lastNameKana = lastNameKana;
		this.firstNameKana = firstNameKana;
		this.sex = sex;
		this.bornYear = bornYear;
		this.bornMonth = bornMonth;
		this.bornDay = bornDay;
		this.age = age;
		this.postalCode1 = postalCode1;
		this.postalCode2 = postalCode2;
		this.address = address;
		this.building = building;
		this.telKind = telKind;
		this.telNumber1 = telNumber1;
		this.telNumber2 = telNumber2;
		this.telNumber3 = telNumber3;
		this.remarks = remarks;
	}
	
}
