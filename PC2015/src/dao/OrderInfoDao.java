package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import model.Category;
import model.GoodsList;
import model.OrderInfo;

public class OrderInfoDao extends HibernateUtil {

	/**
	 * 購入履歴の検索
	 * @param memberId
	 * @param orderDate ("yyyy" or "yyyy/MM" or "yyyy/MM/dd")
	 * @param category
	 * @return
	 */
	public List<?> orderInfoSelect(String memberId, String orderDate, String category) {
		// 検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT {o.*}, {g.*}, {c.*} "
						+ "FROM order_info o, goodslist g, category_master c";
		String where1 = " WHERE o.OrderMemberID = '" + memberId.replace("'", "''") + "'"
						+ " AND o.OrderGoodsCode = g.GoodsCode"
						+ " AND g.Category = c.Category"
						+ " AND g.DeleteFlag = '0'"
						+ " AND c.DeleteFlag = '0'";
		String sort = " ORDER BY CAST(SUBSTRING(o.OrderDate, 1, 10) AS DATE) DESC,"
							+ " o.OrderNo DESC,"
							+ " o.OrderGoodsCode ASC";

		// 個別の条件設定
		String whereOrderDate = "";
		String whereCategory = "";

		// 注文日
		if (!orderDate.isEmpty()) {
			if (orderDate.length() == 10) {
				// 年月日を条件とする
				whereOrderDate = " AND date_format(o.OrderDate, '%Y/%m/%d') = '" + orderDate + "'";
			} else if ((orderDate.length() == 7)) {
				// 年月を条件とする
				whereOrderDate = " AND date_format(o.OrderDate, '%Y/%m') = '" + orderDate + "'";
			} else if ((orderDate.length() == 4)) {
				// 年を条件とする
				whereOrderDate = " AND date_format(o.OrderDate, '%Y') = '" + orderDate + "'";
			}
		}

		// 商品種別
		if (!category.isEmpty()) {
			whereCategory = " AND g.Category = '" + category + "'";
		}

		String sql = select + where1 + whereOrderDate + whereCategory + sort;

		try {
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("o", OrderInfo.class)
					.addEntity("g", GoodsList.class)
					.addEntity("c", Category.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 注文番号の最大値を検索
	 * @return orderNo
	 */
	public String maxOrderNoSelect() {

		String orderNo = null;
		
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();

		// SQL文
		String sql = "SELECT MAX(OrderNo) FROM order_info";

		try {
			Object obj = session.createSQLQuery(sql).uniqueResult();
			orderNo = (String)obj;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return orderNo;
	}
	
	/**
	 * 注文情報登録
	 * @param orderInfo[]
	 */
	public void insert(ArrayList<OrderInfo> orderInfo) {

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();

		for (int i = 0; i < orderInfo.size(); i++) {
			try {
				// 注文情報の件数分登録
				OrderInfo info = orderInfo.get(i);
				session.save(info);
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}

		// トランザクションの終了
		session.getTransaction().commit();
	}
}
