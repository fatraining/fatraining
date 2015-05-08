package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.User_Character;
import model.User_Profile;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class UserProfileManager extends HibernateUtil {

	// 全件のデータを検索
	public List<?> searchAll() {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// SQL文の作成
		String select = "SELECT * FROM User_Profile d ,User_Character i"; // 2つのテーブルの選択
		String where1 = "WHERE i.id = d.personality2"; // i(id)のカラム名とd(personality2)のカラム名を一致させる
		String sql = select + " " + where1; // sql文で2つのテーブルを結合させる

		// SQL文の実行（固定文言）
		List<?> resultTable = null; // SQLの検索結果用の変数
		try {
			resultTable = session.createSQLQuery(sql)
					// resultテーブルにsql文を代入
					.addEntity("user_profile", User_Profile.class)
					.addEntity("user_character", User_Character.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了（固定文言）
		session.getTransaction().commit();

		return resultTable;
	}

	// 条件指定のデータを検索

	public List<?> searchAll(String dwelling, String name) {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// SQL文の作成
		// もしdwellingが空の場合、ワイルドガードを代入して何でも検索する
		if (dwelling.isEmpty()) {
			dwelling = "%";
		}

		if (name.isEmpty()) {
			name = "%";
		}

		// 全てのテーブルの選択
		String select = "SELECT * FROM user_profile d, user_character i";
		// i(characterテーブル)とd(profileテーブル)が一緒の条件
		String where1 = "WHERE i.id = d.personality2";
		// 2つのテーブルを結合
		String where2 = "AND (d.dwelling LIKE '" + dwelling
				+ "' AND d.name LIKE '" + name + "')";
		// 2つのテーブルをsql文に代入
		String sql = select + " " + where1 + " " + where2;

		// SQL文の実行（固定文言）
		List<?> resultTable = null; // SQLの検索結果用の変数
		try {

			// resultテーブルにsql文を代入
			resultTable = session.createSQLQuery(sql)
					.addEntity("User_Profile", User_Profile.class)
					.addEntity("User_Character", User_Character.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了（固定文言）
		session.getTransaction().commit();

		return resultTable;
	}

	// user_characterテーブル検索用のメソッド
	public User_Character user_characterList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			// user_charactrテーブルの全件検索
			String sql = "SELECT * FROM user_Character i";
			resultTable = session.createSQLQuery(sql)
			// session.createSQLQuery(sql)の戻り値をUser_Profileクラスに渡している
					.addEntity("User_Character", User_Character.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return (User_Character) resultTable.get(resultTable.size() - 1);
	}

	public void insert(String personality, String interest, String name,
			String zipcode, String dwelling, String phonenumber, String userId) {
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
		String userid = userId;
		String newuserid = userId;

		// インスタンス化
		User_Character insert_user_character_table = new User_Character();

		// user_characterのデータ作成
		insert_user_character_table.setPersonality(personality); // 性格
		insert_user_character_table.setInterest(interest); // 趣味
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
		insert_userprofile_table.setName(name);
		insert_userprofile_table.setZipcode(Integer.valueOf(zipcode));
		insert_userprofile_table.setDwelling(dwelling);
		insert_userprofile_table.setPhonenumber(Integer.valueOf(phonenumber));
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
	}

	public void delete(String delete_id) {
		// 複数選択の削除
		String str = new String(delete_id);
		// 文字列の分割
		String[] strAry = str.split(",");

		// DBとの接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 処理の繰り返し
		for (int i = 0; i < strAry.length; i++) {

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

		}

		session.getTransaction().commit();
	}
}
