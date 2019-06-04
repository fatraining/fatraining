package jp.co.futureantiques.webapptraining.model.GuiterFujimoto;
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

/**guiterMainFujimotoテーブルと対応するEntity
 *
 * @author future FUJIMOTO
 *
 */
@Data
@Entity
public class GuiterMainFujimoto {
	/**ID 主キーとなるので@の表記が違う*/
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**名前*/
	@Column(name="aco_name")
	@Size(max=256)
	private String aconame;

	/**会社ID*/
	@Column(name="company_id")
	private Integer companyId;

	/**木材ID*/
	@Column(name="wood_id")
	private Integer woodId;

	/**価格*/
	@Column(name="price_int")
	private Integer priceInt;

	/**色*/
	@Column(name="color_name")
	@Size(max=256)
	private String colorname;

	/**コメント*/
	@Column(name="comment")
	@Size(max=256)
	private String comment;

	/**削除フラグ*/
	@Column(name="del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：会社ID*/
	@ManyToOne(targetEntity=CompanyFujimoto.class)
	@JoinColumn(name="company_id",referencedColumnName="id",insertable=false,updatable=false)
	private CompanyFujimoto company;

	/** 外部キー設定：もくざい*/
	@ManyToOne(targetEntity=WoodFujimoto.class)
	@JoinColumn(name="wood_id",referencedColumnName="id",insertable=false,updatable=false)
	private WoodFujimoto wood;
}
