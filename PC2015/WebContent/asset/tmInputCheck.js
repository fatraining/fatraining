/**
 * 数値のみ入力可能
 * @returns {Boolean}
 */
function numOnly() {
	keyCode = event.keyCode;
	if(keyCode == 8		// バックスペース
	|| keyCode == 9		// タブキー
	|| keyCode == 46	// deleteキー
	|| (keyCode >= 37 && 40 >= keyCode)		// 矢印キー
	|| (keyCode >= 48 && 57 >= keyCode)		// テンキーじゃない数字
	|| (keyCode >= 96 && 105 >= keyCode)) {	// テンキーの数字
		return true;
	} else {
		return false;
	}
}

/**
 * 半角英数字のみ入力可能
 */
function hanAlpha() {
	keyCode = event.keyCode;
	if(keyCode == 8		// バックスペース
	|| keyCode == 9		// タブキー
	|| keyCode == 46	// deleteキー
	|| (keyCode >= 37 && 40 >= keyCode)		// 矢印キー
	|| (keyCode >= 48 && 57 >= keyCode)		// テンキーじゃない数字
	|| (keyCode >= 96 && 105 >= keyCode)	// テンキーの数字
	|| (keyCode >= 65 && 90 >= keyCode)		// a-z
	|| (keyCode >= 97 && 122 >= keyCode)) {	// A-Z
		return true;
	} else {
		return false;
	}
}


/**
 * 閏年チェック
 */
 function chkUru(chkYear) {
	if (((chkYear % 4 == 0) && (chkYear % 100 != 0)) || (chkYear % 400 == 0)) {
		// 閏年
		return true;
	} else {
		// 通常年
		return false;
	}
}
