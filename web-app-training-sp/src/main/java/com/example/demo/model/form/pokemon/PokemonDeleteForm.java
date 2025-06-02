package com.example.demo.model.form.pokemon;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *ポケモン削除画面のFormクラス
 *
 * @author satoyoshi
 */
@Data

public class PokemonDeleteForm {

	/** 削除ID */
	//↓チェックボックスにチェックがないとエラー(チェックを入れてください)
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
