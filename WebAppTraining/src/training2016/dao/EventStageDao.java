package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.EventArea;
import training2016.model.EventStage;

public class EventStageDao extends AbstractDao {


//追加画面のエリア取得
	@SuppressWarnings("unchecked")		//エリアプルダウンに項目を作るためにareaなのかな
	public List<EventArea> getEventAreaList() {
	//検索結果変数
		List<EventArea> resultTable = null;
	//DB接続
		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM eventarea")
				//resultテーブルにSQLを入れる
					.addEntity("eventarea",EventArea.class)	.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}


//検索結果(null)
	@SuppressWarnings("unchecked")
	public List<EventStage> resultList() {
	// SQLの検索結果用変数
	List<EventStage> resultTable = null;
	// DB接続
	Session session = this.getCurrentSession();
	//トランザクション（複数の処理を連結した処理）の開始
	session.beginTransaction();

	String select = "SELECT {s.*},{a.*} FROM eventstage s, eventarea a";
	String where1 = "WHERE s.areaID = a.ID";
	String sql = select + " " + where1;
	try {
		resultTable = session.createSQLQuery(sql)
				.addEntity("a", EventArea.class)
				.addEntity("s", EventStage.class).list();
	} catch (Exception e) {
		e.printStackTrace();
		session.getTransaction().rollback();
		System.out.println("停止");
	}
	session.getTransaction().commit();
	return resultTable;
}



//検索結果(条件あり)
	@SuppressWarnings("unchecked")
	public List<EventStage> resultList(String areaID, String record, String name) {
		List<EventStage> resultTable = null;

		Session session = this.getCurrentSession();

	try {
		session.beginTransaction();
		String select = "SELECT {s.*},{a.*} FROM eventstage s, eventarea a";
		String where1 = "WHERE s.areaID = a.ID";
		String where2 = "";

		if (!StringUtils.isEmpty(areaID)) {
			where2 += "AND(a.id =" + areaID + ")";
		}
		if (!StringUtils.isEmpty(record)) {
			where2 += " AND(s.record LIKE '%" + record + "%')";
		}
		if (!StringUtils.isEmpty(name)) {
			where2 += " AND(s.name LIKE '%" + name + "%')";
		}

		resultTable = session.createSQLQuery(select + " " + where1 + " " + where2)
				.addEntity("a", EventArea.class)
				.addEntity("s", EventStage.class)
				.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}



//削除対象のレコードを取得する
	@SuppressWarnings("unchecked")
	public List<EventStage> selectForDelete(String[] deleteId) {
		List<EventStage> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {s.*},{a.*} FROM eventstage s, eventarea a";
		String where1 = "WHERE s.areaID = a.ID";
		String where2 = "AND s.ID in (";    //ANDが抜けてた
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += " , ";   //2個目からカンマ区切りにするｓ
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql)
					.addEntity("a", EventArea.class)
					.addEntity("s", EventStage.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return resultList;
	}



//削除
	public void delete(String delete) {
	//文字列を分割
		String[] strAry = delete.split(",");
	// データベースに接続
		Session session = this.getCurrentSession();
	// トランザクション開始
		session.beginTransaction();

		for (int i = 0; i < strAry.length; i++) {
			try {
			//主キーの検索
				EventStage Stage = (EventStage) session.load(EventStage.class, Integer.parseInt(strAry[i].trim()));
				session.delete(Stage);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("削除");
			}
		}
	// トランザクションの終了
		session.getTransaction().commit();
	}



//追加時の接続
	public void insert(
			String ID,
			String name,
			String station,
			String record,
			String comment,
			String areaID) {

		Session session = this.getCurrentSession();
		session.beginTransaction();


		EventStage s = new EventStage();
//		s.setID(Integer.parseInt(ID));
		s.setName(name);
		s.setStation(station);
		s.setRecord(record);
		s.setComment(comment);
		s.setAreaID(Integer.parseInt(areaID));

		try {
			session.save(s);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}


//更新時の接続
/** @param  */
	public void update(EventStage model) {

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



}
