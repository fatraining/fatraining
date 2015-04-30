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
	//フィールドの宣言
	public String delete_id; //update_idからdelete_idに変更
	public String name;
	public String sex;
	public String age;
	public String school;
	public String favorite_song;
	public String part;
	public int band_id;//band_accountテーブルのカラム名BAND_IDの変数、データ型int(String型からint型へ変更)
	public String entry_date;
	public String renewal_date;
	public String entry_userid;
	public String renewal_userid;
	public int exclusion_flg; //band_accountテーブルのカラム名EXCLUSION_FLGの変数、データ型int(String型からint型に修正)
	public int delete_flg; //band_accountテーブルのカラム名DELETE_FLGの変数、データ型int(String型からint型に修正)
	public String band_name;
	public String errormsg;
	
	//executeメソッド。update_idの値を受け取っている。
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}
	//insertメソッド。データベースに値を入れる。
	public String insert() {
		//日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		entry_date = String.valueOf(sdf.format(date));
		renewal_date = String.valueOf(sdf.format(date));
		
		//登録useridにuserIdの値を入れる。
		this.entry_userid = (String)this.sessionMap.get("userId");
		this.renewal_userid = (String)this.sessionMap.get("userId");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//インスタンス化
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
		

			//ToDo
			try {
				session.save(insert_band_account);
				session.save(insert_band_table);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		//ToDo
		session.getTransaction().commit();
		return "bandsearch";

	}
	
	/**********************複数選択の削除の処理ここから**************************************/
	
	
	//deleteメソッド。削除するときの処理
	public String delete() {
		this.delete_id = (String)this.sessionMap.get("delete_id");
		
		//複数選択の削除のために文字列の分割
		String str = new String(this.delete_id);
		String[] strAry = str.split(",");
		
		if (this.delete_id.isEmpty()) {
			return "bandsearch";
		}
		//for文で処理を繰り返す
		for(int i = 0; i < strAry.length; i++){
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションを開始
		session.beginTransaction();
		try {
			BandAccount bandaccount = (BandAccount) session.load(BandAccount.class, strAry[i]);
			BandTable bandtable = (BandTable) session.load(BandTable.class,strAry[i]);
			session.delete(bandaccount); //band_accountテーブルの選択された行を削除
			session.delete(bandtable); //band_tableテーブルの選択された行を削除
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();//
		}
		return "bandsearch";
		
	}

	
	/**************************複数選択の削除の処理ここまで*******************************/
	

}
