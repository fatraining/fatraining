package controller;

import java.util.ArrayList;
import java.util.List;

import model.User_Profile;
import model.User_Character;
import model.Result5Table;

import org.hibernate.classic.Session;

public class User_ProfileManager extends HibernateUtil {

	public  List<?> resultTable;
	public  ArrayList<Result5Table> outputTable;

	public ArrayList<Result5Table> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//2つのテーブルの選択
		String select = "SELECT * FROM User_Character i,User_Profile d";
		//i(id)のカラム名とd(personality2)のカラム名を一致させる
		String where1 = "WHERE i.id = d.personality2";
		//sql文で2つのテーブルを結合させる
		String sql    = select + " " + where1;

		try {
			//resultテーブルにsql文を代入
			resultTable = session.createSQLQuery(sql)
					.addEntity("user_character", User_Character.class)
					.addEntity("user_profile", User_Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		//this.outputTable = tableTrans(resultTable);

		return outputTable;
	}
	public ArrayList<Result5Table> tableTrans(List<?> resultTable){
		ArrayList<Result5Table> tempTable = new ArrayList<Result5Table>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				Result5Table temp = new Result5Table();
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
//				temp.setDelete(user_profile.getDelete());
//				temp.setFlg(user_profile.getFlg());
				
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}

