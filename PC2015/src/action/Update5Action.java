package action;

import java.text.SimpleDateFormat;
import java.util.*;

import model.User_Profile;
import model.User_Character;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.UserProfileManager;

@Result(name = "main5", value = "main5.action", type = ServletRedirectResult.class)
public class Update5Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 入力項目（追加画面）
	public String name; // 名前
	public String personality; // 性格
	public String interest; // 趣味
	public String zipcode; // 郵便番号
	public String dwelling; // 住所
	public String phonenumber; // 電話番号

	// 表示項目（削除画面）
	public String delete_id;

	// 画面が表示時に実行
	public String execute() throws Exception {
		// 削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// 初期値の設定
		this.name = "田中進";
		this.personality = "穏やか";
		this.interest = "けん玉";
		this.zipcode = "1111234";
		this.dwelling = "千葉県印旛郡栄町矢口";
		this.phonenumber = "0124551334";

		return "success";
	}

	// 追加ボタンを押下時
	public String insert() {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// 登録、更新日時設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String day = String.valueOf(sdf.format(date));
		String newday = String.valueOf(sdf.format(date));

		// 登録更新ID設定
		String userid = (String) this.sessionMap.get("userId");
		String newuserid = (String) this.sessionMap.get("userId");

		// インスタンス化
		User_Character insert_user_character_table = new User_Character();

		// user_characterのデータ作成
		insert_user_character_table.setPersonality(this.personality); // 性格
		insert_user_character_table.setInterest(this.interest); // 趣味
		insert_user_character_table.setDay(day); // 登録日付
		insert_user_character_table.setNewday(newday); // 更新日付
		insert_user_character_table.setUserid(userid); // 登録ユーザID
		insert_user_character_table.setNewuserid(newuserid); // 更新ユーザID
		insert_user_character_table.setDeleteFlg(0); // 排他フラグ
		insert_user_character_table.setFlg(0); // 削除フラグ

		// user_characterテーブルに追加
		try {
			session.save(insert_user_character_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// user_characterテーブルのデータ検索
		UserProfileManager userprofilemanager = new UserProfileManager();
		User_Character tmpInsert_user_character_table = userprofilemanager
				.user_characterList();

		// インスタンス化
		User_Profile insert_userprofile_table = new User_Profile();

		// User_Profileのデータ作成
		insert_userprofile_table.setPersonality2(tmpInsert_user_character_table
				.getId()); // user_profileテーブルのpersonality2を取得し、user_characterテーブルのidに代入
		insert_userprofile_table.setName(this.name);
		insert_userprofile_table.setZipcode(Integer.valueOf(this.zipcode));
		insert_userprofile_table.setDwelling(this.dwelling);
		insert_userprofile_table.setPhonenumber(Integer
				.valueOf(this.phonenumber));
		insert_userprofile_table.setDay(day);
		insert_userprofile_table.setNewday(newday);
		insert_userprofile_table.setUserid(userid);
		insert_userprofile_table.setNewuserid(newuserid);
		insert_userprofile_table.setDeleteFlg(0); // 排他フラグ
		insert_userprofile_table.setFlg(0); // 削除フラグ

		try {
			session.save(insert_userprofile_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return "main5";
	}

	// 検索結果内の値を削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		if (this.delete_id.isEmpty()) {
			return "main5";
		}

		// 複数選択の削除
		String str = new String(this.delete_id);
		// 文字列の分割
		String[] strAry = str.split(",");

		// 処理の繰り返し
		for (int i = 0; i < strAry.length; i++) {

			// DBとの接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			try {
				User_Profile user_profile = (User_Profile) session.load(
						User_Profile.class, strAry[i]);
				User_Character user_character = (User_Character) session.load(
						User_Character.class, user_profile.getPersonality2());
				session.delete(user_profile);
				session.delete(user_character);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
		}
		return "main5";
	}
}

// // テーブル内のカラム名の宣言
// public String update_id;
// public String errormsg;
// public int id;
// public String day;
// public String newday;
// public String userid;
// public String newuserid;
// // public int delete;
// // public int flg;

// public String insert() {
// // 登録、更新日時設定
// Date date = new Date();
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
// day = String.valueOf(sdf.format(date));
// newday = String.valueOf(sdf.format(date));
//
// // 登録、更新UAER設定
// this.userid = (String) this.sessionMap.get("userId");
// this.newuserid = (String) this.sessionMap.get("userId");
//
// Session session =
// HibernateUtil.getSessionFactory().getCurrentSession();
// session.beginTransaction();
//
// //User_ProfileクラスとUser_Characterクラスのインスタンス化
// User_Profile insert_user_profile_table = new User_Profile();
// User_Character insert_user_character_table = new User_Character();
//
// insert_user_profile_table.setId(this.id);
// insert_user_profile_table.setPhonenumber(this.phonenumber);
// insert_user_profile_table.setZipcode(this.zipcode);
// insert_user_profile_table.setDwelling(this.dwelling);
// insert_user_profile_table.setName(this.name);
// insert_user_character_table.setPersonality(this.personality);
// insert_user_profile_table.setDay(this.day);
// insert_user_profile_table.setNewday(this.newday);
// insert_user_profile_table.setUserid(this.userid);
// insert_user_profile_table.setNewuserid(this.newuserid);
// insert_user_character_table.setInterest(this.interest);
// String[] data = { this.dwelling, this.name, this.day, this.newday,
// this.userid, this.newuserid, this.interest, this.personality };
// int i = 0;
// for (String temp : data) {
//
// // user_profileテーブルとuser_characterテーブルに値を追加
// try {
// session.save(insert_user_profile_table);
// session.save(insert_user_character_table);
//
// } catch (HibernateException e) {
// e.printStackTrace();
// session.getTransaction().rollback();
// }
//
// }
// session.getTransaction().commit();
// //main5に戻る
// return "main5";

// }

// 検索結果内の値を削除
// public String delete() {
// this.update_id = (String) this.sessionMap.get("update_id");
// //もしupdate_idが空の場合はmain5に戻る
// if (this.update_id.isEmpty()) {
// return "main5";
// }
// // サーバー内のテーブルの値を削除
// Session session =
// HibernateUtil.getSessionFactory().getCurrentSession();
// session.beginTransaction();
// try {
// User_Profile profile = (User_Profile) session.load(
// User_Profile.class, Integer.valueOf(update_id));
// User_Character character = (User_Character) session.load(
// User_Character.class, Integer.valueOf(update_id));
// session.delete(profile);
// session.delete(character);
// } catch (HibernateException e) {
// e.printStackTrace();
// session.getTransaction().rollback();
// }
// session.getTransaction().commit();
// //main5に戻る
// return "main5";
// }
// }