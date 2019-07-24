package jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma;

import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.MobileLegendsMainSakuma;
import lombok.Data;

/**
 * キャラクター検索画面のFormクラス
 * @author Sakuma
 *
 */
@Data
public class MobileLegendsSakumaSearchForm {

	/**ID*/
	private Integer id;

	/**キャラクター名*/
	private String mobaleChara;

	/**タイプ1ID*/
	private Integer type1Id;

	/**タイプ2ID*/
	private Integer type2Id;

	/**特徴1ID*/
	private Integer feature1Id;

	/**特徴2ID*/
	private Integer feature2Id;

	/**削除フラグON用*/
	private int isDelete;

	/**各フィールドに値を設定する*/
	public void setValues(MobileLegendsMainSakuma mobileLegendsMainSakuma) {
		this.setId((int)mobileLegendsMainSakuma.getId());
		this.setMobaleChara(mobileLegendsMainSakuma.getMobaleChara());
		this.setType1Id(mobileLegendsMainSakuma.getType1Id());
		this.setType2Id(mobileLegendsMainSakuma.getType2Id());
		this.setFeature1Id(mobileLegendsMainSakuma.getFeature1Id());
		this.setFeature2Id(mobileLegendsMainSakuma.getFeature2Id());
	}

}
