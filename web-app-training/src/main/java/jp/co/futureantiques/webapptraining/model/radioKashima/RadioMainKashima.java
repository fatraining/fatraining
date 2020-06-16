package jp.co.futureantiques.webapptraining.model.radioKashima;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class RadioMainKashima {

	/** ラジオID**/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** ラジオ番組名**/
	@Column(name = "program_name")
	@Size(min = 1, max = 255)
	private String programName;

	/** 放送局ID**/
	@Column(name = "keystation_id")
	private Integer keystationId;

	/** パーソナリティ**/
	@Column(name ="personality")
	@Size(min = 1, max = 255)
	private String  personality;


	/** 放送期間**/
	@Column(name = "broadcast_period")
	private String broadcastPeriod;


	/** コメント**/
	@Column(name = "comment")
	private String comment;

	/**削除フラグ**/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時**/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時**/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定： 放送局**/
	@ManyToOne(targetEntity = KeystationKashima.class)
	@JoinColumn(name = "keystation_id", referencedColumnName = "id", insertable = false, updatable = false)
	private KeystationKashima keystationKashima;





}
