package action;

import java.util.Calendar;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import constant.Constants;
import model.Attendances;
import model.Users;
import util.ValidateUtil;
import dao.FacloudAttendancesDao;


@Results({
	@Result(name = "facloudLogin", value = "facloudLogin.action", type = ServletRedirectResult.class),
	@Result(name = "facloudTimecard", value = "facloudTimecard.action", type = ServletRedirectResult.class)})
/**
 * 勤怠修正画面
 * @author miyamoto
 *
 */
public class FacloudAttendanceUpdateAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String titleTxt;
	private String errMsg;
	private String userName;
	private String sectionName;
	private String date;
	private String inTime;
	private String outTime;
	private String comment;
	
	/**
	 * 画面表示時に実行
	 */
	@Override
	public String execute() {
		
		// セッションマップからユーザデータを取得
		Users usersData = (Users) this.sessionMap.get("usersData");
		
		// ユーザーデータがセッションマップになければログイン画面を表示
		if(usersData == null){
			this.sessionMap.clear();
			this.sessionMap.put("errMsg", "ログインしてーや頼むでほんま");
			return "facloudLogin";
		}
		
		// セッションマップから修正したいレコードのidを取得
		int recordId = (int) this.sessionMap.get("recordId");
		
		// データベースからidと一致するデータを取得
		FacloudAttendancesDao attendances = new FacloudAttendancesDao();
		Attendances attendancesData = attendances.findAttendances(recordId);
		
		// 初期表示用データ取得
		this.titleTxt = "修正画面";
		this.userName = usersData.getName();
		this.sectionName = usersData.getSection().getName();
		this.date = makeDateString(attendancesData);
		this.inTime = datetimeToTime(attendancesData.getInTime());
		this.outTime = datetimeToTime(attendancesData.getOutTime());
		this.comment = attendancesData.getComment();
		
		// セッションマップに修正したいレコードのデータを格納
		this.sessionMap.put("attendancesData", attendancesData);
		return "success";
	}
	
	/**
	 * 勤怠データアップデート
	 * @return 成功で"facloudTimecard",失敗で"failed"
	 */
	public String update(){

		// HH:mm形式かチェック
		if( !inTime.isEmpty() && !ValidateUtil.isValidTime(inTime) ) {
			errMsg = "時刻は hh:mm形式で入力するっちゅうお約束や。";
			return "failed";
		}
		if( !outTime.isEmpty() && !ValidateUtil.isValidTime(outTime) ) {
			errMsg = "時刻は hh:mm形式で入力するっちゅうお約束や。";
			return "failed";
		}
		
		// コメントが140文字以内かチェック
		if(comment.length() > 140){
			errMsg = "備考は140文字以内におさめんかい。";
			return "failed";
		}
		
		// DBを更新
		Attendances attendancesData = (Attendances)this.sessionMap.get("attendancesData");
		FacloudAttendancesDao facloudAttendances = new FacloudAttendancesDao();
		facloudAttendances.updateDB(attendancesData, inTime, outTime, comment);
		
		// タイムカード画面に戻る
		return "facloudTimecard";
	}
	
	/**
	 * attendancesDataからyyyy/mm/dd(曜日)文字列を作成する。
	 * @param attendancesData 修正するデータをAttendancesクラスのインスタンスに格納したもの
	 * @return yyyy/mm/dd(曜日)形式の文字列
	 */
	public String makeDateString(Attendances attendancesData){
		
		// 年月日の取得
		int year = attendancesData.getYear();
		int month = attendancesData.getMonth();
		int day = attendancesData.getDay();
		
		// 曜日取得
		Calendar dateCalen = Calendar.getInstance();
		dateCalen.set(year, month-1, day-1);
		String dayOfWeek = Constants.DAY_OF_WEEK[dateCalen.get(Calendar.DAY_OF_WEEK)];
		
		// 結合して戻す
		return year + "/" + month + "/" + day + "(" + dayOfWeek + ")";
	}
	
	/**
	 * yyyy-mm-dd HH:mm:ss形式の文字列からHH:mmのみを取り出す<br>
	 * 引数がnullの場合はnullを返す
	 * @param datetime yyyy-mm-dd HH:mm:ss形式の文字列
	 * @return HH:mm形式の文字列またはnull
	 */
	public String datetimeToTime(String datetime){
		if(datetime != null) {
			return datetime.substring(11,16);
		}
		return null;
		
	}
	
	/**
	 * フィールドのtitleTxtに引数を格納する。
	 * @param titleTxt 
	 */
	public void setTitleTxt(String titleTxt) {
		this.titleTxt = titleTxt;
	}
	
	/**
	 * titleTxtを取得する。
	 * @return titleTxt
	 */
	public String getTitleTxt(){
		return this.titleTxt;
	}
	
	/**
	 * フィールドのerrMsgに引数を格納する。
	 * @param errMsg 
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * errMsgを取得する。
	 * @return errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}
	
	/**
	 * フィールドのuserNameに引数を格納する。
	 * @param userName 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * userNameを取得する。
	 * @return userName
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * フィールドのsectionNameに引数を格納する。
	 * @param sectionName 
	 */
	public void setSectionName(String sectionName){
		this.sectionName = sectionName;
	}
	
	/**
	 * sectionNameを取得する。
	 * @return sectionName
	 */
	public String getSectionName() {
		return this.sectionName;
	}
	
	/**
	 * フィールドのdateに引数を格納する。
	 * @param date 
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * dateを取得する。
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * フィールドのinTimeに引数を格納する。
	 * @param inTime 
	 */
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	/**
	 * inTimeを取得する。
	 * @return inTime
	 */
	public String getInTime() {
		return inTime;
	}
	
	/**
	 * フィールドのoutTimeに引数を格納する。
	 * @param outTime 
	 */
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
	/**
	 * outTimeを取得する。
	 * @return outTime
	 */
	public String getOutTime() {
		return outTime;
	}
	
	/**
	 * フィールドのcommentに引数を格納する。
	 * @param comment 
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * commentを取得する。
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

}
