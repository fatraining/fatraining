package jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi;

import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;
import lombok.Data;

//ハムスター検索画面のFormクラス
@Data
public class HamsterKobayashiSearchForm {

	private Integer id;

	private String name;

	private Integer typeId;

	private Integer graduateId;

	private int isDelete;


	public void setValues(HamsterMainKobayashi hamsterMainKobayashi) {
		this.setId((int) hamsterMainKobayashi.getId());
		this.setName(hamsterMainKobayashi.getName());
		this.setTypeId(hamsterMainKobayashi.getTypeId());
		this.setGraduateId(hamsterMainKobayashi.getGraduateId());


	}

}
