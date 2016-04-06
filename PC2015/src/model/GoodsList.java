package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品リストテーブル
 * @author t.makino
 *
 */
@Entity
@Table(name = "goodslist")
public class GoodsList implements Serializable {
	private static final long serialVersionUID = 1L;

	//===============================
	// フィールド宣言
	//===============================
	/**
	 * 商品コード
	 */
	private String code;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 価格
	 */
	private int price;
	/**
	 * 商品種別
	 */
	private String category;
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
	 * 商品コード
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 商品名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 価格
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 商品種別
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * 商品コード
	 * @return 商品コード
	 */
	@Id
	@GeneratedValue
	@Column(name = "GoodsCode")
	public String getCode() {
		return this.code;
	}

	/**
	 * 商品名
	 * @return 商品名
	 */
	@Column(name = "GoodsName")
	public String getName() {
		return this.name;
	}

	/**
	 * 価格
	 * @return 価格
	 */
	@Column(name = "Price")
	public int getPrice() {
		return this.price;
	}

	/**
	 * 商品種別
	 * @return category
	 */
	@Column(name = "Category")
	public String getCategory() {
		return category;
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
