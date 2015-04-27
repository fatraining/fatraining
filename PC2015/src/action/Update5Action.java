package action;

import java.text.SimpleDateFormat;
import java.util.*;

import model.Profile;
import model.User_Character;
import model.User_Profile;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

@Result(name = "main5", value = "main5.action", type = ServletRedirectResult.class)
public class Update5Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	public String update_id;
	public String errormsg;
	public int id;
	public int phonenumber;
	public int zipcode;
	public String dwelling;
	public String name;
	public String personality;
	public String day;
	public String newday;
	public String userid;
	public String newuserid;
	public String interest;

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");
		return "success";
	}

	public String insert() {
		// 登録日付、登録更新の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy/mm/dd k:m:s");
		day = String.valueOf(sdf.format(date));
		newday = String.valueOf(sdf.format(date));

		// 登録ID、更新ID表示
		this.userid = (String) this.sessionMap.get("userId");
		this.newuserid = (String) this.sessionMap.get("userId");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User_Profile insert_user_profile_table = new User_Profile();
		User_Character insert_user_character_table = new User_Character();
		insert_user_profile_table.setId(this.id);
		insert_user_profile_table.setPhonenumber(this.phonenumber);
		insert_user_profile_table.setZipcode(this.zipcode);
		insert_user_profile_table.setDwelling(this.dwelling);
		insert_user_profile_table.setName(this.name);
		insert_user_character_table.setPersonality(this.personality);
		insert_user_profile_table.setDay(this.day);
		insert_user_profile_table.setNewday(this.newday);
		insert_user_profile_table.setUserid(this.userid);
		insert_user_profile_table.setNewuserid(this.newuserid);
		// insert_user_profile_table.setDelete(this.delete);
		// insert_user_profile_table.setFlg((his.flg);
		insert_user_character_table.setInterest(this.interest);
		String[] data = { this.dwelling, this.name, this.day, this.newday,
				this.userid, this.newuserid, this.interest, this.personality };
		int i = 0;
		for (String temp : data) {
			// if (temp.length() > 50) {
			// this.errormsg = "50文字以下で入力してください";
			// return "error";
			// }
			// if (temp.length() < 1)
			// i++;
			// if (i > 14) {
			// this.errormsg = "未入力は登録できません";
			// return "error";
			// }

			try {
				session.save(insert_user_profile_table);
				session.save(insert_user_character_table);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		}
		session.getTransaction().commit();
		return "main5";

	}

	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "main5";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			User_Profile profile = (User_Profile) session.load(
					User_Profile.class, Integer.valueOf(update_id));
			User_Character character = (User_Character) session.load(
					User_Character.class, Integer.valueOf(update_id));
			session.delete(profile);
			session.delete(character);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main5";
	}
}