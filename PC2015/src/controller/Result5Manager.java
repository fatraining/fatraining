package controller;

import java.util.ArrayList;
import java.util.List;

import model.User_Profile;
import model.User_Character;
import model.Result5Table;

import org.hibernate.classic.Session;

public class Result5Manager extends HibernateUtil {

	public List<?> resultTable;
	public ArrayList<Result5Table> outputTable;

	public ArrayList<Result5Table> resultList(String dwelling, String name) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (dwelling.isEmpty())
				dwelling = "%";
			if (name.isEmpty())
				name = "%";

			String select = "SELECT * FROM user_character i, user_profile d";
			String where1 = "WHERE i.id = d.personality2";
			String where2 = "AND (d.dwelling LIKE '" + dwelling
					+ "' AND d.name LIKE '" + name + "')";
			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql)
					.addEntity("User_Character", User_Character.class)
					.addEntity("User_Profile", User_Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(resultTable);
		return outputTable;
	}

	public ArrayList<Result5Table> tableTrans(List<?> resultTable) {
		ArrayList<Result5Table> tempTable = new ArrayList<Result5Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result5Table temp = new Result5Table();
				obj = (Object[]) resultTable.get(i);

				User_Character user_caharacter = (User_Character) obj[0];
				User_Profile user_profile = (User_Profile) obj[1];
				temp.setId(user_profile.getId());
				temp.setPhonenumber(user_profile.getPhonenumber());
				temp.setZipcode(user_profile.getZipcode());
				temp.setDwelling(user_profile.getDwelling());
				temp.setName(user_profile.getName());
				temp.setDay(user_profile.getDay());
				temp.setNewday(user_profile.getNewday());
				temp.setUserid(user_profile.getUserid());
				temp.setNewuserid(user_profile.getNewuserid());

//				temp.setDelete(user_profile.getDelete());
//				temp.setFlg(user_profile.getFlg());

				temp.setPersonality(user_caharacter.getPersonality());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempTable;
	}
}