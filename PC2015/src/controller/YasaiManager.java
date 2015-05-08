package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.BandAccount;
import model.BandTable;
import model.CoofTa;
import model.LiofTa;
import model.Ryouri;
import model.Yasai;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import action.AbstractAction;
import action.YasaiAddAction;

public class YasaiManager extends HibernateUtil {

	// 何も入力されなかったときのメソッド
	public List<?> resultList() {
		List<?> resultTable = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 野菜と料理テーブルを全件検索
		String select = "SELECT * FROM yasai y,ryouri r";

		// 野菜テーブルの調理idと料理テーブルのidが一緒という条件
		String where1 = "WHERE y.tyouriId=r.id";

		// select文とwhere文あわせたものをsqlに代入
		String sql = select + " " + where1;

		try {
			// SQLが実行され、結果がresultTableに代入される
			resultTable = session.createSQLQuery(sql)
					.addEntity("Yasai", Yasai.class)
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}

	// yasaiが入力された場合のメソッド
	public List<?> resultList(String yasai) {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {

			String select = "SELECT * FROM yasai y,ryouri r";
			String where1 = "WHERE y.tyouriId=r.id";

			// 野菜の文字列を検索(部分一致)
			String where2 = "AND y.yasai LIKE '%" + yasai + "%'";

			// selectとwhere1,where2をつなげたものをsqlに代入
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("Yasai", Yasai.class)
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}

	// 料理テーブル検索用のメソッド
	public Ryouri ryouriList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			// 料理テーブルの全件検索
			String sql = "SELECT * FROM ryouri r";
			resultTable = session.createSQLQuery(sql)
			// session.createSQLQuery(sql)の戻り値をRyouriクラスに渡している
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// resultTableの最終行を取得
		// 自分で入力したものを取得したいため、最終行
		return (Ryouri) resultTable.get(resultTable.size() - 1);
	}

	public void insert(String yasai, String tyouri, String ryouri, String userId) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String date_entry = String.valueOf(sdf.format(date));
		String date_up = String.valueOf(sdf.format(date));

		// 料理のデータ作成
		Ryouri insert_ryouri_table = new Ryouri();

		insert_ryouri_table.setRyouri(ryouri);
		insert_ryouri_table.setTyouri(tyouri);
		insert_ryouri_table.setDate_Entry(date_entry);
		insert_ryouri_table.setDate_Up(date_up);
		insert_ryouri_table.setUserId(userId);

		// 料理テーブルに追加
		try {
			session.save(insert_ryouri_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// 料理テーブルのデータ検索
		YasaiManager yasaimanager = new YasaiManager();
		insert_ryouri_table = yasaimanager.ryouriList();

		// 野菜データの作成
		Yasai insert_yasai_table = new Yasai();
		insert_yasai_table.setYasai(yasai);

		// 料理テーブルのid取得し、野菜テーブルの調理idに代入
		insert_yasai_table.setTyouriId(insert_ryouri_table.getId());
		insert_yasai_table.setDate_Entry(date_entry);
		insert_yasai_table.setDate_Up(date_up);
		insert_yasai_table.setUserId(userId);

		// 野菜テーブルに追加
		try {
			session.save(insert_yasai_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();

	}

	// 検索結果内の値を削除
	public void delete(String delete_id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 複数選択の削除のために文字列の分割
		String[] strAry = delete_id.split(",");

		for (int i = 0; i < strAry.length; i++) {

			try {
				Yasai yasai = (Yasai) session.load(Yasai.class, strAry[i]);
				Ryouri ryouri = (Ryouri) session.load(Ryouri.class,
						yasai.getTyouriId());
				session.delete(yasai);
				session.delete(ryouri);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		}
		session.getTransaction().commit();
	}
}
