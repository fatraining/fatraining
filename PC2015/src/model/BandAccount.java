package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "band_account")
public class BandAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	// 入力した値をデータベースに挿入する、及び検索した結果を表示させるためにデータを取り出す、変数の宣言
	private String id; // ID
	private String name; // 名前
	private String sex; // 性別
	private String age; // 年齢
	private String school; // 出身校
	private String favorite_song; // 好きな曲
	private String part; // 演奏楽器
	private String band_id; // バンドID
	private String entry_date; // 登録日付
	private String renewal_date; // 更新日付
	private String entry_userid; // 登録ユーザーID
	private String renewal_userid; // 更新ユーザーID
	private int exclusion_flg; // 排他フラグ
	private int delete_flg; // 排他フラグ

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	@Column(name = "SEX")
	public String getSex() {
		return sex;
	}

	@Column(name = "AGE")
	public String getAge() {
		return age;
	}

	@Column(name = "SCHOOL")
	public String getSchool() {
		return school;
	}

	@Column(name = "FAVORITE_SONG")
	public String getFavorite_song() {
		return favorite_song;
	}

	@Column(name = "PART")
	public String getPart() {
		return part;
	}

	@Column(name = "BAND_ID")
	public String getBand_id() {
		return band_id;
	}

	@Column(name = "ENTRY_DATE")
	public String getEntry_date() {
		return entry_date;
	}

	@Column(name = "RENEWAL_DATE")
	public String getRenewal_date() {
		return renewal_date;
	}

	@Column(name = "ENTRY_USERID")
	public String getEntry_userid() {
		return entry_userid;
	}

	@Column(name = "RENEWAL_USERID")
	public String getRenewal_userid() {
		return renewal_userid;
	}

	@Column(name = "EXCLUSION_FLG")
	public int getExclusion_flg() {
		return exclusion_flg;
	}

	@Column(name = "DELETE_FLG")
	public int getDelete_flg() {
		return delete_flg;
	}

	/*--------------------------------------------------*/

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setFavorite_song(String favorite_song) {
		this.favorite_song = favorite_song;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public void setBand_id(String band_id) {
		this.band_id = band_id;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public void setRenewal_date(String renewal_date) {
		this.renewal_date = renewal_date;
	}

	public void setEntry_userid(String entry_userid) {
		this.entry_userid = entry_userid;
	}

	public void setRenewal_userid(String renewal_userid) {
		this.renewal_userid = renewal_userid;
	}

	public void setExclusion_flg(int exclusion_flg) {
		this.exclusion_flg = exclusion_flg;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}
}
