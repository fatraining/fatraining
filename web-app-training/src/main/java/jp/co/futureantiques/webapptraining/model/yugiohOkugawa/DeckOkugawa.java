package jp.co.futureantiques.webapptraining.model.yugiohOkugawa;

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
 * DeckOkugawaと対応するEntity
 *
 * @author Okugawa
 *
 */
@Data
@Entity
public class DeckOkugawa {

	/** デッキID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** デッキ属性 */
	@Column(name = "deck_attribute")
	@Size(max= 30)
	private String deckAttribute;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定:性別ID*/
	@Transient
	@OneToMany(targetEntity = YugiohMainOkugawa.class, mappedBy = "deckAttribute")
	@JoinColumn(name = "id", referencedColumnName = "deck_id")
	private List<YugiohMainOkugawa> yugiohMainOkugawa;

}
