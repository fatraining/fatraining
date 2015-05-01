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

@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class)
public class Update1Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// テーブルで作ったカラム　追加画面にて検索をかけたいカラム名
	//名前
	public String name;
	//性格
	public String personality;
	//出身地
	public String home;
	//誕生月
	public int birthday;
	//趣味
	public String hobby;
	// メソッドを起こすための宣言
	public String delete_id;
	public String day;
	public String new_day;
	public String userid;
	public String new_userid;
	public String errormsg;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド
	public String insert() {
		// 登録、更新日時を追加
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		day = String.valueOf(sdf.format(date));
		new_day = String.valueOf(sdf.format(date));
		// 登録、更新UAERを追加
		this.userid = (String) this.sessionMap.get("userId");
		this.new_userid = (String) this.sessionMap.get("userId");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// サーバーのテーブルに値をインサート
		My_hobby insert_my_hobby_table = new My_hobby();
		Profile insert_profile_table = new Profile();
		insert_my_hobby_table.setHobby(this.hobby);
		insert_profile_table.setName(this.name);
		insert_profile_table.setPersonality(this.personality);
		insert_profile_table.setHome(this.home);
		insert_profile_table.setBirthday(this.birthday);
		insert_profile_table.setDay(this.day);
		insert_profile_table.setNew_day(this.new_day);
		insert_profile_table.setUserid(this.userid);
		insert_profile_table.setNew_userid(this.new_userid);

		try {
			session.save(insert_my_hobby_table);
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
				My_hobby my_hobby = (My_hobby) session.load(My_hobby.class,strAry[i]);
				Profile profile = (Profile) session.load(Profile.class,strAry[i]);
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