package action;


import model.Movie;

import java.util.*;
import java.text.*;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

//リターンがmain7だったらmain7.actionに戻る
@Result(name = "main7", value = "main7.action", type = ServletRedirectResult.class)
public class Update7Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// デリートに必要な変数
	public String delete_id; //削除するID
	// テーブルにインサートするための変数
	public String title; //タイトル
	public int genreId; //ジャンル
	public int exhibition_year; //公開年
	public String comment;
	public String errormsg; //エラーメッセージ

	// 登録画面の初期値設定
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		this.exhibition_year = 1980;
		return "success";
	}

	// 追加するメソッド
	public String insert() {
		//インサートに必要な変数
		String registration_date; //登録日
		String renewal_date; //更新日
		String registration_userid; //登録ユーザーID
		String renewal_userid; //更新ユーザーID

		// 未入力の項目があるときにエラーを返す
		if (this.title.isEmpty() || this.genreId == 0
				|| this.exhibition_year == 0) {
			this.errormsg = "全ての項目に入力してください";
			return "errormsg";
		}
		// 全項目入力済みの時
		else {
			// TODO
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();//DB接続
			session.beginTransaction();//トランザクション(?)開始

			// 日付を自動で入力
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

			// 登録するテーブルとカラムを指定
			Movie insert_movie_table = new Movie();
			insert_movie_table.setTitle(this.title);
			insert_movie_table.setGenreId(this.genreId);
			insert_movie_table.setExhibition_year(this.exhibition_year);
			insert_movie_table.setComment(this.comment);
			insert_movie_table.setRegistration_date(String.valueOf(sdf.format(date))); //日付を入力
			insert_movie_table.setRenewal_date(String.valueOf(sdf.format(date))); //日付を入力
			insert_movie_table.setRegistration_userid((String) this.sessionMap.get("userId")); //ユーザーIDを指定
			insert_movie_table.setRenewal_userid((String) this.sessionMap.get("userId")); //ユーザーIDを指定

			// テーブルにインサートする
			try {
				session.save(insert_movie_table);
				// TODO
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

			session.getTransaction().commit();
		}
		return "main7";

	}

	// デリートメソッド
	public String delete() {
		// delete_id=movieテーブルのidを取得
		this.delete_id = (String) this.sessionMap.get("delete_id");
		String str = new String(this.delete_id);
		String[] strAry = str.split(",");

		if (this.delete_id.isEmpty()) {
			return "main7";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		for (int i = 0; i < strAry.length; i++) {

			try {
				Movie movie = (Movie) session.load(Movie.class, strAry[i]);
				session.delete(movie);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}

		session.getTransaction().commit();
		return "main7";
	}
}