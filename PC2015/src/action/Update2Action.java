package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import controller.SweetsManager;

@Result(name = "main2", value = "main2.action", type = ServletRedirectResult.class)
public class Update2Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 入力項目（追加画面）
	public String name; // お菓子の名前:
	public String genreNm; // ジャンル:

	// 表示項目（削除画面）
	public String delete_id;

	// 画面が表示時に実行
	@Override
	public String execute() {
		// 削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// 初期値の設定
		this.name = "クッキー";
		this.genreNm = "焼き菓子";

		return "success";
	}

	// 追加ボタンを押下時
	public String insert() {

		SweetsManager SweetsManager = new SweetsManager();
		SweetsManager.insert(name, genreNm,
				(String) this.sessionMap.get("userId"));

		return "main2";
	}

	// 削除ボタンを押下時
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		if (this.delete_id.isEmpty()) {
			return "main2";
		}

		SweetsManager SweetsManager = new SweetsManager();
		SweetsManager.delete(this.delete_id);
		;

		return "main2";
	}

}
