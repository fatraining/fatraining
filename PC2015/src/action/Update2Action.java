package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Sweets;
import model.Genre;
import model.Result2Table;
import controller.HibernateUtil;
import controller.SweetsManager;
import controller.Result2Manager;


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

	public String id;
	public String name;
	public String genreNm;
	public String update_id;
	public String do_search;
	public String errormsg;
	public String delete;

	private Result2Manager linkController;
	private SweetsManager allController;
	public ArrayList<Result2Table> outputTable;

	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	private String getDefaultGenreNm() {
		this.genreNm = "";
		return this.genreNm;
	}

	
	//insertメソッド
	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Sweets insert_sweets = new Sweets();
		Genre insert_genre = new Genre();
		insert_sweets.setName(this.name);
		insert_genre.setGenreNm(this.genreNm);

		
//		String[] data = { this.genreNm, this.name };
//		int i = 0;
//		for (String temp : data) {
//			if (temp.length() > 50) {
//				this.errormsg = "50文字以下で入力してください";
//				return "error";
//			}
//			if (temp.length() < 1)
//				i++;
//			if (i > 14) {
//				this.errormsg = "未入力は登録できません";
//				return "error";
//			}
			try {
				session.save(insert_sweets);
				session.save(insert_genre);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			
//		}
		session.getTransaction().commit();
		return "main2";
	}
	
	//deleteメソッド
	public String delete(){
		this.update_id = (String)this.sessionMap.get("update_id");
		
		String str = new String(this.update_id);
		String[] strAry = str.split(",");
		
		if (this.update_id.isEmpty()) {
			return "main2";
		}
		
		for(int i = 0; i < strAry.length; i++) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Sweets sweets = (Sweets) session.load(Sweets.class, strAry[i]);
			Genre genre = (Genre) session.load(Genre.class, strAry[i]);
			session.delete(sweets);
			session.delete(genre);
		}catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		}
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

	//executeメソッド
	@Override
	public String execute() {
		this.id = (String) this.sessionMap.get("id");
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();


		return "success";
	}

	//resetメソッド
	public String reset() {
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();


		return "success";
	}

	//searchメソッド
	public String search() {

		this.do_search = "true";
		this.id = (String) this.sessionMap.get("id");
		if (this.genreNm.isEmpty() && this.name.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result2Manager();
			this.outputTable = linkController.resultList(this.genreNm,
					this.name);
		}
		this.delete = "true";
		return "success";
	}

	//printallメソッド
	public String printall() {
		this.do_search = "true";
		this.id = (String) this.sessionMap.get("id");
		allController = new SweetsManager();
		this.outputTable = allController.resultList(this.genreNm, this.name);
		this.delete = "true";
		return "success";
	}

	//updateメソッド
	public String update() {
		 this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update2.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	
}

