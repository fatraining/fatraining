package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.GroupName;
import training2016.model.Iventcontents;

public class HpiventDao extends AbstractDao{

	/*検索結果の表示  nullの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Iventcontents> resultList(){
		//検索結果用の変数
		List<Iventcontents> resultTable = null;
		//DB接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {g.*},{i.*} FROM groupname g, iventcontents i";
		String where1 = "WHERE g.GroupID = i.GroupID";
		String sql = select + " " + where1;

		try{
			resultTable = session.createSQLQuery(sql).addEntity("g",GroupName.class).addEntity("i",Iventcontents.class)
					.list();

		} catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/*検索結果の表示  条件ありの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Iventcontents> resultList(String groupName, String category, String iventName, String place, String day1, String day2, String comment){
		// SQLの検索結果用の変数
		List<Iventcontents> resultTable = null;
		//DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {g.*},{i.*} FROM groupname g, iventcontents i";
			String where1 = "WHERE g.GroupID = i.GroupID"	;
			String where2 = "";
			if(!StringUtils.isEmpty(groupName)) {
				where2 += " AND (g.GroupName LIKE '%" + groupName + "%' )";
			}
			if(!StringUtils.isEmpty(category)) {
				where2 += " AND (i.Category LIKE '%" + category + "%' )";
			}
			if(!StringUtils.isEmpty(iventName)) {
				where2 += " AND (i.IventName LIKE '%" + iventName + "%' )";
			}
			if(!StringUtils.isEmpty(place)) {
				where2 += " AND (i.Place LIKE '%" + place + "%' )";
			}
			if(!StringUtils.isEmpty(comment)) {
				where2 += " AND (i.Comment LIKE '%" + comment + "%' )";
			}
			if(!StringUtils.isEmpty(day1)) {
				where2 += " AND i.Day >= " + day1 + "* 100";
			}
			if(!StringUtils.isEmpty(day2)) {
				where2 += " AND i.Day <= " + day2 + "* 100";
			}

			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2 + ";").addEntity("g", GroupName.class)
					.addEntity("i",Iventcontents.class).list();
		} catch (Exception e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//追加画面のグループ名リスト取得 //
	/*------------------------------------------------------*/
	public List<?> getGroupnameList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM groupname")
					// Resultテーブルにsql文を代入する
					.addEntity("groupName" , GroupName.class).list();
		} catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
	//追加時の接続//
	/*------------------------------------------------------*/
	public void insert(String ID,String groupID, String category, String iventName, String place, String day, String comment){
		//データベースデータベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();
		Iventcontents i = new Iventcontents();
		i.setID(ID);
		i.setGroupID(groupID);
		i.setIventName(iventName);
		i.setCategory(category);
		i.setPlace(place);
		i.setDay(day);
		i.setComment(comment);

		try {
			session.save(i);
		} catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}

	//削除時の接続//
	/*------------------------------------------------------*/
	public void delete(String delete) {

		// 分割
		String[] strAry = delete.split(",");

		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int j = 0; j < strAry.length; j++) {

			try {
				// load = 主キーの検索
				Iventcontents ivent = (Iventcontents) session.load(Iventcontents.class, strAry[j]);
				session.delete(ivent);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("ハイバネエラ");
			}
		}
		//トランザクションの終了
		session.getTransaction().commit();
	}
}