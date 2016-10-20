package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
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

//Actionクラスのreturn値と出力先を設定する。
@Results({ @Result(name = "update", value = "chocolateUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "chocolateDelete.action", type = ServletRedirectResult.class) })

public class ChocolateSearchAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	//『シリアライズ可能クラス』につける、『シリアルバージョンUID』というもの
	//『シリアルバージョンUID』とは…
	//シリアライズしたとき、出力したオブジェクトがどのクラスを元に作成されたのかを検証するための番号。

	//画面タイトル
	private String title = "Chocolate Search";


	//ブラウザからの入力項目
	private Map<String,String> chocolateCountryMap = new HashMap<String,String>();
	private String country;
	private String shopName;
	private String delete;
	private String updateId;


	//検索リスト
	public ArrayList<Chocolate> chocolateTable = new ArrayList<Chocolate>();


	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	//イニシャライザで変数を初期化 ここで毎回初期化をしてあげることによって、使っている途中に情報が更新されてもここを通るたびに新しい情報を受け取れる。
	{
		this.setChocolateCountryMap();
	}


	//getDefaultメソッドを定義して、テキストボックスの初期値をreturn""（空欄）で返す
	private String getDefaultCountry() {
		return "";
	}
	private String getDefaultShopName() {
		return "";
	}


	//executeメソッド：指定された文字列を正規表現で検索する。複数結果を返す。一番最初に実行される。
	//ここで、getDefaultメソッドを呼び出してあげて、空欄を指定する。
	public String execute() {
		this.country = getDefaultCountry();
		this.shopName = getDefaultShopName();

		this.setChocolateCountryMap();

		return "success";
	}


	//リセットボタンを押したとき
	public String reset() {
		this.country = getDefaultCountry();
		this.shopName = getDefaultShopName();
		this.setChocolateCountryMap();
		this.sessionMap.put("message", null);
		return "success";

	}


	//検索ボタンを押したとき
	public String search() {
		ChocolateDao Dao = new ChocolateDao();  //resultTableはデータベースの結果セットを表すデータのテーブルで、通常、データベースに照会する文を実行することによって生成される。
		List<?> resultTable = null; //「参照するものならなんでも」何かの型のオブジェクトの格納が出来るリスト。その型が何かは分からない。
		//何も入力されなかったとき↓
		//StringUtilsは、Stringオブジェクトを拡張したクラスのこと。NullPointerException が発生しないように null 判定がされている。
		if (StringUtils.isEmpty(country) && StringUtils.isEmpty(shopName)) {
			resultTable = Dao.chocolateList();
		} else {
			country = this.country.trim(); // trim入力時に先頭または後ろに空白がある場合はそれを取り除いて認識する 後ろのcountryはsetから持ってきたcountry?
			shopName = this.shopName.trim();//変に空白があるとDBにちゃんとした条件を渡せないため

			resultTable = Dao.resultList(country, shopName); // 条件あり
		}
		this.sessionMap.put("message", null);
		this.chocolateTable.addAll(resultTrans(resultTable));
		//下にあるresultTrans()を呼び出してリストを生成
		this.setChocolateCountryMap();

		return "success";
	}


	//テーブルの作成
	//List<?>は、その時のリストの数に応じて変わってくれる。リストを生成して回してobjの箱に入れる。
	//入力されたパラメーターをセットする。
	public ArrayList<Chocolate> resultTrans(List<?> resultTable) {
		ArrayList<Chocolate> tempTable = new ArrayList<Chocolate>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Chocolate temp = new Chocolate();
				obj = (Object[]) resultTable.get(i);
				Chocolate a = (Chocolate) obj[0];
				ChocolateCountry aa = (ChocolateCountry) obj[1];
				//同じtableに入れたいので、どのクラスのの変数にも対応できるobjectクラスの配列を使用
				//[0]にはchocolateクラス情報が、[1]にはchocolatecountryの情報が入っている
				//キャストをしてあげて、情報を取り出す
				temp.setId(a.getId());
				temp.setCountryid(a.getCountryid());
				temp.setCountry(aa.getCountry());
				temp.setShopName(a.getShopName());
				temp.setChef(a.getChef());
				temp.setComment(a.getComment());
				temp.setPrice(a.getPrice());
				temp.setImage(a.getImage());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}


	//追加 ↓chocolateSearsh.jspとChocolateSearch.javaは2つでひとつなので、chocoateSearch.jspでupdate()を呼び出すと何も指定がない限り、
	//このクラスのupdate()が呼び出される
	public String update() {
		// セッションマップに指定されたキーでValueをputする
		//(セッションの生成)
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("chocolateUpdate.action"); // 追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}



	/* 削除ボタンを押したとき チェックアリならchocolateDelete.actionにとばす */
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("chocolateDelete.action"); // チェック項目があれば
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}






	//setter and getter

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, String> getChocolateCountryMap() {
		return this.chocolateCountryMap;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public ArrayList<Chocolate> getChocolateTable() {
		return chocolateTable;
	}

	public void setChocolateTable(ArrayList<Chocolate> chocolateTable) {
		this.chocolateTable = chocolateTable;
	}


	/**
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setChocolateCountryMap() {
		ChocolateDao dao = new ChocolateDao();
		List<?> resultTable = dao.getChocolateCountryList();
		//resultTableはdao.getChocolateCountryList()で行った地域の情報が入っているlist
		//これを引数にして下のtableTrans()を呼び出す↓
		this.chocolateCountryMap = tableTrans(resultTable); // ListをMapに変換
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			chocolateCountryMap.put("", "");//プルダウンの一番最初の空白をセット
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
