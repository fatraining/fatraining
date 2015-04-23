package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Sweets;
import model.Genre;
import model.Result2Table;
import controller.TaskUtil;
import controller.SweetsManager;
import controller.Result2Manager;

import java.util.*;
import java.text.*;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class Update2Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String id;
	public String name;
	public String genreNm;
	public String entry_userId;
	public String record_userId;
	public String exclusive_FLG;
	public String delete_FLG;
	public String update_id;
	public String do_search;
	public String errormsg;

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

	private String getDefaultEntry_userId() {
		this.entry_userId = "";
		return this.entry_userId;
	}

	private String getDefaultRecord_userId() {
		this.record_userId = "";
		return this.record_userId;
	}

	private String getDefaultExclusive_FLG() {
		this.exclusive_FLG = "";
		return this.exclusive_FLG;
	}

	private String getDefaultDelete_FLG() {
		this.delete_FLG = "";
		return this.delete_FLG;
	}

	public String insert() {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

//		Sweets insert_genre_table = new Sweets();
//		Genre insert_sweets_table = new Genre();
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
//			try {
//				session.save(insert_sweets_table);
//				session.save(insert_genre_table);
//			} catch (HibernateException e) {
//				e.printStackTrace();
//				session.getTransaction().rollback();
//			}
//		}
//		session.getTransaction().commit();
//		return "Main2";
//	}
//		public String getDefaultDate(){
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
//		record_date = String.valueOf(sdf.format(date));
//		reset_date = String.valueOf(sdf.format(date));
//
		return "date";
	}

	@Override
	public String execute() {
		this.id = (String) this.sessionMap.get("id");
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();
		this.entry_userId = getDefaultEntry_userId();
		this.record_userId = getDefaultRecord_userId();
		this.exclusive_FLG = getDefaultExclusive_FLG();
		this.delete_FLG = getDefaultDelete_FLG();

		return "success";
	}

	public String reset() {
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();
		this.entry_userId = getDefaultEntry_userId();
		this.record_userId = getDefaultRecord_userId();
		this.exclusive_FLG = getDefaultExclusive_FLG();
		this.delete_FLG = getDefaultDelete_FLG();

		return "success";
	}

	public String print() {

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
		this.delete_FLG = "true";
		return "success";
	}

	public String printall() {
		this.do_search = "true";
		this.id = (String) this.sessionMap.get("id");
		allController = new SweetsManager();
		this.outputTable = allController.resultList(this.genreNm, this.name);
		this.delete_FLG = "true";
		return "success";
	}

	public String update() {
		 this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/updateAction");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	
}

