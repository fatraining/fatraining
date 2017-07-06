package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.OzakiAlbum;
import training2016.model.OzakiSong;

public class OzakiDao extends AbstractDao {

	@SuppressWarnings("unchecked")
	public List<OzakiAlbum> getAlbumNameList() {

		List<OzakiAlbum> resultTable = null;

		// DB接続
		Session session = this.getCurrentSession();

		try {
			// トランザクション開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM ozakialbum ORDER BY id")
					// 要素がOzakiAlbumエンティティであるものを返す
					.addEntity("OzakiAlbum", OzakiAlbum.class).list();

		} catch (Exception e) {
			e.printStackTrace();

			// ロールバック実行
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/*---------- 検索結果表示 ----------*/

	/*-- 条件なし --*/

	@SuppressWarnings("unchecked")
	public List<OzakiSong> songList() {
		List<OzakiSong> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {os.*},{oa.*} FROM OzakiSong os, OzakiAlbum oa";
		String where = "WHERE os.albumId = oa.id";
		String sql = select + " " + where;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("os", OzakiSong.class).addEntity("oa", OzakiAlbum.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/*-- 条件あり --*/

	@SuppressWarnings("unchecked")
	public List<OzakiSong> resultList(String albumId, String songName) {
		List<OzakiSong> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {os.*},{oa.*} FROM OzakiSong os, OzakiAlbum oa";
		String where1 = "WHERE os.albumId = oa.id";
		StringBuilder sb = new StringBuilder();
		sb.append("");

		if (!StringUtils.isEmpty(albumId)) {
			sb.append("AND (os.albumId = ").append(albumId).append(" )");
		}
		if (!StringUtils.isEmpty(songName)) {
			sb.append("AND (os.songName LIKE '%").append(songName).append("%' )");
		}
		String where2 = sb.toString();
		String sql = select + " " + where1 + " " + where2;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("os", OzakiSong.class).addEntity("oa", OzakiAlbum.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/*---------- 削除表示 ----------*/

	/*-- 削除用テーブル表示 --*/

	@SuppressWarnings("unchecked")
	public List<OzakiSong> selectForDelete(String[] deleteId) {
		List<OzakiSong> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {os.*},{oa.*} FROM OzakiSong os, OzakiAlbum oa";
		String where1 = "WHERE os.albumId = oa.id";
		String where2 = "AND os.id in (";

		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 = where2 + ","; // 2個目以降の削除IDを指定するときにカンマを追加する
			}
			where2 = where2 + deleteId[i];
		}
		where2 = where2 + ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("os", OzakiSong.class).addEntity("oa", OzakiAlbum.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/*-- 削除の実行 --*/

	public void delete(String delete) {
		Session session = this.getCurrentSession();
		// 削除IDはカンマで分割され、配列に格納される
		String[] deleteId = delete.split(",");

		// トランザクション開始
		session.beginTransaction();

		for (int i = 0; i < deleteId.length; i++) {
			// 先頭または最後の空白を取り除く
			int id = Integer.parseInt(deleteId[i].trim());

			try {
				OzakiSong ozakiSong = (OzakiSong) session.load(OzakiSong.class, id);
				session.delete(ozakiSong);
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
		}
	}

	/*-- 追加の実行 --*/

	public void insert(String id, String songName, String albumId, String songWriting, String age, String lyrics) {
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		OzakiSong os = new OzakiSong();
		// idはオートインクリメントで自動に設定
		os.setSongName(songName);
		os.setAlbumId(Integer.parseInt(albumId));
		os.setSongWriting(songWriting);
		os.setAge(age);
		os.setLyrics(lyrics);

		try {
			session.save(os);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
	}

	/*-- 更新の実行 --*/

	public void update(OzakiSong model) {
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		try {
			session.update(model);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
	}
}
