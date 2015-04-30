package action;

//import java.io.UnsupportedEncodingException;

import model.DetailEat;
import model.IDofEat; //モデルのインポート

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

	public String eatFood; //食べ物名
	public String eatCalory; //カロリー
	public String eat_year; //年
	public String eat_month; //月
	public String eat_day; //日
	public String eat_hour; //時間
	public String entry_day; //登録日付
	public String renew_day; //更新日付
	public String entry_userid; //登録userID
	public String renew_userid; //更新userID
	public String delete_id; // 削除に使うレコードのID

	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}
	
	//追加の処理
	public String insert() {
		//日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		entry_day = String.valueOf(sdf.format(date));
		renew_day = String.valueOf(sdf.format(date));
			
		//登録、更新UAER表示
		this.entry_userid = (String) this.sessionMap.get("userId");
		this.renew_userid = (String) this.sessionMap.get("userId");
		
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();

		//インスタンス化
		DetailEat insert_detail_table = new DetailEat();
		IDofEat insert_id_table = new IDofEat();
		insert_detail_table.setEat_year(this.eat_year);
		insert_detail_table.setEat_month(this.eat_month);
		insert_detail_table.setEat_day(this.eat_day);
		insert_detail_table.setEat_hour(this.eat_hour);
		insert_detail_table.setEntry_day(this.entry_day);
		insert_detail_table.setRenew_day(this.renew_day);
		insert_detail_table.setEntry_userid(this.entry_userid);
		insert_detail_table.setRenew_userid(this.renew_userid);
		insert_id_table.setEatFood(this.eatFood);
		insert_id_table.setEatCalory(this.eatCalory);
		insert_id_table.setEntry_day(this.entry_day);
		insert_id_table.setRenew_day(this.renew_day);
		insert_id_table.setEntry_userid(this.entry_userid);
		insert_id_table.setRenew_userid(this.renew_userid);

		
		try {
			session.save(insert_detail_table);
			session.save(insert_id_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}//todo

		session.getTransaction().commit();  //todo(データベースに処理結果を反映させる？)
		return "main10";  
	}
	
	//検索結果内の値の削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");//セッションマップからdelete_idを取得
		//update_idが空である場合main10へ
		if (this.delete_id.isEmpty()) {
			return "main10";
		}
		
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();
		try {	
			DetailEat detaileat = (DetailEat) session.load(DetailEat.class,
					Integer.valueOf(delete_id));
			IDofEat idofeat = (IDofEat) session.load(IDofEat.class,
					Integer.valueOf(delete_id)); //todo(delete_idがStringでは処理できないのでキャストする)

//			DetailEat detaileat = (DetailEat) session.load(DetailEat.class, delete_id);
//			IDofEat idofeat = (IDofEat) session.load(IDofEat.class, delete_id);（キャストしていないもの）
			
			session.delete(detaileat); //引数を入れ、指定した行を削除する
			session.delete(idofeat); //引数を入れ、指定した行を削除する
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback(); //障害が起きたら障害が起きる前に戻る
		}
		session.getTransaction().commit();  //todo(削除してデータベースに処理結果を反映させる？)
		return "main10";
	}

}