package action;

import model.My_hobby;
import model.Profile;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.TaskUtil;

@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class)
public class Update1Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	public String update_id;
	public String name;
	public String personality;
	public String home;
	public int birthday;
	public String hobby;
	public String day;
	public String new_day;
	public String errormsg;

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");
		return "success";
	}

	public String insert() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		 day = String.valueOf(sdf.format(date));
		 new_day= String.valueOf(sdf.format(date));
		
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		My_hobby insert_my_hobby_table = new My_hobby();
		Profile insert_profile_table = new Profile();
		insert_my_hobby_table.setHobby(this.hobby);
		insert_profile_table.setName(this.name);
		insert_profile_table.setPersonality(this.personality);
		insert_profile_table.setHome(this.home);
		insert_profile_table.setBirthday(this.birthday);
		insert_profile_table.setDay(this.day);
		insert_profile_table.setNew_day(this.new_day);
		String[] data = { this.hobby, this.name, this.personality, this.home, this.day, this.new_day };
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
				session.save(insert_my_hobby_table);
				session.save(insert_profile_table);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		}
		session.getTransaction().commit();
		return "main1";

	}

	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "main1";
		}
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			My_hobby my_hobby = (My_hobby) session.load(My_hobby.class,
					Integer.valueOf(update_id));
			Profile profile = (Profile) session.load(Profile.class,
					Integer.valueOf(update_id));
			session.delete(my_hobby);
			session.delete(profile);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main1";
	}
}