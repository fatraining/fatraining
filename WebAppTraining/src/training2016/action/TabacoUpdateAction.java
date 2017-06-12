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

import training2016.dao.TabacoDao;
import training2016.model.Tabaco;
import training2016.model.TabacoArea;

/**
 * たばこ追加・更新のアクション！
 * @author otawaratomoki
 *
 */
@Results({ @Result(name = "tabacoSearch", value = "tabacoSearch.action", type = ServletRedirectResult.class) })
public class TabacoUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "新しいたばこの追加";
	/** ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/** id(更新時のみ) */
	private String id;
	/** エリアid */
	private String tabacoAreaId;
	
	/** 商品画像格納用 */
	private String namePhoto;
	
	/** アップロードファイル*/
	private File image;
	/** アップロードファイルのコンテンツ */
	private String imageContentType;
	
	/** アップロードファイルの元ファイル名 */
	private String imageFileName;

	
	 /** 保存先 */
	 private static final String IMG_SAVE_BASE = "\\assets\\images\\temp";
	
	 
	/** 商品名 */
	private String name;
	/** タール数 */
	private String tar;
	/** ニコチン */
	private String nicotine;
	/** コメント */
	private String comment;
    /** 価格 */
	private String price;
	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	private String errorMessage;

	/** エリアプルダウン用マップ */
	private Map<String, String> tabacoAreaMap = new HashMap<String, String>();
	
	// イニシャライザ
	{
		this.setTabacoAreaMap();
	}

	@Override // 更新
	public String execute() throws Exception {
		this.setTabacoAreaMap();

		// セッションマップから指定のキーでputされた更新対象のIDを取得
		this.id = this.getValueFromSession("updateId");

		TabacoDao dao = new TabacoDao();
		Tabaco target = null;// 更新の対象
		// 更新対象IDがあったらデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) { // idがあったら
			target = dao.select(Integer.parseInt(this.id), Tabaco.class); // idを引数にして更新対象のobjectを持ってくる
			if (target != null) {// idがあったら
				this.tabacoAreaId = String.valueOf(target.getTabacoAreaId());// IDをString型に変える
				this.namePhoto = target.getNamePhoto();
				this.name = target.getName();
				this.tar = target.getTar();
				this.nicotine = target.getNicotine();
				this.price = target.getPrice();
				this.comment = target.getComment();

				this.updateBtnTitle = "更新"; // ボタンのvalueを追加から更新へ
				this.title = "たばこ新しくなった？";
			}
		}else{
			//新規
			this.id = "";
		}
		return "success";
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 */
	private boolean isEmptyParam(String param){
		return StringUtils.isEmpty(param);
	}
	
	/**
	 * updateメソッド idがあれば更新、なければ追加になる。更新、追加し終わったら検索画面へ戻る
	 */
	public String update(){
		this.setTabacoAreaMap();
		
		if(StringUtils.isNotEmpty(this.id)) {
			this.title ="たばこ新しくなった？";  //idがあればタイトルを"追加"→"更新"
			this.updateBtnTitle = "更新";  //idがあればボタンのvalueを新規登録→更新
		}
		
		if(this.isEmptyParam(tabacoAreaId)){
			addActionError("※銘柄名を選択してください");
		}
		if(this.isEmptyParam(name)){
			addActionError("※商品名を入力してください");
		}
		if(this.isEmptyParam(tar)){
			addActionError("※タール数を入力してください");
		}
		
		//1つでもエラーがあったらだめ
		if(this.getActionErrors().size() > 0){
			return "error";
		}
		
		// 画像アップロード
				try {
					if (this.image != null) {
						BufferedImage img = ImageIO.read(image);
						String expansionName = this.imageContentType.split("/")[1];
						ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("")
								+ IMG_SAVE_BASE + "\\" + imageFileName));
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
					this.message = "画像の保存に失敗しました";
				}
				
				// idがあれば更新なので、一度取得したモデルに入力値をセットする
				TabacoDao dao = new TabacoDao();
				if(StringUtils.isNotEmpty(this.id)) {
					Tabaco target = dao.select(Integer.parseInt(this.id),Tabaco.class);
					//更新したテーブルを上書き
					dao.update(this.generateTabacoModel(target)); //上書きは下に書いてある
					this.message = "データを更新しました";
					this.sessionMap.put("message", this.message);
				}else{ //新規の場合
					dao.insert(this.id, 
								this.tabacoAreaId,
								this.imageFileName,
								this.name, 
								this.tar,
								this.nicotine,
								this.price,
								this.comment);
					this.message = "新しいデータを追加しました";
					this.sessionMap.put("message", this.message);
				
				}
				
				return "tabacoSearch";
	}
	
	/**
	 * 今フィールドに保持している値で引数のモデルにセットにして返す『更新用』
	 */
	private Tabaco generateTabacoModel(Tabaco target){
		target.setTabacoAreaId(Integer.parseInt(this.tabacoAreaId));
		target.setNamePhoto(this.imageFileName);
		target.setName(this.name);
		target.setTar(this.tar);
		target.setNicotine(this.nicotine);
		target.setPrice(price);
		target.setComment(this.comment);
		
		return target;
	}

	/**
	 * タイトルを返す
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * uodatebtntitleを返す
	 * @return
	 */

	public String getUpdateBtnTitle() {
		return updateBtnTitle;
	}

	/**
	 * idをセットして返す
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * tabacoAreaIdをセットして返す
	 * @return
	 */
	public String getTabacoAreaId() {
		return tabacoAreaId;
	}

	public void setTabacoAreaId(String tabacoAreaId) {
		this.tabacoAreaId = tabacoAreaId;
	}
	
	/**
	 * 商品画像をセットして返す
	 * @return
	 */
	/** イメージを決める */
	public void setImage(File image) {
		this.image = image;
	}
	/** イメージのコンテントタイプを決める */	
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**イメージのファイル名を決める */	
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}
		
	/**
	 * 商品名をセットして返す
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 価格をセットして返す
	 * @return
	 */
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * タールをセットして返す
	 * @return
	 */

	public String getTar() {
		return tar;
	}

	public void setTar(String tar) {
		this.tar = tar;
	}
	/**
	 * ニコチンをセットして返す
	 * @return
	 */

	public String getNicotine() {
		return nicotine;
	}

	public void setNicotine(String nicotine) {
		this.nicotine = nicotine;
	}
	/**
	 * コメントをセットして返す
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**商品画像をセットして返す */
	public String getNamePhoto() {
		return namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	/**
	 * messageをセットして返す
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * errormessageをセットして返す
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	/**
	 * エリア【銘柄】プルダウン用のマップをセットする
	 */
	public void setTabacoAreaMap() {
		TabacoDao dao = new TabacoDao();
		List<?> resultTable = dao.getTabacoAreaList();
		this.tabacoAreaMap = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 */
	public Map<String, String> getTabacoAreaMap() {
		return this.tabacoAreaMap;
	}

	/*-----------------------------------*/
	// エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			tabacoAreaMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				TabacoArea tt = (TabacoArea) resultTable.get(i);
				tabacoAreaMap.put(tt.getId(), tt.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tabacoAreaMap;
	}
	
}
