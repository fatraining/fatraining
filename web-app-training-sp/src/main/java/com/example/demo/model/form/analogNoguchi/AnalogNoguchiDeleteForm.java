package com.example.demo.model.form.analogNoguchi;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * アナログゲーム削除画面のFormクラス
 * 
 * @author future
 */
@Data
public class AnalogNoguchiDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
