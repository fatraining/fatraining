package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Chocolate;
import training2016.model.ChocolateCountry;

public class ChocolateDao extends AbstractDao{

	/**
	 *
	 * 追加画面のエリア取得
	 */



	@SuppressWarnings("unchecked")//プルダウンの項目を拾ってくる
	public List<ChocolateCountry> getChocolateCountryList() {
		// SQLの検索結果変数
		List<ChocolateCountry> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession(); //sessionを取得してDBに接続
		try {
			// トランザクション(正常に完了しない場合、各アクションで行われたすべての変更が取り消される)を開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM ChocolateCountry") //SQL実行 ここでは、countryのカラムを呼び出したいので、chocolateCountryを設定する。
					// ResultTableにsql文をいれる
					.addEntity("ChocolateCountry", ChocolateCountry.class).list(); //地域のリストを取得
		} catch (Exception e) {
			e.printStackTrace(); //例外が投げられた理由を簡単に取得できる
			session.getTransaction().rollback(); //ROLLBACK文を使用すると、現行のトランザクションで実行された処理を取り消すこができる
		}
		// トランザクション終了
		session.getTransaction().commit(); // commitは、トランザクションが全て正常に完結したという宣言。
		return resultTable;
	}


	/**
	 *
	 * 検索結果(null)
	 */
	@SuppressWarnings("unchecked")
	public List<Chocolate> chocolateList() {
		List<Chocolate> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Chocolate a, ChocolateCountry aa";
		String where1 = "WHERE a.countryId = aa.id";
		String sql = select + " " + where1;

		try {     //Entityとは、インスタンスと同じように情報の集合のこと
			      //createSQLQueryでsqlを実行して、Entityに情報を加えていく。それをまとめたものがresultListとして戻り値になる
			resultTable = session.createSQLQuery(sql).addEntity("a", Chocolate.class).addEntity("aa", ChocolateCountry.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();  //トランザクションclose
		return resultTable;
	}


	/**
	 *
	 * 検索結果(条件あり)
	 */
	@SuppressWarnings("unchecked")
	public List<Chocolate> resultList(String countryId, String shopName) {
		List<Chocolate> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Chocolate a, ChocolateCountry aa";
			String where1 = "WHERE a.countryId = aa.id";
			String where2 = ""; //where2を定義して、のちに使う

			if (!StringUtils.isEmpty(countryId)) {
				where2 += "AND (aa.id = " + countryId + " )"; //where2でANDを定義して、範囲を定める
			}
			if (!StringUtils.isEmpty(shopName)) {
				where2 += "AND (a.shopname LIKE '%" + shopName + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Chocolate.class).addEntity("aa", ChocolateCountry.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}



	/**
	 * IDをキーにして削除対象のレコードを取得する
	 *
	 * @param deleteId
	 * @return resultList
	 */
	@SuppressWarnings("unchecked")
	public List<Chocolate> selectForDelete(String[] deleteId) {
		List<Chocolate> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Chocolate a, ChocolateCountry aa";
		String where1 = "WHERE a.countryId = aa.id";
		String where2 = "AND a.id in ("; // ANDが抜けてた
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += " , "; // 2個目からカンマ区切りにする
			}
			where2 += deleteId[i];//deleteidをdeleteする分だけ加えていく
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).addEntity("a", Chocolate.class).addEntity("aa", ChocolateCountry.class)
					.list();
			//addEntity("",)は、""テーブルの情報を.classからとってきてEntityに格納するということ
			//Entityとは、インスタンスと同じように情報の集合のこと
			//.list()とは、addEntityでとってきた情報をlistの形にするということ
			//createSQLQueryでsqlを実行して、Entityに情報を加えていく。それをまとめたものがresultListとして戻り値になる
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
				Chocolate chocolate = (Chocolate) session.load(Chocolate.class, Integer.parseInt(strAry[i].trim()));
				//session.loadはsession.getと似ているが、loadの場合例外が発生し、getの場合はnullが返る
				//chocolate classのIDをセットしていく
				session.delete(chocolate);
				//Session.Classにとんで、このchocolateのsessionをdeleteする
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();//rollback()は途中で処理が失敗したため、今までの処理も無効にするということ
			}
		}
		session.getTransaction().commit();//commit()はトランザクションが完了したということ
	}

	/**
	 * 追加時の接続
	 *
	 */

	public void insert(String id,String image,String countryId,  String shopName, String chef, String comment,String price) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Chocolate a = new Chocolate();
		// idはオートインクリメントなのでなくて大丈夫
		a.setCountryid(Integer.parseInt(countryId));
		a.setShopName(shopName);
		a.setChef(chef);
		a.setPrice(price);
		a.setComment(comment);
		a.setImage(image);


		try {
			session.save(a);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	/**
	 * 更新時の接続
	 *
	 * @param model
	 */

	public void update(Chocolate model) {
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

}
