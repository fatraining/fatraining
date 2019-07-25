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

import lombok.Data;

@Data
@Entity
public class AreaIdJsuzuki {

	/**登場地方ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**登場地方*/
	@Column(name = "area_id")
	@Size(max = 255)
	private String areaId;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：登場地方ID*/
	@Transient
	@OneToMany(targetEntity = PokemonMainJsuzuki.class,mappedBy = "areaId")
	@JoinColumn(name = "id",referencedColumnName = "area_id")
	private List<PokemonMainJsuzuki>pokemonMainJsuzukiList;
}


