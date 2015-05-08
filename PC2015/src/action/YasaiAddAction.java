package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.YasaiManager;

@Result(name = "yasaiSearch", value = "yasaiSearch.action", type = ServletRedirectResult.class)
public class YasaiAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 追加画面入力
	public String yasai;
	public String ryouri;
	public String tyouri;

	// エラーメッセージ表示
	public String errormsg;

	// 削除チェックボックス
	public String delete_id;

	// 画面表示時に実行
	public String execute() throws Exception {
		// YasaiSearchActionのdelete_idを呼び出し
		this.delete_id = (String) this.sessionMap.get("delete_id");

		return "success";
	}

	// 追加ボタン押下時
	public String insert() {

		// 入力チェック
		if (this.yasai.isEmpty() || this.ryouri.isEmpty()
				|| this.tyouri.isEmpty()) {
			// 野菜、料理、調理の欄のいずれかが空だとエラーメッセージを返す
			this.errormsg = "全ての項目に入力してください";
			return "errormsg";

			// 全て入力された場合
		} else {
			// セッションマップからuserIdを取得
			String userId = (String) this.sessionMap.get("userId");
			// YasaiManagerをインスタンス化
			YasaiManager yasaimanager = new YasaiManager();
			// YasaiManagerのinsertメソッドに値を渡す
			yasaimanager.insert(this.yasai, this.tyouri, this.ryouri, userId);
		}

		return "yasaiSearch";
	}

	// 削除画面で削除ボタン押下時
	public String delete() {

		this.delete_id = (String) this.sessionMap.get("delete_id");

		if (delete_id.isEmpty()) {
			return "yasaiSearch";
		}
		YasaiManager yasaimanager = new YasaiManager();
		yasaimanager.delete(this.delete_id);

		return "yasaiSearch";

	}

}
