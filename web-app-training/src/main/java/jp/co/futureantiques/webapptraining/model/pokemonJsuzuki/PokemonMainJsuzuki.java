package jp.co.futureantiques.webapptraining.model.pokemonJsuzuki;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * pokemon_main_jsuzukiと対応するEntity
 * @author future
 *
 */


@Data
@Entity
public class PokemonMainJsuzuki {
	/**ポケモンID*/
	@Id
	@GenericGenerator(name = "gen" , strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**ポケモンネーム*/
	@Column(name = "pokemon_name")
	private String pokemonName;

	/**登場地方ID*/
	@Column(name = "area_id")
	private Integer areaId;

	/**タイプID1*/
	@Column(name = "type1_id")
	private Integer type1Id;

	/**タイプID2*/
	@Column(name = "type2_id")
	private Integer type2Id;

	/**HP*/
	@Column(name = "hp")
	private Integer hp;

	/**攻撃*/
	@Column(name = "attack")
	private Integer attack;

	/**防御*/
	@Column(name = "defense")
	private Integer defense;

	/**特攻*/
	@Column(name = "special_attack")
	private Integer specialAttack;

	/**特防*/
	@Column(name = "special_defense")
	private Integer specialDefense;

	/**素早さ*/
	@Column(name = "speed")
	private Integer speed;

	/**合計種族値*/
	@Column(name = "parameter")
	private Integer parameter;
	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：登場地方*/
	@ManyToOne(targetEntity = AreaIdJsuzuki.class)
	@JoinColumn(name = "area_id",referencedColumnName = "id",insertable = false,updatable = false)
	private AreaIdJsuzuki area;

	/**外部キー設定：タイプ*/
	@ManyToOne(targetEntity = TypeIdJsuzuki.class)
	@JoinColumn(name = "type1_id",referencedColumnName = "id",insertable = false,updatable = false)
	private TypeIdJsuzuki type1;

	/**外部キー設定：タイプ*/
	@ManyToOne(targetEntity = TypeIdJsuzuki.class)
	@JoinColumn(name = "type2_id",referencedColumnName = "id",insertable = false,updatable = false)
	private TypeIdJsuzuki type2;



}
