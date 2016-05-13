package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import training2016.dao.NailDao;
import training2016.model.Nail;
import training2016.model.Season;

public class NailSearchAction extends AbstractAction {

	private String title = "ネイル検索画面";
	private static final long serialVersionUID = 1L;

	public Map<String, String> Kisetu = new LinkedHashMap<String, String>();
	//LinkedHushMap は取ってきたマップの順番を保持する

	private String kisetuID;/** 季節 */
	private String color[];


//	private String errormsg;/** エラーメッセージ */
	public String delete;/** 削除ID */

	private static final String IMG_SAVE_BASE = "C:\\Users\\笠嶋　美雪\\Documents\\pleiades\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\WebAppTraining\\assets\\images\\temp";



	public List<Nail> outputTable = new ArrayList<Nail>();
//	private String setImageFileName;
	//Nailリストをアウトプットテーブルに引っ張ります


	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMsg() {
		return (String) this.sessionMap.get("msg");
	}
	//初期値
	private String getDefaultSeason(){
		return "";
	}
	private String[] getDefaultColor(){
		return null;
	}

	//画面上へ呼び出し
	{
		this.setKisetuName();
	}

	@Override
	public String execute() {
		this.kisetuID  = getDefaultSeason();
		this.color  = getDefaultColor();
		return "success";
	}
	//画面呼び出し
	private void setKisetuName() {
		NailDao nail = new NailDao();
		List<?> resultTable = nail.getSeasonList();
		this.Kisetu = generateSeasonPulldown(resultTable);

	}

	//季節プルダウン作成
	public Map<String, String> generateSeasonPulldown(List<?> resultTable){
		Map<String, String> tempMap = new LinkedHashMap<String,String>();
		tempMap.put("", "");
		//デフォルトで空欄（空のマップ）をいれる
		try{
			for(int i = 0; i < resultTable.size(); i++){
				Season season = (Season) resultTable.get(i);
				tempMap.put(season.getKisetuID(), season.getKisetu());
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return tempMap;
	}


	//リセット
	public String reset(){
		this.kisetuID  = getDefaultSeason();
		this.color  = getDefaultColor();
		this.sessionMap.put("msg", null);
		return "success";
	}



	// 検索ボタン押したとき
	public String search(){
		//季節プルダウン
		NailDao nail = new NailDao();
		List<?> resultTable = null;
		if ((this.kisetuID == null || this.kisetuID.length() == 0 ) &&
				(this.color == null || this.color.length == 0)){
			resultTable = nail.resultList();

		} else {
			resultTable = nail.resultList(this.kisetuID,this.color);
			//splitでStringをString配列[]に変更
		}
		this.sessionMap.put("msg", null);
		this.outputTable.addAll(tableTrans(resultTable));
		this.setDelete("true");
		return "success";
	}


	/**
	 * 検索結果変換
	 * @param resultTable
	 * @return
	 */
	public List<Nail> tableTrans(List<?> resultTable){
		List<Nail> tempTable = new ArrayList<Nail>();
		Object[] obj;
		try{
			for(int i = 0; i < resultTable.size(); i++){
				Nail temp = new Nail();
				obj = (Object[]) resultTable.get(i);
				Season s = (Season) obj[0];
				Nail n = (Nail) obj[1];
				temp.setId(n.getId());
				temp.setDate(n.getDate());
				temp.setKisetuID(s.getKisetu());
				temp.setMaincolor(n.getMaincolor());
				temp.setHandmodel(n.getHandmodel());
				temp.setImageFileName(n.getImageFileName());
				temp.setComment(n.getComment());
				tempTable.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("NailSearchActionを見よ");
		}
		return tempTable;
	}


	//追加ボタンを押したとき
	public String update(){
		this.sessionMap.put("deleteID", null);
		try{
			this.response.sendRedirect("nailUpdate.action");
		}catch(IOException e){
			e.printStackTrace();
		}
		return "success";
	}

	// 削除ボタンクリック時、チェックありなら nailUpdate へ飛ばす//
	/*------------------------------------------------------*/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("nailUpdate.action");

			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}




	//タイトル
	public String getTitle(){
		return this.title;
	}

//////setter,getter
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getDelete(){
		return delete;
	}
	public void setKisetuID(String kisetuID){
		this.kisetuID = kisetuID;
	}
	public String getKisetuID(){
		return kisetuID;
	}
	public void setColor(String[] color){
		this.color = color;
	}
	public String[] getColor(){
		return color;
	}





}



