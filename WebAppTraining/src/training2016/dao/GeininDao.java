package training2016.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				+ "WHERE id = ? ORDER BY id";
		Session session = this.getCurrentSession();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			//トランザクションを開始
			session.beginTransaction();
			// SQL文の実行
			pst.setString(1, String.valueOf(id));
			ResultSet rs = pst.executeQuery();
			// ResultSetから結果の取得
			while (rs.next()) {
			// Geininオブジェクトに値をセット
				geinin.setId(rs.getString("id"));
				geinin.setImage(rs.getString("image"));
				geinin.setName(rs.getString("name"));
				geinin.setWork(rs.getString("work"));
				System.out.println("searchById: " + id);
			}
		} catch (SQLException | ClassNotFoundException e) {
			this.rollback();
			e.printStackTrace();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return geinin;
	}

//	idの配列を引数に検索
	public ArrayList<Geinin> searchById(String[] idArray){
		// 戻り値となるリスト
		ArrayList<Geinin> resultList = new ArrayList<>();
//		データをリストに格納
		for(int i = 0; i < idArray.length; i++) {
			resultList.add(searchById(idArray[i]));
		}
		return resultList;
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
		String sql = "INSERT INTO geinins VALUES (?,?,?,?)";

		Session session = this.getCurrentSession();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			//トランザクションを開始
			session.beginTransaction();
			// SQL文の実行
//			IDはオートで決定
			pst.setInt(1, 0);
			pst.setString(2, image);
			pst.setString(3, name);
			pst.setString(4, work);
//			ResultSet rs =
			pst.executeUpdate();
			System.out.println("insert: " + sql);
		} catch (SQLException | ClassNotFoundException e) {
			this.rollback();
			e.printStackTrace();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
	}


	/* 削除の実行 */
	public void delete(String[] idArray) {
//		実行するsql詳細
		String sql = "DELETE FROM geinins WHERE id = ?";

		Session session = this.getCurrentSession();
		//トランザクションを開始
		session.beginTransaction();
		for(int i = 0; i < idArray.length; i++) {
			try (Connection con = getConnection();
					PreparedStatement pst = con.prepareStatement(sql) ) {
//				SQL文の実行
				pst.setInt(1, Integer.parseInt(idArray[i]));
//				ResultSet rs =
				pst.executeUpdate();
				System.out.println("deleteMethod deleteId: " + idArray[i]);
			} catch (SQLException | ClassNotFoundException e) {
				this.rollback();
				e.printStackTrace();
			}
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
	}



	/* 更新の実行*/
	public void update(String id, String image, String name, String work) {
//		実行するsql詳細
		String sql = "UPDATE geinins SET image = ?, name = ?, work = ? WHERE id = ?";

		Session session = this.getCurrentSession();
		//トランザクションを開始
		session.beginTransaction();
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
//			SQL文の実行
			pst.setString(1, image);
			pst.setString(2, name);
			pst.setString(3, work);
			pst.setString(4, id);
//			ResultSet rs =
			pst.executeUpdate();
			System.out.println("updateMethod updateId: " + id);
		} catch (SQLException | ClassNotFoundException e) {
			this.rollback();
			e.printStackTrace();
			}
		//トランザクション終了
		session.getTransaction().commit(); //close
	}


}
