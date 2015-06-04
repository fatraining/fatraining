package dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import model.My_hobby;
import model.Profile;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class ProfileDao extends HibernateUtil {

	public List<?> resultList() {
		List<?> resultTable = null;
		//　DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//　検索結果の全表示
		String select = "SELECT * FROM table_profile i, table_hobby d";
		String where1 = "WHERE i.hobby_id = d.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_hobby", My_hobby.class)
					.addEntity("table_profile", Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}

	public List<?> resultList(String name, String home, String hobby) {
		List<?> resultTable = null;
		//　DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//　検索をかける場合
		try {
			if (name.isEmpty()) {
				name = "%";
			}
			if (home.isEmpty()) {
				home = "%";
			}
			if (hobby.isEmpty()) {
				hobby = "%";
			}
			String select = "SELECT * FROM table_profile i, table_hobby d";
			String where1 = "WHERE i.hobby_id = d.id";
			String where2 = "AND (i.name LIKE '" + name + "' AND i.home LIKE '"
					+ home + "' AND d.hobby LIKE '" + hobby + "')";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("My_hobby", My_hobby.class)
					.addEntity("Profile", Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	public My_hobby my_hobbyList() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//　table_hobbyのリストをすべて表示
		try {
			String sql = "SELECT * FROM table_hobby d";
			resultTable = session.createSQLQuery(sql)
					.addEntity("My_hobby", My_hobby.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//　my_hobby_tableで生成したIDを取得(昇順)
		return (My_hobby) resultTable.get(resultTable.size() - 1);
	}
	//　insertメソッドに引数として値を渡す
	public void insert(String hobby, String name, String personality,
			String home, int birthday, String userid, String new_userid) {
		//　DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 登録、更新日時表示
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String day = String.valueOf(sdf.format(date));
		String new_day = String.valueOf(sdf.format(date));

		My_hobby insert_my_hobby_table = new My_hobby();
		// table_myhobbyにインサート
		insert_my_hobby_table.setHobby(hobby);
		insert_my_hobby_table.setDay(day);
		insert_my_hobby_table.setNew_day(new_day);
		insert_my_hobby_table.setUserid(userid);
		insert_my_hobby_table.setNew_userid(new_userid);
		insert_my_hobby_table.setDbflg(0);
		insert_my_hobby_table.setDeleteflg(0);

		try {
			session.save(insert_my_hobby_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		ProfileDao profilemanager = new ProfileDao();
		insert_my_hobby_table = profilemanager.my_hobbyList();
		
		Profile insert_profile_table = new Profile();
		// my_hobby_tableで生成したIDを取得しHobby_idにセットする
		insert_profile_table.setHobby_id(insert_my_hobby_table.getId());
		// table_profileにインサート
		insert_profile_table.setName(name);
		insert_profile_table.setPersonality(personality);
		insert_profile_table.setHome(home);
		insert_profile_table.setBirthday(birthday);
		insert_profile_table.setDay(day);
		insert_profile_table.setNew_day(new_day);
		insert_profile_table.setUserid(userid);
		insert_profile_table.setNew_userid(new_userid);
		insert_profile_table.setDbflg(0);
		insert_profile_table.setDeleteflg(0);

		try {
			session.save(insert_profile_table);

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
		//　DB接続
		Session session = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		
		// 分割
		String[] strAry = delete_id.split(",");
		for (int i = 0; i < strAry.length; i++) {
			try {
				Profile profile = (Profile) session.load(Profile.class,
						strAry[i]);
				My_hobby my_hobby = (My_hobby) session.load(My_hobby.class,
						profile.getHobby_id());
				session.delete(my_hobby);
				session.delete(profile);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}
}