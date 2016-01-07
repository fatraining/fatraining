package action;

import model.Users;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Results({
	@Result(name = "facloudLogin", value = "facloudLogin.action", type = ServletRedirectResult.class),
	@Result(name = "facloudAttendanceUpdate", value = "facloudAttendanceUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "facloudTimecard", value = "facloudTimecard.action", type = ServletRedirectResult.class)
	
})
/**
 * タイムカード画面
 * @author miyamoto
 *
 */
public class FacloudTimecardAction extends AbstractAction {

	
	private static final long serialVersionUID = 1L;
	private String titleTxt;
	private String userName;
	private String sectionName;
	private int id;
	
	
	/**
	 * 画面表示時に実行
	 */
	@Override
	public String execute() {
		// ユーザーデータをセッションマップから取得、なければログイン画面を表示
		Users userData = (Users) this.sessionMap.get("usersData");
		if(userData == null){
			this.sessionMap.clear();
			this.sessionMap.put("errMsg", "ログインしてへんやんか！");
			return "facloudLogin";
		}
		// 初期画面表示用データ取得
		this.titleTxt = "タイムカード";
		this.sectionName = userData.getSection().getName();
		this.userName = userData.getName();
		return "success";
	}

	/**
	 * 勤怠修正画面へ遷移
	 * @return "facloudAttendancesUpdate"
	 */
	public String gotoAttendanceUpdate(){
		// 修正するレコードのｉｄをセッションマップに格納
		this.sessionMap.put("recordId", this.id);
		return "facloudAttendanceUpdate";
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
	public String getUserName(){
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
	 * フィールドのidに引数を格納する。
	 * @param id 
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * idを取得する。
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
}
	
