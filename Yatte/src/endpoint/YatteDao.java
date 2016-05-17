package endpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class YatteDao {
	Connection con = null;

	/*------------------------------------------------------*/
	/**
	 * DBから取ってくるメソッド
	 */
	public List<Contents> dao() {
		List<Contents> yatteList = new ArrayList<>();
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yatte", "root", "");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "select * from yatte";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Contents yatte = new Contents();
				yatte.setNo(rs.getInt("No"));
				yatte.setToDo(rs.getString("toDO"));
				yatte.setWho(rs.getString("who"));
				yatte.setNum(rs.getInt("num"));
				yatte.setTime(rs.getString("time"));
				yatte.setLimit(rs.getTimestamp("limit").toLocalDateTime());
				yatte.setEx(rs.getString("Ex"));
				yatte.setFlg(rs.getInt("flg"));
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

	public List<Contents> addDao(Contents contents) {
		List<Contents> yatteList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yatte", "root", "");
			System.out.println("MySQLに接続できました。");
			Statement stm = con.createStatement();
			String sql = "INSERT INTO yatte values(" + contents.getNo() + ",'" + contents.getName() + "','" + contents.getToDo() + "','"
					+ contents.getWho() + "'," + contents.getNum() + ",'" + contents.getTime() + "','"
					+ contents.getLimit().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "','"
					+ contents.getEx() + "'," + contents.getFlg() + ",'" + contents.getYattal() + "')";
			stm.executeUpdate(sql);
//			System.out.println(sql);

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
		yatteList = dao();
		return yatteList;
	}

	/*------------------------------------------------------*/
	/**
	 * 更新時のメソッド yattal,akanのとき
	 */
	public void updateDao(List<Contents> yaLi) {
		List<Contents> daoList = dao();

		for (int i = 0; i < daoList.size(); i++) {
			if (yaLi.get(i).getFlg() == 0 && daoList.get(i).getYattal() != yaLi.get(i).getYattal() || daoList.get(i).getFlg() != yaLi.get(i).getFlg()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					// MySQLに接続
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yatte", "root", "");
					System.out.println("MySQLに接続できました。");
					Statement stm = con.createStatement();

					String sql = "UPDATE yatte SET flg = "+ yaLi.get(i).getFlg() + " , " + "yattal = '" + yaLi.get(i).getYattal().replace("'", "zl")
							+ "' WHERE No =" + yaLi.get(i).getNo();
					stm.executeUpdate(sql);
					System.out.println(sql);

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
			}
		}
	}

	/*
	 * DBから名前とってくるメソッド
	 * */
	public List<yatteName> name() {
		List<yatteName> names  = new ArrayList<>();
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
