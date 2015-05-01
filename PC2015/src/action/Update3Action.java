package action;

import model.Story;
import model.Tb_Genre;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;

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
	
	
	
	
	
	
	
	
	
	
//	
//
//	public int genre_id;
//	// public String signup;
//	// public String update;
//	// public String signupUSERID;
//	// public String updateUSERID;
//	// public String exclusiveFLG;
//	// public String deleteFLG;
//	public String do_print;
//	public String update_id;
//	public String errormsg;



	//インサートのメソッド
	public String insert() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		Tb_Genre insert_genre_table = new Tb_Genre();
//		Story insert_story_table = new Story();
//		insert_genre_table.setGenre(this.genre);
//		insert_story_table.setTitle(this.title);
//		insert_story_table.setGenre_id(this.genre_id);
//		// insert_story_table.setSignup(this.signup);
//		// insert_story_table.setUpdate(this.update);
//		// insert_story_table.setSignupUSERID(this.signupUSERID);
//		// insert_story_table.setUpdateUSERID(this.updateUSERID);
//		// insert_story_table.setExclusiveFLG(this.exclusiveFLG);
//		// insert_story_table.setdeleteFLG(this.deleteFLG);
//		//
//		// String[] data =
//		// {this.update_id,this.title,this.genre,this.signup,this.update,this.signupUSERID,this.updateUSERID,this.exclusiveFLG,this.deleteFLG};
//		// int i=0;
//		// for(String temp : data){
//		// if(temp.length()>50){
//		// this.errormsg =
//		// "50�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾈ会ｿｽ�ｿｽﾅ難ｿｽ�ｿｽﾍゑｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ";
//		// return "error";
//		// }
//		// if(temp.length()<1)i++;
//		// if(i>14){
//		// this.errormsg = "�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾍは登�ｿｽ^�ｿｽﾅゑｿｽ�ｿｽﾜゑｿｽ�ｿｽ�ｿｽ";
//		// return "error";
//		// }
//
//		try {
//			session.save(insert_story_table);
//			session.save(insert_genre_table);
//
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//
//		// }
//		session.getTransaction().commit();
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
