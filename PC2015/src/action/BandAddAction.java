package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.BandAllManager;

@Result(name = "bandsearch", value = "bandSearch.action", type = ServletRedirectResult.class)
public class BandAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String delete_id; // 削除に関する変数
	public String name; // 名前
	public String sex; // 性別
	public String age; // 年齢
	public String school; // 出身校
	public String favorite_song; // 好きな曲
	public String part; // 演奏楽器
	public String band_name; // バンド名
	public String errorMsg; // エラーフラグ

	// executeメソッド。
	public String execute() throws Exception {

		// delete_idの値を受け取っている。
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// 初期値の設定
		this.band_name = "砂糖と塩";
		this.name = "佐藤敏夫";
		this.sex = "男";
		this.age = "20";
		this.school = "銀座大学";
		this.favorite_song = "二月の兵隊";
		this.part = "ギター";

		return "success";
	}

	// insertメソッド。データベースに値を入れる。
	public String insert() {

		// 登録useridにuserIdの値を入れる。
		String entry_userid = (String) this.sessionMap.get("userId");
		// 更新useridにuserIdの値を入れる。
		String renewal_userid = (String) this.sessionMap.get("userId");

		// 全ての入力項目が入力されていなかったとき、エラーメッセージを表示
		if (this.band_name.isEmpty() || this.name.isEmpty()
				|| this.sex.isEmpty() || this.age.isEmpty()
				|| this.school.isEmpty() || this.favorite_song.isEmpty()
				|| this.part.isEmpty()) {

			this.errorMsg = "true"; // エラーメッセージを表示させるためにtrueを代入

			return "success";

		}

		// BandAllManagerのインスタンス生成
		BandAllManager insert = new BandAllManager();

		// BandAllManagerのinsertメソッドを参照
		insert.insert(this.band_name, this.name, this.sex, this.age,
				this.school, this.favorite_song, this.part, entry_userid,
				renewal_userid);

		return "bandsearch";

	}

	// deleteメソッド。削除するときの処理
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// BandAllManagerのインスタンス生成
		BandAllManager delete = new BandAllManager();

		// BandAllManagerのdeleteメソッドを参照
		delete.delete(delete_id);

		return "bandsearch";

	}

}
