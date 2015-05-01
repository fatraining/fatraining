package controller;

import java.util.ArrayList;
import java.util.List;

import model.BandAccount;
import model.BandTable;
import model.BandResultTable;

import org.hibernate.classic.Session;

//HibernateUtilクラスを継承したクラス
public class BandAllManager extends HibernateUtil{
	
	//三つのメソッドで使用するため、フィールドで宣言
	//public List<?> bandResultTable;//いらない
	//public ArrayList<BandResultTable> outputTable;//いらない
	
	//bandResultListメソッド(引数なし)。検索時入力がなかったとき実行
	public ArrayList<BandResultTable> bandResultList(){
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションを開始
		session.beginTransaction();
		
		//検索した結果を表示させるためのsql文
		//band_accountテーブルとband_tableテーブルの全件を検索
		String select = "SELECT * FROM band_account a,band_table t ";
		//band_accountテーブルのIDとband_tableテーブルのIDが等しい
		String where1 = "WHERE a.id = t.id ";
		//select文とwhere文を合わせたものをsqlに代入
		String sql = select + " " + where1;
		
		//SQL文の実行(固定文言)
		List<?> bandResultTable = null; //SQLの検索結果用の変数
		try{
			bandResultTable = session.createSQLQuery(sql) //インスタンス生成
					//SQLQuery.addEntityメソッドで戻り値BandAccountの型設定
					.addEntity("BandAccount",BandAccount.class)
					//SQLQuery.addEntityメソッドで戻り値BandTableの型設定。SQLQuery.listメソッドでクエリの実行
					.addEntity("BandTable",BandTable.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了(固定文言)
		session.getTransaction().commit();
		
		ArrayList<BandResultTable> outputTable = bandTableTrans(bandResultTable);
		
		//下の処理はもともとは必要だったもの。検索結果の処理を移すにあたり不要となる？
		//this.outputTable = bandTableTrans(bandResultTable);
		
		return outputTable;
	}
	
	
	//BandResultManager.javaの処理をここに移す。bandResultListメソッド(引数あり)。検索時入力があったときに実行
public ArrayList<BandResultTable> bandResultList(String band_name,String name,String part){
		
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory()	
				.getCurrentSession();
		//トランザクション開始
		session.beginTransaction();
		
		
			if(band_name.isEmpty()){band_name="%";} //band_nameが空の時はワイルドカード「%」を代入
			if(name.isEmpty()){name="%";} //nameが空の時はワイルドカード「%」を代入
			if(part.isEmpty()){part="%";} //partが空の時はワイルドカード「%」を代入
			
			//band_accountテーブルとband_tableテーブルの全件を検索
			String select = "SELECT * FROM band_account a,band_table t ";
			//band_accountテーブルのIDとband_tableテーブルのIDが等しいという条件
			String where1 = "WHERE a.id = t.id ";
			//入力された値とそれぞれのテーブルにあるカラムの値が等しいという条件
			String where2 = "AND (t.BAND_NAME LIKE '"+ band_name +"' AND a.NAME LIKE '"+ name +"' AND a.PART LIKE '"+ part + "')";
			//sqlにselect文、where文二つを代入
			String sql = select + " " + where1 + " " + where2;
			
			List<?> bandResultTable = null; //SQLの検索結果用の変数
			try{
				
			bandResultTable = session.createSQLQuery(sql)
					//SQLQuery.addEntityメソッドで戻り値BandAccountの型設定
					.addEntity("BandAccount",BandAccount.class)
					//SQLQuery.addEntityメソッドで戻り値BandTableの型設定。SQLQuery.listメソッドでクエリの実行
					.addEntity("BandTable",BandTable.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了(固定文言)	
		session.getTransaction().commit();
		
		ArrayList<BandResultTable> outputTable = bandTableTrans(bandResultTable);
		//下の処理はもともとは必要だったもの。検索結果の処理を移すにあたり不要となる？
		//this.outputTable = tableTrans(bandResultTable);
		return outputTable;
	}

	//SQLの検索結果を画面表示用のListに入れ替えている
	private ArrayList<BandResultTable> bandTableTrans(List<?> bandResultTable){
		
		//画面表示用のリストをインスタンス化
		ArrayList<BandResultTable> tempTable = new ArrayList<BandResultTable>();
		
		//変数の初期化
		Object[] obj;
		
		//SQLの検索結果の件数分ループ
		for(int i = 0;i < bandResultTable.size();i++){
			
			//画面表示用のレコードをインスタンス化
			BandResultTable temp = new BandResultTable();
			
			//SQLの検索結果を分解
			obj = (Object[]) bandResultTable.get(i);
			BandAccount bandaccount = (BandAccount)obj[0];
			BandTable bandtable = (BandTable)obj[1];
			
			//画面表示用に設定
			temp.setId(bandaccount.getId());
			temp.setName(bandaccount.getName());
			temp.setSex(bandaccount.getSex());
			temp.setAge(bandaccount.getAge());
			temp.setSchool(bandaccount.getSchool());
			temp.setFavorite_song(bandaccount.getFavorite_song());
			temp.setPart(bandaccount.getPart());
			temp.setBand_name(bandtable.getBand_name());
			
			//画面表示用にリストに追加
			tempTable.add(temp);
			}
		
		return tempTable;
	}
	
	
}
