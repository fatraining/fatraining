package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.GuitarInfo;
import training2016.model.GuitarMaker;


public class GuitarDao extends AbstractDao {

//検索結果の表示：nullの場合
	@SuppressWarnings("unchecked")
	public List<GuitarInfo>resultList(){
		//検索結果用の変数
		List<GuitarInfo> resultTable = null;
		//DB接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {gm.*},{gi.*} FROM guitarMaker gm,guitarInfo gi";
		String where1 = "WHERE gm.Id = gi.guitarMakerId";
		String sql = select + " " + where1;

		try{
			resultTable = session.createSQLQuery(sql).addEntity("gm",GuitarMaker.class)
					.addEntity("gi",GuitarInfo.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}
	//検索結果の表示、条件ありの場合
	@SuppressWarnings("unchecked")
	public List<GuitarInfo> resultList(String name , String typeName , String priceLow , String priceHi) {
		//SQLの検索結果用の変数
		List<GuitarInfo>resultTable = null;

		Session session = this.getCurrentSession();
		try{
			//トランザクション開始
			session.beginTransaction();
			String select = "SELECT {gm.*},{gi.*} FROM guitarMaker gm ,guitarInfo gi ";
			String where1 = "WHERE gm.id = gi.guitarMakerId";
			String where2 = "";
			if(!StringUtils.isEmpty(name)){
				where2 += "AND (gm.id = " + name + ")";
			}
			if(!StringUtils.isEmpty(typeName)){
				where2 += "AND (gi.typeName LIKE '%" + typeName + "%')";
			}
			if (!StringUtils.isEmpty(priceLow)) {
				where2 += " AND gi.price >= " + priceLow;
			}
			if (!StringUtils.isEmpty(priceHi)) {
				where2 += " AND gi.price <= " + priceHi + ";";
			}
			resultTable = session.createSQLQuery(select + " "+ where1 + " " + where2).addEntity("gm",GuitarMaker.class)
					.addEntity("gi",GuitarInfo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
	//検索画面のメーカー名リスト取得
	public List<?> getNameList(){
		List<?> resultTable = null;

		Session session = this.getCurrentSession();
		try{
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM guitarMaker")
					.addEntity("name" , GuitarMaker.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
//	追加時の接続
	public void insert(String id , String guitarMakerId , String typeName , int price , String comment){
		Session session = this.getCurrentSession();

		session.beginTransaction();
		GuitarInfo gi = new GuitarInfo();
		gi.setId(id);
		gi.setGuitarMakerId(guitarMakerId);
		gi.setTypeName(typeName);
		gi.setPrice(price);
		gi.setComment(comment);

		try{
			session.save(gi);
		}catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	//削除時の接続
	public void delete(String delete) {

		String[] strAry = delete.split(",");
		Session session = this.getCurrentSession();
		session.beginTransaction();

		for(int i = 0 ; i < strAry.length ; i++){
			try{
				//主キーの検索
				GuitarInfo gi = (GuitarInfo)session.load(GuitarInfo.class,strAry[i]);
				session.delete(gi);
			}catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("ハイバネエラー");
			}
		}
		session.getTransaction().commit();
	}
}
