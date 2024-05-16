package com.example.demo.model.form.catHayashichika;

import java.util.ArrayList;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *猫削除のFormクラス
 *@author future 
 */
@Data
public class CatHayashichikaDeleteForm {
	/**削除ID*/
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
