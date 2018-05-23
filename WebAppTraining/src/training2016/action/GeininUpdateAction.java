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

		return "success";
	}



	/* 追加or更新ボタンクリック時 */
	public String update() {

//		// 全ての値が入っているかの判定
//		if (this.isEmpty(this.image) || this.isEmpty(this.name) || this.isEmpty(this.work)) {
//			addActionError("全ての項目を入力してください");
//			this.title = "若手芸人データ更新";
//			this.btn = "更新";
//			System.out.println("updateError: すべての値が入っていない");
//			return "error";
//		}
//
//		// 画像の書き方が適切であるかの判定
//		if (this.imageCheck(this.image)) {
//			addActionError("画像アドレスが適切ではありません");
//			this.title = "若手芸人データ更新";
//			this.btn = "更新";
//			System.out.println("updateError: 画像アドレスが適切ではない");
//			return "error";
//		}

		GeininDao dao = new GeininDao();
//		if (StringUtils.isNotEmpty(this.id)) {
////			データを更新する
////			Geinin geinin = dao.select(Integer.parseInt(this.id), Geinin.class);
////			geinin.setId(id);
////			this.sessionMap.put("completeMessage", "更新しました");
//		} else {
//			データを追加する

			dao.insert(this.image, this.name, this.work);
//			this.sessionMap.put("completeMessage", "追加しました");
//		}
//		this.sessionMap.put("from", "update");
		return "geininSearch";
	}




//	データが空かどうか
	private boolean isEmpty(String param) {
		return StringUtils.isEmpty(param);
	}

//	00.jpgの形をとっているか
	private boolean imageCheck(String address) {
		String[] addressSplit = address.split("\\.");
		if(addressSplit.length != 2) {
			return false;
		}else if(addressSplit[1].equals("jpg") || addressSplit[1].equals("png") || addressSplit[1].equals("gif")) {
			return true;
		}else {
			return false;
		}

	}


//	setter/getter



}
