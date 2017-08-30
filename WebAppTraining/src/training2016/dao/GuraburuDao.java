package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.GuraburuCharacter;
import training2016.model.GuraburuRace;

public class GuraburuDao extends AbstractDao {

	/*------------------------------------------------*/
	// 種族取得
	/*------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<GuraburuRace> getRaceList() {
		//検索結果変数
		List<GuraburuRace> resultTable = null;
		//DB接続
		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM guraburu_race")
					//resultテーブルにSQLを入れる
					.addEntity("guraburu_race",GuraburuRace.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}
	/*------------------------------------------------*/
	// 検索結果（null）
	/*------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<GuraburuCharacter> guraburuList() {
		List<GuraburuCharacter> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {c.*},{r.*} FROM Guraburu_Character_info c, Guraburu_Race r";
		String where1 = "WHERE c.raceId = r.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("c",GuraburuCharacter.class)
					.addEntity("r",GuraburuRace.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}
	/*------------------------------------------------*/
	// 検索結果（条件あり）
	/*------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<GuraburuCharacter> resultList(String name,String sex,String attribute,String race) {
		List<GuraburuCharacter> resultTable = null;

		Session session = this.getCurrentSession();
		try {
			session.beginTransaction();
			String select = "SELECT {c.*},{r.*} FROM Guraburu_Character_info c, Guraburu_Race r";
			String where1 = "WHERE c.raceId = r.id";
			String where2 = "";

			if(!StringUtils.isEmpty(name)) {
				where2 += "AND (c.name LIKE '%" + name + "%' )";
			}
			if(!StringUtils.isEmpty(sex)) {
				where2 += "AND(c.sex = '" + sex + "')";
			}
			if(!StringUtils.isEmpty(attribute)) {
				where2 += "AND(c.attribute = '" + attribute + "' )";
			}
			if(!StringUtils.isEmpty(race)) {
				where2 += "AND(r.id = " + race + ")";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql)
					.addEntity("c",GuraburuCharacter.class)
					.addEntity("r",GuraburuRace.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}
	/*------------------------------------------------*/
	//追加の実行
	/*------------------------------------------------*/
	public void insert(String name, String sex, String attribute, String raceId,String dataUrl, String comment) {
		Session session = this.getCurrentSession();

		session.beginTransaction();

		GuraburuCharacter c  = new GuraburuCharacter();
		//idはオートインクリメントで自動に設定
		c.setName(name);
		c.setSex(sex);
		c.setAttribute(attribute);
		c.setRaceId(Integer.parseInt(raceId));
		c.setDataUrl(dataUrl);
		c.setComment(comment);

		try {
			session.save(c);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
	/*------------------------------------------------*/
	//更新の実行
	/*------------------------------------------------*/
	public void update(GuraburuCharacter model) {
		Session session = this.getCurrentSession();

		session.beginTransaction();

		try {
			session.update(model);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
	/*------------------------------------------------*/
	//削除表示
	/*------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<GuraburuCharacter> selectForDelete(String[] deleteId){
		List<GuraburuCharacter> resultTable = null;
		Session session = this.getCurrentSession();

		session.beginTransaction();

		String select = "SELECT {c.*},{r.*} FROM Guraburu_Character_info c, Guraburu_Race r";
		String where1 = "WHERE c.raceId = r.id";
		String where2 = "AND c.id in(";

		for(int i = 0; i < deleteId.length; i++) {
			if(i > 0) {
				//２個目以降の削除IDの指定でカンマをいれる
				where2 += ",";
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("c",GuraburuCharacter.class)
					.addEntity("r",GuraburuRace.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}
	/*------------------------------------------------*/
	//削除実行
	/*------------------------------------------------*/
	public void delete(String delete) {
		Session session = this.getCurrentSession();
		//削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		String[] deleteId = delete.split(", ");

		session.beginTransaction();

		for(int i = 0; i < deleteId.length; i++) {
			System.out.println("aaa");
			System.out.println(deleteId[i]);
			int id = Integer.parseInt(deleteId[i].trim());
			System.out.println(id);
			try {
				GuraburuCharacter guraburuCharacter = (GuraburuCharacter) session.load(GuraburuCharacter.class, id);
				session.delete(guraburuCharacter);
			} catch(Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		}
		session.getTransaction().commit();
	}


}
