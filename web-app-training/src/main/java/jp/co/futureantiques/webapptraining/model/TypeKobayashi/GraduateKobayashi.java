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

//GraduateKobayashiテーブルと対応するEntity

@Data
@Entity
public class GraduateKobayashi {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Size(max = 255)
	private String name;

	@Column(name = "del_flg")
	private String delflg;

	@Column(name = "create_date")
	private String createDate;

	@Column(name = "update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity = HamsterMainKobayashi.class, mappedBy = "graduatekobayashi")
	@JoinColumn(name = "id", referencedColumnName = "graduate_id")
	private List<HamsterMainKobayashi> hamsterMainKobayashiList;


}
