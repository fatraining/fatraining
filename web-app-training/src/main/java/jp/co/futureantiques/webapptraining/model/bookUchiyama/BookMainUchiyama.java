package jp.co.futureantiques.webapptraining.model.bookUchiyama;



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
	public class BookMainUchiyama {

		@Id
		@GenericGenerator(name = "gen", strategy = "increment")
		@GeneratedValue(generator = "gen")
		private long id;


		@Column(name = "book_title")
		private String bookTitle;

		@Column(name = "genre_id")
		private Integer genreId;

		@Column(name = "writer_id")
		private Integer writerId;

		@Column(name = "release_year")
		private Integer releaseYear;

		@Column(name = "comment")
		@Size(max = 255)
		private String comment;

		@Column(name = "del_flg")
		private String delFlg;

		@Column(name = "create_date")
		private Timestamp createDate;

		@Column(name = "update_date")
		private Timestamp updateDate;

		@ManyToOne(targetEntity = GenreUchiyama.class)
		@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
		private GenreUchiyama genreUchiyama;

		@ManyToOne(targetEntity = WriterUchiyama.class)
		@JoinColumn(name = "writer_id", referencedColumnName = "id", insertable = false, updatable = false)
		private WriterUchiyama writerUchiyama;


}
