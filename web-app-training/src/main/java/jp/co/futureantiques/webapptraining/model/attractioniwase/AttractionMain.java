package jp.co.futureantiques.webapptraining.model.attractioniwase;

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

/**
 * AttractionMainテーブルと対応するEntity
 *
 * @author iwase
 */
@Data
@Entity

public class AttractionMain {


	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	@Column(name = "attraction_name")
	@Size(max = 256)
	private String attractionName;

	@Column(name = "themepark_id")
	@Size(max = 2)
	private Integer themeparkId;

	@Column(name = "open_date")
	@Size(max = 20)
	private int openDate;

	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	@Column(name = "del_flg")
	@Size(max = 1)
	private String delFlg;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "update_date")
	private Timestamp updateDate;

	@ManyToOne(targetEntity = ThemeparkIwase.class)
	@JoinColumn(name = "themepark_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ThemeparkIwase themeparkiwase;
}
