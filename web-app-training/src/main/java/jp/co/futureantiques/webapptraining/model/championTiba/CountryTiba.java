package jp.co.futureantiques.webapptraining.model.championTiba;

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
public class CountryTiba {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="country")
	@Size(max=4)
	private String country;

	@Column(name="del_flg")
	private String delFlg;

	@Column(name="create_date")
	private String createDate;

	@Column(name="update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity=ChampionMainTiba.class, mappedBy="country")
	@JoinColumn(name="id", referencedColumnName="country_id")
	private List<ChampionMainTiba> ChampionMainTibaList;
}
