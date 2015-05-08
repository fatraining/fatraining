package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "band_table")
public class BandTable implements Serializable {

	private static final long serialVersionUID = 1L;

	// 入力した値をデータベースに挿入する、及び検索した結果を表示させるためにデータを取り出す、変数の宣言
	private String id; // ID
	private String band_name; // バンド名
	private String entry_date; // 登録日付
	private String renewal_date; // 更新日付
	private String entry_userid; // 登録ユーザーID
	private String renewal_userid; // 更新ユーザーID
	private int exclusion_flg; // 排他フラグ
	private int delete_flg; // 排他フラグ

	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	@Column(name = "BAND_NAME")
	public String getBand_name() {
		return band_name;
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

	/*-------------------------------------------------*/
	public void setId(String id) {
		this.id = id;
	}

	public void setBand_name(String band_name) {
		this.band_name = band_name;
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
