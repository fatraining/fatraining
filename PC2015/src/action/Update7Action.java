package action;

//import java.io.UnsupportedEncodingException;

import model.Movie;
//import model.MovieGenre;

import java.util.*;
import java.text.*;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

@Result(name = "main7", value = "main7.action", type = ServletRedirectResult.class)
public class Update7Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// デリートに必要な変数
	public String update_id;
	// テーブルにインサートするための変数
	public String title;
	public int genreId;
	public int exhibition_year;
	public String registration_date;
	public String renewal_date;
	public String registration_userid;
	public String renewal_userid;
	public int control;
	// public int delete;
	public String errormsg;

	// 登録画面の初期値設定
	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");

		return "success";
	}

	// 追加するメソッド
	public String insert() {
		// 未入力の項目があるときにエラーを返す
		if (this.title.isEmpty() || this.genreId == 0
				|| this.exhibition_year == 0) {
			this.errormsg = "全ての項目に入力してください";
			return "errormsg";
		}
		// 全項目入力済みの時
		else {
			// TODO
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			// 日付を自動で入力
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
			registration_date = String.valueOf(sdf.format(date));
			renewal_date = String.valueOf(sdf.format(date));

			// ユーザーIdを自動で入力
			this.registration_userid = (String) this.sessionMap.get("userId");
			this.renewal_userid = (String) this.sessionMap.get("userId");

			// 登録するテーブルとカラムを指定
			Movie insert_movie_table = new Movie();
			// MovieGenre insert_movie_genre_table = new MovieGenre();
			insert_movie_table.setTitle(this.title);
			insert_movie_table.setGenreId(this.genreId);
			insert_movie_table.setExhibition_year(this.exhibition_year);
			insert_movie_table.setRegistration_date(this.registration_date);
			insert_movie_table.setRenewal_date(this.renewal_date);
			insert_movie_table.setRegistration_userid(this.registration_userid);
			insert_movie_table.setRenewal_userid(this.renewal_userid);
			// insert_movie_table.setControl(this.control);

			// テーブルにインサートする
			try {
				session.save(insert_movie_table);
				// session.save(insert_movie_genre_table);
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
		// update_id=movieテーブルのidを取得
		this.update_id = (String) this.sessionMap.get("update_id");
		String str = new String(this.update_id);
		String[] strAry = str.split(",");

		if (this.update_id.isEmpty()) {
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