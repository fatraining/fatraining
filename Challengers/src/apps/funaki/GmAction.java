package apps.funaki;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Arrays.asList;

import apps.AbstractAction;

public class GmAction extends AbstractAction {

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("/gm.jsp");
//		rd.forward(request, response);
//	}

	private static final long serialVersionUID = 1L;

	public String job = "未選択";
	public int jobChoice; //ジョブ選択項目を数値化
	private int jobLv = 1;
//	public String weapon; //使ってない項目かも
	public boolean errCheck;
	public String errmsg;
	public String msg1 = "あなたのジョブを選択し、レベルを入力してください。";


	// パラメータ各項目（順番確認用
	public int hp = 0; //HP
	public int atk = 0; //物攻
	public int ma = 0; //魔攻
	public int agi = 0; //敏捷
	public int def = 0; //物防
	public int md = 0; //魔防
	public int dex = 0; //命中
	public int eva = 0; //回避
	public int crt = 0; //会心
	public int allSum = 0; //総合戦闘力
	public int jobSum = 0; //ジョブのみの総合戦闘力

	// 装備群の初期化
//	public String[] weapon;
	private int selected;

	// パラメータ配列
	public int[] allResult = new int[9]; //各パラメータを加算した値を格納
	public int[] jobResult = new int[9]; //ジョブステータスのみを格納
	public int[] weaponLv = {1,1,1,1,1}; //武器のレベル値を格納　現在は５つ
	public String[] weapon = new String[5]; //選択した武器５つを格納
	public int[] weaponSelected = new int[5];//数値化した選択武器を格納
	public int[] armorLv = {1,1,1,1}; //頭・胴・手・足の４部位
	public String[] armor = new String[4]; //選択した防具
	public int[] armorSelected = new int[4]; //数値化した防具

	/* ジョブパラメーター上昇値 */
	public int[][] jobRising = {
		{8,10,0,6,4,0,6,6,6}, //戦士　上昇値
		{4,4,6,8,4,0,10,10,10}, //シーフ
		{6,8,0,0,10,6,2,0,2}, //ナイト
		{2,4,2,2,4,10,0,2,0}, //白
		{0,0,10,6,0,2,6,6,6}, //黒
		{10,6,0,8,10,2,8,8,8}, //モンク
		{2,2,8,2,2,8,4,2,4}, //赤
		};

	/* 武器初期値 -------------------- */
	public int[][] weaponParameter = new int[][] {
		{0,0,0,0,0,0,0,0,0}, //なし
		{117,100,33,83,0,0,67,50,50}, //片手斧
		{117,117,33,33,0,0,83,50,67}, //両手斧
		{100,100,33,100,0,0,17,67,83}, //短剣
		{117,100,33,83,0,67,33,33,33}, //剣
		{67,83,83,67,0,83,33,67,17}, //棍棒
		{83,33,117,50,0,50,33,100,33}, //杖
		{133,100,17,83,0,0,33,83,50}, //格闘
		{83,33,100,67,33,100,50,17,17}, //小剣
		};

	/* 防具初期値 -------------------- */
	public int[][] armorParameter = new int[][] {
		{0,0,0,0,0,0,0,0,0}, //なし
		{93,0,0,30,125,62,93,30,62}, //重頭S
		{62,0,0,93,93,62,62,62,62}, //軽頭S
		{62,0,0,62,62,125,62,62,62}, //魔頭S
		{110,0,0,27,138,83,55,27,55}, //重胴S
		{83,0,0,55,110,83,55,55,55}, //軽胴S
		{83,0,0,55,83,138,55,55,27}, //魔胴S
		{87,0,0,28,117,58,87,28,87}, //重手S
		{58,0,0,58,87,58,58,58,117}, //軽手S
		{55,0,55,55,55,110,55,55,55}, //魔手S
		{87,0,0,58,117,58,87,58,28}, //重足S
		{58,0,0,87,87,58,58,87,58}, //軽足S
		{58,0,0,87,58,117,58,87,28}, //魔足S
		};

	/* 武器上昇値 -------------------- */
	public double[][] weaponRising = new double[][] {
		{0,0,0,0,0,0,0,0,0}, //なし
		{3.3768115942,2.8985507,0.9710145,2.4202899,0.0,0.0,1.9275362,1.4492754,1.4492754}, //片手斧
		{3.3768115942,3.3768116,0.9710145,0.9710145,0.0,0.0,2.4202899,1.4492754,1.9275362}, //両手斧
		{2.8985507,2.8985507,0.9710145,2.8985507,0.0,0.0,0.4782609,1.9275362,2.4202899}, //短剣
		{3.376811594,2.898550725,0.971014493,2.420289855,0.0,1.927536232,0.971014493,0.971014493,0.971014493}, //剣
		{1.927536232,2.420289855,2.420289855,1.927536232,0.0,2.420289855,0.971014493,1.927536232,0.47826087,14.49275362},//棍棒
		{2.420289855,0.971014493,3.3768115942,1.449275362,0.0,1.449275362,0.971014493,2.898550725,0.971014493}, //杖
		{3.869565217,2.898550725,0.47826087,2.420289855,0.0,0.0,0.971014493,2.420289855,1.449275362}, //格闘
		{2.42028985507,0.97101449275,2.89855072464,1.92753623188,0.97101449275,2.89855072464,1.44927536232,0.47826086956,0.47826086956}, //小剣
		};

	/* 防具上昇値 -------------------- */
	public double[][] armorRising = new double[][] {
		{0,0,0,0,0,0,0,0,0}, //なし
		{2.710144927536232,	0.0,	0.0,	0.8695652173913043,	3.623188405797101,	1.782608695652174,	2.710144927536232,	0.8695652173913043,	1.782608695652174}, //重頭S
		{1.782608695652174,	0.0,	0.0,	2.710144927536232,	2.710144927536232,	1.782608695652174,	1.782608695652174,	1.782608695652174,	1.782608695652174}, //軽頭S
		{1.782608695652174, 0.0,	0.0,	1.782608695652174,	1.782608695652174,	3.623188405797101,	1.782608695652174,	1.782608695652174,	1.782608695652174}, //魔頭S
		{3.188405797101449,	0.0,	0.0,	0.7681159420289855,	4.014492753623188,	2.420289855072464,	1.594202898550725,	0.7681159420289855,	1.594202898550725}, //重胴S
		{2.420289855072464, 0.0,	0.0,	1.594202898550725,	3.188405797101449,	2.420289855072464,	1.594202898550725,	1.594202898550725,	1.594202898550725}, //軽胴S
		{2.420289855072464, 0.0,	0.0,	1.594202898550725,	2.420289855072464,	4.014492753623188,	1.594202898550725,	1.594202898550725,	0.7681159420289855}, //魔胴S
		{2.507246376811594, 0.0,	0.0,	0.8260869565217391,	3.376811594202899,	1.695652173913043,	2.507246376811594,	0.8260869565217391,	2.507246376811594}, //重手S
		{1.695652173913043, 0.0,	0.0,	1.695652173913043,	2.507246376811594,	1.695652173913043,	1.695652173913043,	1.695652173913043,	3.376811594202899}, //軽手S
		{1.594202898550725, 0.0,	1.594202898550725,	1.594202898550725,	1.594202898550725,	3.188405797101449,	1.594202898550725,	1.594202898550725,	1.594202898550725}, //魔手S
		{2.507246376811594, 0.0,	0.0,	1.695652173913043,	3.376811594202899,	1.695652173913043,	2.507246376811594,	1.695652173913043,	0.8260869565217391}, //重足S
		{1.695652173913043, 0.0,	0.0,	2.507246376811594,	2.507246376811594,	1.695652173913043,	1.695652173913043,	2.507246376811594,	1.695652173913043}, //軽足S
		{1.695652173913043, 0.0,	0.0,	2.507246376811594,	1.695652173913043,	3.376811594202899,	1.695652173913043,	2.507246376811594,	0.8260869565217391}, //魔足S
	};

	// リスト  2通りの初期化方法で記述
	public List<String> weapons = new ArrayList<String>() {
		{add("なし");}
	};
//	public List<String> weapons = java.util.Arrays.asList("なし");
	public List<String> armors = new ArrayList<String>(Arrays.asList("なし"));
	public List<String> head = new ArrayList<String>(Arrays.asList("なし"));
	public List<String> body = new ArrayList<String>(Arrays.asList("なし"));
	public List<String> arms = new ArrayList<String>(Arrays.asList("なし"));
	public List<String> foot = new ArrayList<String>(Arrays.asList("なし"));


	/* SETTER - GETTER -=-=-=-=-=-=-なくても動く？けれどとりあえず一部だけ設置 */
	public int getJobLv() {
		return jobLv;
	}
	public void setJobLv(int jobLv) {
		this.jobLv = jobLv;
	}


	/* プロフィール送信とエラーメッセージ */
	public String send() throws Exception {
		if ( this.job.equals("未選択") ) {
			this.errmsg = "ジョブが選択されていません。";
			errCheck = true;
			return "error";
		}
		if ( this.jobLv <= 0 || this.jobLv >= 61) {
			this.errmsg = "無効のLｖです。現在のレベルキャップは「60」です。";
			errCheck = true;
			return "error";
		}
		this.msg1 = "続いて、装備を選んで計算ボタンを押してください。";
		weaponsPattern();
		armorsPattern();
		jobCalc();
		return "success";
	}


	/* 武器パターン + ジョブ判定を数値化 */
	private void weaponsPattern() {
		if ( this.job.equals("戦士") ) {
			this.weapons.add("両手斧");
			this.weapons.add("片手斧");
			this.jobChoice = 0;
		}
		if ( this.job.equals("シーフ") ) {
			this.weapons.add("短剣");
			this.jobChoice = 1;
		}
		if ( this.job.equals("ナイト") ) {
			this.weapons.add("剣");
			this.jobChoice = 2;
		}
		if ( this.job.equals("白魔") ) {
			this.weapons.add("棍");
			this.jobChoice = 3;
		}
		if ( this.job.equals("黒魔") ) {
			this.weapons.add("杖");
			this.jobChoice = 4;
		}
		if ( this.job.equals("モンク") ) {
			this.weapons.add("格闘");
			this.jobChoice = 5;
		}
		if ( this.job.equals("赤魔") ) {
			this.weapons.add("小剣");
			this.jobChoice = 6;
		}

	}
	/* 防具パターン */
	private void armorsPattern() {
		if ( this.job.equals("戦士") || this.job.equals("ナイト") ) {
			this.head.addAll(Arrays.asList("重頭装備S","重頭装備A")); //まとめて追加するにはこれ
//			this.head.add("重頭装備S");
			this.body.add("重胴装備S");
			this.arms.add("重手装備S");
			this.foot.add("重足装備S");
		}
		if ( this.job.equals("シーフ") || this.job.equals("モンク") ) {
			this.head.add("軽頭装備S");
			this.body.add("軽胴装備S");
			this.arms.add("軽手装備S");
			this.foot.add("軽足装備S");
		}
		if ( this.job.equals("白魔") || this.job.equals("黒魔") || this.job.equals("赤魔") ) {
			this.head.add("魔頭装備S");
			this.body.add("魔胴装備S");
			this.arms.add("魔手装備S");
			this.foot.add("魔足装備S");
		}
	}

	/* ===== パラメータ計算 ===== */
	// ジョブのみの計算
	private void jobCalc() {
		for (int i = 0; i < this.jobResult.length; i++) {
			this.jobResult[i] = 50 + (this.jobRising[this.jobChoice][i] * this.jobLv);
			this.jobSum = this.jobSum + this.jobResult[i];
		}
	}

	// 選択した武器の数値化
	private void weaponSelect() {
		for (int i = 0; i < weapon.length; i++) {
			if (this.weapon[i].equals("なし")) {
				this.weaponSelected[i] = 0;
			}
			if (this.weapon[i].equals("片手斧")) {
				this.weaponSelected[i] = 1;
			}
			if (this.weapon[i].equals("両手斧")) {
				this.weaponSelected[i] = 2;
			}
			if (this.weapon[i].equals("短剣")) {
				this.weaponSelected[i] = 3;
			}
			if (this.weapon[i].equals("剣")) {
				this.weaponSelected[i] = 4;
			}
			if (this.weapon[i].equals("棍")) {
				this.weaponSelected[i] = 5;
			}
			if (this.weapon[i].equals("杖")) {
				this.weaponSelected[i] = 6;
			}
			if (this.weapon[i].equals("格闘")) {
				this.weaponSelected[i] = 7;
			}
			if (this.weapon[i].equals("小剣")) {
				this.weaponSelected[i] = 8;
			}
		}
	}

	// 選択した防具を数値化
	private void armorSelect() {
		for (int i = 0; i < armor.length; i++) {
			if (this.armor[i].equals("なし")) {
				this.armorSelected[i] = 0;
			}
			if (this.armor[i].equals("重頭装備S")) {
				this.armorSelected[i] = 1;
			}
			if (this.armor[i].equals("軽頭装備S")) {
				this.armorSelected[i] = 2;
			}
			if (this.armor[i].equals("魔頭装備S")) {
				this.armorSelected[i] = 3;
			}
			if (this.armor[i].equals("重胴装備S")) {
				this.armorSelected[i] = 4;
			}
			if (this.armor[i].equals("軽胴装備S")) {
				this.armorSelected[i] = 5;
			}
			if (this.armor[i].equals("魔胴装備S")) {
				this.armorSelected[i] = 6;
			}
			if (this.armor[i].equals("重手装備S")) {
				this.armorSelected[i] = 7;
			}
			if (this.armor[i].equals("軽手装備S")) {
				this.armorSelected[i] = 8;
			}
			if (this.armor[i].equals("魔手装備S")) {
				this.armorSelected[i] = 9;
			}
			if (this.armor[i].equals("重足装備S")) {
				this.armorSelected[i] = 10;
			}
			if (this.armor[i].equals("軽足装備S")) {
				this.armorSelected[i] = 11;
			}
			if (this.armor[i].equals("魔足装備S")) {
				this.armorSelected[i] = 12;
			}
		}
	}

	// 武器の計算と、結果を総合パラメータに代入
	private void equipWeaponCalc() {
		//武器５つを計算して加算
		for (int num = 0; num < 5; num++) {
			for (int s = 0; s < allResult.length; s++) {

				double val = (this.weaponRising[this.weaponSelected[num]][s] * (this.weaponLv[0] - 1));
				BigDecimal bd = new BigDecimal(val);
				BigDecimal bd1 = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
				this.allResult[s] = this.allResult[s] + this.weaponParameter[this.weaponSelected[num]][s] + (int)bd1.doubleValue();
			}
		}
		//防具４つを計算して加算
		for (int num = 0; num < 4; num++) {
			for (int s = 0; s < allResult.length; s++) {

				double val = (armorRising[this.armorSelected[num]][s] * (armorLv[0] - 1));
				BigDecimal bd = new BigDecimal(val);
				BigDecimal bd1 = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
				this.allResult[s] = this.allResult[s] + this.armorParameter[this.armorSelected[num]][s] + (int)bd1.doubleValue();
			}
		}
		//ジョブの数値を加算
		for (int i = 0; i < this.allResult.length; i++) {
			this.allResult[i] = this.allResult[i] + this.jobResult[i];
		}
		for (int i = 0; i < this.allResult.length; i++) {
			this.allSum = this.allSum + this.allResult[i];
		}
	}

	// 装備群の計算とジョブパラメータの合算
	public String calc() throws Exception {
		weaponsPattern();
		armorsPattern();
		jobCalc();
		weaponSelect();
		armorSelect();
		equipWeaponCalc();
		this.hp = this.allResult[0];
		this.atk = this.allResult[1];
		this.ma = this.allResult[2];
		this.agi = this.allResult[3];
		this.def = this.allResult[4];
		this.md = this.allResult[5];
		this.dex = this.allResult[6];
		this.eva = this.allResult[7];
		this.crt = this.allResult[8];
		return "success";
	}

//	public List getReturnlist() {
//		return returnList;
//		}
//	public void setReturnlist(List returnList) {
//		this.returnList= returnList;
//		}
//	public String execute(){
//		GmAction map = new GmAction();
//		map.put("AAA", "value1");
//		map.put("BBB", "value2");
//
//		// Listの[0]番
//		returnList.add(map);
//		// Listの[1]番
//		returnList.add(map);
//		return "success";
//		}
//}

/* LISTの表示方法その１ */
//	public String execute() {
//		setWeapons(this.weapons);
//		setArmors(this.armors);
//		return "success";
//	}
//
//	//getter and setter method for state variable//
//	public List getWeapons() {
//		return weapons;
//	}
//
//	public void setWeapons(List weapons) {
//		if ( this.job.equals("戦士") ) {
//			weapons.add("test");
//		}
//		if (this.job.equals("シーフ")) {
//			weapons.add("短剣");
//		}
//		if (this.job.equals("ナイト")) {
//			weapons.add("剣");
//		} else {
//			weapons.add("選択肢なし");
//		}
//	}
//
//	public List getArmors() {
//		return armors;
//	}
//
//	public void setArmors(List armors) {
//
//		armors.add("頭");
//		armors.add("胴");
//		armors.add("手");
//		armors.add("足");
//	}

}