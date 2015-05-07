package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.Story;
import model.Tb_Genre;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.StoryManager;

@Result(name = "main3", value = "main3.action", type = ServletRedirectResult.class)
public class Update3Action extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	
	//入力項目
	public String title; //タイトル
	public String genre; //ジャンル
	
	//表示項目（削除画面）
	public String delete_id;
	
	//画面が表示時に実行
	public String execute() throws Exception {
		//削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");
		
		//初期値の設定
		this.title = "黒い家";
		this.genre = "ホラー";

		return "success";
	}
	
	//追加ボタンを押下時
	public String insert() {
		
		// 登録、更新日時設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String day = String.valueOf(sdf.format(date));
		String newday = String.valueOf(sdf.format(date));
		
		// 登録更新ID設定
		String userid = (String) this.sessionMap.get("userId");
		String newuserid = (String) this.sessionMap.get("userId");
		
		// インスタンス化
		Tb_Genre ｔbGenre = new Tb_Genre();
		ｔbGenre.setGenre(this.genre); //ジャンル
		ｔbGenre.setSignup(day); //登録日付
		ｔbGenre.setUpdateDate(newday); //更新日付
		ｔbGenre.setSignupUSERID(userid); //登録ユーザID
		ｔbGenre.setUpdateUSERID(newuserid); //更新ユーザID
		ｔbGenre.setExclusiveFLG(0); //排他フラグ
		ｔbGenre.setdeleteFLG(0); //削除フラグ
		
		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();
		
		// Tb_Genreテーブルに追加
		try {
			session.save(ｔbGenre);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// Tb_Genreテーブルのデータ検索
		StoryManager linkController  = new StoryManager();
		Tb_Genre tmpTbGenre = linkController.tb_GenreList();
		
		Story insert_story_table = new Story();
		insert_story_table.setTitle(this.title); //タイトル
		insert_story_table.setGenre_id(tmpTbGenre.getId()); //ジャンル
		insert_story_table.setSignup(day); //登録日付
		insert_story_table.setUpdateDate(newday); //更新日付
		insert_story_table.setSignupUSERID(userid); //登録ユーザID
		insert_story_table.setUpdateUSERID(newuserid); //更新ユーザID
		insert_story_table.setExclusiveFLG(0); //排他フラグ
		insert_story_table.setdeleteFLG(0); //削除フラグ
		
		try {
			session.save(insert_story_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		
		return "main3";
	}
	
	//デリートのメソッド
	public String delete() {
//		this.update_id = (String) this.sessionMap.get("update_id");
//		if (this.update_id.isEmpty()) {
//			return "main3";
//		}
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		try {
//			Story story = (Story) session.load(Story.class,
//					Integer.valueOf(update_id));
//			Tb_Genre tb_genre = (Tb_Genre) session.load(Tb_Genre.class,
//					Integer.valueOf(update_id));
//			session.delete(story);
//			session.delete(tb_genre);
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		session.getTransaction().commit();
		return "main3";
	}
	//
	//
	// private static boolean checkCharacterCode(String str, String encoding) {
	// if (str == null) {
	// return true;
	// }
	//
	// try {
	// byte[] bytes = str.getBytes(encoding);
	// return str.equals(new String(bytes, encoding));
	// } catch (UnsupportedEncodingException ex) {
	// throw new
	// RuntimeException("�ｿｽG�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽﾌゑｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾜゑｿｽ�ｿｽ�ｿｽB",
	// ex);
	// }
}
