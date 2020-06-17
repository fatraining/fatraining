package jp.co.futureantiques.webapptraining.model.alcoholishida;

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

/**
 * AlcoholMainIshidaテーブルと対応するEntity
 *
 * @author t.ishida
 */

@Entity
@Data
public class AlcoholMainIshida {

	/**お酒ID*/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**お酒名*/
	@Column(name = "alcohol_name")
	private String alcoholName;

	/**リキュールID*/
	@Column(name = "liqueur_id")
	private Integer liqueurId;

	/**材料ID1*/
	@Column(name = "ingredient_id1")
	private Integer ingredientId1;

	/**材料ID2*/
	@Column(name = "ingredient_id2")
	private Integer ingredientId2;

	/**材料ID3*/
	@Column(name = "ingredient_id3")
	private Integer ingredientId3;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 255)
	private String comment;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：リキュール*/
	@ManyToOne(targetEntity = LiqueurIshida.class)
	@JoinColumn(name = "liqueur_id", referencedColumnName = "liqueur_id", insertable = false, updatable = false)
	private LiqueurIshida liqueur;

	/**外部キー設定：材料1*/
	@ManyToOne(targetEntity = IngredientIshida.class)
	@JoinColumn(name = "ingredient_id1", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
	private IngredientIshida ingredient1;

	/**外部キー設定：材料2*/
	@ManyToOne(targetEntity = IngredientIshida.class)
	@JoinColumn(name = "ingredient_id2", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
	private IngredientIshida ingredient2;

	/**外部キー設定：材料3*/
	@ManyToOne(targetEntity = IngredientIshida.class)
	@JoinColumn(name = "ingredient_id3", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
	private IngredientIshida ingredient3;

}