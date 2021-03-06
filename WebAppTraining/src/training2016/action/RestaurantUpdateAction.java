package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.AreaDao;
import training2016.dao.RestaurantDao;
import training2016.model.Restaurant;

/**
 * 飲み屋追加・更新Action
 *
 * @author harasan
 */
@Results({
	@Result(name = "backToSearch", value = "restaurantSearch!redisplay", type = ServletRedirectResult.class)
})
public class RestaurantUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "いい店だけ追加";
	/** ボタン表示名 */
	private String updateBtnTitle = "追加";

	/** ID(更新時のみ) */
	private String id;
	/** 店舗名 */
	private String name;
	/** 店舗エリア */
	private String area;
	/** 検索結果マップ */
	private Map<String, String> areaMap;
	/** 店舗評価 */
	private String stars;
	/** コメント */
	private String comment;

	/** アップロードファイル */
	private File image;
	/** アップロードファイルのコンテンツタイプ */
	private String imageContentType;
	/** アップロードファイルの元ファイル名 */
	private String imageFileName;

	/** 保存先 */
	private static final String IMG_SAVE_BASE = "\\assets\\images\\temp";

	// イニシャライザ
	{
		this.setAreaMap();
	}

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	public String execute() throws Exception {
		// セッションマップから更新対象IDを取得
		this.id = this.getValueFromSession("updateId");

		RestaurantDao dao = new RestaurantDao();
		Restaurant target = null;
		// 更新対象IDがあればデータの更新
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Restaurant.class);
			if (target != null) {
				this.name = target.getName();
				this.area = String.valueOf(target.getAreaId());
				this.stars = String.valueOf(target.getStars());
				this.comment = target.getComment();
				this.updateBtnTitle = "更新";
				this.title = "いい店を更新";
			}
		} else {
			// 新規
			this.id = "";
		}
		return "success";
	}

	/**
	 * updateメソッド。
	 *
	 * @return 結果
	 */
	public String update() {
		// 未入力の項目があるときにエラーを返す
		if (!this.isValidate()) {
			this.addActionError("全項目入力してください。");
			return "error";
		}

		try {
			// 画像
			if (this.image != null) {
				BufferedImage img = ImageIO.read(image);
				String expansionName = this.imageContentType.split("/")[1];
				String dateString =  new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String tempFileName = this.imageFileName + "_" + dateString + "." + expansionName;
				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("") + IMG_SAVE_BASE + "\\" + tempFileName));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			this.addActionError("画像の保存に失敗しました");
		}

		// ID があれば更新なので、一度取得したモデルに入力値をセットする
		RestaurantDao dao = new RestaurantDao();
		if (StringUtils.isNotEmpty(this.id)) {
			Restaurant target = dao.select(Integer.parseInt(this.id), Restaurant.class);
			dao.update(this.generateRestaurantModel(target));
		} else {
			dao.insert(this.generateRestaurantModel());
		}

		return "backToSearch";
	}

	/**
	 * 検索画面に戻る
	 *
	 * @return
	 */
	public String back() {
		return "backToSearch";
	}

	/**
	 * 今フィールドに保持している値でRestaurantModelを生成して返す
	 *
	 * @return restaurant
	 */
	private Restaurant generateRestaurantModel() {
		Restaurant model = new Restaurant();
		model.setName(this.name);
		model.setStars(Short.parseShort(this.stars));
		model.setComment(this.comment);
		model.setAreaId(Integer.parseInt(this.area));
		Date registerDate = new Date();
		model.setCreateUser(this.getUserId());
		model.setCreateDate(new Timestamp(registerDate.getTime()));
		model.setUpdateUser(this.getUserId());
		model.setUpdateDate(new Timestamp(registerDate.getTime()));

		return model;
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す<br>
	 * 更新用。
	 *
	 * @return restaurant
	 */
	private Restaurant generateRestaurantModel(Restaurant target) {
		target.setName(this.name);
		target.setStars(Short.parseShort(this.stars));
		target.setComment(this.comment);
		target.setAreaId(Integer.parseInt(this.area));
		Date updateDate = new Date();
		target.setUpdateUser(this.getUserId());
		target.setUpdateDate(new Timestamp(updateDate.getTime()));

		return target;
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 * @return 無問題ならtrue、ダメならfalse
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(this.name) ||
			StringUtils.isEmpty(this.area) ||
			StringUtils.isEmpty(this.stars) ||
			StringUtils.isEmpty(this.comment)) {
			return false;
		}
		return true;
	}

	/**
	 * DBから取得したエリア情報を元に
	 * プルダウン用エリアマップを作成してセットする
	 */
	private void setAreaMap() {
		AreaDao dao = new AreaDao();
		this.areaMap = dao.getAll().stream().collect(
			() -> new HashMap<String, String>(),
			(map, area) -> map.put(String.valueOf(area.getId()), area.getName()),
			(map, area) -> map.putAll(map)
		);
		// エリア未選択時用
		this.areaMap.put("", "エリアを選択する");
	}

	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 *
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * areaを返す
	 *
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * areaをセットする
	 *
	 * @param area セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * areaMapを返す
	 *
	 * @return areaMap
	 */
	public Map<String, String> getAreaMap() {
		return this.areaMap;
	}

	/**
	 * starsを返す
	 *
	 * @return stars
	 */
	public String getStars() {
		return this.stars;
	}

	/**
	 * starsにセットする
	 *
	 * @param stars セットする stars
	 */
	public void setStars(String stars) {
		this.stars = stars;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * commentをセットする
	 *
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * updateBtnTitleを返す
	 *
	 * @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}

	/**
	 * imageをセットする
	 *
	 * @param image セットする image
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * imageContentTypeをセットする
	 *
	 * @param imageContentType セットする imageContentType
	 */
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**
	 * imageFileNameをセットする
	 *
	 * @param imageFileName セットする imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}
