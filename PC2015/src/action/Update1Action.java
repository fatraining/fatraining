package action;

import model.My_hobby;
import model.Profile;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.ProfileManager;

@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class)
public class Update1Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// テーブルで作ったカラム　追加画面にて検索をかけたいカラム名
	public String name;
	public String personality;
	public String home;
	public int birthday;
	public int hobby_id;
	public String hobby;
	// メソッドを起こすための変数
	public String delete_id;
	public String errormsg;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド
	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String day;
		String new_day;

		// 登録、更新日時表示
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		day = String.valueOf(sdf.format(date));
		new_day = String.valueOf(sdf.format(date));
		
		String userid;
		String new_userid;
		
		// 登録、更新UAER表示
		userid = (String) this.sessionMap.get("userId");
		new_userid = (String) this.sessionMap.get("userId");

		My_hobby insert_my_hobby_table = new My_hobby();
		insert_my_hobby_table.setHobby(this.hobby);

		try {
			session.save(insert_my_hobby_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		ProfileManager profilemanager = new ProfileManager();
		insert_my_hobby_table = profilemanager.my_hobbyList();

		Profile insert_profile_table = new Profile();
		insert_profile_table.setHobby_id(insert_my_hobby_table.getId());
		insert_profile_table.setName(this.name);
		insert_profile_table.setPersonality(this.personality);
		insert_profile_table.setHome(this.home);
		insert_profile_table.setBirthday(this.birthday);
		insert_profile_table.setDay(day);
		insert_profile_table.setNew_day(new_day);
		insert_profile_table.setUserid(userid);
		insert_profile_table.setNew_userid(new_userid);

		try {
			session.save(insert_profile_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main1";
	}

	// deleteメソッド
	// 検索結果の内容を削除のため
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		String str = new String(this.delete_id);
		String[] strAry = str.split(",");

		if (this.delete_id.isEmpty()) {
			return "main1";
		}

		for (int i = 0; i < strAry.length; i++) {

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
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
			session.getTransaction().commit();
		}
		return "main1";
	}
}