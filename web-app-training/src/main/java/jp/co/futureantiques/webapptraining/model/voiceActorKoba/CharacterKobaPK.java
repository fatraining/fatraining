package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterKobaPK implements Serializable {
    @Column(name="id")
    private long id;
    @Column(name="anime_id")
    private Integer animeId;

    // setter, getter 自動生成 右クリック＞ソースから選択
	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return animeId
	 */
	public Integer getAnimeId() {
		return animeId;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param animeId セットする animeId
	 */
	public void setAnimeId(Integer animeId) {
		this.animeId = animeId;
	}

	// hashcode,equalsメソッド 自動生成 右クリック＞ソースから選択
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animeId == null) ? 0 : animeId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterKobaPK other = (CharacterKobaPK) obj;
		if (animeId == null) {
			if (other.animeId != null)
				return false;
		} else if (!animeId.equals(other.animeId))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}