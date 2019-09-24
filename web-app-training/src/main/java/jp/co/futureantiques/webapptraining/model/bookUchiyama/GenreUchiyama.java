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
public class GenreUchiyama {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="genre")
	private String genre;

	@Column(name="del_flg")
	private String delFlg;

	@Column(name="create_date")
	private String createDate;

	@Column(name="update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity=BookMainUchiyama.class, mappedBy="genre")
	@JoinColumn(name="id", referencedColumnName="genre_id")
	private List<BookMainUchiyama> bookMainUchiayamList;
}
