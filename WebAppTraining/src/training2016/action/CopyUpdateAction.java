package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.CopyDao;
import training2016.dao.TitleDao;
import training2016.model.Copy;
import training2016.model.CopySearchCondition;

/**
 * コピー追加・更新Action
 *
 * @author minoguchi
 */
@Results({ @Result(name = "backToSearch", value = "copySearch!redisplay", type = ServletRedirectResult.class) })
public class CopyUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String titlename = "あらたなコピー能力をおぼえた！";
	/** ボタン表示名 */
	private String updateBtnTitle = "おぼえる";

	/** ID(更新時のみ) */
	private String id;
	/** コピー名 */
	private String name;
	/** 初登場作品タイトル */
	private String title;
	/** 検索結果マップ */
	private Map<String, String> titleMap;
	/** 登場回数 */
	private String appearance;

	/** コメント */
	private String imgpath;

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
		this.setTitleMap();
	}

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	public String execute() throws Exception {
		// セッションマップから更新対象IDを取得
		this.id = this.getValueFromSession("updateId");

		CopyDao dao = new CopyDao();
		Copy target = null;
		// 更新対象IDがあればデータの更新
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Copy.class);
			if (target != null) {
				this.name = target.getName();
				this.title = String.valueOf(target.getTitleid());
				this.appearance = String.valueOf(target.getAppearance());
				this.imgpath = target.getImg_path();
				this.updateBtnTitle = "更新";
				this.titlename = "コピー能力がパワーアップした！";
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

		CopyDao dao = new CopyDao();
		// 排他フラグを確認
		if (StringUtils.isNotEmpty(this.id)) {
			CopySearchCondition cond = new CopySearchCondition();
			cond.setId(this.id);
			List<Copy> resultList = dao.getByCondition(cond);
			if (resultList.get(0).isExclusiveflag()) {
				this.addActionError("ほかの人が使用中です。");
				return "error";
			}else{
				resultList.get(0).setExclusiveflag(true);
				dao.update(resultList.get(0));
			}
		} else {

		}

		try {
			// 画像
			if (this.image != null) {
				BufferedImage img = ImageIO.read(image);
				String expansionName = this.imageContentType.split("/")[1];
				String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String tempFileName = this.imageFileName + "_" + dateString + "." + expansionName;
				//img_pathに格納用W
				imgpath = tempFileName;
				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("")
						+ IMG_SAVE_BASE + "\\" + tempFileName));
				System.out.println("img: "+img);
				System.out.println("expansionName: "+expansionName);
				System.out.println("dateString: "+dateString);
				System.out.println("tempFileName: "+ tempFileName);
			}else{
				imgpath = "Nodata.jpg";
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			this.addActionError("画像の保存に失敗しました");
		}

		// ID があれば更新なので、一度取得したモデルに入力値をセットする
		if (StringUtils.isNotEmpty(this.id)) {
			Copy target = dao.select(Integer.parseInt(this.id), Copy.class);
			//排他フラグを戻す
			target.setExclusiveflag(false);
			dao.update(this.generateCopyModel(target));
		} else {
			dao.insert(this.generateCopyModel());
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
	 * 今フィールドに保持している値でCopyModelを生成して返す
	 *
	 * @return copy
	 */
	private Copy generateCopyModel() {
		Copy model = new Copy();
		model.setName(this.name);
		model.setAppearance(Integer.parseInt(this.appearance));
		model.setImg_path(this.imgpath);
		model.setTitleid(Integer.parseInt(this.title));
		Date registerDate = new Date();
		model.setCreateuser(this.getUserId());
		model.setCreatedate(new Timestamp(registerDate.getTime()));
		model.setUpdateuser(this.getUserId());
		model.setUpdatedate(new Timestamp(registerDate.getTime()));
		model.setDeleteflag(false);
		model.setExclusiveflag(false);

		return model;
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す
	 * 更新用。
	 *
	 * @return copy
	 */
	private Copy generateCopyModel(Copy target) {
		target.setName(this.name);
		target.setAppearance(Integer.parseInt(this.appearance));
		target.setImg_path(this.imgpath);
		target.setTitleid(Integer.parseInt(this.title));
		Date updateDate = new Date();
		target.setUpdateuser(this.getUserId());
		target.setUpdatedate(new Timestamp(updateDate.getTime()));

		return target;
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 * @return 無問題ならtrue、ダメならfalse
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(this.name) || StringUtils.isEmpty(this.title) || StringUtils.isEmpty(this.appearance)) {
			return false;
		}
		return true;
	}

	/**
	 * DBから取得したエリア情報を元に プルダウン用エリアマップを作成してセットする
	 */
	private void setTitleMap() {
		TitleDao dao = new TitleDao();
		this.titleMap = dao.getAll().stream().collect(() -> new LinkedHashMap<String, String>(),
				(map, area) -> map.put(String.valueOf(area.getId()), area.getName()), (map, area) -> map.putAll(map));
	}

	/**
	 * タイトルマップを返す
	 * @return titleMap
	 */
	public Map<String, String> getTitleMap() {
		return this.titleMap;
	}

	/**
	 * イメージを決める
	 * @param image
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * イメージのコンテキストタイプを決める
	 * @param imageContentType
	 */
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**
	 * イメージのファイル名を決める
	 * @param imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * IDを返す
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * IDを決める
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * nameを返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameを決める
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * titleを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * titleを決める
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * aapearanceを変える
	 * @return appearance
	 */
	public String getAppearance() {
		return this.appearance;
	}

	/**
	 * appearanceをきめる
	 * @param appearance
	 */
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	/**imgpathを返す
	 * @return
	 */
	public String getImgpath() {
		return this.imgpath;
	}

	/**imgpathを決める
	 * @param imgpath
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	/**
	 * titlenameを返す
	 *
	 * @return titlename
	 */
	public String getTitleName() {
		return this.titlename;
	}

	/**
	 * updateBtnTitleを返す
	 *
	 * @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}

}