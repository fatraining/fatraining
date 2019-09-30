package jp.co.futureantiques.webapptraining.model.form.animeNagatake;

import jp.co.futureantiques.webapptraining.model.animeNagatake.AnimeMainNagatake;
import lombok.Data;

@Data
public class AnimeNagatakeSearchForm {

		/** ID */
		private Integer id;

		/** アニメタイトル */
		private String animeTitle;

		/** ジャンルID */
		private Integer genreId;

		/** スタジオID */
		private Integer studioId;

		/** 声優ID */
		private Integer voiceactorId;

		/** 出典ID */
		private Integer sourceId;

		/** 削除フラグON用 */
		private int isDelete;

		/**
		 * 各フィールドに値を設定する
		 *
		 * @param AnimeMainNagatake
		 * */
		public void setValues(AnimeMainNagatake animeMainNagatake) {
			this.setId((int)animeMainNagatake.getId());
			this.setAnimeTitle(animeMainNagatake.getAnimeTitle());
			this.setGenreId(animeMainNagatake.getGenreId());
			this.setStudioId(animeMainNagatake.getStudioId());
			this.setVoiceactorId(animeMainNagatake.getVoiceactorId());
			this.setSourceId(animeMainNagatake.getSourceId());

		}
	}