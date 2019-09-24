package jp.co.futureantiques.webapptraining.model.bookUchiyama;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class WriterUchiyama {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "country")
	private String country;

	@Column(name = "del_flg")
	private String delFlg;

	@Column(name = "create_date")
	private String createDate;

	@Column(name = "update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity = BookMainUchiyama.class, mappedBy = "writer")
	@JoinColumn(name = "id", referencedColumnName = "writer_id")
	private List<WriterUchiyama> writerUchiyamaList;
}
