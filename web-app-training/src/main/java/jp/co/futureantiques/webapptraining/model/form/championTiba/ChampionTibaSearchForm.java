package jp.co.futureantiques.webapptraining.model.form.championTiba;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import lombok.Data;

@Data

public class ChampionTibaSearchForm{
	private Integer id;
	private String championName;
	private Integer classId;
	private Integer countryId;
	private int isDelete;


	public void setValues(ChampionMainTiba championMainTiba) {
		this.setId((int)championMainTiba.getId());
		this.setChampionName(championMainTiba.getChampionName());
		this.setClassId(championMainTiba.getClassId());
		this.setCountryId(championMainTiba.getCountryId());

	}
}