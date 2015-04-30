package controller;

import java.util.ArrayList;
import java.util.List;

import model.Result2Table;
import model.User_Profile;
import model.User_Character;
import model.Result5Table;

import org.hibernate.classic.Session;

public class UserProfileManager extends HibernateUtil {

	//全件のデータを検索
	public ArrayList<Result5Table> searchAll() {
		
		//DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始（固定文言）
		session.beginTransaction();

		//SQL文の作成
		String select = "SELECT * FROM User_Character i,User_Profile d"; //2つのテーブルの選択
		String where1 = "WHERE i.id = d.personality2"; //i(id)のカラム名とd(personality2)のカラム名を一致させる
		String sql    = select + " " + where1; //sql文で2つのテーブルを結合させる

		//SQL文の実行（固定文言）
		List<?> resultTable = null; //SQLの検索結果用の変数
		try {
			resultTable = session.createSQLQuery(sql)//resultテーブルにsql文を代入
					.addEntity("user_character", User_Character.class)
					.addEntity("user_profile", User_Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了（固定文言）
		session.getTransaction().commit();

		ArrayList<Result5Table> outputTable = tableTrans(resultTable);

		return outputTable;
	}
	
	
	public ArrayList<Result5Table> resultList(String dwelling, String name) {

		//DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始（固定文言）
		session.beginTransaction();
		
		//SQL文の作成
		//もしdwellingが空の場合、ワイルドガードを代入して何でも検索する
		if (dwelling.isEmpty())
			dwelling = "%";
		if (name.isEmpty())
			name = "%";
		
		//全てのテーブルの選択
		String select = "SELECT * FROM user_character i, user_profile d";
		//i(characterテーブル)とd(profileテーブル)が一緒の条件
		String where1 = "WHERE i.id = d.personality2";
		//2つのテーブルを結合
		String where2 = "AND (d.dwelling LIKE '" + dwelling
				+ "' AND d.name LIKE '" + name + "')";
		//2つのテーブルをsql文に代入
		String sql = select + " " + where1 + " " + where2;
		
		//SQL文の実行（固定文言）
		List<?> resultTable = null; //SQLの検索結果用の変数
		try {

			//resultテーブルにsql文を代入
			resultTable = session.createSQLQuery(sql)
					.addEntity("User_Character", User_Character.class)
					.addEntity("User_Profile", User_Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了（固定文言）
		session.getTransaction().commit();

		ArrayList<Result5Table> outputTable = tableTrans(resultTable);

		return outputTable;
	}
	
	//SQLの検索結果を画面表示用のListに入れ替えている
	public ArrayList<Result5Table> tableTrans(List<?> resultTable){
		
		// 画面表示用のリストをインスタンス化する。
		ArrayList<Result5Table> tempTable = new ArrayList<Result5Table>();

		// 変数の初期化
		Object[] obj;

		// SQLの検索結果の件数分ループする。
		for (int i = 0; i < resultTable.size(); i++) {

			// 画面表示用のレコードをインスタンス化する。
			Result5Table temp = new Result5Table();

			// SQLの検索結果を分解する。
			obj = (Object[]) resultTable.get(i);
			User_Character user_character = (User_Character) obj[0];
			User_Profile user_profile = (User_Profile) obj[1];

			// 画面表示用に設定する。
			temp.setInterest(user_character.getInterest());
			temp.setId(user_profile.getId());
			temp.setPhonenumber(user_profile.getPhonenumber());
			temp.setZipcode(user_profile.getZipcode());
			temp.setDwelling(user_profile.getDwelling());
			temp.setName(user_profile.getName());
			temp.setPersonality(user_character.getPersonality());
			temp.setDay(user_profile.getDay());
			temp.setNewday(user_profile.getNewday());
			temp.setUserid(user_profile.getUserid());
			temp.setNewuserid(user_profile.getNewuserid());
			// temp.setDelete(user_profile.getDelete());
			// temp.setFlg(user_profile.getFlg());

			// 画面表示用にリストに追加する。
			tempTable.add(temp);
		}

		return tempTable;
	}
}

