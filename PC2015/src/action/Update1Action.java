package action;

import model.My_hobby;
import model.Profile;

import java.io.UnsupportedEncodingException;
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

		// 登録、更新日時表示
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		My_hobby insert_my_hobby_table = new My_hobby();
		insert_my_hobby_table.setHobby(checkcode(this.hobby));
		insert_my_hobby_table.setDay(String.valueOf(sdf.format(date)));
		insert_my_hobby_table.setNew_day(String.valueOf(sdf.format(date)));
		insert_my_hobby_table.setUserid((String) this.sessionMap.get("userId"));
		insert_my_hobby_table.setNew_userid((String) this.sessionMap.get("userId"));

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
		insert_profile_table.setName(checkcode(this.name));
		insert_profile_table.setPersonality(checkcode(this.personality));
		insert_profile_table.setHome(checkcode(this.home));
		insert_profile_table.setBirthday(this.birthday);
		insert_profile_table.setDay(String.valueOf(sdf.format(date)));
		insert_profile_table.setNew_day(String.valueOf(sdf.format(date)));
		insert_profile_table.setUserid((String) this.sessionMap.get("userId"));
		insert_profile_table.setNew_userid((String) this.sessionMap.get("userId"));
		String[] data = {this.hobby,this.name,this.personality,this.home};
		int i=0;
		for(String temp : data){
			if(temp.length()>50){
				this.errormsg = "50文字以下で入力してください";
				return "error";
			}
			if(temp.length()<1)i++;
			if(i>3){
				this.errormsg = "未入力は登録できません";
				return "error";
			}

		try {
			session.save(insert_profile_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		}
		session.getTransaction().commit();
		return "main1";
		}
	// deleteメソッド
	// 検索結果の内容を削除のため
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		
		if (this.delete_id.isEmpty()) {
			return "main1";
		}

		String[] strAry = this.delete_id.split(",");


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
	public String checkcode(String code) {


		//code = code.replaceAll("[^a-zA-Z_0-9]","_");
		if(!code.matches("[a-zA-Z_0-9]{0,50}")){
			//return "";
		}
		return code;
	}
	private static boolean checkCharacterCode(String str, String encoding) {
		if (str == null) {
			return true;
		}

		try {
			byte[] bytes = str.getBytes(encoding);
			return str.equals(new String(bytes, encoding));
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("エンコード名称が正しくありません。", ex);
		}
	}
}