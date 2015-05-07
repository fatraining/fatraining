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
	//カラムの呼び出し
	//表示項目
	public String delete_id; //削除画面
	public String id; //ID
	public String u; //登録日
	public String upDay; //更新日
	//入力項目
	public String series; //シリーズ名
	public String se; //シリーズID
	public String title; //タイトル
	public String userId; //ユーザー名
	public String upUser; //ユーザーID
	public String nonStyle; //切り札
	public String del; //起源
	
    //画面が表示時に実行
	public String execute() throws Exception {
		//削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");

		return "success";
	}

	//追加画面
	//追加入力
    //　日付の表示
	public String insert() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		u = String.valueOf(sdf.format(date));
		upDay = String.valueOf(sdf.format(date));
		
		//dbの接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();
		
		// サーバーのテーブルに値をインサート
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
        //トランザクションの終了
		session.getTransaction().commit();
		return "main6";

	}
	
	//削除動作
	public String delete() {
		//delete_idを取得
		this.delete_id = (String) this.sessionMap.get("delete_id");
		
		String str = new String(this.delete_id);
		String[] strAry = str.split(",");
		
		// delete_idが空である場合
		if (this.delete_id.isEmpty()) {
			return "main6";
		}
		for(int i = 0; i < strAry.length; i++){
			//データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			//トランザクション開始
			session.beginTransaction();
			
		try {
			LikeGame likegame = (LikeGame) session.load(LikeGame.class, strAry[i]);
			LikeSeries likeseries = (LikeSeries) session.load(LikeSeries.class, strAry[i]);
			session.delete(likegame);
			session.delete(likeseries);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクションの終了
		session.getTransaction().commit();
	}
	return "main6";
   }
}