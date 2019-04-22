package jp.co.futureantiques.webapptraining.model.form.yuruYokoyama;

	import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;
import lombok.Data;

	/**
	 * 映画登録・更新画面用のFormクラス
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
		 * @param movieMain
		 */
		public void initWithMovieMain(YuruDataYokoyama yuruData) {
			this.setId((int) yuruData.getId());
			this.setName(yuruData.getName());
			this.setFromId(yuruData.getFromId());
			this.setBelongId(yuruData.getBelongId());
			this.setPoint(yuruData.getPoint());
			//画像？
			this.setUpdateDate(String.valueOf(yuruData.getUpdateDate()));
		}

		/**
		 * YuruDataエンティティに登録値を入れる
		 *
		 * @return YuruData
		 */
		public YuruDataYokoyama convertToYuruDataForInsert() {
			YuruDataYokoyama yuruData = new YuruDataYokoyama();
			yuruData = convertToYuruData(yuruData);
			yuruData.setCreateDate(new Timestamp(new Date().getTime()));
			yuruData.setUpdateDate(yuruData.getCreateDate());
			return yuruData;
		}

		/**
		 * YuruDataエンティティに更新値を入れる
		 *
		 * @param YuruDataYokoyama yuruData
		 * @return YuruData
		 */
		public YuruDataYokoyama convertToYuruDataForUpdate(YuruDataYokoyama yuruData) {
			yuruData = convertToYuruData(yuruData);
			yuruData.setUpdateDate(new Timestamp(new Date().getTime()));
			return yuruData;
		}

		/**
		 * YuruDataエンティティに入力値を入れる
		 *
		 * @param YuruDataYokoyama yuruData
		 * @return YuruData
		 */
		private YuruDataYokoyama convertToYuruData(YuruDataYokoyama yuruData) {
			yuruData.setName(this.name);
			yuruData.setFromId(this.fromId);
			yuruData.setBelongId(this.belongId);

			yuruData.setPoint(this.point);
			yuruData.setDelFlg("0");
			return yuruData;
		}
	}