package action;

import model.My_hobby;
import model.Profile;

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

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド
	public String insert() {

		String userid = (String) this.sessionMap.get("userId");
		String new_userid = (String) this.sessionMap.get("userId");

		ProfileManager insert = new ProfileManager();
		insert.insert(this.hobby, this.name, this.personality, this.home,
				this.birthday, userid, new_userid);

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
}