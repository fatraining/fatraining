package com.example.demo.model.form.zelda;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * ゼルダ削除画面のFormクラス
 */
@Data
public class ZeldaDeleteForm {
	
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
