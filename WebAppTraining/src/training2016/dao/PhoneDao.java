package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Operator;
import training2016.model.Phones;

public class PhoneDao extends AbstractDao {

	/*検索結果の表示  nullの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Phones> resultList() {
		// 検索結果用の変数
		List<Phones> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {o.*},{p.*} FROM operator o, phones p";
		String where1 = "WHERE o.OperatorID = p.OperatorID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("o", Operator.class).addEntity("p", Phones.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/*検索結果の表示  条件ありの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Phones> resultList(String operatorName, String phoneName, String priceLow, String priceHi) {
		// SQLの検索結果用の変数
		List<Phones> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {o.*},{p.*} FROM operator o, phones p";
			String where1 = "WHERE o.OperatorID = p.OperatorID";
			String where2 = "";
			if (!StringUtils.isEmpty(operatorName)) {
				where2 += "AND (o.OperatorName LIKE '%" + operatorName + "%' )";
			}
			if (!StringUtils.isEmpty(phoneName)) {
				where2 += " AND (p.PhonesName LIKE '%" + phoneName + "%' )";
			}
			if (!StringUtils.isEmpty(priceLow)) {
				where2 += " AND p.Price >= " + priceLow;
			}
			if (!StringUtils.isEmpty(priceHi)) {
				where2 += " AND p.Price <= " + priceHi + ";";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2).addEntity("o", Operator.class)
					.addEntity("p", Phones.class).list();
		} catch (Exception e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//追加画面の事業者リスト取得 //
	/*------------------------------------------------------*/
	public List<?> getOperatorList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM operator")
					// Resultテーブルにsql文を代入する。
					.addEntity("operator", Operator.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//追加時の接続//
	/*------------------------------------------------------*/
	public void insert(String ID ,String operatorID, String phoneName, int price, String size, String date, String comment) {
		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();
		Phones p = new Phones();
		p.setID(ID);
		p.setOperatorID(operatorID);
		p.setPhoneName(phoneName);
		p.setPrice(price);
		p.setSize(Double.parseDouble(size));
		p.setDate(date);
		p.setComment(comment);

		try {
			session.save(p);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}


	//削除時の接続 //
	/*------------------------------------------------------*/
	public void delete(String delete) {

		// 分割
		String[] strAry = delete.split(",");

		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				Phones phone = (Phones) session.load(Phones.class,strAry[i]);
				session.delete(phone);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("ハイバネエラ");
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
}
