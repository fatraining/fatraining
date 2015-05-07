package action;

//import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.LikeGame;
import model.LikeSeries;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

@Result(name = "main6", value = "main6.action", type = ServletRedirectResult.class)
public class Update6Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	// カラムの呼び出し
	// 表示項目
	public String delete_id; // 削除画面
	// 入力項目
	public String id; // ID
	public String series; // シリーズ名
	public String se; // シリーズID
	public String title; // タイトル
	public String u; // 登録日
	public String upDay; // 更新日
	public String userId; // ユーザー名
	public String upUser; // ユーザーID
	public String nonStyle; // 切り札
	public String del; // 起源

	// executeメソッド
	// 画面が表示時に実行
	public String execute() throws Exception {
		// 削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");

		return "success";
	}

	// insertメソッド
	// 追加画面
	// 日付
	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();// dbの接続
		session.beginTransaction();
		// 登録日の表示
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		u = String.valueOf(sdf.format(date));
		upDay = String.valueOf(sdf.format(date));

		LikeGame insert_game_table = new LikeGame();
		LikeSeries insert_series_table = new LikeSeries();

		insert_game_table.setId(this.id);
		insert_game_table.setTitle(this.title);
		insert_game_table.setSeries(this.series);
		insert_series_table.setSe(this.se);
		insert_series_table.setU(this.u);
		insert_game_table.setUpDay(this.upDay);
		insert_game_table.setUserId(this.userId);
		insert_game_table.setUpUser(this.upUser);
		insert_game_table.setNonStyle(this.nonStyle);
		insert_game_table.setDel(this.del);

		try {
			session.save(insert_series_table);
			session.save(insert_game_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return "main6";

	}

	// 削除動作
	// 検索結果の内容を削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		String str = new String(this.delete_id);
		String[] strAry = str.split(",");

		if (this.delete_id.isEmpty()) {
			return "main6";
		}

		for (int i = 0; i < strAry.length; i++) {
			// データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			// トランザクション開始
			session.beginTransaction();

			try {
				LikeGame likegame = (LikeGame) session.load(LikeGame.class,
						strAry[i]);
				LikeSeries likeseries = (LikeSeries) session.load(
						LikeSeries.class, strAry[i]);
				session.delete(likegame);// 指定したIDを削除する
				session.delete(likeseries);// 指定したIDを削除する
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			// トランザクションの終了
			session.getTransaction().commit();

		}
		return "main6";
	}
}