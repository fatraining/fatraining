package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Sweets;
import model.Genre;
import model.Result2Table;
import controller.HibernateUtil;
import controller.SweetsManager;
//import controller.Result2Manager;





import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

//import java.util.*;
//import java.text.*;
//import java.io.UnsupportedEncodingException;
//import java.text.SimpleDateFormat;
//
//import model.BandAccount;
//import model.BandTable;

import org.apache.struts2.config.Result;
//import controller.HibernateUtil;

@Result(name = "main2", value = "main2.action", type = ServletRedirectResult.class)
public class Update2Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	//入力項目（追加画面）
	public String name; //お菓子の名前:
	public String genreNm; //ジャンル:
	
	//表示項目（削除画面）
	public String delete_id;
	
	//画面が表示時に実行
	@Override
	public String execute() {
		//削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");
		
		//初期値の設定
		this.name = "クッキー";
		this.genreNm = "焼き菓子";

		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public String id;
//
//	public String do_search;
//	public String errormsg;
//	public String delete;
//	public String add_id;
//
////	private Result2Manager linkController;
//	private SweetsManager allController;
//	public ArrayList<Result2Table> outputTable;


	


	
	//insertメソッド
	public String insert() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
//		Sweets sweets = new Sweets();
//		Genre genre = new Genre();
//		
//		Sweets insert_sweets = new Sweets();
//		Genre insert_genre = new Genre();
//		insert_sweets.setName(this.name);
//		insert_genre.setGenreNm(this.genreNm);
//		
//		
//		sweets.setName(this.name);
//		genre.setGenreNm(this.genreNm);
//
//		
////		String[] data = { this.genreNm, this.name };
////		int i = 0;
////		for (String temp : data) {
////			if (temp.length() > 50) {
////				this.errormsg = "50文字以下で入力してください";
////				return "error";
////			}
////			if (temp.length() < 1)
////				i++;
////			if (i > 14) {
////				this.errormsg = "未入力は登録できません";
////				return "error";
////			}
//			try {
//				session.save(sweets);
//				session.save(genre);
//			} catch (HibernateException e) {
//				e.printStackTrace();
//				session.getTransaction().rollback();
//			}
//			
////		}
//		session.getTransaction().commit();
		return "main2";
	}
	
	//deleteメソッド
	public String delete(){
//		this.delete_id = (String)this.sessionMap.get("delete_id");
//		
//		String str = new String(this.delete_id);
//		String[] strAry = str.split(",");
//		
//		if (this.delete_id.isEmpty()) {
//			return "main2";
//		}
//		
//		for(int i = 0; i < strAry.length; i++) {
//		
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		try {
//			Sweets sweets = (Sweets) session.load(Sweets.class, strAry[i]);
//			Genre genre = (Genre) session.load(Genre.class, strAry[i]);
//			session.delete(sweets);
//			session.delete(genre);
//		}catch (HibernateException e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		session.getTransaction().commit();
//		}
		return "main2";
	}
//		public String getDefaultDate(){
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
//		record_date = String.valueOf(sdf.format(date));
//		reset_date = String.valueOf(sdf.format(date));
//
//		return "date";
//	}


	
}

