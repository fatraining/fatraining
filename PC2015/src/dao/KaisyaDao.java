package dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Busyo;
import model.Kaisya;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class KaisyaDao extends HibernateUtil {

	public List<?> resultList() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// 検索結果の全表示
		String select = "SELECT * FROM table_kaisya i, table_busyo d";
		String where1 = "WHERE i.busyo_id = d.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_busyo", Busyo.class)
					.addEntity("table_kaisya", Kaisya.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}

	public List<?> resultList(String syamei, String name, String busyo) {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// 検索をかける場合
		try {
			if (syamei.isEmpty()) {
				syamei = "%";
			}
			if (name.isEmpty()) {
				name = "%";
			}
			if (busyo.isEmpty()) {
				busyo = "%";
			}
			String select = "SELECT * FROM table_kaisya i, table_busyo d";
			String where1 = "WHERE i.busyo_id = d.id";
			String where2 = "AND (i.syamei LIKE '%" + syamei
					+ "%' AND i.name LIKE '%" + name + "%' AND d.busyo LIKE '%"
					+ busyo + "%')";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("Busyo", Busyo.class)
					.addEntity("Kaisya", Kaisya.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	public Busyo busyoList() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// table_busyoのリストをすべて表示
		try {
			String sql = "SELECT * FROM table_busyo d";
			resultTable = session.createSQLQuery(sql)
					.addEntity("Busyo", Busyo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// 　busyo_tableで生成したIDを取得(昇順)
		return (Busyo) resultTable.get(resultTable.size() - 1);
	}

	// insertメソッドに引数として値を渡す
	public void insert(String syamei, String name, String nyusyabi, String busyo,
			String comment, String userId, String userId_up) {
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 登録、更新日時表示
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String day_entry = String.valueOf(sdf.format(date));
		String day_up = String.valueOf(sdf.format(date));

		Busyo insert_busyo_table = new Busyo();
		// table_busyoにインサート
		insert_busyo_table.setBusyo(busyo);
		insert_busyo_table.setDay_entry(day_entry);
		insert_busyo_table.setDay_up(day_up);
		insert_busyo_table.setUserId(userId);
		insert_busyo_table.setUserId_up(userId_up);
		insert_busyo_table.setControl(0);
		insert_busyo_table.setDeleteflg(0);

		try {
			session.save(insert_busyo_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		KaisyaDao kaisyamanager = new KaisyaDao();
		insert_busyo_table = kaisyamanager.busyoList();

		Kaisya insert_kaisya_table = new Kaisya();
		// busyo_tableで生成したIDを取得しBusyo_idにセットする
		insert_kaisya_table.setBusyo_id(insert_busyo_table.getId());
		// table_kaisyaにインサート
		insert_kaisya_table.setSyamei(syamei);
		insert_kaisya_table.setName(name);
		insert_kaisya_table.setNyusyabi(nyusyabi);
		insert_kaisya_table.setComment(comment);
		insert_kaisya_table.setDay_entry(day_entry);
		insert_kaisya_table.setDay_up(day_up);
		insert_kaisya_table.setUserId(userId);
		insert_kaisya_table.setUserId_up(userId_up);
		insert_kaisya_table.setControl(0);
		insert_kaisya_table.setDeleteflg(0);

		try {
			session.save(insert_kaisya_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	// deleteメソッドに引数として値を渡す
	public void delete(String delete_id) {

		if (delete_id.isEmpty()) {
		}
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 分割
		String[] strAry = delete_id.split(",");
		for (int i = 0; i < strAry.length; i++) {
			try {
				Kaisya kaisya = (Kaisya) session.load(Kaisya.class, strAry[i]);
				Busyo busyo = (Busyo) session.load(Busyo.class,
						kaisya.getBusyo_id());
				session.delete(busyo);
				session.delete(kaisya);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}
}