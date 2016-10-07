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

import training2016.dao.MeganeDao;
import training2016.model.Megane;
import training2016.model.MeganeArea;

//Actionクラスのreturn値と出力先を設定する。のテーション
@Results({ @Result(name = "update", value = "meganeUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "purchase", value = "meganePurchase.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "meganeDelete.action", type = ServletRedirectResult.class)})

public class meganeSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L; // シリアルバージョンUID値は適当でも良いらしい他と被るとダメらしい

	/* 画面タイトル */
	private String title = "メガネ購入検索";

	/** ブラウザからの入力項目 */


	/*画像*/
	private String gazou;
	/* メガネの形 */
	private String area;
	/* ブランド名 */
	private String name;

	/* 購入ID */
	private String purchase;

	/* 更新ID */
	private String updateId;

	/* 削除ID */
	private String delete;

	private static final String IMG_SAVE_BASE = "C:\\pleiades\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebAppTraining\\assets\\images";

	/* エリアプルダウン用マップ */
	// マップを生成するときに使うもの.1つのキーに１つの値
	private Map<String, String> MeganeForm = new HashMap<String, String>();/*DBとマッピングする*/

	/* 検索リスト */
	public ArrayList<Megane> meganeTable = new ArrayList<Megane>();

	// ～豚野郎さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	//エラーメッセージとか
	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	// イニシャライザ＝このメガネフォームを初期化
	{
		this.setMeganeForm();
	}

	/* 初期値の設定 */
	private String getDefaultArea() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	/* executeメソッド→SQLTextプロパティに設定したSQL文をサーバプログラムに対して実行する １番最初に実行 */
	@Override
	public String execute() {
		this.area = getDefaultArea();
		this.name = getDefaultName();

		this.setMeganeForm();

		return "success";
	}

	/* リセットボタンを押したとき */
	public String reset() {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.setMeganeForm();
		this.sessionMap.put("message", null);
		return "success";

	}

	/* 検索ボタンを押したとき */
	public String search() {
		MeganeDao Dao = new MeganeDao();
		List<?> resultTable = null; // ワイルドカード「参照するものならなんでも」何かの型のオブジェクトの格納が出来るリスト。その型が何かは分からない。
		if (StringUtils.isEmpty(area) && StringUtils.isEmpty(name)) {	//形も名前も入っていないとき
			resultTable = Dao.meganeList(); // nullのとき
		} else {
			area = this.area.trim(); // trim入力時に先頭または後ろに空白がある場合はそれを取り除いて認識する
			name = this.name.trim();

			resultTable = Dao.resultList(area, name); // 条件あり
		}
		this.sessionMap.put("message", null);//エラー文が出てるところにnullで打ち消してる
		this.meganeTable.addAll(resultTrans(resultTable));
		this.setMeganeForm();

		return "success";
	}

	/* テーブルの作成 選択されたフォームのパラメータをセットして返す */
	/**メガネクラス作成理由・・・中身が欲しい。配列にして中身を全て回すためリストにする*/
	public ArrayList<Megane> resultTrans(List<?> resultTable) {
		ArrayList<Megane> tempTable = new ArrayList<Megane>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Megane temp = new Megane();
				obj = (Object[]) resultTable.get(i);
				Megane a = (Megane) obj[0];//配列の1番目
				MeganeArea aa = (MeganeArea) obj[1];//メガネを見た後の配列で1個ずれる
				temp.setGazou(a.getGazou());
				temp.setId(a.getId());
				temp.setMeganeAreaId(a.getMeganeAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setColor(a.getColor());
				temp.setLink(a.getLink());
				temp.setKingaku(a.getKingaku());
				temp.setSyousai(a.getSyousai());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}



	/* 追加・更新ボタンを押したとき */
	public String update() {
		// セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);//同じ名前を使っているobjと結びつける
		try {
			this.response.sendRedirect("meganeUpdate.action"); // 追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}


	/* 購入ボタンを押したとき チェックアリならmeganePurchase.actionにとばす */
	public String purchase() {
		this.sessionMap.put("purchaseId", this.purchase);
		if (purchase == null) {
			addActionError("なんか買ってよ、、お願いだよ");
			search();/*初期化されないようにする*/
			return "error";
		} else {
			try {
				this.response.sendRedirect("meganePurchase.action"); // チェック項目があれば
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}



	/* 削除ボタンを押したとき チェックアリならmeganeDeleteActionにとばす */
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("消すの消さないのどっち");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("meganeDelete.action"); // チェック項目があれば
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}


	/* setter・getter */
	/**
	 * エリアをセットする
	 *
	 * @param area
	 *            セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}



	/**
	 * 画像をセットする
	 *
	 *
	 */
	public void setGazou(String gazou) {
		this.gazou = gazou;
	}

	/**
	 * ブランド名を返す
	 *
	 *
	 */
	public String getGazou() {
		return this.gazou;
	}



	/**
	 * メガネの形を返す
	 *
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * ブランド名をセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ブランド名を返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 購入idをsetする
	 *
	 * @param purchase
	 *            セットする purchase
	 */
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	/**
	 * 購入idを返す
	 *
	 * @return purchase
	 */
	public String getPurchase() {
		return this.purchase;
	}

	/**
	 * 更新idをセットする
	 *
	 * @param updateId
	 *            セットする update
	 */
	public void setUpdateId(String updateId) {

		this.updateId = updateId;
	}

	/**
	 * 更新idを返す
	 *
	 * @return update
	 */
	public String getUpdateId() {
		return this.updateId;
	}


	/**
	 * 削除idをセットする
	 *
	 *
	 */
	public void setDelete(String delete) {

		this.delete = delete;
	}

	/**
	 * 削除idを返す
	 *
	 *
	 */
	public String getDelete() {
		return this.delete;
	}



	/**
	 * 画面タイトルを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * メガネフォームを返す
	 *
	 * @return MeganeForm
	 */
	public Map<String, String> getMeganeForm() {
		return this.MeganeForm;
	}


	/**
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setMeganeForm() {
		MeganeDao dao = new MeganeDao();
		List<?> resultTable = dao.getMeganeAreaList();
		this.MeganeForm = tableTrans(resultTable); // ListをMapに変換
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			MeganeForm.put("", "");/*表示させる*/
			for (int i = 0; i < resultTable.size(); i++) {
				MeganeArea aa = (MeganeArea) resultTable.get(i);
				MeganeForm.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MeganeForm;
	}

	public static String getImgSaveBase() {
		return IMG_SAVE_BASE;
	}

}
