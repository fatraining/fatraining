package action;

import model.Story;
import model.Genre;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.TaskUtil;

@Result(name = "main", value = "main.action", type = ServletRedirectResult.class)
public class Update3Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String update_Id;
	public String title;
	public String genre;
	public int genre_id;
//	public String signup;
//	public String update;
//	public String signupUSERID;
//	public String updateUSERID;
//	public String exclusiveFLG;
//    public String deleteFLG;
    public String do_print;
	public String update_id;
	public String errormsg;

	public String execute() throws Exception {
		this.update_id = (String)this.sessionMap.get("update_id");



		return "success";
	}

	public String insert(){
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Genre insert_genre_table = new Genre();
		Story insert_story_table = new Story();
		insert_genre_table.setGenre(this.genre);
		insert_story_table.setTitle(this.title);
		insert_story_table.setGenre_id(this.genre_id);
//		insert_story_table.setSignup(this.signup);
//		insert_story_table.setUpdate(this.update);
//		insert_story_table.setSignupUSERID(this.signupUSERID);
//		insert_story_table.setUpdateUSERID(this.updateUSERID);
//		insert_story_table.setExclusiveFLG(this.exclusiveFLG);
//		insert_story_table.setdeleteFLG(this.deleteFLG);
//		
//		String[] data = {this.update_id,this.title,this.genre,this.signup,this.update,this.signupUSERID,this.updateUSERID,this.exclusiveFLG,this.deleteFLG};
//		int i=0;
//		for(String temp : data){
//			if(temp.length()>50){
//				this.errormsg = "50文字以下で入力してください";
//				return "error";
//			}
//			if(temp.length()<1)i++;
//			if(i>14){
//				this.errormsg = "未入力は登録できません";
//				return "error";
//			}

			try{
				session.save(insert_story_table);
				session.save(insert_genre_table);

			}catch(HibernateException e){
				e.printStackTrace();
				session.getTransaction().rollback();
			}

//		}
		session.getTransaction().commit();
		return "main";

	}
	public String delete() {
		this.update_id = (String)this.sessionMap.get("update_id");
		if(this.update_id.isEmpty()){
			return "main";
		}
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Story detailpc = (Story)session.load(Story.class, update_id);
			Genre idpc = (Genre) session.load(Genre.class, update_id);
			session.delete(detailpc);
			session.delete(idpc);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "main";
	}
//	
//	
//	private static boolean checkCharacterCode(String str, String encoding) {
//		if (str == null) {
//			return true;
//		}
//
//		try {
//			byte[] bytes = str.getBytes(encoding);
//			return str.equals(new String(bytes, encoding));
//		} catch (UnsupportedEncodingException ex) {
//			throw new RuntimeException("エンコード名称が正しくありません。", ex);
//		}
	}
