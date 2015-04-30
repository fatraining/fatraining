package controller;

import java.util.ArrayList;
import java.util.List;

import model.My_hobby;
import model.Profile;
import model.Result1Table;

import org.hibernate.classic.Session;

public class ProfileManager extends HibernateUtil {

	public List<?> resultTable;
	public ArrayList<Result1Table> outputTable;

	public ArrayList<Result1Table> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM table_profile i, table_hobby d";
		String where1 = "WHERE i.id = d.id";
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

		this.outputTable = tableTrans(resultTable);

		return outputTable;
	}
	public ArrayList<Result1Table> resultList(String name, String home,
			String hobby) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (name.isEmpty())
				name = "%";
			if (home.isEmpty())
				home = "%";
			if (hobby.isEmpty())
				hobby = "%";

			String select = "SELECT * FROM table_profile i, table_hobby d";
			String where1 = "WHERE i.id = d.id";
			String where2 = "AND (i.name LIKE '" + name + "' AND i.home LIKE '"
					+ home + "' AND i.id LIKE '" + hobby + "')";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("My_hobby", My_hobby.class)
					.addEntity("Profile", Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(resultTable);
		return outputTable;
	}

	public ArrayList<Result1Table> tableTrans(List<?> resultTable) {
		ArrayList<Result1Table> tempTable = new ArrayList<Result1Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result1Table temp = new Result1Table();
				obj = (Object[]) resultTable.get(i);
				My_hobby my_hobby = (My_hobby) obj[0];
				Profile profile = (Profile) obj[1];
				temp.setId(profile.getId());
				temp.setName(profile.getName());
				temp.setPersonality(profile.getPersonality());
				temp.setHome(profile.getHome());
				temp.setBirthday(profile.getBirthday());
				temp.setDay(profile.getDay());
				temp.setNew_day(profile.getNew_day());
				temp.setUserid(profile.getUserid());
				temp.setNew_userid(profile.getNew_userid());
//				temp.setTime_stamp(profile.getTime_stamp());
//				temp.setDelete(profile.getDelete());
				temp.setHobby(my_hobby.getHobby());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}