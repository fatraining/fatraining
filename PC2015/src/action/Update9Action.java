package action;

import java.text.SimpleDateFormat;
import java.util.*;

import model.CoofTa;
import model.LiofTa;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.LiofTaManager;

@Result(name = "main9", value = "main9.action", type = ServletRedirectResult.class)
public class Update9Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	// 名前
	public String name;
	// 食べ物
	public String food;
	// 飲み物
	public String drink;
	// 色
	public String color;

	// 変数
	public String delete_id;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド（挿入）
	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		// 日付
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String day = String.valueOf(sdf.format(date));
		String new_day = String.valueOf(sdf.format(date));

		// USERid
		String userid = (String) this.sessionMap.get("userId");
		String new_userid = (String) this.sessionMap.get("userId");
		
		CoofTa insert_color_table = new CoofTa();
		
		insert_color_table.setColor(this.color);
		insert_color_table.setDay(day);
		insert_color_table.setNew_day(new_day);
		insert_color_table.setUserid(userid);
		insert_color_table.setNew_userid(new_userid);
		
		try {
			session.save(insert_color_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		LiofTaManager lioftamanager = new LiofTaManager();
		insert_color_table = lioftamanager.cooftaList();

		LiofTa insert_like_table = new LiofTa();
		
		insert_like_table.setName(this.name);
		insert_like_table.setFood(this.food);
		insert_like_table.setDrink(this.drink);
		insert_like_table.setColorNm(insert_color_table.getId());
		insert_like_table.setDay(day);
		insert_like_table.setNew_day(new_day);
		insert_like_table.setUserid(userid);
		insert_like_table.setNew_userid(new_userid);

		try {
			session.save(insert_like_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();

		return "main9";	
	}

	// deleteメソッド（消去）
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		String str = new String(this.delete_id);
		String[] strAry = str.split(",");

		if (this.delete_id.isEmpty()) {
			return "main9";
		}

		for (int i = 0; i < strAry.length; i++) {

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			session.beginTransaction();
			try {
				CoofTa coofta = (CoofTa) session.load(CoofTa.class, strAry[i]);
				LiofTa liofta = (LiofTa) session.load(LiofTa.class, strAry[i]);
				session.delete(coofta);
				session.delete(liofta);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback(); // 障害が起こった時その前の状態まで戻る
			}
			session.getTransaction().commit(); // 処理が成功したときに結果を確立させる
		}
		return "main9";
	}
}
