package jp.co.futureantiques.webapptraining.model.GuiterFujimoto;
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


/**Woodテーブルと対応するEntityクラス
 * @author futureFUJIMOTO
 *
 */
@Data
@Entity
public class WoodFujimoto {
	/** 木材ID*/
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	//木材/
	@Column(name="wood")
	@Size(max=256)
	private String wood;

	//削除フラグ*/
	@Column(name="del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name="create_date")
	private String createDate;

	//更新日時*/
	@Column(name="update_date")
	private String updateDate;

	/**外部キー設定：所属グループID*/
	@Transient
	@OneToMany(targetEntity=GuiterMainFujimoto.class,mappedBy="wood_id")
	@JoinColumn(name="id",referencedColumnName="wood_id")
	private List<GuiterMainFujimoto> guiterMainFujimotoList;



}
