package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Tabaco;
import training2016.model.TabacoArea;

public class TabacoDao extends AbstractDao {

	/**
	 * 検索結果(null)
	 */
	@SuppressWarnings("unchecked")
	public List<Tabaco> tabacoList() {
		List<Tabaco> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Tabaco a, TabacoArea aa";
		String where1 = "WHERE a.tabacoAreaId = aa.id";
		String sql = select + " " + where1;

		try {

			resultTable = session.createSQLQuery(sql).addEntity("a", Tabaco.class).addEntity("aa", TabacoArea.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 検索結果(条件あり)
	 */

	@SuppressWarnings("unchecked")
	public List<Tabaco> resultList(String TabacoAreaId, String tar, String name) {
		List<Tabaco> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Tabaco a, TabacoArea aa";
			String where1 = "WHERE a.tabacoAreaId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(TabacoAreaId)) {
				where2 += "AND (aa.id = " + TabacoAreaId + " )";// 1と11の区別ができる。LIKEじゃない方がええ
			}
			if (!StringUtils.isEmpty(tar)) {
				where2 += "AND (a.tar LIKE '%" + tar + "%' )";// 
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";//LIKE =～を含む
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Tabaco.class).addEntity("aa", TabacoArea.class)
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
	 */

	@SuppressWarnings("unchecked") // エラー抑制
	public List<TabacoArea> getTabacoAreaList() {
		// SQLの検索結果変数
		List<TabacoArea> resultTable = null;
		// データテーブル接続
		Session session = this.getCurrentSession();
		try {
			// トランザクション開始
			session.beginTransaction();
			// SQL実行
			resultTable = session.createSQLQuery("SELECT * FROM TabacoArea")
					// ReasultTableにSQL文をいれる
					// メガネのリストを取得
					.addEntity("TabacoArea", TabacoArea.class).list();
		} catch (Exception e) {
			// 例外の理由
			e.printStackTrace();
			// 元のエラーのない状態に戻す
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
	/**
	 * IDをキーにして削除対象のレコードを取得する
	 */
	@SuppressWarnings("unchecked")
	public List<Tabaco> selectForDelete(String[] deleteId) {
		List<Tabaco> resultList = null;
		Session session = this.getCurrentSession(); //対象のセッション
		session.beginTransaction();
		
		String select = "SELECT {a.*},{aa.*} FROM tabaco a, tabacoArea aa";
		String where1 = "WHERE a.tabacoAreaId = aa.id";
		String where2 = "AND a.id in (";
		for(int i = 0;i < deleteId.length; i++){
			if(i > 0) {//あった場合
				where2 += " , "; //2個めからカンマ区切りする
			}
			/**選択されたデリートID */
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).
						addEntity("a", Tabaco.class).
						addEntity("aa", TabacoArea.class)
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
	 */
	public void delete(String delete) {
		//文字列を分割
		String[] strAry = delete.split(",");
		
		Session session = this.getCurrentSession();
		session.beginTransaction();
		
		//for文で処理を繰り返す
		for(int i = 0; i < strAry.length; i++) {
			
			try{
				//load = 主キー検索
				Tabaco tabaco = (Tabaco) session.load(Tabaco.class,Integer.parseInt(strAry[i].trim()));
				session.delete(tabaco);
			}catch(HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}
	
	/**
	 * 追加・更新時の接続
	 * 
	 * @param model
	 */

	public void update(Tabaco model) {
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
	 * 追加時の接続
	 */
//insertはデータベースからデータを挿入する
	public void insert(String id,
				String tabacoAreaId, 
				String namePhoto, 
				String name,
				String tar,
				String nicotine, 
				String price,
				String comment) {
		Session session = this.getCurrentSession();
		session.beginTransaction();// トランザクション開始

		Tabaco t = new Tabaco();
		// idはオートインクリメント『自動的に1加える？』なので消しておけー
		t.setTabacoAreaId(Integer.parseInt(tabacoAreaId));
		t.setNamePhoto(namePhoto);
		t.setName(name);
		t.setTar(tar);
		t.setNicotine(nicotine);
		t.setPrice(price);
		t.setComment(comment);

		try {
			session.save(t);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
	
}
