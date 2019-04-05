package jp.co.futureantiques.webapptraining.model.TypeKobayashi;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

//Hamster_Main_kobayashiテーブルと対応するEntity
@Data
@Entity
public class HamsterMainKobayashi {

	@Id
	@GenericGenerator(name = "gen",strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type_id")
	private Integer typeId;

	@Column(name = "graduate_id")
	private Integer graduateId;

	@Column(name = "life_span")
	private String lifeSpan;

	@Column(name = "comment")
	private String comment;

	@Column(name = "del_flg")
	private String delFlg;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "update_date")
	private Timestamp updateDate;

	//外部キー設定
	@ManyToOne(targetEntity = TypeKobayashi.class)
	@JoinColumn(name = "type_id" , referencedColumnName = "id" , insertable = false, updatable = false)
	private TypeKobayashi typeKobayashi;

	@ManyToOne(targetEntity = GraduateKobayashi.class)
	@JoinColumn(name = "graduate_id" , referencedColumnName = "id" , insertable = false, updatable = false)
	private GraduateKobayashi graduateKobayashi;


}
