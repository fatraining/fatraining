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
 * tabacoテーブルと対応するモデル
 */

@Entity
@Proxy(lazy = false)
@Table(name = "tabaco")
public class Tabaco implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "tabacoAreaId")
	private int tabacoAreaId;
	
	@Column(name = "namePhoto")
	private String namePhoto;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "tar")
	private String tar;
	
	@Column(name = "nicotine")
	private String nicotine;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "comment")
	private String comment;
	
	private String area;//銘柄名
	
	/**
	 * idを返す
	 */
	
	public int getId(){
		return this.id;
	}
	
	/**
	 * idをセット
	 */
	
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * tabacoAreaIdを返す
	 */
	
	public int getTabacoAreaId(){
		return this.tabacoAreaId;
	}
	
	/**
	 * tabacoAreaIdをセット
	 */
	
	public void setTabacoAreaId(int TabacoAreaId){
		this.tabacoAreaId = TabacoAreaId;
	}
	
	/**
	 * namePhoto【画像】をゲットして返す
	 */
	
	public String getNamePhoto(){
		return this.namePhoto;
	}
	
	public void setNamePhoto(String namePhoto){
		this.namePhoto = namePhoto;
	}
	
	/**
	 * name【商品】をゲットして返す
	 */
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * tar【タール】をゲットして返す
	 * @return
	 */
	
	public String getTar() {
		return tar;
	}

	public void setTar(String tar) {
		this.tar = tar;
	}
	
	/**
	 * nicotine【ニコチン】をゲットして返す
	 * @return
	 */

	public String getNicotine() {
		return nicotine;
	}

	public void setNicotine(String nicotine) {
		this.nicotine = nicotine;
	}
	
	/**
	 * price【価格】をゲットして返す。
	 * @return
	 */

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * comment【コメント】をゲットして返す
	 * @return
	 */

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * area【銘柄名】をゲットして返す
	 * @return
	 */

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}


