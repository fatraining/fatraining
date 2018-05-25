package training2016.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GeininDao;
import training2016.model.Geinin;

@Results({ @Result(name = "geininSearch", value = "geininSearch.action", type = ServletRedirectResult.class) })
public class GeininUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;


	// タイトル及びボタンの表示名は追加更新ボタンによって変化
	/* タイトル */
	private String title = "若手芸人データ追加";

	/* ボタン表示 */
	private String btn = "追加";

//	メッセージ
	private String message;
	private String errorMessage;

	/* 追加する項目 */
	private String id;
	private String image;
	private String name;
	private String work;


//	// プルダウン用マップ
//	/* メーカー */
//	private Map<String, String> makerMap = new HashMap<>(); // DBからマッピング
//
//	/* 商品タイプ */
//	private Map<String, String> typeMap = new LinkedHashMap<>(); // 配列を取得
//
//	/* 検索リスト */
//	public List<PotatoProduct> potatoTable = new ArrayList<>();

	// 初期値の設定
	/*----------------------------------------------
	*/

//	@Override
	public String execute() {
		// セッションマップから指定のキーでputされた更新対象のIDを取得
//		★
		this.id = this.getValueFromSession("updateId");

		GeininDao dao = new GeininDao();
		Geinin geinin = null;
		//セッションマップから取得した更新対象のIDが空でない場合
		if (StringUtils.isNotEmpty(this.id)) { //つまり「更新」のとき
			geinin = dao.searchById(id);
//			geinin = dao.select(Integer.parseInt(this.id), Geinin.class);
			if (geinin != null) { //更新対象のデータが空でない場合
				this.id = geinin.getId();
				this.name = geinin.getName();
				this.image = geinin.getImage();
				this.work = geinin.getWork();
				this.title = "若手芸人データ更新";
				this.btn = "更新";
			}
		} else { //「追加」のとき
			this.id = "";
		}
		this.message = getValueFromSession("message");
		this.errorMessage = getValueFromSession("errorMessage");
		return "success";
	}



	/* 追加or更新ボタンクリック時 */
	public String update() {

		// 全ての値が入っているかの判定
		if (this.isEmpty(this.image) || this.isEmpty(this.name) || this.isEmpty(this.work)) {
			this.sessionMap.put("errorMessage", "全ての項目を入力してください");
			this.title = "若手芸人データ更新";
			this.btn = "更新";
			System.out.println("updateError: すべての値が入っていない");
			return "error";
		}

		// 画像の書き方が適切であるかの判定
		if (this.imageCheck(this.image)) {
			this.sessionMap.put("errorMessage", "画像アドレスが適切ではありません");
			this.title = "若手芸人データ更新";
			this.btn = "更新";
			System.out.println("updateError: 画像アドレスが適切ではない");
			return "error";
		}

		GeininDao dao = new GeininDao();
		if (StringUtils.isNotEmpty(this.id)) {
//			データを更新する
			dao.update(this.id, this.image, this.name, this.work);
			this.sessionMap.put("message", "更新しました");
		} else {
//			データを追加する
			dao.insert(this.image, this.name, this.work);
			this.sessionMap.put("message", "追加しました");
		}
//		this.sessionMap.put("from", "update");
		return "geininSearch";
	}




//	データが空かどうか
	private boolean isEmpty(String param) {
		return StringUtils.isEmpty(param);
	}

//	00.jpgの形をとっているか 形をとっていたらfalse
	private boolean imageCheck(String address) {
		boolean check = false;
		String[] addressSplit = address.split("\\.");

////		check
//		for(int i = 0; i < addressSplit.length; i++) {
//			System.out.println(addressSplit[i]);
//		}

		if(addressSplit.length == 2) {
			if(addressSplit[1].equals("jpg") || addressSplit[1].equals("png") || addressSplit[1].equals("gif")) {
				check = true;
			}
		}
		return !check;
	}



//	setter/getters

	/**
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}



	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return btn
	 */
	public String getBtn() {
		return this.btn;
	}



	/**
	 * @param btn セットする btn
	 */
	public void setBtn(String btn) {
		this.btn = btn;
	}



	/**
	 * @return id
	 */
	public String getId() {
		return this.id;
	}



	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return image
	 */
	public String getImage() {
		return this.image;
	}



	/**
	 * @param image セットする image
	 */
	public void setImage(String image) {
		this.image = image;
	}



	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}



	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return work
	 */
	public String getWork() {
		return this.work;
	}



	/**
	 * @param work セットする work
	 */
	public void setWork(String work) {
		this.work = work;
	}



	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}



	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}



	/**
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}



	/**
	 * @param errorMessage セットする errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}






}
