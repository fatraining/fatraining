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
 * onsenテーブルと対応するモデル
 */
@Entity
@Proxy(lazy = false) // おまじない程度で
@Table(name = "onsen")
public class Onsen implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "onsenAreaId")
	private int onsenAreaId;

	@Column(name = "name")
	private String name;

	@Column(name = "effect")
	private String effect;

	@Column(name = "link")
	private String link;

	@Column(name = "comment")
	private String comment;

	private String area;

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
	 * onsenAreaIdを返す
	 *
	 * @return onsenAreaId
	 */
	public int getOnsenAreaId() {
		return this.onsenAreaId;
	}

	/**
	 * onsenAreaIdをセットする
	 *
	 * @param onsenAreaId
	 *            セットする osnenAreaId
	 */
	public void setOnsenAreaId(int onsenAreaId) {
		this.onsenAreaId = onsenAreaId;
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
	 * effectを返す
	 *
	 * @return effect
	 */
	public String getEffect() {
		return this.effect;
	}

	/**
	 * effectをセットする
	 *
	 * @param efecte
	 *            セットする effect
	 */
	public void setEffect(String effect) {
		this.effect = effect;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
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

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return this.link;
	}

}
