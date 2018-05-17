package training2016.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

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

//	有吉追記
	public Session openSession() {
		return sessionFactory.openSession();
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
		this.startTransaction();
		M m = null;
		try {
			m = (M)this.session.load(cls, id);
		} catch (Throwable e) {
			this.rollback();
			e.printStackTrace();
			return null;
		}
		this.commit();
		return m;
	}

	/**
	 * 検索して返す。<br>
	 * 検索条件は継承先の実装に従う
	 *
	 * @return モデルリスト
	 */
	@SuppressWarnings("unchecked")
	public <M> List<M> select(AbstractSearchCondition cond) {
		this.startTransaction();
		List<M> modelList = null;
		try {
			Query query = this.session.createQuery(cond.generateQueryString());
			cond.setQueryParameters(query);
			modelList = query.list();
		} catch (Throwable e) {
			this.rollback();
			e.printStackTrace();
			return new ArrayList<M>();
		}
		this.commit();
		return modelList;
	}

	/**
	 * 渡されたモデルを永続化(=insert)する
	 *
	 * @param m
	 */
	public <M> void save(M m) {
		this.startTransaction();
		try {
			this.session.save(m);
		} catch (Throwable e) {
			this.rollback();
			e.printStackTrace();
			throw e;
		}
		this.commit();
	}

	/**
	 * 渡されたモデルに対応するテーブルに、<br>
	 * 渡された関数型インターフェースにより操作を行う
	 *
	 * @param m
	 */
	public <M> void apply(M m, BiConsumer<Session, M> func) {
		this.startTransaction();
		try {
			func.accept(this.session, m);
		} catch (Throwable e) {
			this.rollback();
			e.printStackTrace();
			throw e;
		}
		this.commit();
	}
}
