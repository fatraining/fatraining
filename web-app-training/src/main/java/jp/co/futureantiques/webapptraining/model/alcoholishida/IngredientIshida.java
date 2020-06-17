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
 * Ingredientテーブルと対応するEntity
 *
 * @author t.ishida
 */
@Data
@Entity
public class IngredientIshida {

	/**材料ID*/
	@Id
	@GeneratedValue
	@Column(name = "ingredient_id")
	private int ingredientId;

	/**材料名*/
	@Column(name = "ingredient")
	@Size(max = 255)
	private String ingredient;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：材料1*/
	@Transient
	@OneToMany(targetEntity = AlcoholMainIshida.class, mappedBy = "ingredient1")
	@JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id1")
	private List<AlcoholMainIshida> IngredientMainIshidaList;

	/**外部キー設定：材料2*/
	@Transient
	@OneToMany(targetEntity = AlcoholMainIshida.class, mappedBy = "ingredient2")
	@JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id2")
	private List<AlcoholMainIshida> IngredientMain1List;

	/**外部キー設定：材料3*/
	@Transient
	@OneToMany(targetEntity = AlcoholMainIshida.class, mappedBy = "ingredient3")
	@JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id3")
	private List<AlcoholMainIshida> IngredientMain2List;
}