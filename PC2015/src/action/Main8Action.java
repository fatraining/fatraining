package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Result8Table;
import model.Ryouri;
import model.Yasai;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.YasaiManager;

@Result(name = "addyasai", value = "addyasai.action", type = ServletRedirectResult.class)
public class Main8Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// デフォルト値表示のためと、resultListの引数に使用するため
	public String yasai;
	public String userId;
	// 削除ボタンを表示させるための変数
	public String delete;
	// 検索結果を表示させるための変数
	public String do_print;
	//
	public String update_id;

	public ArrayList<Result8Table> outputTable;
	private List<?> resultTable;

	// yasai=野菜をデフォルトで表示させるメソッド
	private String getDefaultYasai() {
		this.yasai = "野菜";
		return this.yasai;
	}

	@Override
	public String execute() {
		// userIdを表示させるため、sessionMapから取得している
		this.userId = (String) this.sessionMap.get("userId");
		this.yasai = getDefaultYasai();

		// 最初の検索画面では削除ボタンは出さないので、"faluse"
		this.delete = "faluse";
		return "success";
	}

	// リセット時のメソッド
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId");
		// リセットしたときに"野菜"を表示させたいため、getDefaultYasaiをyasaiに代入
		this.yasai = getDefaultYasai();

		return "success";
	}

	// 検索時のメソッド
	public String search() {
		YasaiManager yasaimanager = new YasaiManager();
		this.userId = (String) this.sessionMap.get("userId");
		// 検索結果を出したいので、このメソッドを呼び出したときに"true"を代入
		this.do_print = "true";
		if (this.yasai.isEmpty()) {
			try {
				// yasaiが空だったら、yasaimanagerのresultList()を呼び出す
				resultTable = yasaimanager.resultList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// yasaiが空でなかったら、yasaimanagerのresultList(yasai)を呼び出す
			resultTable = yasaimanager.resultList(yasai);
		}
		// resultTableを引数にtableTranseメソッドを呼び出し、outputTableに代入
		this.outputTable = tableTrans(resultTable);
		// 削除ボタンを出したいので、"true"を代入
		this.delete = "true";
		return "success";
	}

	// TODO
	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			// 指定したURL先に飛ばしている
			this.response.sendRedirect("/PC2015/addyasai.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	// AddyasaiAction移行するためのメソッド
	public String gotoaddyasai() {
		return "addyasai";
	}

	public ArrayList<Result8Table> tableTrans(List<?> resultTable) {
		ArrayList<Result8Table> tempTable = new ArrayList<Result8Table>();

		// objectの配列を宣言
		Object[] obj;
		try {
			// resultTableのサイズ分まわす
			for (int i = 0; i < resultTable.size(); i++) {
				// Result8Tableをインスタンス化
				Result8Table temp = new Result8Table();

				// resultTableのインデックスを全て取得して、objectに代入
				// リスト型を配列に変換（キャスト）
				obj = (Object[]) resultTable.get(i);
				//
				Yasai yasai = (Yasai) obj[0];
				Ryouri ryouri = (Ryouri) obj[1];

				temp.setId(yasai.getId());
				temp.setYasai(yasai.getYasai());
				temp.setTyouriId(yasai.getTyouriId());
				temp.setDate_Entry(yasai.getDate_Entry());
				temp.setDate_Up(yasai.getDate_Up());
				temp.setUserId(yasai.getUserId());
				temp.setDate_Up(yasai.getUserId_Up());
				temp.setControl(yasai.getControl());
				temp.setDeleteFlg(yasai.getDeleteFlg());

				// （料理ID）int型をString型に変換
				temp.setId(String.valueOf(ryouri.getId()));

				temp.setTyouri(ryouri.getTyouri());
				temp.setRyouri(ryouri.getRyouri());
				temp.setDate_Entry(ryouri.getDate_Entry());
				temp.setDate_Up(ryouri.getDate_Up());
				temp.setUserId(ryouri.getUserId());
				temp.setDate_Up(ryouri.getUserId_Up());
				temp.setControl(ryouri.getControl());
				temp.setDeleteFlg(ryouri.getDeleteFlg());

				//tempTableにtempを加える
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
