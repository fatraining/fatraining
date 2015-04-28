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
	public String name;
	public String personality;
	public String home;
	public int birthday;
	public String hobby;
	// メソッドを起こすための変数
	public String update_id;
	public String day;
	public String new_day;
	public String userid;
	public String new_userid;
	// public int time_stamp;
	// public int delete;
	public String errormsg;

	// executeメソッド
	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");
		return "success";
	}

	// insertメソッド
	public String insert() {
		// 登録、更新日時表示
		Date date = new Date();// インスタンス化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");// インスタンス化
		day = String.valueOf(sdf.format(date));// キャスト　文字列から数値への変換
		new_day = String.valueOf(sdf.format(date));// キャスト　文字列から数値への変換
		// 登録、更新UAER表示
		this.userid = (String) this.sessionMap.get("userId");
		this.new_userid = (String) this.sessionMap.get("userId");
		// 削除フラグ
		// time_stamp = 0;
		// delete = 0;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		// サーバーのテーブルに値をインサート
		My_hobby insert_my_hobby_table = new My_hobby();// インスタンス化
		Profile insert_profile_table = new Profile();// インスタンス化
		insert_my_hobby_table.setHobby(this.hobby);
		insert_profile_table.setName(this.name);
		insert_profile_table.setPersonality(this.personality);
		insert_profile_table.setHome(this.home);
		insert_profile_table.setBirthday(this.birthday);
		insert_profile_table.setDay(this.day);
		insert_profile_table.setNew_day(this.new_day);
		insert_profile_table.setUserid(this.userid);
		insert_profile_table.setNew_userid(this.new_userid);
		// String[] data = { this.hobby, this.name, this.personality, this.home,
		// this.day, this.new_day, this.userid, this.new_userid };
		// int i = 0;
		// for (String temp : data) {

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
	public String delete() {// 検索結果の内容を削除のため
		this.update_id = (String) this.sessionMap.get("update_id");

		String str = new String(this.update_id);
		String[] strAry = str.split(",");

		if (this.update_id.isEmpty()) {
			return "main1";
		}

		for (int i = 0; i < strAry.length; i++) {

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			session.beginTransaction();
			try {
				My_hobby my_hobby = (My_hobby) session.load(My_hobby.class,
						Integer.valueOf(strAry[i]));// キャスト　文字列から数値への変換
				Profile profile = (Profile) session.load(Profile.class,
						Integer.valueOf(strAry[i]));// キャスト　文字列から数値への変換
				session.delete(my_hobby);// 使用する場所が違うソース　削除に必要
				session.delete(profile);// 使用する場所が違うソース　削除に必要
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
		}
		return "main1";
	}
}