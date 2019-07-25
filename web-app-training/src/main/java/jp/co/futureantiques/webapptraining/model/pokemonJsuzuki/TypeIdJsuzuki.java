package jp.co.futureantiques.webapptraining.model.pokemonJsuzuki;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import jp.co.futureantiques.webapptraining.model.resipeishikawa.ResipeMainIshikawa;
import lombok.Data;


@Data
@Entity
public class TypeIdJsuzuki {

	/**タイプID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**タイプ名*/
	@Column(name = "type_id")
	@Size(max = 256)
	private String typeId;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：タイプ1*/
	@Transient
	@OneToMany(targetEntity = PokemonMainJsuzuki.class,mappedBy = "type1")
	@JoinColumn(name = "id",referencedColumnName = "type1_id")
	private List<PokemonMainJsuzuki>pokemonMainJsuzukiList;

	/**外部キー設定：タイプ2*/
	@Transient
	@OneToMany(targetEntity = ResipeMainIshikawa.class,mappedBy = "type2")
	@JoinColumn(name = "id",referencedColumnName = "type2_id")
	private List<PokemonMainJsuzuki>pokemonMainList;

}
