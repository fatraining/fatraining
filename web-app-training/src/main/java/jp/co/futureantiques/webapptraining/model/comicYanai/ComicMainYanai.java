package jp.co.futureantiques.webapptraining.model.comicYanai;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class ComicMainYanai {
	//ID
	@Id
	@GeneratedValue
	@Column(name ="id")
	private long id;
	//comictitle
	@Column(name="comic_title")
	private String comicTitle;
	//genreId
	@Column(name="genre_id")
	private Integer genreId;
	//pubcoId
	@Column(name="pubco_id")
	private Integer pubcoId;
	//volume
	@Column(name="volume")
	private Integer volume;
	//comment
	@Column(name="comment")
	private String comment;
	//delFlg
	@Column(name="del_flg")
	private String delFlg;
	//createDate
	@Column(name="create_date")
	private Timestamp createDate;
	//updateDate
	@Column(name="update_date")
	private Timestamp updateDate;
	//外部キー
	@ManyToOne(targetEntity = GenreYanai.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreYanai genre;
	@ManyToOne(targetEntity = PubcoYanai.class)
	@JoinColumn(name = "pubco_id", referencedColumnName = "id", insertable = false, updatable = false)
	private PubcoYanai pubco;

}
