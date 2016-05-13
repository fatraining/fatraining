package training2016.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Nail;
import training2016.model.Season;

public class NailDao extends AbstractDao  {

	//季節リスト取得
	public List<?> getSeasonList(){
		//sql検索結果用
		List<?> resultTable = null;
		//データベースに接続
		Session session = this.getCurrentSession();

		try{
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM season")
										.addEntity("season", Season.class).list();
			//Resultテーブルにsql文を代入
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}


	//検索結果の表示 nullの場合
	@SuppressWarnings("unchecked")
	//引数に抑止したい警告を示す文字列を指定することによって、コンパイラーの該当の警告を出さないようにするアノテーション
	public List<Nail>resultList(){
		//検索結果用の変数
		List<Nail> resultTable = null;

		//DB接続
		Session session = this.getCurrentSession();
		//トランザクション（複数の処理を連結した処理）開始
		session.beginTransaction();


		String select = "SELECT {s.*},{n.*} FROM season s, nail n";
		String where1 = "WHERE s.KisetuID = n.KisetuID";
		String sql = select + " " + where1 + ";";

		try{
			resultTable = session.createSQLQuery(sql).
					addEntity("s", Season.class).addEntity("n", Nail.class).list();

		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.print("検索条件が設定されていません");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	//条件ありの場合
	@SuppressWarnings("unchecked")
	public List<Nail> resultList(String KisetuID, String[] maincolors){
		//SQLの検索結果用の変数
		List<Nail> resultTable = null;
		//DB接続
		Session session = this.getCurrentSession();
		try{
			//トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {s.*},{n.*} FROM season s, nail n";
			String where1 = "WHERE s.KisetuID = n.KisetuID";
			String where2 = "";

			if(KisetuID != null && KisetuID.length() > 0){
				where2 += "AND (s.KisetuID LIKE '%" + KisetuID + "%' )";
			}
			if(maincolors != null && maincolors.length > 0){
				where2 += "AND (";
				for(int i = 0; i < maincolors.length; i++){
					if(i != 0 ) {
						where2 += " OR ";
					}
					where2 += "n.maincolor LIKE '%" + maincolors[i].trim() + "%'";
					//trimは表示左折部分にかけるのが確実
				}
				where2 += ")";
			}

			resultTable = session.createSQLQuery(select + " " + where1 +" " + where2 + ";")
					.addEntity("s", Season.class).addEntity("n", Nail.class).list();

		}catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//終了
		session.getTransaction().commit();
		return resultTable;

	}
	//追加の接続

	public void insert(int ID,
	 String date,String KisetuID,String maincolor,
	 String handmodel, String comment,String imageFileName){
		//データベースに接続
		Session session = this.getCurrentSession();

		//トランザクションを開始
		session.beginTransaction();
		Nail n = new Nail();
		n.setId(ID);
		n.setDate(date);
		n.setKisetuID(KisetuID);
		n.setMaincolor(maincolor);
		n.setHandmodel(handmodel);
		n.setComment(comment);
		n.setImageFileName(imageFileName);

		try{
			session.save(n);

		}catch (HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクションの終了
		session.getTransaction().commit();

	}


	//削除時の接続 //
		/*------------------------------------------------------*/
		public void delete(String delete) {

			// 分割
			String[] strAry = delete.split(",");

			// データベースに接続
			Session session = this.getCurrentSession();

			// トランザクションを開始

			session.beginTransaction();

			// for文で処理を繰り返す
			for (int i = 0; i < strAry.length; i++) {

				try {
					// load = 主キーの検索
					Nail nail = (Nail) session.load(Nail.class,Integer.parseInt(strAry[i].trim()));
					//Stringをintに変換

					session.delete(nail);

				} catch (HibernateException e) {
					e.printStackTrace();
					session.getTransaction().rollback();
					System.out.println("ハイバネエラー");
				}
			}
			// トランザクションの終了
			session.getTransaction().commit();
		}


}
