package action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.CoofTa;
import model.LiofTa;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.LiofTaManager;

@Result(name = "main9", value = "main9.action", type = ServletRedirectResult.class)
public class Update9Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String name;
	public String food;
	public String drink;
	public String color;

	public String colorNm;

	public String delete_id;

	public String errormsg;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド（挿入）
	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		CoofTa insert_color_table = new CoofTa();
		insert_color_table.setColorNm(checkcode(this.colorNm));
		insert_color_table.setDay(String.valueOf(sdf.format(date)));
		insert_color_table.setNew_day(String.valueOf(sdf.format(date)));
		insert_color_table.setUserid((String) this.sessionMap.get("userId"));
		insert_color_table
				.setNew_userid((String) this.sessionMap.get("userId"));

		try {
			session.save(insert_color_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		LiofTaManager lioftamanager = new LiofTaManager();
		insert_color_table = lioftamanager.cooftaList();

		LiofTa insert_like_table = new LiofTa();

		insert_like_table.setColor(insert_color_table.getId());
		insert_like_table.setName(checkcode(this.name));
		insert_like_table.setFood(checkcode(this.food));
		insert_like_table.setDrink(checkcode(this.drink));
		insert_like_table.setDay(String.valueOf(sdf.format(date)));
		insert_like_table.setNew_day(String.valueOf(sdf.format(date)));
		insert_like_table.setUserid((String) this.sessionMap.get("userId"));
		insert_like_table.setNew_userid((String) this.sessionMap.get("userId"));

		String[] data = { this.name, this.food, this.drink, this.colorNm };
		int i = 0;
		for (String temp : data) {
			if (temp.length() > 50) {
				this.errormsg = "50文字以下で入力してください";
				return "error";
			}
			if (temp.length() < 1)
				i++;
			if (i > 3) {
				this.errormsg = "未入力は登録できません";
				return "error";
			}
			try {
				session.save(insert_like_table);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
		return "main9";

	}

	// deleteメソッド
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		if (this.delete_id.isEmpty()) {
			return "main9";
		}

		String[] strAry = this.delete_id.split(",");

		for (int i = 0; i < strAry.length; i++) {

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();

			session.beginTransaction();
			try {
				LiofTa liofta = (LiofTa) session.load(LiofTa.class, strAry[i]);
				CoofTa coofta = (CoofTa) session.load(CoofTa.class,
						liofta.getColor());
				session.delete(coofta);
				session.delete(liofta);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
		}
		return "main9";
	}

	public String checkcode(String code) {

		// code = code.replaceAll("[^a-zA-Z_0-9]","_");
		if (!code.matches("[a-zA-Z_0-9]{0,50}")) {
			// return "";
		}
		return code;
	}

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
