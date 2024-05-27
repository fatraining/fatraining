package com.example.demo.model.form.drama;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ドラマ削除画面のFormクラス
 */
@Data
public class DramaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
