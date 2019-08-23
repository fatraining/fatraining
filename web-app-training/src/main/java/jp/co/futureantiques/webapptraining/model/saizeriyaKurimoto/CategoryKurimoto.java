package jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**Genreテーブルと対応するEntityクラス
*@author kurimoto*/

@Data
@Entity
public class CategoryKurimoto {

	/**カテゴリID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**カテゴリ*/
	@Column(name = "category_name")
	private String categoryName;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：カテゴリID*/
	@Transient
	@OneToMany(targetEntity = SaizeriyaMenuMainKurimoto.class, mappedBy = "category")
	@JoinColumn(name = "id", referencedColumnName = "category_id")
	private List<SaizeriyaMenuMainKurimoto> saizeriyaMenuMainKurimotoList;
}