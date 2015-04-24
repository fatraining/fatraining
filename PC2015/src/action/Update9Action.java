package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.CoofTa;
import model.LiofTa;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

@Result(name = "main9", value = "main9.action", type = ServletRedirectResult.class)
public class Update9Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String update_id;
	public String name;
	public String food;
	public String drink;
	public String colorNm;
	public String taste;
	public String day;
	public String new_day;
	// public String date_of_registration;
	// public String update_date;
	// public String registration_userid;
	// public String update_userid;
	// public int time_stamp;
	// public int delete;
	public String errormsg;

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");
		return "success";
	}

	public String insert() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		day = String.valueOf(sdf.format(date));
		new_day = String.valueOf(sdf.format(date));

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		LiofTa insert_like_table = new LiofTa();
		CoofTa insert_color_table = new CoofTa();

		insert_like_table.setName(this.name);
		insert_like_table.setFood(this.food);
		insert_like_table.setDrink(this.drink);
		insert_color_table.setColorNm(this.colorNm);
		insert_color_table.setTaste(this.taste);
		// insert_color_table.setDate_of_registration(this.date_of_registration);
		// insert_color_table.setUpdate_date(this.update_date);
		// insert_color_table.setRegistration_userid(this.registration_userid);
		// insert_color_table.setUpdate_userid(this.update_userid);
		// insert_like_table.setDelete(this.delete);

		try {
			session.save(insert_like_table);
			session.save(insert_color_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// String[] data = { this.name, this.food, this.drink, this.color,
		// this.taste};
		// int i = 0;
		// for (String temp : data) {
		// if (temp.length() > 50) {
		// this.errormsg = "50文字以下で入力してください";
		// return "error";
		// }
		// if (temp.length() < 1)
		// i++;
		// if (i > 14) {
		// this.errormsg = "未入力は登録できません";
		// return "error";
		// }
		//
		session.getTransaction().commit();
		return "main9";

	}

	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "main9";
		}

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CoofTa coofta = (CoofTa) session.load(CoofTa.class,
					Integer.valueOf(update_id));
			LiofTa liofta = (LiofTa) session.load(LiofTa.class,
					Integer.valueOf(update_id));
			session.delete(coofta);
			session.delete(liofta);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main9";
	}
}
