package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_info")
public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//===============================
	// フィールド宣言
	//===============================
	/**
	 * シーケンスNo
	 */
	private int sequenceNo;
	/**
	 * 注文番号
	 */
	private String orderNo;
	/**
	 * 会員ID
	 */
	private String orderMemberID;
	/**
	 * 商品コード
	 */
	private String orderGoodsCode;
	/**
	 * 購入個数
	 */
	private int orderQuantity;
	/**
	 * 注文日
	 */
	private Date orderDate;
	/**
	 * 備考
	 */
	private String remarks;
	/**
	 * 発送済みフラグ
	 */
	private String sendingFlag;
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
	 * 注文番号
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * 会員ID
	 * @param orderMemberID
	 */
	public void setOrderMemberID(String orderMemberID) {
		this.orderMemberID = orderMemberID;
	}

	/**
	 * 商品コード
	 * @param orderGoodsCode
	 */
	public void setOrderGoodsCode(String orderGoodsCode) {
		this.orderGoodsCode = orderGoodsCode;
	}

	/**
	 * 購入個数
	 * @param orderQuantity
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * 注文日
	 * @param orderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * 備考
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 発送済みフラグ
	 * @param sendingFlag
	 */
	public void setSendingFlag(String sendingFlag) {
		this.sendingFlag = sendingFlag;
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
	 * 注文番号
	 * @return orderNo
	 */
	@Column(name = "OrderNo")
	public String getOrderNo() {
		return orderNo;
	}
	
	/**
	 * 会員ID
	 * @return orderMemberID
	 */
	@Column(name = "OrderMemberID")
	public String getOrderMemberID() {
		return orderMemberID;
	}

	/**
	 * 商品コード
	 * @return orderGoodsCode
	 */
	@Column(name = "OrderGoodsCode")
	public String getOrderGoodsCode() {
		return orderGoodsCode;
	}

	/**
	 * 購入個数
	 * @return orderQuantity
	 */
	@Column(name = "OrderQuantity")
	public int getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * 注文日
	 * @return orderDate
	 */
	@Column(name = "OrderDate")
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * 備考
	 * @return remarks
	 */
	@Column(name = "Remarks")
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 発送済みフラグ
	 * @return sendingFlag
	 */
	@Column(name = "SendingFlag")
	public String getSendingFlag() {
		return sendingFlag;
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
