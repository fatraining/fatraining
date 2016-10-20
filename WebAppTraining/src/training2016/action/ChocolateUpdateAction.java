package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.ChocolateDao;
import training2016.model.Chocolate;
import training2016.model.ChocolateCountry;

//extends AbstractActionを継承して、addActionErrorメソッドとかを使えるようにしてあげる

@Results({ @Result(name = "chocolateSearch", value = "chocolateSearch.action", type = ServletRedirectResult.class) })
public class ChocolateUpdateAction extends AbstractAction {

	private static final long serialVersionUID = 1L;


	//画面タイトル
	private String title = "AddChocolate";
	//ボタンに表示する文字
	private String updateBtnTitle = "Add";


	private String id;
	private String countryid;
	private String shopName;
	private String chef;
	private String comment;
	private String price;
	private String image;

	//メッセージ
	private String message;
	//エラーメッセージ
	private String errorMessage;

	//エリアプルダウン用マップ
	private Map<String, String> chocolateCountryMap = new HashMap<String, String>();

	// イニシャライザ 最初の入力項目をはずす
	{
		this.setChocolateCountryMap();
	}


	public String execute() throws Exception{
		this.setChocolateCountryMap();

		// セッションマップから更新対象のidを取得
				this.id = this.getValueFromSession("updateId");

				ChocolateDao dao = new ChocolateDao();
				Chocolate target = null; // 更新対象
				// 更新対象idがあれば、更新の画面をここで作る
				if (StringUtils.isNotEmpty(this.id)) {
					target = dao.select(Integer.parseInt(this.id), Chocolate.class); // idを引数にして更新対象のobjectを持ってくる
					if (target != null) {
						this.countryid = String.valueOf(target.getCountryid()); // IDをStringに
						this.shopName = target.getShopName();
						this.chef = target.getChef();
						this.comment = target.getComment();
						this.image = target.getImage();
						this.price = target.getPrice();

						this.updateBtnTitle = "Update"; // ボタンのvalueを追加→更新
						this.title = "チョコレートを更新";
					}
				} else {
					// 新規(idがなければ、idがないということをsetして、updateメソッドで新規の場合に進む
					this.id = "";
				}
				return "success";
			}
	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/**
	 * updateメソッド idがあれば更新、なければ追加になる 更新、追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setChocolateCountryMap();

		if (this.isEmptyParam(countryid)) {
			addActionError("Areaを選択してください");
		}
		if (this.isEmptyParam(shopName)) {
			addActionError("Shop nameを入力してください");
		}
		if (this.isEmptyParam(chef)) {
			addActionError("Chefを入力してください");
		}
		if (this.isEmptyParam(comment)) {
			addActionError("Commentを入力してください");
		}
		if (this.isEmptyParam(image)) {
			addActionError("Imageを挿入してください");
		}
		if (this.isEmptyParam(price)) {
			addActionError("Priceを入力してください");
		}

		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {
			return "error";
		}

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		ChocolateDao dao = new ChocolateDao();
		if (StringUtils.isNotEmpty(this.id)) {
			Chocolate target = dao.select(Integer.parseInt(this.id), Chocolate.class);
			//AbstractDaoにあるselect()を呼び出して、sessionを取得
			dao.update(this.generateChocolateModel(target));
			//取得したsessionを引数に下にあるgenerateChocolateMode()メソッドを実行して、Modelの形にしてupdate()に渡す
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else { // 新規の場合
			dao.insert(this.id,this.image,this.countryid, this.shopName, this.chef, this.comment,this.price);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}

		return "chocolateSearch";
	}

	/**
	 * 今フィールドに保持している値(新しいもの)で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Chocolate generateChocolateModel(Chocolate target) {
		target.setCountryid(Integer.parseInt(this.countryid));
		target.setShopName(this.shopName);
		target.setChef(this.chef);
		target.setComment(this.comment);
		target.setImage(this.image);
		target.setPrice(this.price);
		return target;





		//setter and gettre

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpdateBtnTitle() {
		return updateBtnTitle;
	}
	public void setUpdateBtnTitle(String updateBtnTitle) {
		this.updateBtnTitle = updateBtnTitle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	/**
	 * エリアプルダウン用マップをセットする
	 *
	 */
	public void setChocolateCountryMap() {
		ChocolateDao dao = new ChocolateDao();
		List<?> resultTable = dao.getChocolateCountryList();
		this.chocolateCountryMap = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 *
	 * @return chocolateCountryMap
	 */
	public Map<String, String> getChocolateCountryMap() {
		return this.chocolateCountryMap;
	}

	/*-----------------------------------*/
	// エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			chocolateCountryMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				ChocolateCountry aa = (ChocolateCountry) resultTable.get(i);
				chocolateCountryMap.put(aa.getId(), aa.getCountry());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chocolateCountryMap;
	}
	}
