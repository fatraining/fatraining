package apps.matsufuji;

import java.util.ArrayList;
import java.util.List;

import apps.AbstractAction;

@SuppressWarnings("unchecked")
public class BaseballAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	/** 入力用フィールド */
	public String content1;
	public String content2;
	public int rbi;
	public String batter;
	public String batterList;
	public int inningCount = 0;
	public int outCount =0;

	/** 出力用フィールド */
	public BaseballScoreboard teamA;
	public BaseballScoreboard teamB;
	public List<BaseballResult> resultList;
	public String inningNameArray[] = {"1回表","1回裏","2回表","2回裏","3回表","3回裏","4回表","4回裏","5回表","5回裏","6回表","6回裏","7回表",	"7回裏",	"8回表",	"8回裏",	"9回表",	"9回裏",	"10回表","10回裏","11回表","11回裏","12回表","12回裏"};
	public String inningName;

	public int hitCount;
	public int errorCount;

	public String execute()throws Exception{
		this.sessionMap.put("inningCount", this.inningCount);
		this.sessionMap.put("outCount", this.outCount);
		this.batter = null;

		this.teamA = null;
		this.teamB = null;
		return "success";
	}
	//入力ボタン
	public String input()throws Exception{
		//スコアボード
		this.setTeamScoreBoard();
		// それぞれ、なければ作る
		if(teamA == null){
			this.teamA = new BaseballScoreboard();
		}
		if(teamB == null){
			this.teamB = new BaseballScoreboard();
		}

		this.inningCount = (int) this.sessionMap.get("inningCount");
		this.outCount = (int) this.sessionMap.get("outCount");

		BaseballScoreboard scoreBoard = this.teamB;
		scoreBoard.teamName ="B";
		if ((this.inningCount % 2) == 0) {
			scoreBoard = this.teamA;
			scoreBoard.teamName ="A";
		}

		switch (content2) {
		case "安打":
		case "二塁打":
		case "三塁打":
		case "本塁打":
			scoreBoard.hit += 1;
			break;
		case "失策":
			scoreBoard.error += 1;
			break;
		case "四球":
		case "死球":
		case "スクイズ":
			break;
		case "併殺打":
			outCount += 2;
			break;
		default:
			outCount += 1;
		}
		if(outCount >= 5){
			outCount =0;
		}
		this.sessionMap.put("outCount", this.outCount);

		scoreBoard.scores[inningCount/2] = scoreBoard.scores[inningCount/2] + rbi;

		scoreBoard.run = scoreBoard.run + rbi;

		//打者番号
		if(scoreBoard.playerCount == 9){
			scoreBoard.playerCount = 1;
		}else{
		scoreBoard.playerCount += 1;
		}

		this.inningName = this.inningNameArray[inningCount];


		this.sessionMap.put("teamA", this.teamA);
		this.sessionMap.put("teamB", this.teamB);

		//打撃内容表
		this.resultList = (List<BaseballResult>) this.sessionMap.get("resultList");
		if(this.resultList == null){
			this.resultList = new ArrayList<BaseballResult>();
		}

		this.batterList = scoreBoard.teamName + "チーム" + scoreBoard.playerCount + "番打者";
		this.batter = scoreBoard.teamName + "チーム" + (scoreBoard.playerCount + 1) + "番打者";
		if(scoreBoard.playerCount==9){
			this.batter = scoreBoard.teamName + "チーム" + "1番打者";
		}


		BaseballResult result = new BaseballResult();
		result.content1 = this.content1;
		result.content2 = this.content2;
		result.rbi = rbi;
		result.batterList = this.batterList;
		this.resultList.add(result);

		this.sessionMap.put("resultList", this.resultList);


		return "success";
	}

	//試合開始ボタン
	public String playBall() throws Exception{

		this.inningCount = (int) this.sessionMap.get("inningCount");
		this.inningCount = 0;
		this.sessionMap.put("inningCount", this.inningCount);

		this.outCount = (int) this.sessionMap.get("outCount");
		this.outCount = 0;
		this.sessionMap.put("outCount", this.outCount);

		this.sessionMap.put("resultList", null);
		this.sessionMap.put("teamA", null);
		this.sessionMap.put("teamB", null);
		this.batter = "Aチーム1番打者";
		this.inningName = "1回表";

		return "success";
	}

	//アウトボタン
		public String outSum()throws Exception{
			this.inningCount = (int) this.sessionMap.get("inningCount");
			this.outCount = (int) this.sessionMap.get("outCount");
			this.resultList = (List<BaseballResult>) this.sessionMap.get("resultList");
			this.outCount += 1;
			if(outCount >= 5){
				outCount =0;
			}
			this.sessionMap.put("outCount", this.outCount);
			this.setTeamScoreBoard();
			this.inningName = this.inningNameArray[inningCount];

			return "success";
		}

	//チェンジボタン
	public String change()throws Exception{
		this.inningCount = (int) this.sessionMap.get("inningCount");
		this.outCount = (int) this.sessionMap.get("outCount");
		this.resultList = (List<BaseballResult>) this.sessionMap.get("resultList");
		this.inningCount += 1;
		this.outCount = 0;
		this.sessionMap.put("inningCount", this.inningCount);
		this.sessionMap.put("outCount", this.outCount);
		this.setTeamScoreBoard();
		this.inningName = this.inningNameArray[inningCount];


		return "success";
	}

	//得点ボタン
	public String scoreSum() throws Exception{
		this.resultList = (List<BaseballResult>) this.sessionMap.get("resultList");
		this.inningCount = (int) this.sessionMap.get("inningCount");
		this.setTeamScoreBoard();
		if ((this.inningCount % 2) == 0) {
			this.teamA.run += 1;
			this.teamA.scores[inningCount/2] +=1;
		}else{
			this.teamB.run += 1;
			this.teamB.scores[inningCount/2] +=1;
		}
		this.inningName = this.inningNameArray[inningCount];

		return "success";
	}

	//エラーボタン
	public String errorSum() throws Exception{
		this.resultList = (List<BaseballResult>) this.sessionMap.get("resultList");
		this.inningCount = (int) this.sessionMap.get("inningCount");
		this.setTeamScoreBoard();
		if ((this.inningCount % 2) == 0) {
			this.teamA.error += 1;
		}else{
			this.teamB.error += 1;
		}
		this.inningName = this.inningNameArray[inningCount];

		return "success";
	}

	//試合終了ボタン
	public String gameSet() throws Exception{
		this.resultList = (List<BaseballResult>) this.sessionMap.get("resultList");
		this.setTeamScoreBoard();
		return "success";
	}

	private void setTeamScoreBoard() {
		this.teamA = (BaseballScoreboard) this.sessionMap.get("teamA");
		this.teamB = (BaseballScoreboard) this.sessionMap.get("teamB");

	}

}


