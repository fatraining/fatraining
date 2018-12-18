package jp.co.futureantiques.webapptraining.model.attractioniwase;
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


@Data
@Entity
public class Themeparkiwase {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@Size(max = 2)
	private int id;

	@Column(name = "themepark")
	@Size(max = 256)
	private String themepark;

	@Column(name = "del_flg")
	@Size(max = 1)
	private String delFlg;

	@Column(name = "create_date")
	private String createDate;

	@Column(name = "update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity = AttractionMain.class, mappedBy = "themepark")
	@JoinColumn(name = "id", referencedColumnName = "themepark_id")
	private List<AttractionMain> attractionMainList;
}


