package jp.co.futureantiques.webapptraining.model.bandSasaki;

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
public class Birthplace {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="birthplace")
	@Size(max=4)
	private String birthplace;

	@Column(name="del_flg")
	private String delFlg;

	@Column(name="create_date")
	private String createDate;

	@Column(name="update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity=BandMain.class, mappedBy="birthplace")
	@JoinColumn(name="id", referencedColumnName="birthplace_id")
	private List<BandMain> bandMainList;
}
