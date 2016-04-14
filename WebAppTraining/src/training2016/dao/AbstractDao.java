package training2016.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import training2016.model.AbstractSearchCondition;

/**
 * Daoクラスの基本的な動きを規定する抽象クラス
 *
 * @author harasan
 */
public abstract class AbstractDao {

	private static final SessionFactory sessionFactory;

	private Session session;
	private Transaction transaction;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * セッションを取得して返す
	 *
	 * @return セッション
	 */
	public Session getCurrentSession() {
		// DB(データベース)への接続処理
		return sessionFactory.getCurrentSession();
	}

	/**
	 * セッションを取得してトランザクションを開始する。
	 */
	public void startTransaction() {
		// DB(データベース)への接続処理
		this.session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		this.transaction = this.session.beginTransaction();
	}

	/**
	 * セッションを返す。
	 *
	 * @return session
	 */
	protected Session getSession() {
		return this.session;
	}

	/**
	 * 現在のトランザクションをロールバックする。
	 */
	public void rollback() {
		this.transaction.rollback();
	}

	/**
	 * 現在のトランザクションをコミットする。
	 */
	public void commit() {
		this.transaction.commit();
	}

	/**
	 * 主キー(ID)により、単一のモデルを取得して返す。<br>
	 * 該当データがなければnullを返す。
	 *
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <M> M select(int id, Class<M> cls) {
		return (M)session.get(cls, id);
//		return (M)session.load(cls, id);
	}

	/**
	 * 検索して返す。<br>
	 * 検索条件は継承先の実装に従う
	 *
	 * @return モデルリスト
	 */
	@SuppressWarnings("unchecked")
	protected <M> List<M> select(AbstractSearchCondition cond) {
		this.startTransaction();
		List<M> modelList = null;
		try {
			Query query = this.session.createQuery(cond.generateQueryString());
			cond.setQueryParams(query);
			modelList = query.list();
		} catch (Throwable e) {
			this.rollback();
			e.printStackTrace();
			return null;
		}
		this.commit();
		return modelList;
	}

}
