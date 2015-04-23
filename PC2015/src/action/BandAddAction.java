package action;

import java.util.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import model.BandAccount;
import model.BandTable;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

@Result(name = "bandsearch", value = "bandSearch.action", type = ServletRedirectResult.class)
public class BandAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String update_id;
	public String name;
	public String sex;
	public String age;
	public String school;
	public String favorite_song;
	public String part;
	public String band_id;
	public String entry_date;
	public String renewal_date;
	public String entry_userid;
	public String renewal_userid;
	public String exclusion_flg;
	public String delete_flg;
	public String band_name;
	public String errormsg;
	

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");
		return "success";
	}

	public String insert() {
		//日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		entry_date = String.valueOf(sdf.format(date));
		renewal_date = String.valueOf(sdf.format(date));
		
		//exclusion_flg,delete_flgの値を0にする。キャスト
		exclusion_flg = String.valueOf(0);
		delete_flg = String.valueOf(0);
		
		//登録useridにuserIdの値を入れる。
		this.entry_userid = (String)this.sessionMap.get("userId");
		this.renewal_userid = (String)this.sessionMap.get("userId");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		BandAccount insert_band_account = new BandAccount();
		BandTable insert_band_table = new BandTable();
		insert_band_account.setName(this.name);
		insert_band_account.setSex(this.sex);
		insert_band_account.setAge(this.age);
		insert_band_account.setSchool(this.school);
		insert_band_account.setFavorite_song(this.favorite_song);
		insert_band_account.setPart(this.part);
		insert_band_account.setBand_id(this.band_id);
		insert_band_account.setEntry_date(this.entry_date);
		insert_band_account.setRenewal_date(this.renewal_date);
		insert_band_account.setEntry_userid(this.entry_userid);
		insert_band_account.setRenewal_userid(this.renewal_userid);
		insert_band_account.setExclusion_flg(this.exclusion_flg);
		insert_band_account.setDelete_flg(this.delete_flg);
		insert_band_table.setBand_name(this.band_name);
		/*String[] data = { this.name, this.sex, this.age, this.school,
				this.favorite_song, this.part, this.band_id, this.entry_date,
				this.renewal_date, this.entry_userid, this.renewal_userid,
				this.exclusion_flg, this.delete_flg };
		int i = 0;
		for (String temp : data) {
			if (temp.length() > 50) {
				this.errormsg = "50文字以下で入力してください";
				return "error";
			}
			if (temp.length() < 1)
				i++;
			if (i>7) {
				this.errormsg = "未入力は登録できません";
				return "error";
			}*/

			try {
				session.save(insert_band_account);
				session.save(insert_band_table);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		//}
		session.getTransaction().commit();
		return "bandsearch";

	}

	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "bandsearch";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			BandAccount bandaccount = (BandAccount) session.load(BandAccount.class, update_id);
			BandTable bandtable = (BandTable) session.load(BandTable.class,update_id);
			session.delete(bandaccount);
			session.delete(bandtable);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();//
		return "bandsearch";
	}

	/*public String checkcode(String code) {

		// code = code.replaceAll("[^a-zA-Z_0-9]","_");
		if (!code.matches("[a-zA-Z_0-9]{0,50}")) {
		}
		return code;
	}*/

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
