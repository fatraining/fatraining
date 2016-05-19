package endpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CyatteDao {
	Connection con = null;

	/*------------------------------------------------------*/
	/**
	 * DBから取ってくるメソッド
	 */
	public List<CContents> dao() {
		List<CContents> yatteList = new ArrayList<>();
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yatte", "root", "");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from cyatte";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				CContents yatte = new CContents();
				yatte.setName(rs.getString("name"));
				yatte.setNo(rs.getInt("No"));
				yatte.setWho(rs.getString("who"));
				yatte.setTime(rs.getString("time"));
				yatte.setEx(rs.getString("Ex"));
				yatte.setYattal(rs.getString("yattal"));
				yatteList.add(yatte);
//				System.out.println("取得結果 -> " + yatte.getNo() + ":" + yatte.getToDo() + ":" + yatte.getWho() + ":"
//						+ yatte.getNum() + ":" + yatte.getTime() + ":" + yatte.getLimit() + ":" + yatte.getEx() + ":"
//						+ yatte.getFlg() + ":" + yatte.getYattal());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
		return yatteList;
	}

	/*------------------------------------------------------*/
	/**
	 * yatte(追加)の時の処理
	 */

	public List<CContents> addDao(CContents CContents) {
		List<CContents> yatteList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yatte", "root", "");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "INSERT INTO cyatte (`No`, `name`, `who`, `time`, `ex`, `yattal`) values (" + CContents.getNo() + ",'" + CContents.getName() + "','"
					+ CContents.getWho() + "','" + CContents.getTime() + "','"
					+ CContents.getEx() + "','" + CContents.getYattal() + "')";
			System.out.println(sql);
			stm.executeUpdate(sql);
//			System.out.println(sql);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ざんねんでしたーw");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
		yatteList = dao();
		return yatteList;
	}

	/*
	 * DBから名前とってくるメソッド
	 * */
	public List<yatteName> name() {
		List<yatteName> names = new ArrayList<>();
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yatte", "root", "");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from yName";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				yatteName yName = new yatteName();
				yName.setNo(rs.getInt("No"));
				yName.setName(rs.getString("name"));
				yName.setPass(rs.getString("pass"));
				names.add(yName);
				System.out.println("取得結果 ->" + yName.getName() + ":" + yName.getPass());
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
		return names;
	}
}
