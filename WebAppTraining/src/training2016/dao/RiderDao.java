package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.BikeTeam;
import training2016.model.Rider;

//Dao=Database Access Object
//データの保存、読み込みを行うObject
public class RiderDao extends AbstractDao{

	//検索欄に何も入力しなかった場合、全てを表示させるやつ
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Rider> resultList(){

		//SQLの検索結果を返すための変数
		List<Rider>resultTable = null ;

		//DBへ接続
		Session session = this.getCurrentSession();

		//トランザクションの実行
		session.beginTransaction();

		//SQL文
		String select = "SELECT {t.*},{r.*} FROM biketeam t, rider r";

		//biketeamテーブルのIDとriderテーブルのteamIDを結合
		String where1 = "WHERE t.ID = r.TeamID";
		String sql = select + " " + where1 ;


		try{//SQLの実行。resultTableに代入しRiderSearchでそれを受け取る
			resultTable = session.createSQLQuery(sql)

					//BikeTeamとRiderクラスを実行させて値を取得しリスト化
					.addEntity("t", BikeTeam.class)
					.addEntity("r",Rider.class)
					.list();
		}
		//何か間違ってたらコンソールで原因を表示させる
		catch(Exception e){
			e.printStackTrace();

			//例外が起こった時、原因を探るためのやつ
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		//.commit()でトランザクションを終了
		session.getTransaction().commit();
		return resultTable ;
	}



	//検索欄に何かが入力されていた場合
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Rider> resultList(String number, String teamName, String riderName){
		List<Rider> resultTable = null;
		Session session = this.getCurrentSession();

		try{
			session.beginTransaction();
			String select = "SELECT {t.*},{r.*} FROM biketeam t , rider r";
			String where1 = "WHERE t.ID = r.TeamID";
			String where2 = "";

			//！を使って逆転させる。isEmpty()が空じゃない状態
			if(!StringUtils.isEmpty(number)){
				//where2に検索条件を追加する。(SQLでの処理)
				//LIKE '～%'で～を含む文字列を検索する
				where2 += "AND (r.Number LIKE '%" + number + "%' )";
			}
			if(!StringUtils.isEmpty(teamName)){
				where2 += "AND (t.TeamName LIKE '%" + teamName + "%' )";
			}
			if(!StringUtils.isEmpty(riderName)){
				where2 += "AND (r.RiderName LIKE '%" + riderName + "%' )";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2)
					.addEntity("t",BikeTeam.class)
					.addEntity("r",Rider.class)
					.list();
		}
		catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable ;
	}



	//追加画面のチームリストを取得
	/*------------------------------------------------------*/
	public List<?> getTeamNameList(){
		List<?> resultTable = null;
		Session session = this.getCurrentSession();
		try{
			session.beginTransaction();
			//SQLでBikeTeamテーブルを全て取得
			resultTable = session.createSQLQuery("SELECT * FROM BikeTeam")
					.addEntity("bikeTeam" , BikeTeam.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();;
		}
		session.getTransaction().commit();
		return resultTable;
	}


	//追加する時の接続
	/*------------------------------------------------------*/
	public void insert(
			String ID,
			String number,
			String riderName,
			String teamID,
			String country,
			String age,
			String birthDay,
			String comment ) {
		Session session = this.getCurrentSession();

		session.beginTransaction();
		//引数をmodelへセット
		Rider r = new Rider();
		r.setID(ID);
		r.setNumber(number);
		r.setRiderName(riderName);
		r.setTeamID(teamID);
		r.setCountry(country);
		r.setAge(age);
		r.setBirthDay(birthDay);
		r.setComment(comment);

		try{
			//modelへ値をセットし、model事態をSQLへ保存する
			//ここまでRiderのIDはnullだけど、modelのGeneratedValueで自動採番される
			session.save(r);
		}catch (HibernateException e){
			//うまく保存できなかった場合
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	//削除するときに接続する
	/*------------------------------------------------------*/
	public void delete(String delete){
		//split(",")でdeleteに入っている文字列を分割する
		String[] strAry = delete.split(",");

		Session session = this.getCurrentSession();

		session.beginTransaction();
		//配列のstrAryを全て取得
		for(int i = 0; i < strAry.length; i++){

			try{
				//.loadで分割して格納されていた値をriderへ代入
				Rider rider = (Rider) session.load(Rider.class,strAry[i]);
				//代入された値を削除
				session.delete(rider);

			}catch (HibernateException e){
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("はいばねーと");
			}
			session.getTransaction().commit();
		}
	}
}
