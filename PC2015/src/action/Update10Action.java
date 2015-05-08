package action;

//import java.io.UnsupportedEncodingException;

import model.DetailEat;
import model.IDofEat; //モデルのインポート

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import java.text.SimpleDateFormat;
import java.util.*;

import controller.HibernateUtil;
import controller.All10Manager;

@Result(name = "main10", value = "main10.action", type = ServletRedirectResult.class)
public class Update10Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String eatFood; // 食べ物名
	public String eatCalory; // カロリー
	public String eat_year; // 年
	public String eat_month; // 月
	public String eat_day; // 日
	public String eat_hour; // 時間
	public String delete_id; // 削除に使うレコードのID

	// 画面表示時に実行
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド、追加の処理 データベースに値を入れる
	public String insert() {

		// 登録、更新UAER表示
		String entry_userid = (String) this.sessionMap.get("userId");
		String renew_userid = (String) this.sessionMap.get("userId");// セッションマップからuserIDを取得

		// インスタンス化、id_tableにレコードを挿入する
		IDofEat insert_id_table = new IDofEat();
		
		insert_id_table.setEntry_userid(entry_userid);
		insert_id_table.setRenew_userid(renew_userid);

		All10Manager insert = new All10Manager();
		
		//insertメソッドを参照
		insert.insert(this.eat_year,this.eat_month,this.eat_day, this.eat_hour,this.eatFood,this.eatCalory,entry_userid,renew_userid);

		return "main10";
	}

	// 検索結果内の値の削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");// セッションマップからdelete_idを取得

		// 複数選択の削除のために文字列の分割
		String str = new String(this.delete_id);
		String[] strAry = str.split(",");

		// delete_idが空である場合
		if (this.delete_id.isEmpty()) {
			return "main10"; // Main10Actionへ
		}

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			// データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			// トランザクションの開始
			session.beginTransaction();
			try {
				DetailEat detaileat = (DetailEat) session.load(DetailEat.class,
						strAry[i]);
				IDofEat idofeat = (IDofEat) session.load(IDofEat.class,
						detaileat.getFood_id());

				// DetailEat detaileat = (DetailEat)
				// session.load(DetailEat.class,
				// Integer.valueOf(delete_id));
				// IDofEat idofeat = (IDofEat) session.load(IDofEat.class,
				// Integer.valueOf(detaileat.getFood_id())); //
				// TODO(delete_idがStringでは処理できないのでキャストする)

				session.delete(detaileat); // detail_tableの指定した行を削除する
				session.delete(idofeat); // id_tableの指定した行を削除する

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			// トランザクションの終了
			session.getTransaction().commit();
		}
		return "main10"; // Main10Actionへ
	}

}