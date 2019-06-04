package jp.co.futureantiques.webapptraining.model.championTiba;

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
public class ChampionMainTiba {

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	@Column(name = "champion_name")
	private String championName;

	@Column(name = "class_id")
	private Integer classId;

	@Column(name = "country_id")
	private Integer countryId;

	@Column(name = "achievement")
	private String achievement;

	@Column(name = "comment")
	@Size(max = 255)
	private String comment;

	@Column(name = "del_flg")
	private String delFlg;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "update_date")
	private Timestamp updateDate;

	@ManyToOne(targetEntity = ClassTiba.class)
	@JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ClassTiba classTiba;

	@ManyToOne(targetEntity = CountryTiba.class)
	@JoinColumn(name = "country_id", referencedColumnName = "id", insertable = false, updatable = false)
	private CountryTiba countryTiba;

}
