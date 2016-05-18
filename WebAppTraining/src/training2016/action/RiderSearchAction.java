package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.RiderDao;
import training2016.model.BikeTeam;
import training2016.model.Rider;


public class RiderSearchAction extends AbstractAction{

	private static final long serialVersionUID = 1L ;

	//タイトル
	private String title = "MotoGP ライダー検索" ;

	//フィールド
	//入力してほしいもの
	private String number ;
	private String teamName ;
	private String riderName ;
	//削除の値
	private String delete ;

	//検索結果のリスト↓↓
	public ArrayList<Rider> outputTable = new ArrayList<Rider>() ;

	//↓↓ログインアクションでセッションマップに保管されていたuserIDを取得
	public String getUserID(){
		return(String) this.sessionMap.get("userId");
	}

	//↓UpdateRiderActionでセットされたエラーメッセージをここで取得してJSPへ値を送る。
	public String getMsg(){
		return(String)this.sessionMap.get("msg");
	}


	//初期値の設定（何も値がない状態にっする）↓↓
	/*------------------------------------------------------*/
	private String getDefaultNumber(){
		return "" ;
	}
	private String getDefaultTeamName(){
		return "" ;
	}
	private String getDefaultRiderName(){
		return "" ;
	}

	//executeメソッド↓↓
	//まずこの動作が行われる。全てが上の初期値を取得する。
	/*------------------------------------------------------*/
	@Override
	public String execute(){
		this.number = getDefaultNumber();
		this.teamName = getDefaultTeamName();
		this.riderName = getDefaultRiderName();
		return "success" ;
	}


	//リセットボタンが押され、初期値になるためのresetメソッド
	/*------------------------------------------------------*/
	public String reset(){
		this.number = getDefaultNumber() ;
		this.teamName = getDefaultTeamName();
		this.riderName = getDefaultRiderName();
		//セッションマップはなくてもいけるけど、↑でゲットしちゃってるから一応？
		this.sessionMap.put("msg", null);
 		return "success" ;
	}

	//検索ボタンを押したときの動作
	/*------------------------------------------------------*/
	public String search(){
		RiderDao Dao = new RiderDao();
		//Listは配列のようなもの
		List<?> resultTable = null ;
		//値に何も入力されていなかったときの処理
		//StringUtils.isEmptyは空文字の状態かnullが入ってきたらtrueを
		//返すというもの
		//上のimportでapatch.commons.lang3をインポートする必要がある
		if(StringUtils.isEmpty(number)
				&& StringUtils.isEmpty(teamName)
				&& StringUtils.isEmpty(riderName)){
			//何も入ってない状態を返すため、引数なし
			//Daoで引数のないresultTableをDaoで作る必要がある。
			resultTable = Dao.resultList();
		}else {
			//↓条件があった場合
			//trim()は前後のスペースを取り除くことができるメソッド
			//trimがあれば、もしスペースが入ってしまったときにスペースなしで
			//文字を送ることができる。
			number = this.number.trim();
			teamName = this.teamName.trim();
			riderName = this.riderName.trim();
			//DaoのresultListへ引数を送る
			resultTable = Dao.resultList(number,teamName,riderName);
		}
		this.sessionMap.put("msg", null);
		//outputTableにresultTableを追加する
		//addAllでリストに値を追加することができる
		//↓のメソッドでテーブルを作成してあるから、あとはJspにこの値を取得させて表示するだけ。
		this.outputTable.addAll(tableTrans(resultTable));
		this.setDelete("true");
		return "success";
	}

	//テーブル作成
	/**表示させたい項目をかく。ここでIDのsetとgetをしていないと削除の時にIDを送れない**/
	//SQLのSELECTとおなじ（？）
	/*------------------------------------------------------*/
	//                                         ↓DaoにあるresultTable
	public ArrayList<Rider> tableTrans(List<?> resultTable){
		ArrayList<Rider> tempTable = new ArrayList<Rider>();
		Object[] obj ;
		try{
			//↓のfor文でListを全部取得することができる
			for(int i = 0; i < resultTable.size(); i ++ ){
				//↓ModelのRiderのインスタンス
				Rider temp = new Rider();
				//Listの中身を配列に代入
				obj = (Object[]) resultTable.get(i);
				BikeTeam t = (BikeTeam)obj[0];
				Rider r = (Rider) obj[1];
				//Listの中にmodelの中の値を淹れる
				temp.setID(r.getID());
				temp.setNumber(r.getNumber());
				temp.setTeamName(t.getTeamName());
				temp.setRiderName(r.getRiderName());
				temp.setCountry(r.getCountry());
				temp.setAge(r.getAge());
				temp.setBirthDay(r.getBirthDay());
				temp.setComment(r.getComment());
				//tempTableに追加して返す。
				tempTable.add(temp);
			}
		//例外処理
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("RiderSeartchActionを見よ");
		}
		return tempTable ;
	}

	//追加ボタンを押したとき
	/*------------------------------------------------------*/
	public String update(){
		//sessionMapにdeleteIDをいれる
		this.sessionMap.put("deleteID", null);
		try{
			//リダイレクトでページ移動
			this.response.sendRedirect("updateRider.action");
		}catch(IOException e){
			e.printStackTrace();
		}
		return "success";
	}

	//削除ボタンを押したとき
	/*------------------------------------------------------*/
	public String delete(){
		this.sessionMap.put("deleteID", this.delete);
		//JSPのチェックボックスに何もない
		if(delete == null){
			addActionError("削除する項目を選択してください");
			//searchメソッドを実行させて、また表を表示させている
			search();
			return "error";
		}else{
			try{
				this.response.sendRedirect("updateRider.action");
			}catch(IOException e){
				e.printStackTrace();
			}
			return "success";
		}
	}
	//フィールドに値を入れるgetter/setter
	/*------------------------------------------------------*/
	public void setNumber(String number){
		this.number = number ;
	}
	public String getNumber(){
		return number ;
	}
	public void setTeamName(String teamName){
		this.teamName = teamName ;
	}
	public String teamName(){
		return teamName ;
	}
	public void setRiderName(String riderName){
		this.riderName = riderName;
	}
	public String getRiderName(){
		return riderName ;
	}
	public void setDelete(String delete){
		this.delete = delete ;
	}
	public String getDelete(){
		return delete ;
	}
	public String getTittle(){
		return this.title;
	}
}