package jp.co.futureantiques.webapptraining.model.comicYanai;

import java.sql.Timestamp;
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
public class GenreYanai {
	//genreId
	@Id
	@GeneratedValue
	@Column(name ="id")
	private int id;

	//genre
	@Column(name="genre")
	private String genre;

	//delFlg
	@Column(name="del_flg")
	private String delFlg;

	//createDate
	@Column(name="createDate")
	private Timestamp createDate;

	//updateDate
	@Column(name="updateDate")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = ComicMainYanai.class, mappedBy = "genre")
	@JoinColumn(name = "id", referencedColumnName = "genre_id")
	private List<ComicMainYanai> comicMainYanaiList;

}
