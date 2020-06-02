package jp.co.futureantiques.webapptraining.model.form.comicYanai;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class ComicYanaiDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
