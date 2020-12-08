package jp.co.futureantiques.webapptraining.model.form.DanmachiWang;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.DanmachiWang.DanmachiMain;
import lombok.Data;
/**
 * ダンまち登録・更新画面用のFormクラス
 *
 * @author Wang
 */

@Data
public class DanmachiInputForm {

	private Long id;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 255,message = "Danmachi.text.error.countover")
	private String name;

	@NotNull(message = "common.text.error.require")
	private Long famiId;

	@NotNull(message = "common.text.error.require")
	private Long raceId;

	/**二つ名*/
	@Size(max = 255)
	private String title;

	/**声優*/
	@Size(max = 255)
	private String cast;

	/**更新日時(排他制御用)*/
	private String updateDate;

	/**
	 *フィールドにエンティティの中身を入れる
	 *
	 * @param Danmachi
	 */

	public void initWithDanmachi(DanmachiMain d) {
		this.setId((long)d.getId());
		this.setName(d.getName());
		this.setFamiId(d.getFamiId());
		this.setRaceId(d.getFamiId());
		this.setTitle(d.getTitle());
		this.setCast(d.getCast());
		this.setUpdateDate(String.valueOf(d.getUpdateDate()));
	}
	/**
	 * Danmachiエンティティに登録値を入れる
	 *
	 * @param Danmachi d
	 * @return Danmachi
	 */

	public DanmachiMain convertToDanmachiForInsert() {
		DanmachiMain d = new DanmachiMain();
		d = convertToDanmachi(d);
		d.setCreateDate(new Timestamp(new Date().getTime()));
		d.setUpdateDate(d.getCreateDate());
		return d;
	}

	/**
	 *Danmachiエンティティに更新値を入れる
	 *
	 * @param Danmachi d
	 * @return Danmachi
	 */
	public DanmachiMain convertToDanmachiForUpdate(DanmachiMain d) {
		d = convertToDanmachi(d);
		d.setUpdateDate(new Timestamp(new Date().getTime()));
		return d;
	}

	/**
	 *AlcoholMainIshidaエンティティに入力値を入れる
	 *
	 *@param Danmachi d
	 *@param Danmachi
	 */
	private DanmachiMain convertToDanmachi(DanmachiMain d) {
		d.setName(this.name);
		d.setFamiId(this.famiId);
		d.setRaceId(this.raceId);
		d.setTitle(this.title);
		d.setCast(this.cast);
		d.setDelFlg("0");
		return d;
	}
}
