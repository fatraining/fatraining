package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * meganeテーブルと対応するモデル
 *
 * @author TomokiNakagawa
 *
 */
@Entity
@Proxy(lazy = false) // Hibernate関係のなにか
@Table(name = "megane")
public class Megane implements Serializable {
	// Serializable(シリアライズ)オブジェクトの状態をStreamの状態に変換すること

	@Id
	@GeneratedValue // プライマリキーカラムにユニークな値を自動で生成，付与する方法を指定するアノテーション
	@Column(name = "id")
	private int id;

	@Column(name = "meganeAreaId")
	private int meganeAreaId;

	@Column(name = "name")
	private String name;

	@Column(name = "color")
	private String color;

	@Column(name = "link")
	private String link;

	@Column(name = "kingaku")
	private String kingaku;

	@Column(name = "gazou")
	private String gazou;

	@Column(name = "syousai")
	private String syousai;


	private String area;


	/**
	 * idを返す
	 */

	public int getId() {
		return this.id;
	}

	/**
	 * idをセット
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * meganeAreaIdを返す
	 */
	public int getMeganeAreaId() {
		return this.meganeAreaId;
	}

	/**
	 * 上記をセット
	 */

	public void setMeganeAreaId(int MeganeAreaId) {
		this.meganeAreaId = MeganeAreaId;
	}

	/**
	 * nameをゲットして返す
	 */

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * colorをゲットして返す
	 */

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * kingakuをゲットして返す
	 */

	public String getKingaku() {
		return this.kingaku;
	}

	public void setKingaku(String kingaku) {
		this.kingaku = kingaku;
	}

	/**
	 * areaを返す
	 */


	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Linkを返す
	 */
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Syousaiを返す
	 */
	public String getSyousai() {
		return this.syousai;
	}

	public void setSyousai(String syousai) {
		this.syousai = syousai;
	}

	/**
	 * gazouを返す
	 */
public String getGazou() {
		return this.gazou;
	}

	public void setGazou(String gazou) {
		this.gazou = gazou;
	}



}
