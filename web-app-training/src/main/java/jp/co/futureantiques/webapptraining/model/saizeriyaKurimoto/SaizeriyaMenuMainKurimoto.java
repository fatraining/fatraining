package jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**MenuKurimotoテーブルと対応するEntity
*@author Kurimoto*/

@Data
@Entity
public class SaizeriyaMenuMainKurimoto {

	/**メニューID*/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**メニュー名*/
	@Column(name = "menu_name")
	private String menuName;

	/**カテゴリID*/
	@Column(name = "category_id")
	private Integer categoryId;

	/**価格帯ID*/
	@Column(name = "price_id")
	private Integer priceId;

	/**定価*/
	@Column(name = "teika")
	private Integer teika;

	/**カロリー*/
	@Column(name = "calories")
	private Integer calories;

	/**塩分*/
	@Column(name = "sodium")
//	@Size(max = 255)
	private Double sodium;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：カテゴリ*/
	@ManyToOne(targetEntity = CategoryKurimoto.class)
	@JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private CategoryKurimoto categoryKurimoto;

	/**外部キー設定：価格帯*/
	@ManyToOne(targetEntity = PriceKurimoto.class)
	@JoinColumn(name = "price_id", referencedColumnName = "id", insertable = false, updatable = false)
	private PriceKurimoto priceKurimoto;
}