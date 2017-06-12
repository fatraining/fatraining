 package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.MeganeDao;
import training2016.model.Megane;
import training2016.model.MeganeArea;

/**
 * メガネ追加・更新のアクション
 *
 */
@Results({ @Result(name = "meganeSearch", value = "meganeSearch.action", type = ServletRedirectResult.class) })
public class MeganeUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "メガネ追加";
	/** ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/** id(更新時のみ) */
	private String id;
	/** メガネid */
	private String meganeAreaId;
	/** ブランド名 */
	private String name;
	/** カラー */
	private String color;

	/** 金額 */
	private String kingaku;

	/** リンク */
	private String link;

	/** 詳細 */
	private String syousai;

	private String gazou;

	private File gazouFileName;
	private String gazouContentType;

	private static final String IMG_SAVE_BASE = "\\assets\\images";

	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	private String errorMessage;

	/** エリアプルダウン用マップ */
	private Map<String, String> MeganeForm = new HashMap<String, String>();

	private String gazouFileNameContentType;

	// イニシャライザ 最初の入力項目をはずす
	{
		this.setMeganeForm();
	}

	@Override // 更新・追加
	public String execute() throws Exception {
		this.setMeganeForm();

		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		MeganeDao dao = new MeganeDao();
		Megane target = null; // 更新対象
		// 更新対象idがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {/* あったら */
			target = dao.select(Integer.parseInt(this.id), Megane.class); // idを引数にして更新対象のobjectを持ってくる
			if (target != null) {/* あったら */
				this.meganeAreaId = String.valueOf(target.getMeganeAreaId()); // IDをStringに
				this.name = target.getName();
				this.color = target.getColor();
				this.kingaku = target.getKingaku();
				this.link = target.getLink();
				this.syousai = target.getSyousai();
				this.gazou = target.getGazou();

				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
				this.title = "メガネの更新";
			}
		} else {
			// 新規
			this.id = "";
		}
		return "success";
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 */
	private boolean isEmptyParam(String param) {/* 初期がfalse */
		return StringUtils.isEmpty(param);
	}

	/**
	 * updateメソッド idがあれば更新、なければ追加になる 更新、追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setMeganeForm();

		if (this.isEmptyParam(meganeAreaId)) {
			addActionError("形を入力してください");
		}
		if (this.isEmptyParam(name)) {
			addActionError("ブランド名を入力してください");
		}
		if (this.isEmptyParam(color)) {
			addActionError("カラーを入力してください");
		}
		if (this.isEmptyParam(kingaku)) {
			addActionError("金額を入力してください");
		}
		if (this.isEmptyParam(link)) {
			addActionError("リンクを入力してください");
		}
		if (this.isEmptyParam(syousai)) {
			addActionError("詳細を入力してください");
		}

		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {
			return "error";
		}

		// 画像アップロード
		try {
			if (this.gazouFileName != null) {
				BufferedImage img = ImageIO.read(gazouFileName);
				String expansionName = this.gazouContentType.split("/")[1];

				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("")
						+ IMG_SAVE_BASE + "\\" + gazou));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			this.message = "画像の保存に失敗しました";
		}

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		MeganeDao dao = new MeganeDao();
		if (StringUtils.isNotEmpty(this.id)) {
			Megane target = dao.select(Integer.parseInt(this.id), Megane.class);
			// 更新したテーブルを上書き
			dao.update(this.generateMeganeModel(target));/* 上書きは下に書いてあります */
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else { // 新規の場合
			dao.insert(this.id, this.meganeAreaId, this.name, this.color, this.kingaku, this.link, this.syousai,
					this.gazou);
			this.sessionMap.put("message", this.message);
			this.message = "追加しました";

		}

		return "meganeSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Megane generateMeganeModel(Megane target) {
		target.setMeganeAreaId(Integer.parseInt(this.meganeAreaId));
		target.setName(this.name);
		target.setColor(this.color);
		target.setKingaku(this.kingaku);
		target.setLink(this.link);
		target.setSyousai(this.syousai);
		target.setGazou(this.gazou);

		return target;
	}



	/* setter・getter */
	/**
	 * updateBtnTitleを返す
	 *
	 * @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
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
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * meganeAreaIdをセットする
	 *
	 * @param meganeAreaId
	 *            セットする meganeAreaId
	 */
	public void setMeganeAreaId(String meganeAreaId) {
		this.meganeAreaId = meganeAreaId;
	}

	/**
	 * meganeAreaIdを返す
	 *
	 * @return meganeAreaId
	 */
	public String getMeganeAreaId() {
		return this.meganeAreaId;
	}

	/**
	 * nameをセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * カラーをセットする
	 *
	 * @param color
	 *            セットする collor
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * カラーを返す
	 *
	 * @return color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * 金額をセットして返す
	 *
	 * @param kingaku
	 *            セットする kingakut
	 */
	public void setKingaku(String kingaku) {
		this.kingaku = kingaku;
	}

	public String getKingaku() {
		return this.kingaku;
	}

	/**
	 * リンクをセットする
	 *
	 * @param link
	 *            セットする l
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * リンクを返す
	 *
	 * @return link
	 */
	public String getLink() {
		return this.link;
	}

	/**
	 * 詳細をセットしてゲット
	 *
	 *
	 *
	 */
	public void setSyousai(String syousai) {
		this.syousai = syousai;
	}

	public String getSyousai() {
		return this.syousai;
	}






	// 画像gazou,gazouContentTypeのセット
	public void setGazouFileName(File gazouFileName) {
		this.gazouFileName = gazouFileName;
	}

	public void setGazouFileNameContentType(String gazouFileNameContentType) {
		this.gazouFileNameContentType = gazouFileNameContentType;
	}

	/**
	 * メッセージをセットする
	 *
	 * @param message
	 *            セットする messagge
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * メッセージを返す
	 *
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * エラーメッセージを返す
	 *
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * エリアプルダウン用マップをセットする
	 *
	 */
	public void setMeganeForm() {
		MeganeDao dao = new MeganeDao();
		List<?> resultTable = dao.getMeganeAreaList();
		this.MeganeForm = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 *
	 * @return MeganeForm
	 */
	public Map<String, String> getMeganeForm() {
		return this.MeganeForm;
	}

	/*-----------------------------------*/
	// エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			MeganeForm.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				MeganeArea aa = (MeganeArea) resultTable.get(i);
				MeganeForm.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MeganeForm;
	}
}
