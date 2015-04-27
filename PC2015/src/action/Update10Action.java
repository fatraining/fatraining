package action;

import java.io.UnsupportedEncodingException;

import model.DetailEat;
import model.IDofEat;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import java.text.SimpleDateFormat;
import java.util.*;

import controller.HibernateUtil;

@Result(name = "main10", value = "main10.action", type = ServletRedirectResult.class)
public class Update10Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String update_id;

	public String eatFood;
	public String eatCalory;
	public String eat_year;
	public String eat_month;
	public String eat_day;
	public String eat_hour;
	public String entry_day;
	public String renew_day;
	public String entry_userid;
	public String renew_userid;
	public String errormsg;

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");

		return "success";
	}
	

	public String insert() {
			//日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		entry_day = String.valueOf(sdf.format(date));
		renew_day = String.valueOf(sdf.format(date));
			
		//登録、更新UAER表示
		this.entry_userid = (String) this.sessionMap.get("userId");
		this.renew_userid = (String) this.sessionMap.get("userId");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		DetailEat insert_detail_table = new DetailEat();
		IDofEat insert_id_table = new IDofEat();

		insert_detail_table.setEat_year(this.eat_year);
		insert_detail_table.setEat_month(this.eat_month);
		insert_detail_table.setEat_day(this.eat_day);
		insert_detail_table.setEat_hour(this.eat_hour);
//		insert_detail_table.setEntry_day(this.entry_day);
//		insert_detail_table.setRenew_day(this.renew_day);
//		insert_detail_table.setEntry_userid(this.entry_userid);
//		insert_detail_table.setRenew_userid(this.renew_userid);
		insert_id_table.setEatFood(this.eatFood);
		insert_id_table.setEatCalory(this.eatCalory);
		insert_id_table.setEntry_day(this.entry_day);
		insert_id_table.setRenew_day(this.renew_day);
		insert_id_table.setEntry_userid(this.entry_userid);
		insert_id_table.setRenew_userid(this.renew_userid);
		
		// String[] data = {this.eat_year, this.eat_month, this.eat_day,
		// this.eat_hour, this.eatFood, this.eatCalory};
		// int i=0;
		// for(String temp : data){
		// if(temp.length()>50){
		// this.errormsg = "50文字以下で入力してください";
		// return "error";s
		// }
		// if(temp.length()<1)i++;
		// if(i>14){
		// this.errormsg = "未入力は登録できません";
		// return "error";
		// }

		try {
			session.save(insert_detail_table);
			session.save(insert_id_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return "main10";

	}

	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "main10";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			DetailEat detaileat = (DetailEat) session.load(DetailEat.class,
					Integer.valueOf(update_id));
			IDofEat idofeat = (IDofEat) session.load(IDofEat.class,
					Integer.valueOf(update_id));
			session.delete(detaileat);
			session.delete(idofeat);
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main10";
	}

	// public String checkcode(String code) {

	// code = code.replaceAll("[^a-zA-Z_0-9]","_");
	// if(!code.matches("[a-zA-Z_0-9]{0,50}")){
	// return "";
	// }
	// return code;
	// }
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