package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ozakialbum")

/* 直列化（オブジェクト状態をStreamの状態に変換） */
public class OzakiAlbum implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "albumName")
	private String albumName;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
}
