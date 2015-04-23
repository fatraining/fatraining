package controller;

import java.util.ArrayList;
import java.util.List;

import model.User_Profile;
import model.User_Character;
import model.ResultTable;

import org.hibernate.classic.Session;

public class User_ProfileManager extends HibernateUtil {

	public  List<?> resultTable;
	public  ArrayList<ResultTable> outputTable;

	public ArrayList<ResultTable> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT *  FROM User_Character i,User_Profile d";
		String where1 = "WHERE i.id = d.personality2";
		String sql    = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("user_character", User_Character.class)
					.addEntity("user_profile", User_Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		this.outputTable = tableTrans(resultTable);

		return outputTable;
	}
	public ArrayList<ResultTable> tableTrans(List<?> resultTable){
		ArrayList<ResultTable> tempTable = new ArrayList<ResultTable>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				ResultTable temp = new ResultTable();
				obj = (Object[]) resultTable.get(i);
				User_Character user_character =  (User_Character)obj[0];
				User_Profile user_profile     = (User_Profile)obj[1];
				
				
				temp.setInterest(user_character.getInterest());
				temp.setId(user_profile.getId());
				temp.setPhonenumber(user_profile.getPhonenumber());
				temp.setZipcode(user_profile.getZipcode());
				temp.setDwelling(user_profile.getDwelling());
				temp.setName(user_profile.getName());
				temp.setPersonality(user_character.getPersonality());
				temp.setDay(user_profile.getDay());
				temp.setNewday(user_profile.getNewday());
				temp.setUserid(user_profile.getUserid());
				temp.setNewuserid(user_profile.getNewuserid());
				temp.setDelete(user_profile.getDelete());
				temp.setFlg(user_profile.getFlg());
				
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}