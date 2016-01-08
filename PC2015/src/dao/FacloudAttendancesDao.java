package dao;

import java.sql.Timestamp;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import model.Attendances;

/**
 * attendancesテーブル操作用クラス
 * @author miyamoto
 *
 */
public class FacloudAttendancesDao{

	/**
	 * 引数のrecordIdと一致するレコードをattendancesテーブルから取得するやで。
	 * 
	 * @param recordId
	 * @return attendancesData idと一致したレコードをAttendancesインスタンスに保持したもの
	 */
	public Attendances findAttendances(int recordId) {

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Attendances attendancesData = new Attendances();
		try {
			// トランザクションを開始
			session.beginTransaction();
			attendancesData = (Attendances) session.get(Attendances.class, recordId);
					
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		
		return attendancesData;
	}
	
	/**
	 * 勤怠データ修正処理
	 * @param attendancesData 修正するレコードのデータをAttendancesインスタンスに保持したもの
	 * @param inTime 出社時刻
	 * @param outTime 退社時刻
	 * @param comment 備考
	 */
	public void updateDB(Attendances attendancesData, String incompleteInTime, String incompleteOutTime, String comment){
		
		// 現在のタイムスタンプを取得
		String updatedAt = makeTimestamp();
		
		// 出社、退社時刻をyyyy-mm-dd HH:mm:00形式の文字列に作り直す
		String inTime = fitFormatToDatetime(attendancesData, incompleteInTime);
		String outTime = fitFormatToDatetime(attendancesData, incompleteOutTime);
		
		// 変更するデータの格納
		attendancesData.setInTime(inTime);
		attendancesData.setOutTime(outTime);
		attendancesData.setComment(comment);
		attendancesData.setUpdatedAt(updatedAt);
		
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// トランザクションを開始
		Transaction trans = session.beginTransaction();

		try {
			session.update(attendancesData);
			
			// トランザクション終了
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	/**
	 * 現在のタイムスタンプを取得し文字列で戻す。
	 * @return タイムスタンプの文字列
	 */
	private String makeTimestamp(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.toString();
	}
	
	/**
	 * 引数からyyyy-mm-dd HH:mm:00 形式の文字列を作成する。
	 * @param attendancesData
	 * @param time HH:mm形式の文字列
	 * @return yyyy-mm-dd HH:mm:00 形式の文字列
	 */
	private String fitFormatToDatetime(Attendances attendancesData, String time){
		if(time.isEmpty()){
			return "0000-00-00 00:00:00";
		}
		return attendancesData.getYear() + "-" + attendancesData.getMonth() + "-" + attendancesData.getDay()
		+ " " + time + ":00";
	}
}
