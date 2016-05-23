package training2016.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GuitarDao;
import training2016.model.GuitarInfo;
import training2016.model.GuitarMaker;

@Result(name = "guitarUpdate" , value = "guitarUpdate.action" , type = ServletRedirectResult.class)
public class GuitarSearchAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	//画面タイトル
	private String title = "国産ハイエンドギター検索";
	//入力項目
    //メーカー名
	private String name;
	//型名
	private String typeName;
	//価格下限
	private String priceLow;
	//価格上限
	private String priceHi;
	//削除
	private String delete;
	//検索結果マップ
	private Map<String,String> nameMap;

	private String updateId;

	public ArrayList<GuitarInfo> resultTable = new ArrayList<GuitarInfo>();

	public String getUserID(){
		return (String) this.sessionMap.get("userId");
	}

	public String getMsg(){
		return (String) this.sessionMap.get("msg");
	}

	//executeメソッド
	@Override
	public String execute(){
		this.fieldInit();
		return "success";
	}
	//リセットボタンを押したとき
	public String reset() {
		this.fieldInit();
		return "success";
	}
	//フィールド初期化
	private void fieldInit(){
		this.setNameMap();

		this.name = "";
		this.typeName = "";
		this.priceLow = "";
		this.priceHi = "";
	}
	//検索ボタンを押したとき
	public String search() {
		GuitarDao dao = new GuitarDao();
		List<GuitarInfo> resultTable = null;
		//フォームがnullの時
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(typeName) && StringUtils.isEmpty(priceLow)
				&& StringUtils.isEmpty(priceHi)){
			resultTable = dao.resultList();
		}else{
			name = this.name.trim();
			typeName = this.typeName.trim();
			resultTable = dao.resultList(name, typeName, priceLow, priceHi);
		}
		this.sessionMap.put("msg", null);
		this.resultTable.addAll(resultTrans(resultTable));
		this.setDelete("true");
		this.setNameMap();
		return"success";
	}
	//テーブルの作成
	public ArrayList<GuitarInfo> resultTrans(List<?>resultTable){
		ArrayList<GuitarInfo> tempTable = new ArrayList<GuitarInfo>();
		Object[] obj;
		try{
			for(int i = 0 ; i < resultTable.size() ; i++){
				GuitarInfo temp = new GuitarInfo();
				obj = (Object[]) resultTable.get(i);
				GuitarMaker gm = (GuitarMaker) obj[0];
				GuitarInfo gi = (GuitarInfo) obj[1];
				temp.setId(gi.getId());
				temp.setGuitarMakerId(gi.getGuitarMakerId());
				temp.setName(gm.getName());
				temp.setTypeName(gi.getTypeName());
				temp.setPrice(gi.getPrice());
				temp.setComment(gi.getComment());
				tempTable.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("GuitarSearchActionを見よ");
		}
		return tempTable;
	}
	//追加ボタンを押したとき
	public String update() {
		this.sessionMap.put("deleteId", null);
		return "guitarUpdate";
	}
	//削除ボタンクリック時にチェックありならguitarUpdateへ飛ばす.
	public String delete(){
		this.sessionMap.put("deleteId", this.delete);
		if(delete == null){
			addActionError("削除する項目を選択してください。");
			search();
			return"error";
		}else{
			return "guitarUpdate";
		}
	}
	//get,setメソッド


	public void setUpdateId(String updateId){
		this.updateId = updateId;
	}
	public String getUpdateId(){
		return this.updateId;
	}


	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setPriceLow(String priceLow){
		this.priceLow = priceLow;
	}
	public String getPriceLow(){
		return priceLow;
	}
	public void setPriceHi(String priceHi){
		this.priceHi = priceHi;
	}
	public String getPriceHi(){
		return priceHi;
	}
	public void setDelete(String delete){
		this.delete = delete;
	}
	public String getDelete(){
		return delete;
	}
	public String getTitle(){
		return this.title;
	}
	public Map<String,String> getNameMap(){
		return nameMap;
	}
	public void setNameMap(){
		GuitarDao dao = new GuitarDao();
		List<?> resultTable = dao.getNameList();
		this.nameMap = tableTrans(resultTable);
	}
	//メーカー名用マップを返す
	public Map<String,String> tableTrans(List<?> resultTable){
		Map<String,String> tempMap = new LinkedHashMap<String,String>();
		tempMap.put("", "メーカーを選択");
		try{
			for(int i = 0 ; i < resultTable.size(); i++){
				GuitarMaker gm = (GuitarMaker) resultTable.get(i);
				tempMap.put(gm.getId(), gm.getName());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return tempMap;
	}
}
