package jp.co.futureantiques.webapptraining.model.bandSasaki;
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
public class BandMain {

@Id
@GenericGenerator(name="gen", strategy="increment")
@GeneratedValue(generator="gen")
private long id;

	@Column(name="band_name")
	private String bandName;

	@Column(name="member_id")
	private Integer memberId;

	@Column(name="birthplace_id")
	private Integer birthplaceId;

	@Column(name="formation_year")
	private Integer formationYear;

	@Column(name="release_num")
	private Integer releaseNum;

	@Column(name="comment")
	@Size(max=255)
	private String comment;

	@Column(name="del_flg")
	private String delFlg;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name = "member_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Member member;

	@ManyToOne(targetEntity = Birthplace.class)
	@JoinColumn(name = "birthplace_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Birthplace birthplace;

}
