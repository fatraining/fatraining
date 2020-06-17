package jp.co.futureantiques.webapptraining.model.alcoholishida;

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
 * Liqueurテーブルに対応するEntityクラス
 *
 * @author t.ishida
 */
@Data
@Entity
public class LiqueurIshida {
	/**リキュールID*/
	@Id
	@GeneratedValue
	@Column(name = "liqueur_id")
	private int liqueurId;

	/**リキュール*/
	@Column(name = "liqueur")
	@Size(max = 255)
	private String liqueur;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_Date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_Date")
	private String updateDate;

	/**外部キー設定：リキュールID*/
	@Transient
	@OneToMany(targetEntity = AlcoholMainIshida.class, mappedBy = "liqueur")
	@JoinColumn(name = "liqueur_id", referencedColumnName = "liqueur_id")
	private List<AlcoholMainIshida> liqueurIshidaList;
}