package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 *
 * thsテーブルと対応するモデル
 */
@Entity
@Proxy(lazy = false) // おまじない程度で
@Table(name = "ths")
public class Ths implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "thsSubjectId")
	private int thsSubjectId;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private String level;

	@Column(name = "comment")
	private String comment;

	@Column(name = "link")
	private String link;

	private String subject;

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * subjectIdを返す
	 *
	 * @return subjectId
	 */
	public int getThsSubjectId() {
		return this.thsSubjectId;
	}

	/**
	 * thsSubjectIdをセットする
	 *
	 * @param thsSubjectId
	 *            セットする thsSubjectId
	 */
	public void setThsSubjectId(int thsSubjectId) {
		this.thsSubjectId = thsSubjectId;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * levelを返す
	 *
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}

	/**
	 * levelをセットする
	 *
	 * @param level
	 *            セットする level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	public String getLink() {
		return this.link;
	}

	/**
	 * commentをセットする
	 *
	 * @param comment
	 *            セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setLink(String link) {
		this.link = link;
	}



}
