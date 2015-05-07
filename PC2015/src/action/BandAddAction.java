package action;

import java.util.*;
import java.text.SimpleDateFormat;

import model.BandAccount;
import model.BandTable;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.BandAllManager;

@Result(name = "bandsearch", value = "bandSearch.action", type = ServletRedirectResult.class)
public class BandAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String delete_id; // update_idからdelete_idに変更
	public String name; // 名前に関する変数nameを宣言
	public String sex; // 性別に関する変数sexを宣言
	public String age; // 年齢に関する変数ageを宣言
	public String school; // 出身校に関する変数schoolを宣言
	public String favorite_song; // 好きな曲に関する変数favorite_songを宣言
	public String part; // 演奏楽器に関する変数partを宣言
	// public int exclusion_flg; //更新FLGに関する変数exclusion_flgを宣言
	// public int delete_flg; //削除FLGに関する変数delete_flgを宣言
	public String band_name; // バンド名に関する変数band_nameを宣言

	// public String entry_userid;
	// public String renewal_userid;
	// public String entry_date;
	// public String renewal_date;

	// executeメソッド。update_idの値を受け取っている。
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド。データベースに値を入れる。
	public String insert() {

		// 登録useridにuserIdの値を入れる。
		String entry_userid = (String) this.sessionMap.get("userId");
		// 更新useridにuserIdの値を入れる。
		String renewal_userid = (String) this.sessionMap.get("userId");

		//BandAllManagerのインスタンス生成
		BandAllManager insert = new BandAllManager();

		//BandAllManagerのinsertメソッドを参照
		insert.insert(this.band_name, this.name, this.sex, this.age,
				this.school, this.favorite_song, this.part, entry_userid,
				renewal_userid);

		return "bandsearch";

	}

	/********************** 複数選択の削除の処理ここから **************************************/

	// deleteメソッド。削除するときの処理
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// 複数選択の削除のために文字列の分割
		String str = new String(this.delete_id);
		String[] strAry = str.split(",");

		if (this.delete_id.isEmpty()) {
			return "bandsearch";
		}
		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {
			// データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			// トランザクションを開始
			session.beginTransaction();
			try {
				BandAccount bandaccount = (BandAccount) session.load(
						BandAccount.class, strAry[i]);
				BandTable bandtable = (BandTable) session.load(BandTable.class,
						bandaccount.getBand_id());
				session.delete(bandaccount); // band_accountテーブルの選択された行を削除
				session.delete(bandtable); // band_tableテーブルの選択された行を削除
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();//
		}
		return "bandsearch";

	}

	/************************** 複数選択の削除の処理ここまで *******************************/

}
