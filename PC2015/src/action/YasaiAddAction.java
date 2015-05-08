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

	/****************** TODO *********************/

	// 追加ボタン押下時
	public String insert() {

		// 入力チェック
		// 野菜、料理、調理の欄のいずれかが空だとエラーメッセージを返す
		if (this.yasai.isEmpty() || this.ryouri.isEmpty()
				|| this.tyouri.isEmpty()) {
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

	/****************** TODO *****************/

}

// public ArrayList<ResultTable> tableTrans(List<?> resultTable) {
// ArrayList<ResultTable> tempTable = new ArrayList<ResultTable>();
//
// Object[] obj;
// try {
// for (int i = 0; i < resultTable.size(); i++) {
// ResultTable temp = new ResultTable();
//
// obj = (Object[]) resultTable.get(i);
// Yasai yasai = (Yasai) obj[0];
// Ryouri ryouri = (Ryouri) obj[1];
//
// temp.setId(yasai.getId());
// temp.setYasai(yasai.getYasai());
// temp.setTyouriId(yasai.getTyouriId());
// temp.setDate(yasai.getDate());
// temp.setDate_up(yasai.getDate_up());
// temp.setUserId(yasai.getUserId());
// temp.setUserId_up(yasai.getUserId_up());
// temp.setControl(yasai.getControl());
// temp.setDelete(yasai.getDelete());
//
// temp.setId(ryouri.getId());
// temp.setTyouri(ryouri.getTyouri());
// temp.setRyouri(ryouri.getRyouri());
// temp.setDate(ryouri.getDate());
// temp.setDate_up(ryouri.getDate_up());
// temp.setUserId(ryouri.getUserId());
// temp.setUserId_up(ryouri.getUserId_up());
// temp.setControl(ryouri.getControl());
// temp.setDelete(ryouri.getDelete());
//
// tempTable.add(temp);
// }
// } catch (Exception e) {
// e.printStackTrace();
//
// }
//
// return tempTable;
// }

