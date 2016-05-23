package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GuitarDao;
import training2016.model.GuitarInfo;
import training2016.model.GuitarMaker;


@Result(name = "guitarSearch",value = "guitarSearch.action",type = ServletRedirectResult.class)
public class GuitarUpdateAction extends AbstractAction{

	private String title = "国産ハイエンドギター検索";

	private String id;
	private String name;
	private String guitarMakerId;
	private String typeName;
	private String price;
	private String comment;
	private Map<String,String> nameMap;
	private String delete;

	//エラー表示
	private String errorMsg;
	private String msg;


	//insertメソッド。追加

	public String insert(){
		this.setNameMap();

		if(!this.isValidate()){
			this.errorMsg = "必須項目(※)を入力してください。";
			return "error";
		}
		GuitarDao dao = new GuitarDao();
		dao.save(this.generateGuitarModel());
		this.msg = "登録しました。";
		sessionMap.put("msg", this.msg);
		return "guitarSearch";
	}

	//フィールドに所持している値でGuitarModelを生成して返す。
	private GuitarInfo generateGuitarModel(){
		GuitarInfo model = new GuitarInfo();
		model.setId(this.id);
		model.setGuitarMakerId(this.guitarMakerId);
		model.setName(this.name);
		model.setTypeName(this.typeName);
		model.setPrice(Integer.parseInt(this.price));
		model.setComment(this.comment);
		return model;
	}

    //必須項目が入力済みか確認
	private boolean isValidate(){
		if (StringUtils.isEmpty(this.guitarMakerId) ||
				StringUtils.isEmpty(this.typeName) ||
				StringUtils.isEmpty(this.price)) {
			return false;
		}
		return true;
	}

	//削除メソッド

	@Override
	public String execute() throws Exception{
		//deleteの取り出し
		this.setDelete((String)this.sessionMap.get("deleteId"));
		this.setNameMap();
		return "success";
	}

	public String delete(){
		this.setDelete((String)this.sessionMap.get("deleteId"));
		GuitarDao dao = new GuitarDao();
		dao.delete(this.getDelete());
		this.msg = "削除しました。";
		this.sessionMap.put("msg", this.msg);
		return "guitarSearch";
	}

	//メーカー名のプルダウン用マップ
	public Map<String,String>tableTrans(List<?> resultTable){
		Map<String,String> tempMap = new LinkedHashMap<String,String>();
		tempMap.put("","メーカーを選択");
		try{
			for(int i = 0 ; i < resultTable.size() ; i++){
				GuitarMaker gm = (GuitarMaker) resultTable.get(i);
				tempMap.put(gm.getId(),gm.getName());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return tempMap;
	}



	//get,setメソッド

//	public String getId(){
//		return id;
//	}
//	public void setId(String id){
//		this.id = id;
//	}
	public String getTitle(){
		return title;
	}
	public Map<String,String> getNameMap(){
		return nameMap;
	}
	public void setNameMap(){
		GuitarDao dao = new GuitarDao();
		List<?> resultTable = dao.getNameList();
		this.nameMap = tableTrans(resultTable);
	}
	public String getDelete(){
		return delete;
	}
	public void setDelete(String delete){
		this.delete = delete;
	}
	public String getGuitarMakerId(){
		return  this.guitarMakerId;
	}
	public void setGuitarMakerId(String guitarMakerId){
		this.guitarMakerId = guitarMakerId;
	}
	public String getTypeName(){
		return typeName;
	}
	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getComment(){
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public String getErrorMsg(){
		return this.errorMsg;
	}

}

