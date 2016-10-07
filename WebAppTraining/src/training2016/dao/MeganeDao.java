package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Megane;
import training2016.model.MeganeArea;

public class MeganeDao extends AbstractDao {

	/**
	 * 検索結果(null)
	 */

	// トランザクションとは一連の作業を全体として一つの処理として管理する

	@SuppressWarnings("unchecked") // エラー抑制
	public List<Megane> meganeList() {
		List<Megane> resultTable = null;
		Session session = this.getCurrentSession();// カレントは操作対象
		session.beginTransaction();// データ ソースでトランザクションを開始します。

		String select = "SELECT {a.*},{aa.*} FROM Megane a,MeganeArea aa";
		String where1 = "WHERE a.meganeAreaId = aa.id";
		String sql = select + " " + where1;//離すため

		/** インターフェースのインスタンス取得 */
		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Megane.class).addEntity("aa", MeganeArea.class)// addEntityはそれぞれの名前の設定
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();// ロールバック、トランザクションを停止してまっさらな状態に戻す
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 *
	 * 検索結果(条件あり)
	 */

	@SuppressWarnings("unchecked") // エラー抑制
	public List<Megane> resultList(String meganeAreaId, String name) {
		List<Megane> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Megane a, MeganeArea aa";
			String where1 = "WHERE a.meganeAreaId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(meganeAreaId)) {
				// LIKE＝～を含む
				where2 += "AND (aa.id = " + meganeAreaId + " )";
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Megane.class).addEntity("aa", MeganeArea.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 追加画面のエリア取得
	 *
	 */

	@SuppressWarnings("unchecked") // エラー抑制
	public List<MeganeArea> getMeganeAreaList() {
		// SQLの検索結果変数
		List<MeganeArea> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始 1つの作業単位
			session.beginTransaction();
			// SQL実行
			resultTable = session.createSQLQuery("SELECT * FROM MeganeArea")
					// ReasultTableにSQL文をいれる
					// メガネのリストを取得
					.addEntity("MeganeArea", MeganeArea.class).list();
		} catch (Exception e) {
			// 例外が投げられた理由を取得
			e.printStackTrace();
			// 元のエラーの無い状態に戻す
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 追加・更新時の接続
	 *
	 * @param model
	 */

	public void update(Megane model) {
		// this.apply(model, (s, m) -> {s.update(m);});

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

	/**
	 * IDをキーにして削除対象のレコードを取得する
	 *
	 * @param deleteId
	 * @return resultList
	 */
	@SuppressWarnings("unchecked")
	public List<Megane> selectForDelete(String[] deleteId) {
		List<Megane> resultList = null;
		Session session = this.getCurrentSession();//対象となるセッション
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Megane a, MeganeArea aa";
		String where1 = "WHERE a.meganeAreaId = aa.id";
		String where2 = "AND a.id in (";
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) { //あった場合
				where2 += " , "; // 2個目からカンマ区切りにする
			}
			/**選択されたデリートID*/
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).addEntity("a", Megane.class).addEntity("aa", MeganeArea.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return resultList;
	}

	/**
	 * 削除時の接続
	 *
	 */
	public void delete(String delete) {
		// 文字列を分割する
		String[] strAry = delete.split(",");

		Session session = this.getCurrentSession();
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				//配列をINT型にする
				Megane megane = (Megane) session.load(Megane.class, Integer.parseInt(strAry[i].trim()));
				session.delete(megane);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

	/**
	 * IDをキーにして購入対象のレコードを取得する
	 *
	 *
	 */

	@SuppressWarnings("unchecked") // エラー抑制
	public List<Megane> selectForPurchase(String[] purchaseID) {
		List<Megane> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Megane a, MeganeArea aa";
		String where1 = "WHERE a.meganeAreaID = aa.id";
		String where2 = "AND a.id in (";// 括弧の片割れはもう少し下にあるよ
		for (int i = 0; i < purchaseID.length; i++) {
			if (i > 0) {
				where2 += " , ";
			}
			where2 += purchaseID[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).addEntity("a", Megane.class).addEntity("aa", MeganeArea.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultList;
	}

	// insertはデータベースからデータを挿入する文
	public void insert(String id, String meganeAreaId, String name, String color, String kingaku, String link,
			String syousai, String gazou) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Megane a = new Megane();
		// idはオートインクリメント(自動的に連番の値が格納されていく）なのでなくて大丈夫
		a.setMeganeAreaId(Integer.parseInt(meganeAreaId));
		a.setName(name);
		a.setColor(color);
		a.setLink(link);
		a.setKingaku(kingaku);
		a.setSyousai(syousai);
		a.setGazou(gazou);

		try {
			session.save(a);// saveは永続化データ挿入
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

	}

}
