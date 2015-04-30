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
	public String update_id;
	public String id;
	public String series;
	public String se;
	public String title;
	public String u;
	public String upDay;
	public String userId;
	public String upUser;
	public String nonStyle;
	public String del;
	
	public String errormsg;

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");

		return "success";
	}

	//追加画面
	//追加入力
	public String insert() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		u = String.valueOf(sdf.format(date));
		upDay = String.valueOf(sdf.format(date));
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//dbの接続
		session.beginTransaction();

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
//		String[] data = {this.id, this.title, this.series, this.u, this.upDay,
//				this.userId, this.upUser, this.nonStyle, this.del,
//				 };
//		int i = 0;

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
	
	//削除動作
	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		
		String str = new String(this.update_id);
		String[] strAry = str.split(",");
		
		if (this.update_id.isEmpty()) {
			return "main6";
		}
		for(int i = 0; i < strAry.length; i++){
			//データベースに接続
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			//トランザクション
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
		session.getTransaction().commit();
		return "main6";
	}
		return str;

		
//	private static boolean checkCharacterCode(String str, String encoding) {
//		if (str == null) {
//			return true;
//		}
//
//		try {
//			byte[] bytes = str.getBytes(encoding);
//			return str.equals(new String(bytes, encoding));
//		} catch (UnsupportedEncodingException ex) {
//			throw new RuntimeException("エンコード名称が正しくありません。", ex);
//		}
//	}
  }
}