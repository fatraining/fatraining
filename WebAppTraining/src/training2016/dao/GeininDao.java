package training2016.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		String sql = "SELECT id,imabe,name,work FROM geinins "
				+ "WHERE name LIKE %" + keyword + "% ORDER BY id";
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			// SQL文の実行
			ResultSet rs = pst.executeQuery();
			// ResultSetから結果の取得
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
			e.printStackTrace();
		}
		return list;
	}

//	条件なしの場合
	public ArrayList<Geinin> allGeininList() {
		// 戻り値となるリスト
		ArrayList<Geinin> list = new ArrayList<>();
//		実行するsql詳細
		String sql = "SELECT id,image,name,work FROM geinins "
				+ "ORDER BY id";
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(sql) ) {
			// SQL文の実行
			ResultSet rs = pst.executeQuery();
			// ResultSetから結果の取得
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
			e.printStackTrace();
		}
		return list;
	}


}
