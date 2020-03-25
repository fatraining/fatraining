package jp.co.futureantiques.webapptraining.model.form.voiceActorKoba;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;
import lombok.Data;

@Data
public class VoiceActorKobaSearchForm {

	public Object getId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String getActorName() {
		return null;
	}

	public Integer getOfficeId() {
		return null;
	}

	public String getAnimeTitle() {
		return null;
	}

    public void setValues(VoiceActorMainKoba voiceActorMainKoba) {
        this.setId(voiceActorMainKoba.getId());
        this.setActorName(voiceActorMainKoba.getActorName());
        this.setImage(voiceActorMainKoba.getImage());
        this.setBirthday(voiceActorMainKoba.getBirthday());
        this.setFromId(voiceActorMainKoba.getFromId());
        this.setOfficeId(voiceActorMainKoba.getOfficeId());
    }

	private void setId(long id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void setActorName(String actorName) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void setImage(String image) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void setBirthday(String birthday) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void setFromId(Integer fromId) {
		// TODO 自動生成されたメソッド・スタブ

	}


	private void setOfficeId(Integer officeId) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
