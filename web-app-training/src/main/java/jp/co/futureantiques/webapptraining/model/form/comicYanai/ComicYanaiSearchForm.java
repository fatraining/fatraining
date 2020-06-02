package jp.co.futureantiques.webapptraining.model.form.comicYanai;

import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;
import lombok.Data;
@Data
public class ComicYanaiSearchForm {

	//ID
	private Integer id;

	// 漫画名
	private String comicTitle;

	// ジャンルID
	private Integer genreId;

	// 出版社ID
	private Integer pubcoId;

	// 削除フラグON用
	private int isDelete;

	// 各フィールドに値を設定する

	public void setValues(ComicMainYanai comicMainYanai) {
		this.setId((int) comicMainYanai.getId());
		this.setComicTitle(comicMainYanai.getComicTitle());
		this.setGenreId(comicMainYanai.getGenreId());
		this.setPubcoId(comicMainYanai.getPubcoId());
	}
}
