package jp.co.futureantiques.webapptraining.model.form.mangaKawada;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 漫画削除画面のFormクラス
 *
 * @author Kawada
 */
@Data
public class MangaKawadaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
