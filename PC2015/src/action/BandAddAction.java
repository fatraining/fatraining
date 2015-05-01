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
import controller.BandAllManager;

@Result(name = "bandsearch", value = "bandSearch.action", type = ServletRedirectResult.class)
public class BandAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	//フィールドの宣言
	public String delete_id; //update_idからdelete_idに変更
	public String name; //名前に関する変数nameを宣言
	public String sex; //性別に関する変数sexを宣言
	public String age; //年齢に関する変数ageを宣言
	public String school; //出身校に関する変数schoolを宣言
	public String favorite_song; //好きな曲に関する変数favorite_songを宣言
	public String part; //演奏楽器に関する変数partを宣言
	public int band_id;//テーブル結合の時に必要なBAND_IDに関する変数band_idを宣言
	//public String entry_date; //登録日付に関する変数entry_dateを宣言
	//public String renewal_date; //更新日付に関する変数renewal_dateを宣言
	//public String entry_userid; //登録useridに関する変数entry_useridを宣言
	//public String renewal_userid; //更新useridに関する変数renewal_useridを宣言
	public int exclusion_flg; //更新FLGに関する変数exclusion_flgを宣言
	public int delete_flg; //削除FLGに関する変数delete_flgを宣言
	public String band_name; //バンド名に関する変数band_nameを宣言
	
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
		String entry_date = String.valueOf(sdf.format(date));
		String renewal_date = String.valueOf(sdf.format(date));
		
		//登録useridにuserIdの値を入れる。
		String entry_userid = (String)this.sessionMap.get("userId");
		//更新useridにuserIdの値を入れる。
		String renewal_userid = (String)this.sessionMap.get("userId");
		
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションを開始
		session.beginTransaction();

		//インスタンス化。band_tableのデータ作成
		BandTable insert_band_table = new BandTable();
		insert_band_table.setBand_name(this.band_name);
		insert_band_table.setEntry_date(entry_date);
		insert_band_table.setRenewal_date(renewal_date);
		insert_band_table.setEntry_userid(entry_userid);
		insert_band_table.setRenewal_userid(renewal_userid);
		
		//band_tableテーブルに追加
		try{
			session.save(insert_band_table);
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//band_tableテーブルのデータ検索
		BandAllManager bandAllManager = new BandAllManager();
		insert_band_table = bandAllManager.bandTableList();
		
		//band_accountデータの作成
		BandAccount insert_band_account = new BandAccount();
		insert_band_account.setName(this.name);
		insert_band_account.setSex(this.sex);
		insert_band_account.setAge(this.age);
		insert_band_account.setSchool(this.school);
		insert_band_account.setFavorite_song(this.favorite_song);
		insert_band_account.setPart(this.part);
		//band_tableテーブルのIDを取得し、band_accountテーブルのBAND_IDに代入
		insert_band_account.setBand_id(insert_band_table.getId());
		insert_band_account.setEntry_date(entry_date);
		insert_band_account.setRenewal_date(renewal_date);
		insert_band_account.setEntry_userid(entry_userid);
		insert_band_account.setRenewal_userid(renewal_userid);

			//band_accountテーブルに追加
			try {
				session.save(insert_band_account);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

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
