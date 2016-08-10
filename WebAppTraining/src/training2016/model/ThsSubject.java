package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * thssubjectテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "thssubject")
public class ThsSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "subject")
	private String subject;

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * subjectを返す
	 *
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}

	/**
	 * subjectをセットする
	 *
	 * @param subject
	 *            セットする subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
