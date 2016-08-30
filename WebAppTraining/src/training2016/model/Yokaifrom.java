package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* youkaifromテーブルと対応するモデル

 */

@Entity
@Table(name = "yokaifrom")
public class Yokaifrom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "yokaifrom")
	private String yokaifrom;

	/* idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/* idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/* youkaifromを返す
	 *
	 * @return youkaifrom
	 */
	public String getYokaifrom() {
		return this.yokaifrom;
	}

	/* youkaifromをセットする
	 *
	 * @param youkaifrom
	 *            セットする youkaifrom
	 */
	public void setYokairom(String yokaifrom) {
		this.yokaifrom = yokaifrom;
	}
}
