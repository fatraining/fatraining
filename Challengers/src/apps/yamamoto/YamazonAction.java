package apps.yamamoto;

import apps.AbstractAction;

public class YamazonAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String userId;
	public String sendDate;
	public String comment;

	public String[] monthArray;		//←1回1回Jspに渡すたびにmonthArrayが戻ってくるわけじゃないので、またこっちで使ったりする時は
									//もう1回生成してあげないといけない。this.monthArray = createMonthArray();

//---------------購入履歴の2次元--------------------------------------
	private String[][] purchaseHistory = {
			{"あんぱん","かれーぱん","めろんぱん","やきそばパン","ナン","フランスパン","サンドウィッチ"},
			{"かけそば240円","月見そば310円","山かけそば420円","とんこつラーメン500円","味噌ラーメン500円","しょうゆラーメン340円"},
			{"天丼そばセット530円","たぬきそば320円","鴨せいろそば600円","ばかしそば300円","上ホルモン500円","特上カルビ300円"},
			{"もりそば300円","2枚盛り350円","かきあげそば400円","牛タン塩300円","特上ハラミ600円","豚トロ900円"},
			{"上天丼500円","天丼400円","鳥から丼420円","肉角ふじラーメン900円","サッポロ一番味噌ラーメン200円","サッポロ一番塩ラーメン200円"},
			{"カレーうどん400円","カレーそば400円","わかめそば400円","牛もつ煮込み500円","フレッシュネスバーガー600円","インドカレー900円"},
			{"牛丼　並320円","牛丼頭盛り400円","牛丼中盛り440円","ガーリックトマトチキン400円","バジルトマトチキン500円","海老天ぷら5本　600円"},
			{"豚丼　並320円","豚丼頭盛り400円","豚丼中盛り440円","ハーゲンダッツストロベリー200円","ハーゲンダッツバニラ200円","ハーゲンダッツチョコ200円"},
			{"タカラみりん200円","テトリス9　500円","ヨットセット600円","ミンミン打破600円","デスソース500円","スルメイカ300円","ヨーグルトドリンク900円"},
			{"テトリス10　5000円","ロックマン9800円","サンタクロースコスプレセット500円","ひれカツ定食500円","サーロイン定食600円","鳥のからあげ定食700円"},
			{"ヨーダの逆襲　400円","とちおとめ10kg　5000円","おやつカルパス500円","北海道昆布500円","北海道カニ三昧7000円","山芋あんかけご飯300円"},
			{"ミネラルウォーター500円","コカコーラ500円","サイダー500円","メッツコカコーラ300円","メントス200円","オロナミンC100本セット20000円"},
	};

	public String[] historyOfMonth;

	public String day;
	public String year;
	public String month;
	public String test;
//---------------最初に呼ばれるメソッドのexecute--------------------------------------
	public String execute() throws Exception {							//特に実行する特に実行するメソッドの指定がない場合は、executeメソッドを実行することになっているので、executeメソッドを実行し、結果「success」を得ます。
			//		this.userId = (String)this.sessionMap.get("userId");	//すると検索される順が【Actionクラス名からActionを除いたもの】-success.jsp→【Actionクラス名からActionを除いたもの】.jspと検索されていく
			//		this.sendDate = getDefaultDate();						//@Result(name = "yamazon", value = "yamazon.action", type = ServletRedirectResult.class) ここのnameで検索を変える事もできる。
			//		this.comment = getDefaultMessage();
		this.monthArray = createMonthArray();
		this.month = "02";
		this.historyOfMonth = purchaseHistory[Integer.parseInt(this.month) - 1];
		return "success";
}

//----------------Jspで側で月を選んでボタンを押したときにsendで送られてくるメソッド------------------------------------
	public String send() throws Exception{
		this.monthArray = createMonthArray();
		this.historyOfMonth = purchaseHistory[Integer.parseInt(this.month) - 1];
		return "success";
	}

//----------------executeメソッドによって呼ばれるメソッド monthArray用の配列を作っている------------------------------
	private String[] createMonthArray() {
		String[] ymArray = new String[12];
		for (int i = 0; i < ymArray.length; i++) {
			ymArray[i] = String.format("%1$02d", i + 1);
		}
		return ymArray;
	}
}