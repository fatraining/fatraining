package jp.co.futureantiques.webapptraining.model.form.icecreamSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.IcecreamMainSako;
import lombok.Data;

/**
 * 検索画面のFormクラス
 *
 * @author MINAMI SAKO
 */
@Data
public class IcecreamSearchForm {

		/** ID */
		private Integer id;

		/** 名前 */
		private String name;

		/**ジャンルID */
		private Integer genreId;

		/** メーカーID */
		private Integer makerId;

		/** 削除フラグON用 */
		private int isDelete;

		/**
		 * 各フィールドに値を設定する
		 *
		 * @param icecreamMainSako
		 */
		public void setValues(IcecreamMainSako icecreamMainSako) {
			this.setId((int) icecreamMainSako.getId());
			this.setName(icecreamMainSako.getName());
			this.setGenreId(icecreamMainSako.getGenreId());
			this.setMakerId(icecreamMainSako.getMakerId());
		}
	}


