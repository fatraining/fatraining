package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.SessionException;

import training2016.dao.NailDao;
import training2016.model.Season;

@Result(name = "nailSearch",value = "nailSearch.action",type = ServletRedirectResult.class)

public class NailUpdateAction extends AbstractAction  {
	/** 画面タイトル */
	private String title = "ネイル追加";

	private static final long serialVersionUID = 1L;
	public int ID;
//	public String ID;
	public String date;
	public Map<String, String> Kisetu = new HashMap<String, String>();
	public String KisetuID;
	public String maincolor;/** メインカラー */
	public String handmodel;
	public String imageFileName;
	public String comment;
	public String msg;

	private File image;
	private String imageContentType;
	private String updateBtnTitle = "追加";

	private static final String IMG_SAVE_BASE = "\\assets\\images\\temp";



	//エラー表示
	public String errormsg;
	//削除画面時の表示項目
	public String delete;
	private Map<String,String> kisetuName;
	{
		this.setKisetuName();
	}

	public String execute() throws Exception{
		//deleteを取り出し
		this.delete = (String) this.sessionMap.get("deleteID");


		return "success";

	}

	//削除メソッド
	public String delete(){
		this.delete = (String) this.sessionMap.get("deleteID");
		NailDao nail = new NailDao();
		nail.delete(this.delete);
		this.msg = "削除が完了しました";
		this.sessionMap.put("msg", this.msg);
		return "nailSearch";
	}

	private void setKisetuName() {
		NailDao nail = new NailDao();
		List<?> resultTable = nail.getSeasonList();
		this.Kisetu = tableTrans(resultTable);
	}
	public Map<String, String> getKisetuName(){
		return kisetuName;
	}


	//プルダウン作成
	public Map<String, String> tableTrans(List<?> resultTable){
		Map<String, String> tempMap = new HashMap<String,String>();
		tempMap.put("", "");
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
	public String getTitle() {
		return this.title;
	}

	//追加ボタンを押したとき
	public String insert(){
		if(this.isEmptyParam(this.date)){
			addActionError("日時が未入力です。");
			return "error";
		}
		if(this.KisetuID == null || this.KisetuID.length() == 0){
			addActionError("季節が未選択です。");
			return "error";
		}
		if(this.maincolor == null || this.maincolor.length() == 0){
			addActionError("メインカラーが未選択です。");
			return "error";
		}
		if(this.isEmptyParam(this.handmodel)){
			addActionError("ハンドモデルの名前が未入力です。");
			return "error";
		}
		if(this.image == null){
			addActionError("画像が添付されていません。");
			return "error";
		}
		if(this.isEmptyParam(this.comment)){
			addActionError("コメントが未入力です。");
			return "error";
		}
		//日付の書式指定
		SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");

		//日付の解析を厳密に行う
		df.setLenient(false);
		try{
			//画像アップロード
			if (this.image != null) {
				BufferedImage img = ImageIO.read(image);
				String expansionName = this.imageContentType.split("/")[1];

				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("") + IMG_SAVE_BASE + "\\" + imageFileName));
			}
			//日付の取得
			Date day = df.parse(this.date);
			NailDao insert = new NailDao();
			//DBに入れる
			insert.insert(this.ID, this.date, this.KisetuID, this.maincolor, this.handmodel, this.comment, this.imageFileName);
		}catch(SessionException | NumberFormatException | ParseException e){
			e.printStackTrace();
			addActionError("日付が不正です");

			return "error";
		}catch (IOException ioe) {
			ioe.printStackTrace();
			this.errormsg = "画像の保存に失敗しました";
		}
		this.msg = "登録しました";
		sessionMap.put("msg", this.msg);
		return "nailSearch";
	}

	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}


	// image,imageContentTypeをセットする
	public void setImage(File image) {
		this.image = image;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	//updateBtnTitleを返す
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}


}



