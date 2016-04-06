package action;

import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.MemberInfoDao;
import dao.OrderInfoDao;
import model.MemberInfo;
import model.OrderInfo;
import model.ResultGoodsList;
import model.ResultMemberInfo;

/**
 * 顧客情報確認画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "next", value = "tmOrderConfirm.action", type = ServletRedirectResult.class),
@Result(name = "back", value = "tmInputUserInfo.action", type = ServletRedirectResult.class),
@Result(name = "change", value = "tmChangeMemberInfo.action", type = ServletRedirectResult.class)
})
public class TmCheckUserInfoAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 顧客情報クラス（画面表示用）
	 */
	private ResultMemberInfo memberInfo;
	/**
	 * 顧客情報テーブルクラス
	 */
	private MemberInfo memberInfoTable;
	/**
	 * ボタンID
	 */
	private String buttonId;

	//=============================
	// setter/getter
	//=============================
	/**
	 * 顧客情報クラス（画面表示用）
	 * @param memberInfo
	 */
	public void setMemberInfo(ResultMemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	/**
	 * 顧客情報クラス（画面表示用）
	 * @return memberInfo
	 */
	public ResultMemberInfo getMemberInfo() {
		return this.memberInfo;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @param memberInfoTable
	 */
	public void setMemberInfoTable(MemberInfo memberInfoTable) {
		this.memberInfoTable = memberInfoTable;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @return memberInfoTable
	 */
	public MemberInfo getMemberInfoTable() {
		return this.memberInfoTable;
	}
	/**
	 * ボタンID
	 * @param buttonId
	 */
	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}
	/**
	 * ボタンID
	 * @return buttonId
	 */
	public String getButtonId() {
		return buttonId;
	}

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute
     * @return
     * @throws Exception
	 */
	public String execute() throws Exception {
		// 顧客情報を取得
		setMemberInfo((ResultMemberInfo)super.sessionMap.get("memberInfo"));

		// ボタンIDの取得
		setButtonId((String)super.sessionMap.get("buttonId"));

		return "init";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		// 注文情報の登録
		insertOrderInfo();
		// 注文確定画面へ
		return "next";
	}

	/**
	 * 変更するボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String change() throws Exception {
		// 顧客情報の更新
		updateMemberInfo();

		// 変更確定画面へ
		return "change"; 
	}
	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		// 顧客情報表示・入力画面へ
		return "back";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 注文情報の登録
	 */
	private void insertOrderInfo() {
		ArrayList<ResultGoodsList> goodsList = (ArrayList<ResultGoodsList>)super.sessionMap.get("goodsList");
		ResultMemberInfo memberInfo = (ResultMemberInfo)super.sessionMap.get("memberInfo");
		ArrayList<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
		OrderInfoDao orderInfoDao = new OrderInfoDao();

		// 注文番号の採番
		String orderNo = setOrderNo(orderInfoDao);

		// 会員IDの取得
		String memberId = null;
		if (super.sessionMap.get("memberId") == null) {
			memberId = "********************";
		} else {
			memberId = (String)super.sessionMap.get("memberId");
		}

		// システム日時を取得
		Date date = new Date();

		// 登録内容の設定
		for (int i = 0; i < goodsList.size(); i++) {
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrderNo(orderNo);
			orderInfo.setOrderMemberID(memberId);
			orderInfo.setOrderGoodsCode(goodsList.get(i).getCode());
			orderInfo.setOrderQuantity(goodsList.get(i).getQuantity());
			orderInfo.setOrderDate(date);
			orderInfo.setRemarks(memberInfo.getRemarks());
			orderInfo.setSendingFlag("0");
			orderInfo.setDeleteFlag("0");
			orderInfo.setRegistrationUserID("system");
			orderInfo.setRegistrationDate(date);
			orderInfo.setUpdateUserID("system");
			orderInfo.setUpdateDate(date);
			orderInfoList.add(orderInfo);
		}

		// 登録処理
		orderInfoDao.insert(orderInfoList);
	}
	
	/**
	 * 注文番号の採番
	 * @param dao
	 * @return orderNo
	 */
	private String setOrderNo(OrderInfoDao dao) {
		// 注文番号の最大値を取得
		String orderNo = dao.maxOrderNoSelect();
		
		if (orderNo == null || orderNo.isEmpty()) {
			//-----------------------------------
			// 注文番号が取得できなかった場合
			// （注文が1件もない場合）
			//-----------------------------------
			orderNo = "0000-000000-000001";
		} else {
			//-----------------------------------
			// 上記以外の場合
			//-----------------------------------
			// 注文番号の末尾６桁を取得
			int a = orderNo.lastIndexOf('-');
			int orderNoLast6 = Integer.parseInt(orderNo.substring(orderNo.lastIndexOf('-') + 1));
			if (orderNoLast6 < 999999) {
				// 末尾６桁がオール９でない場合、注文番号に１を加算
				orderNoLast6 += 1;
				orderNo = orderNo.substring(0, orderNo.lastIndexOf('-') + 1) + String.format("%06d", orderNoLast6);
			} else {
				// 末尾６桁がオール９の場合は繰り上がり
				// 注文番号の中６桁を取得
				int orderNoMiddle6 = Integer.parseInt(orderNo.substring(orderNo.indexOf('-') + 1, orderNo.lastIndexOf('-')));
				if (orderNoMiddle6 < 999999) {
					// 中６桁がオール９でない場合、中６桁に1を加算し、末尾６桁にオールゼロを設定
					orderNoMiddle6 += 1;
					orderNo = orderNo.substring(0, orderNo.indexOf('-') + 1) + String.format("%06d", orderNoMiddle6) + "000000";
				} else {
					// 中６桁がオール９の場合は繰り上がり
					// 注文番号の先頭４桁を取得
					int orderNoTop4 = Integer.parseInt(orderNo.substring(0, orderNo.indexOf('-')));
					// 先頭４桁に1を加算し、以降オールゼロを設定
					orderNoTop4 += 1;
					orderNo = String.format("%04d", orderNoTop4) + "-000000-000000";
				}
			}
		}
		
		return orderNo;
	}

	/**
	 * 会員情報更新
	 */
	private void updateMemberInfo() {
		Date date = new Date();
		// 顧客情報を取得
		setMemberInfoTable((MemberInfo)super.sessionMap.get("memberInfoTable"));
		ResultMemberInfo memberInfo = (ResultMemberInfo)super.sessionMap.get("memberInfo");
		
		// 変更内容を設定
		memberInfoTable.setLastName(memberInfo.getLastName());
		memberInfoTable.setFirstName(memberInfo.getFirstName());
		memberInfoTable.setLastNameKana(memberInfo.getLastNameKana());
		memberInfoTable.setFirstNameKana(memberInfo.getFirstNameKana());
		memberInfoTable.setSex(memberInfo.getSex());
		memberInfoTable.setBirthday(memberInfo.getBirthday());
		memberInfoTable.setAge(memberInfo.getAge());
		memberInfoTable.setPostalCode(memberInfo.getPostalCode());
		memberInfoTable.setAddress(memberInfo.getAddress());
		memberInfoTable.setBuilding(memberInfo.getBuilding());
		memberInfoTable.setTelKind(memberInfo.getTelKind());
		memberInfoTable.setTelNumber(memberInfo.getTelNumber());
		memberInfoTable.setUpdateUserID("system");
		memberInfoTable.setUpdateDate(date);

		// 顧客情報更新
		MemberInfoDao dao = new MemberInfoDao();
		dao.update(memberInfoTable);
	}
}
