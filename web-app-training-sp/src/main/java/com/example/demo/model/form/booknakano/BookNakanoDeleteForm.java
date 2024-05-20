package com.example.demo.model.form.booknakano;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 書籍削除画面のFormクラス
 *
 * @author future
 */
@Data
public class BookNakanoDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}