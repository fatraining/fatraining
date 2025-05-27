package com.example.demo.model.form.vegetabletahara;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 野菜削除画面のFormクラス
 *
 * @author future
 */
@Data
public class VegetableTaharaDeleteForm {

	/** 削除ID */   //↓は、バリデーションエラー発生時のメッセージの設定
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}