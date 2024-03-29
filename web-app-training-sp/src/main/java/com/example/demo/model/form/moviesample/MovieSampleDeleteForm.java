package com.example.demo.model.form.moviesample;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 映画削除画面のFormクラス
 *
 * @author future
 */
@Data
public class MovieSampleDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}