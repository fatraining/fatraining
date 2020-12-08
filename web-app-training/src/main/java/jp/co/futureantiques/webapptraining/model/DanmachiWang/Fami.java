package jp.co.futureantiques.webapptraining.model.DanmachiWang;

import java.sql.Timestamp;
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

/**
 * @author Created by Wang
 *
 */
@Data
@Entity


public class Fami {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "fami_name")
    @Size(max = 255)
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
    @OneToMany(targetEntity = DanmachiMain.class, mappedBy = "fami")
    @JoinColumn(name = "id", referencedColumnName = "fami_id")
    private List<DanmachiMain> famiList;
}
