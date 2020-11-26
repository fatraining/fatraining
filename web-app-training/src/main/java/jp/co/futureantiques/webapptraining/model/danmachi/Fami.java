package jp.co.futureantiques.webapptraining.model.danmachi;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

/**
 * @author Created by Wang
 *
 */
@Data
@Entity
@Table(name = "fami_wang")

public class Fami {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fami_name")
    private String famiName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	@Transient
    @OneToMany(targetEntity = Danmachi.class, mappedBy = "fami_wang")
    @JoinColumn(name = "id", referencedColumnName = "fami_id")
    private List<Danmachi> FamiList;
}
