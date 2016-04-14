/**
 * WebApp.js
 */

/**
 * submit関数
 *
 * @param formId フォームID
 * @param action アクション
 * @param method メソッド
 */
function submit_get(formId, action, method){
	// メソッドを判別させるための要素を生成する
	var hiddenTag = document.createElement("input");
	hiddenTag.setAttribute("name", "method:" + method);
	hiddenTag.setAttribute("type", "hidden");
	hiddenTag.setAttribute("value", "1");//判定用の値

	var form = document.getElementById(formId);
	form.appendChild(hiddenTag);
	form.action = action;
	form.method = "get";
	form.submit();
}
