package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/* thsテーブルと対応するモデル
 */
@Entity
@Proxy(lazy = false) // おまじない程度で
@Table(name = "yokai")
public class Yokai implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "yokaifromId")
	private int yokaifromId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "comment")
	private String comment;

	@Column(name = "link")
	private String link;

	private String yokaifrom;

	/* idを返す
	 *
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/* idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* youkaifromIdを返す
	 *
	 * @return youjaifromId
	 */
	public int getYokaifromId() {
		return this.yokaifromId;
	}

	/* youkaifromIdをセットする
	 *
	 * @param yokaifromId
	 *            セットする youkaifromId
	 */
	public void setYokaifromId(int yokaifromId) {
		this.yokaifromId = yokaifromId;
	}

	/* nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/*nameをセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* typeを返す
	 *
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/* typeをセットする
	 *
	 * @param type
	 *            セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	public String getLink() {
		return this.link;
	}

	/* commentをセットする
	 *
	 * @param comment
	 *            セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getYokaifrom() {
		return this.yokaifrom;
	}

	public void setYokaifrom(String yokaifrom) {
		this.yokaifrom = yokaifrom;
	}

	public void setLink(String link) {
		this.link = link;
	}



}
