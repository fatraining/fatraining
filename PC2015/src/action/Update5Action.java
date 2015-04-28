package action;

import java.io.UnsupportedEncodingException;

import model.User_Profile;
import model.User_Character;

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
	// public int delete;
	// public int flg;
	public String interest;

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");

		return "success";
	}

	public String insert() {

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
		// insert_user_profile_table.setDelete((this.delete));
		// insert_user_profile_table.setFlg((this.flg));
		insert_user_character_table.setInterest(this.interest);
		String[] data = { this.dwelling, this.name, this.day, this.newday,
				this.userid, this.newuserid, this.interest, this.personality };
		int i = 0;
		for (String temp : data) {
//			if (temp.length() > 50) {
//				this.errormsg = "50文字以下で入力してください";
//				return "error";
//			}
//			if (temp.length() < 1)
//				i++;
//			if (i > 14) {
//				this.errormsg = "未入力は登録できません";
//				return "error";
//			}

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
					User_Profile.class, update_id);
			User_Character character = (User_Character) session.load(
					User_Character.class, update_id);
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
//
//	public String checkcode(String code) {
//
//		// code = code.replaceAll("[^a-zA-Z_0-9]","_");
//		if (!code.matches("[a-zA-Z_0-9]{0,50}")) {
//			// return "";
//		}
//		return code;
//	}
//
//	private static boolean checkCharacterCode(String str, String encoding) {
//		if (str == null) {
//			return true;
//		}
//
//		try {
//			byte[] bytes = str.getBytes(encoding);
//			return str.equals(new String(bytes, encoding));
//		} catch (UnsupportedEncodingException ex) {
//			throw new RuntimeException("エンコード名称が正しくありません。", ex);
//		}
//	}
//}