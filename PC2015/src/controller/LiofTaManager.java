package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.LiofTa;
import model.CoofTa;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class LiofTaManager extends HibernateUtil {

	public List<?> resultList() {
		List<?> resultTable = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM table_like d,table_color i";
		String where1 = "WHERE d.color = i.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_color", LiofTa.class)
					.addEntity("table_like", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}

	public List<?> resultList(String name, String food, String drink) {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (name.isEmpty()) {
				name = "%";
			}
			if (food.isEmpty()) {
				food = "%";
			}
			if (drink.isEmpty()) {
				drink = "%";
			}

			String select = "SELECT * FROM table_like d, table_color i";
			String where1 = "WHERE d.color = i.id";
			String where2 = "AND (d.name LIKE '" + name + "' AND d.food LIKE '"
					+ food + "' AND d.drink LIKE '" + drink + "')";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("CoofTa", LiofTa.class)
					.addEntity("LiofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	public CoofTa cooftaList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			String sql = "SELECT * FROM table_color i ORDER BY id";
			resultTable = session.createSQLQuery(sql)
					.addEntity("CoofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return (CoofTa) resultTable.get(resultTable.size() - 1);
	}

	public String insert(String name, String food, String drink, String color,
			String colorNm, String userid, String new_userid) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		CoofTa insert_color_table = new CoofTa();
		insert_color_table.setColorNm(colorNm);
		insert_color_table.setDay(String.valueOf(sdf.format(date)));
		insert_color_table.setNew_day(String.valueOf(sdf.format(date)));
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
		insert_like_table.setColor(insert_color_table.getId());
		insert_like_table.setName(name);
		insert_like_table.setFood(food);
		insert_like_table.setDrink(drink);
		insert_like_table.setDay(String.valueOf(sdf.format(date)));
		insert_like_table.setNew_day(String.valueOf(sdf.format(date)));
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

	public String delete(String delete_id) {

		if (delete_id.isEmpty()) {
			return "main9";
		}
		String[] strAry = delete_id.split(",");

		for (int i = 0; i < strAry.length; i++) {

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			session.beginTransaction();
			try {
				LiofTa liofta = (LiofTa) session.load(LiofTa.class, strAry[i]);
				CoofTa coofta = (CoofTa) session.load(CoofTa.class,
						liofta.getColor());
				session.delete(coofta);
				session.delete(liofta);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
		}
		return "main9";
	}
}