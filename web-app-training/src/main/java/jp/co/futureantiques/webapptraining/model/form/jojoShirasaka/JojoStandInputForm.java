package jp.co.futureantiques.webapptraining.model.form.jojoShirasaka;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;
import lombok.Data;

/**
 * 映画登録・更新画面用のFormクラス
 *
 */
@Data
public class JojoStandInputForm {

	/** ID */
	private int id;

	/** スタンド名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String standName;

	/** スタンド能力者 */
	private String standUser;

	/** 性別ID */
	private Integer sexId;

	/** 能力 */
	@NotBlank(message = "common.text.error.require")
	private String ability;

	/** 登場部ID */
	@NotNull(message = "common.text.error.require")
	@Min(value=1, message = "common.text.error.require")
	private Integer appearanceId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param jojoMainShirasaka
	 */
	public void initWithJojoMain(JojoMainShirasaka jojoMainShirasaka) {
		this.setId((int) jojoMainShirasaka.getId());
		this.setStandName(jojoMainShirasaka.getStandName());
		this.setStandUser(jojoMainShirasaka.getStandUserName());
		this.setSexId(jojoMainShirasaka.getSexId());
		this.setAbility(jojoMainShirasaka.getAbility());
		this.setAppearanceId(jojoMainShirasaka.getAppearanceId());
		this.setComment(jojoMainShirasaka.getComment());
		this.setUpdateDate(String.valueOf(jojoMainShirasaka.getUpdateDate()));
	}

	/**
	 * JojoMainShirasakaエンティティに登録値を入れる
	 *
	 * @return JojoMainShirasaka
	 */
	public JojoMainShirasaka convertToJojoMainForInsert() {
		JojoMainShirasaka jojoMainShirasaka = new JojoMainShirasaka();
		jojoMainShirasaka = convertToJojoMain(jojoMainShirasaka);
		jojoMainShirasaka.setCreateDate(new Timestamp(new Date().getTime()));
		jojoMainShirasaka.setUpdateDate(jojoMainShirasaka.getCreateDate());
		return jojoMainShirasaka;
	}

	/**
	 * JojoMainShirasakaエンティティに更新値を入れる
	 *
	 * @param JojoMainShirasaka jojoMainShirasaka
	 * @return JojoMainShirasaka
	 */
	public JojoMainShirasaka convertToJojoMainForUpdate(JojoMainShirasaka jojoMainShirasaka) {
		jojoMainShirasaka = convertToJojoMain(jojoMainShirasaka);
		jojoMainShirasaka.setUpdateDate(new Timestamp(new Date().getTime()));
		return jojoMainShirasaka;
	}

	/**
	 * JojoMainShirasakaエンティティに入力値を入れる
	 *
	 * @param JojoMainShirasaka jojoMainShirasaka
	 * @return JojoMainShirasaka
	 */
	private JojoMainShirasaka convertToJojoMain(JojoMainShirasaka jojoMainShirasaka) {
		jojoMainShirasaka.setStandName(this.standName);
		jojoMainShirasaka.setStandUserName(this.standUser);
		jojoMainShirasaka.setSexId(this.sexId);
		jojoMainShirasaka.setAbility(this.ability);
		jojoMainShirasaka.setAppearanceId(this.appearanceId);
		jojoMainShirasaka.setComment(this.comment);
		jojoMainShirasaka.setDelFlg("0");
		return jojoMainShirasaka;
	}
}