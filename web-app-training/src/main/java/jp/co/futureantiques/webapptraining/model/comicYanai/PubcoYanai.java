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
@Entity
@Data
public class PubcoYanai {
		//pubcoId
		@Id
		@GeneratedValue
		@Column(name ="id")
		private int id;

		//pubco
		@Column(name="pubco")
		private String pubco;

		//delFlg
		@Column(name="del_flg")
		private String delFlg;

		//createDate
		@Column(name="createDate")
		private Timestamp createDate;

		//updateDate
		@Column(name="updateDate")
		private Timestamp updateDate;

		/** 外部キー設定：出版社ID */
		@Transient
		@OneToMany(targetEntity = ComicMainYanai.class, mappedBy = "pubco")
		@JoinColumn(name = "id", referencedColumnName = "pubco_id")
		private List<ComicMainYanai> comicMainYanaiList;


}
