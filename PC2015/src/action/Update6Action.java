package action;

import java.io.UnsupportedEncodingException;

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
	public String update_id;
	public int id;
	public int series;
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

	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		LikeGame insert_game_table = new LikeGame();
		LikeSeries insert_series_table = new LikeSeries();
		insert_game_table.setId(this.id);
		insert_game_table.setTitle(this.title);
		insert_game_table.setSeries(this.series);
		insert_series_table.setU(this.u);
		insert_game_table.setUpDay(this.upDay);
		insert_game_table.setUserId(this.userId);
		insert_game_table.setUpUser(this.upUser);
		insert_game_table.setNonStyle(this.nonStyle);
		insert_game_table.setDel(this.del);
		String[] data = {this.title, this.u, this.upDay,
				this.userId, this.upUser, this.nonStyle, this.del,
				 };
		int i = 0;

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
	
	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "main6";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
			LikeGame likegame = (LikeGame) session.load(LikeGame.class,
					update_id);
			LikeSeries likeseries = (LikeSeries) session.load(LikeSeries.class,
					update_id);
			session.delete(likegame);
			session.delete(likeseries);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main6";
	}
		
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