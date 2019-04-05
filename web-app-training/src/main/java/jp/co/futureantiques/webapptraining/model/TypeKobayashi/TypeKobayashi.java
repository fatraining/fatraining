package jp.co.futureantiques.webapptraining.model.TypeKobayashi;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;

//TypeKobayashiテーブルと対応するEntityクラス

@Data
@Entity
public class TypeKobayashi {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "type")
	@Size(max = 255)
	private  String type;

	@Column(name = "del_flg")
	private String delFlg;

	@Column(name = "create_date")
	private String createDate;


	@Column(name = "update_date")
	private String updateDate;


//外部キー設定
	@Transient
	@OneToMany(targetEntity = HamsterMainKobayashi.class,mappedBy = "type_kobayashi")
	@JoinColumn(name = "id", referencedColumnName = "type_id")
	private List<HamsterMainKobayashi>hamsterMainKobayashiList;



}
