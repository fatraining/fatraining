package jp.co.futureantiques.webapptraining.model.form.yuruYokoyama;

	import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;
import lombok.Data;

	/**
	 * ゆるキャラ登録・更新画面用のFormクラス
	 *
	 * @author future
	 */
	@Data
	public class YuruInputForm {

		/** ID */
		private int id;

		/** 名前 */
		@NotBlank(message = "common.text.error.require")
		@Size(max = 255)
		private String name;

		/** 出身ID */
		private Integer fromId;

		/** 所属ID */
		private Integer belongId;

		/** 特徴 */
		@Size(max = 255)
		private String point;

		/** 画像 */
		//？


		/** 更新日時（排他制御用） */
		private String updateDate;

		/**
		 * フィールドにエンティティの中身を入れる
		 *
		 * @param yuruDataYokoyama
		 */
		public void initWithYuruDataYokoyama(YuruDataYokoyama yuruDataYokoyama) {
			this.setId((int) yuruDataYokoyama.getId());
			this.setName(yuruDataYokoyama.getName());
			this.setFromId(yuruDataYokoyama.getFromId());
			this.setBelongId(yuruDataYokoyama.getBelongId());
			this.setPoint(yuruDataYokoyama.getPoint());
			//画像？
			this.setUpdateDate(String.valueOf(yuruDataYokoyama.getUpdateDate()));
		}

		/**
		 * YuruDataエンティティに登録値を入れる
		 *
		 * @return YuruData
		 */
		public YuruDataYokoyama convertToYuruDataForInsert() {
			YuruDataYokoyama yuruDataYokoyama = new YuruDataYokoyama();
			yuruDataYokoyama = convertToYuruData(yuruDataYokoyama);
			yuruDataYokoyama.setCreateDate(new Timestamp(new Date().getTime()));
			yuruDataYokoyama.setUpdateDate(yuruDataYokoyama.getCreateDate());
			return yuruDataYokoyama;
		}

		/**
		 * YuruDataエンティティに更新値を入れる
		 *
		 * @param YuruDataYokoyama yuruData
		 * @return YuruData
		 */
		public YuruDataYokoyama convertToYuruDataForUpdate(YuruDataYokoyama yuruDataYokoyama) {
			yuruDataYokoyama = convertToYuruData(yuruDataYokoyama);
			yuruDataYokoyama.setUpdateDate(new Timestamp(new Date().getTime()));
			return yuruDataYokoyama;
		}

		/**
		 * YuruDataエンティティに入力値を入れる
		 *
		 * @param YuruDataYokoyama yuruData
		 * @return YuruData
		 */
		private YuruDataYokoyama convertToYuruData(YuruDataYokoyama yuruDataYokoyama) {
			yuruDataYokoyama.setName(this.name);
			yuruDataYokoyama.setFromId(this.fromId);
			yuruDataYokoyama.setBelongId(this.belongId);

			yuruDataYokoyama.setPoint(this.point);
			yuruDataYokoyama.setDelFlg("0");
			return yuruDataYokoyama;
		}
	}