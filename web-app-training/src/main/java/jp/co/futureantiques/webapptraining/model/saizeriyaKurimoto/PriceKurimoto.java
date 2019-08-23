package jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

//price_kurimotoテーブルと対応するEntity
//@author Kurimoto

@Data
@Entity
public class PriceKurimoto{

	//価格帯ID
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	//名前
	@Column(name = "price_name")
	private String priceName;

	//削除フラグ
	@Column(name = "del_flg")
	private String delFlg;

	//登録日時
	@Column(name = "create_date")
	private Timestamp createDate;

	//更新日時
	@Column(name = "update_date")
	private Timestamp updateDate;

	//外部キー設定：価格帯ID
	@Transient
	@OneToMany(targetEntity = SaizeriyaMenuMainKurimoto.class, mappedBy = "priceKurimoto")
	@JoinColumn(name = "id", referencedColumnName = "price_id")
	private List<SaizeriyaMenuMainKurimoto> saizeriyaMenuMainKurimotoList;
}