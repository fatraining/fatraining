package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;

import training2016.dao.RiderDao;
import training2016.model.BikeTeam;


@Result(name = "riderSearch" , value = "riderSearch.action" , type = ServletRedirectResult.class)
public class UpdateRiderAction extends AbstractAction {

	private String title = "ライダー追加";
	private static final long serialVersionUID = 1L;

	//フィールド
	/*------------------------------------------------------*/
	public Map<Integer,String>bikeTeam = new HashMap<Integer,String>();
	public String ID;
	public String number;
	public String riderName;
	public String teamId;
	public String country;
	public String age;
	public String birthDay;
	public String comment;

	public String msg;
	public String errormsg;
	public String delete;
	//チーム名プルダウン用Map
	private Map<String,String> teamName;

	//イニシャライズ→初期化
	{
		this.setTeamName();
	}

	//executeメソッド
	/*------------------------------------------------------*/
	@Override
	//sessionMapからうけとるだけ
	public String execute() throws Exception {
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	//削除メソッド
	/*------------------------------------------------------*/

	public String delete(){
		//Jspで選択されたIDをsessionMapへ送る
		this.delete = (String) this.sessionMap.get("deleteID");
		RiderDao rider = new RiderDao();
		rider.delete(this.delete);
		this.msg = "削除しました";
		this.sessionMap.put("msg", this.msg);
		return "riderSearch";
	}

	//追加ボタンを押したときの動作
	/*------------------------------------------------------*/
	public String insert(){
		//エラー表示↓↓空の状態だったら表示させる
		if(this.isEmptyParam(this.number)){
			addActionError("ゼッケンナンバーが入力されていません");
		}
		if(this.isEmptyParam(this.teamId)){
			addActionError("チームが選択されていません");
		}
		if(this.isEmptyParam(this.riderName)){
			addActionError("ライダー名が入力されていません");
		}
		if(this.isEmptyParam(this.country)){
			addActionError("国籍が入力されていません");
		}
		if(this.isEmptyParam(this.age)){
			addActionError("年齢が入力されていません");
		}
		if(this.isEmptyParam(this.birthDay)){
			addActionError("誕生日が入力されていません");
		}
		if (this.getActionErrors().size() > 0) {
			return "error";
		}
		try{
			//JSPのFORMから送られてきた値
			RiderDao dao = new RiderDao();
			dao.insert(
					this.ID,
					this.number,
					this.riderName,
					this.teamId,
					this.country,
					this.age,
					this.birthDay,
					this.comment);
		}
		catch (HibernateException e){
			e.printStackTrace();
			return "error";
		}
		//RiderSearchの画面で表示される
		this.msg = "追加しました";
		sessionMap.put("msg", this.msg);
		return "riderSearch";
	}

	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	//teamNameマップのセッター、ゲッター
	/*------------------------------------------------------*/
	private void setTeamName(){
		RiderDao rider = new RiderDao();
		List<?> resultTable = rider.getTeamNameList();
		this.teamName = tableTrans(resultTable);
	}
	public Map<String,String> getTeamName(){
		return teamName ;
	}

	//ぷるだうん
	/*------------------------------------------------------*/
	public Map<String,String> tableTrans(List<?>resultTable){
		Map<String,String>tempMap = new HashMap<String,String>();
		tempMap.put("", "");
		try{
			//table内の値をforで取得
			for(int i = 0; i < resultTable.size(); i++){
				BikeTeam bikeTeam = (BikeTeam) resultTable.get(i);
				//tempMapに値を淹れる
				tempMap.put(bikeTeam.getID(),bikeTeam.getTeamName());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return tempMap;
	}

	//ゲッター
	/*------------------------------------------------------*/
	public String getTitle(){
		return this.title;
	}
}
