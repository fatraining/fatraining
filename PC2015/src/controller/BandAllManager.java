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
	public List<?> bandResultTable;//いらない
	public ArrayList<BandResultTable> outputTable;//いらない（BandSearchActionにまとめるから）
	
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
		session.getTransaction().commit();
		
		this.outputTable = bandTableTrans(bandResultTable);
		
		return outputTable;
	}
	public ArrayList<BandResultTable> bandTableTrans(List<?> bandResultTable){
		//ArrayList<BandResultTable>のインスタンス生成
		ArrayList<BandResultTable> tempTable = new ArrayList<BandResultTable>();
		Object[] obj;
		try{
			//for文でbandResultTableのサイズ分処理を繰り返す
			for(int i = 0;i < bandResultTable.size();i++){
				//BandResultTableのインスタンス生成
				BandResultTable temp = new BandResultTable();
				//bandResultTableのインデックスをすべて取得して、objectに代入
				//リスト型を配列に変換(キャスト)する
				obj = (Object[]) bandResultTable.get(i);
				
				BandAccount bandaccount = (BandAccount)obj[0];
				BandTable bandtable = (BandTable)obj[1];
				temp.setId(bandaccount.getId());
				temp.setName(bandaccount.getName());
				temp.setSex(bandaccount.getSex());
				temp.setAge(bandaccount.getAge());
				temp.setSchool(bandaccount.getSchool());
				temp.setFavorite_song(bandaccount.getFavorite_song());
				temp.setPart(bandaccount.getPart());
				//temp.setBand_id(bandaccount.getBand_id());
				temp.setEntry_date(bandaccount.getEntry_date());
				temp.setRenewal_date(bandaccount.getRenewal_date());
				temp.setEntry_userid(bandaccount.getEntry_userid());
				temp.setRenewal_userid(bandaccount.getRenewal_userid());
				//temp.setExclusion_flg(bandaccount.getExclusion_flg());
				//temp.setDelete_flg(bandaccount.getDelete_flg());
				temp.setBand_name(bandtable.getBand_name());
				tempTable.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return tempTable;
	}
	
	//BandResultManager.javaの処理をここに移す。bandResultListメソッド(引数あり)。検索時入力があったときに実行
public ArrayList<BandResultTable> bandResultList(String band_name,String name,String part){
		
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory()	
				.getCurrentSession();
		//トランザクション開始
		session.beginTransaction();
		try{
			if(band_name.isEmpty())band_name="%"; //band_nameが空の時はワイルドカード「%」を代入
			if(name.isEmpty())name="%"; //nameが空の時はワイルドカード「%」を代入
			if(part.isEmpty())part="%"; //partが空の時はワイルドカード「%」を代入
			//band_accountテーブルとband_tableテーブルの全件を検索
			String select = "SELECT * FROM band_account a,band_table t ";
			//band_accountテーブルのIDとband_tableテーブルのIDが等しいという条件
			String where1 = "WHERE a.id = t.id ";
			//入力された値とそれぞれのテーブルにあるカラムの値が等しいという条件
			String where2 = "AND (t.BAND_NAME LIKE '"+ band_name +"' AND a.NAME LIKE '"+ name +"' AND a.PART LIKE '"+ part + "')";
			//sqlにselect文、where文二つを代入
			String sql = select + " " + where1 + " " + where2;bandResultTable = session.createSQLQuery(sql)
					//SQLQuery.addEntityメソッドで戻り値BandAccountの型設定
					.addEntity("BandAccount",BandAccount.class)
					//SQLQuery.addEntityメソッドで戻り値BandTableの型設定。SQLQuery.listメソッドでクエリの実行
					.addEntity("BandTable",BandTable.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(bandResultTable);
		return outputTable;
	}
	//bandSearch.jspのiteratorを回すための処理。
	public ArrayList<BandResultTable> tableTrans(List<?> bandResultTable){
		ArrayList<BandResultTable> tempTable = new ArrayList<BandResultTable>();
		Object[] obj;
		try{
			for(int i = 0;i < bandResultTable.size();i++){
				BandResultTable temp = new BandResultTable();
				obj = (Object[]) bandResultTable.get(i);
				BandAccount bandaccount = (BandAccount)obj[0];
				BandTable bandtable = (BandTable)obj[1];
				temp.setId(bandaccount.getId());
				temp.setName(bandaccount.getName());
				temp.setSex(bandaccount.getSex());
				temp.setAge(bandaccount.getAge());
				temp.setSchool(bandaccount.getSchool());
				temp.setFavorite_song(bandaccount.getFavorite_song());
				temp.setPart(bandaccount.getPart());
				//temp.setBand_id(bandaccount.getBand_id());
				temp.setEntry_date(bandaccount.getEntry_date());
				temp.setRenewal_date(bandaccount.getRenewal_date());
				temp.setEntry_userid(bandaccount.getEntry_userid());
				temp.setRenewal_userid(bandaccount.getRenewal_userid());
				//temp.setExclusion_flg(bandaccount.getExclusion_flg());
				//temp.setDelete_flg(bandaccount.getDelete_flg());
				temp.setBand_name(bandtable.getBand_name());
				tempTable.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return tempTable;
	}

}
