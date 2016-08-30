package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.ShipDao;
import training2016.model.Country;
import training2016.model.Ships;

@Result(name = "search", value = "shipFinder.action", type = ServletRedirectResult.class)
public class UpdateShipAction extends AbstractAction {
	/** 画面タイトル */
	private String title = "艦艇竣工/解体";

	/** 国ID */
	private String countryID;
	/** 国名 */
	private String countryName;
	/** 艦艇ID */
	private String shipID;
	/** 艦名 */
	private String shipName;
	/** クラス */
	private String shipClass;
	/** 竣工年 */
	private String year;
	/** コメント */
	private String comment;
	/** 解体ID */
	private String delete;
	/** 国名プルダウン用マップ */
	/** クラスプルダウン用マップ */
	private Map<String, String> countryMap;
	private Map<String,String> shipClassMap = new LinkedHashMap<String, String>();		//shipClassMapの生成
	/** エラーメッセージ */
	private String errorMsg;
	/** 普通のメッセージ */
	private String msg;

	/** アップロードファイル */
	 private File image;
	 /** アップロードファイルのコンテンツタイプ */
	 private String imageContentType;
	 /** アップロードファイルの元ファイル名 */
	 private String imageFileName;
	 /** アップロードファイルの保存ファイル名 */
	 private String tempFileName;

	 /** 保存先 */
	 private static final String IMG_SAVE_BASE = "\\assets\\images\\temp";

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	@Override
	public String execute() throws Exception {								//executeは最初に実行される（DBへ接続）
		// deleteを取り出し
		this.setDelete((String)this.sessionMap.get("deleteID"));			//deleteIDを取得
		this.setCountryMap();
		this.setShipClassMap();
		return "success";													//updateShipFinder.jspへリターン
	}

	/**
	 * insertメソッド。
	 * 画面の初期表示に戻す。
	 *
	 * @return 結果
	 */
	public String insert() {											//insertはデータベースへ情報の追加
		this.setCountryMap();
		this.setShipClassMap();

		// ファイル入力があれば、/assets/images/temp に書き込み
		try {
			if (this.image != null) {
				BufferedImage img = ImageIO.read(image);				//Bufferedとはデータを一時的に保持するために用意される記憶領域//imageIOは画像ファイルの読み書き
				String expansionName = this.imageContentType.split("/")[1];
				String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				tempFileName = this.imageFileName + "_" + dateString + "." + expansionName;
				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("") + IMG_SAVE_BASE + "\\" + tempFileName));
			}
		} catch (IOException ioe) {
				ioe.printStackTrace();
				this.addActionError("画像の保存に失敗しました");
			}

		// 未入力の項目があるときにエラーを返す　　　　144行目
		if (!this.isValidate()) {
			this.errorMsg = "必須項目(※)を入力してください。";
			return "error";
		}

		ShipDao dao = new ShipDao();
		dao.save(this.generateShipsModel());			//shipModelを引き起こす(genarate)//insertする
		this.msg = "竣工しました";
		sessionMap.put("msg", this.msg);
		return "search";
	}

	/**
	 * 今フィールドに保持している値でShipsModelを生成して返す
	 *
	 * @return Ships
	 */
	private Ships generateShipsModel() {				//shipModelを引き起こす
		Ships model = new Ships();
		model.setShipID(this.shipID);
		model.setCountryID(this.countryID);
		model.setCountryName(this.countryName);
		model.setShipName(this.shipName);
		model.setShipClass(this.shipClass);
		model.setYear(Integer.parseInt(this.year));
		if (this.comment.indexOf("\r\n") != -1) {
			this.comment = comment.replaceAll("\r\n", "<br />");		//"\r\n"を"<br />"に置き換える(両方改行)
		}
		model.setComment(this.comment);
		model.setImagePath(this.tempFileName);

		return model;
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 * @return 無問題ならtrue,ダメならfalse
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(this.countryID) ||
				StringUtils.isEmpty(this.shipName) ||
				StringUtils.isEmpty(this.shipClass) ||
				StringUtils.isEmpty(this.year)) {
			return false;
		}
		return true;
	}

	/**
	 * 解体メソッド
	 *
	 * @return search
	 */
	public String delete() {
		this.setDelete((String)this.sessionMap.get("deleteID"));
		ShipDao dao = new ShipDao();
		dao.delete(this.getDelete());
		this.msg = "解体が完了しました";
		this.sessionMap.put("msg",this.msg);
		return "search";
	}

	// 国名プルダウン用マップを返す //
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "国を選択");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Country country = (Country) resultTable.get(i);
				tempMap.put(country.getID(), country.getCountryName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}

	// せったーとげったー //
	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return shipClassMap
	 */
	public Map<String, String> getShipClassMap() {
		return shipClassMap;
	}

	/**
	 * @param shipClassMap セットする shipClassMap
	 */
	public void setShipClassMap() {
		this.shipClassMap.put("","クラスを選択");
		this.shipClassMap.put("戦艦","戦艦");
		this.shipClassMap.put("空母","空母");
		this.shipClassMap.put("巡洋艦","巡洋艦");
		this.shipClassMap.put("駆逐艦","駆逐艦");
	}

	/**
	 * @return countryMap
	 */
	public Map<String, String> getCountryMap() {
		return countryMap;
	}

	/**
	 * @param countryMap
	 *            セットする countryMap
	 */
	public void setCountryMap() {
		ShipDao dao = new ShipDao();
		List<?> resultTable = dao.getCountryList();
		this.countryMap = tableTrans(resultTable);
	}

	/**
	 * @return delete
	 */
	public String getDelete() {
		return delete;
	}

	/**
	 *
	 * @param セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return countryID
	 */
	public String getCountryID() {
		return countryID;
	}

	/**
	 *
	 * @param countryID セットするcountryID
	 */
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	/**
	 * @return countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName セットする countryName
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return shipName
	 */
	public String getShipName() {
		return shipName;
	}

	/**
	 * @param shipName セットする shipName
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	/**
	 * @return shipClass
	 */
	public String getShipClass() {
		return shipClass;
	}

	/**
	 * @param shipClass セットする shipClass
	 */
	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}

	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * errorMsgを返す
	 *
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}
