package training2016.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Geinin;

public class GeininDao extends AbstractDao {


	/** ドライバークラス名 */
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	/** DBのURL */
	private static final String URL = "jdbc:mysql://localhost/webapp";
	/** DBのユーザ名 */
	private static final String USER = "root";
	/** DBのパスワード */
	private static final String PASSWORD = "";

	/**
	 * コネクション取得メソッド
	 * @return Connection
	 */
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		return con;
	}

	/**
	 * 部分一致検索メソッド
	 * @param keyword 検索したいキーワード
	 * @return 検索結果を格納するListオブジェクト。
	 */
	public ArrayList<Geinin> searchByName(String keyword) {
		// 戻り値となるリスト
		ArrayList<Geinin> list = new ArrayList<>();
//		実行するsql詳細
		String sql = "SELECT id,image,name,work FROM geinins "
				+ "WHERE name LIKE ? ORDER BY id";
//		+ "WHERE name LIKE \'%" + keyword + "%\' ORDER BY id";
		Session session = this.getCurrentSession();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			//トランザクションを開始
			session.beginTransaction();
			// SQL文の実行
			pst.setString(1, "%" + keyword + "%");
			ResultSet rs = pst.executeQuery();
			// ResultSetから結果の取得
			System.out.println("searchByName: " + sql);
			while (rs.next()) {
				// リストに加えるGeininオブジェクトの生成
				Geinin geinin = new Geinin();
				// ResultSetから各列の値を取得
				String id = rs.getString("id");
				String image = rs.getString("image");
				String name = rs.getString("name");
				String work = rs.getString("work");
				// Geininオブジェクトに値をセット
				geinin.setId(id);
				geinin.setImage(image);
				geinin.setName(name);
				geinin.setWork(work);
				// Geininオブジェクトをリストに加える
				list.add(geinin);
			}
		} catch (SQLException | ClassNotFoundException e) {
			this.rollback();
			e.printStackTrace();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return list;
	}

//	IDによる検索メソッド return Geininクラス
	public Geinin searchById(String id) {
		// 戻り値となるインスタンス
		Geinin geinin = new Geinin();
//		実行するsql詳細
		String sql = "SELECT id,image,name,work FROM geinins "
				+ "WHERE id = '" + id + "' ORDER BY id";
		Session session = this.getCurrentSession();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			//トランザクションを開始
			session.beginTransaction();
			// SQL文の実行
			ResultSet rs = pst.executeQuery();
			// ResultSetから結果の取得
			System.out.println("searchById: " + sql);
			// ResultSetから各列の値を取得
			// Geininオブジェクトに値をセット
			geinin.setId(rs.getString("id"));
			geinin.setImage(rs.getString("image"));
			geinin.setName(rs.getString("name"));
			geinin.setWork(rs.getString("work"));
		} catch (SQLException | ClassNotFoundException e) {
			this.rollback();
			e.printStackTrace();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return geinin;
	}


//	条件なしの検索 return Geininのリスト
	public ArrayList<Geinin> allGeininList() {
		// 戻り値となるリスト
		ArrayList<Geinin> list = new ArrayList<>();
//		実行するsql詳細
		String sql = "SELECT id,image,name,work FROM geinins "
				+ "ORDER BY id";
		Session session = this.getCurrentSession();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			//トランザクションを開始
			session.beginTransaction();
			// SQL文の実行
			ResultSet rs = pst.executeQuery();
			// ResultSetから結果の取得
			System.out.println("allGeininList: " + sql);
			while (rs.next()) {
				// リストに加えるGeininオブジェクトの生成
				Geinin geinin = new Geinin();
				// ResultSetから各列の値を取得
				String id = rs.getString("id");
				String image = rs.getString("image");
				String name = rs.getString("name");
				String work = rs.getString("work");
				// Geininオブジェクトに値をセット
				geinin.setId(id);
				geinin.setImage(image);
				geinin.setName(name);
				geinin.setWork(work);
				// Geininオブジェクトをリストに加える
				list.add(geinin);
			}
		} catch (SQLException | ClassNotFoundException e) {
			this.rollback();
			e.printStackTrace();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return list;
	}


	/* 追加の実行 */
//	全てのパラメータは埋まっている前提
	public void insert(String image, String name, String work) {
//		実行するsql詳細
		String sql = "INSERT INTO geinins VALUES(?)";

		String value1 = "NULL,";
		String value2 = image + ",";
		String value3 = name + ",";
		String value4 = work;
		String values = value1 + value2 + value3 + value4;
		System.out.println(values);
//		IDはオートで決定

//		Session session = this.getCurrentSession();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			//トランザクションを開始
//			session.beginTransaction();
			// SQL文の実行
			pst.setString(1, values);
//			ResultSet rs =
			pst.executeUpdate();
			System.out.println("insert: " + sql + " " + values);
		} catch (SQLException | ClassNotFoundException e) {
//			this.rollback();
			e.printStackTrace();
		}
		//トランザクション終了
//		session.getTransaction().commit(); //close
	}



	/* 更新の実行 Hybernateを使っている・・・ */
	public void updata(Geinin geinin) {

		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		try {
			session.update(geinin);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

}


}
