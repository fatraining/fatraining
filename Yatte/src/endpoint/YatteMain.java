package endpoint;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@ServerEndpoint("/yo")
public class YatteMain {

	private String name;
	private String msg;
	private String toDo;
	private String who;
	private int num;
	private LocalDateTime limit;
	private String time;
	private String ex;
	private int flg;
	private String yattal;

	private static List<Session> ses = new ArrayList<Session>();
	public static List<Contents> yatteList = new ArrayList<>();
	public ContentsMessage json = new ContentsMessage();
	private YatteDao dao = new YatteDao();

	// メソッド類//
	// DBとの通信は@OnOpen と yatteのときのみ

	/*------------------------------------------------------*/
	/** 接続時にセッション追加 */
	@SuppressWarnings("static-access")
	@OnOpen
	public void onOpen(Session session) throws IOException {
		ses.add(session);
		if (yatteList.size() == 0) {
			this.yatteList = dao.dao();
		}
		json.contentsList = check(this.yatteList);
		System.out.println("現在のyatteListのサイズ :  " + yatteList.size());
		yo(json, ses);
		// 送信してみる(開発時確認用)
		// (((Session) ses).getOpenSessions()).forEach(s -> {
		// s.getAsyncRemote().sendText("test");
		// });
		// session.getAsyncRemote().sendText("open");
	}

	/*------------------------------------------------------*/
	/**
	 * メッセージ受信時の処理 JSON文字列をJacksonで処理 ContentsTypeを見て yatte なら制限時間セット yattal なら
	 * No をチェック
	 */
	@SuppressWarnings("static-access")
	@JsonIgnoreProperties(ignoreUnknown = true)
	@OnMessage
	public void OnMessage(String message, Session session)
			throws IOException, NumberFormatException, InterruptedException {
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.readValue(message, ContentsMessage.class);
		Contents contents = new Contents();

		if (json.messageType.equals(json.getTypeYatte())) {
			contents = json.contentsList.get(0);
			contents.setNo(yatteList.size() + 1);
			System.out.println(yatteList.size());

			// yattalをセット
			contents.setYattal("<button class=zlbtn btn-danger btn-lgzl ID=zlyattalzl onclick=yattal("
					+ contents.getNo() + ")>Yattal !</button>");
			
			// limitをセット
			if (contents.getTime().equals("15min")) {
				contents.setLimit(LocalDateTime.now().plusMinutes(15));
			} else if (contents.getTime().equals("today")) {
				contents.setLimit(LocalDateTime.now().plusHours(24));
			} else if (contents.getTime().equals("tomorrow")) {
				contents.setLimit(LocalDateTime.now().plusHours(48));
			} else if (contents.getTime().equals("dAt")) {
				contents.setLimit(LocalDateTime.now().plusHours(72));
			} else if (contents.getTime().equals("test")) {
				contents.setLimit(LocalDateTime.now().plusSeconds(20));
			}
			
			json.contentsList = dao.addDao(contents);
			for (int i = yatteList.size(); i <= json.contentsList.size(); i++) {
				if (i > yatteList.size()) {
					yatteList.add(json.contentsList.get(i - 1));
				}
			}
			json.contentsList = this.yatteList;
			yo(json, ses);
			dao.updateDao(yatteList);
			Timer t = new Timer();
			t.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					try {
						timer(ses);
					} catch (IOException e) {
						System.out.println("ざんねーん");
						e.printStackTrace();
					}
				}
			}, 0, 1000);

		} else if (json.messageType.equals(json.getTypeYattal())) {
			check(json.contentsList.get(0).getNo());
			// やってオブジェクト再利用
			json.contentsList = this.yatteList;
			json.messageType = json.getTypeYattal();
			yo(json, ses);
		}
	}

	/*------------------------------------------------------*/
	/**
	 * Limitのチェック 設定時間が来たらflgをfalseにして @see #yo(ContentsMessage, List)
	 */
	@SuppressWarnings("static-access")

	private void timer(List<Session> ses) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		if (this.yatteList.size() >= 0) {
			for (int i = 0; i < this.yatteList.size(); i++) {
				Contents yaLi = this.yatteList.get(i);
				if (yaLi.getNum() > 0 && now.isAfter(yaLi.getLimit()) && yaLi.getFlg() == 0) {
					yaLi.setTime("おわりー！");
					yaLi.setFlg(1);
					yaLi.setYattal("<font color='FF0000'><strong>あかんかった</strong></font>");
					json.contentsList = this.yatteList;
					json.messageType = json.getTypeAkan();
					dao.updateDao(yatteList);
					yo(json, ses);
				} else if (yaLi.getNum() <= 0 && yaLi.getFlg() == 0 && now.isAfter(yaLi.getLimit())) {
					yaLi.setFlg(1);
					yaLi.setYattal("<font color='00FF00'><strong>やったった</strong></font>");
					dao.updateDao(yatteList);
					yo(json, ses);
				}
			}
		}
	}

	/*------------------------------------------------------*/
	/**
	 * yattalのときの処理 flgをfalseにしてボタン上書き後 @see #yo(ContentsMessage, List) で更新
	 */
	private void check(int No) {
		for (int i = 0; i < yatteList.size(); i++) {
			Contents yaLi = yatteList.get(i);
			if (yaLi.getNo() == No) {
				yaLi.setNum(yaLi.getNum() - 1);
			}
			if (yaLi.getNo() == No && yaLi.getNum() <= 0) {
				yaLi.setYattal("<font color='0000FF'><strong>やってる</strong></font>");
			}
		}
	}

	/*------------------------------------------------------*/
	/**
	 * タイマーによるチェック 時間が過ぎた時にyattal人数(yatteList.getNum)で確認
	 */
	@SuppressWarnings("static-access")
	private List<Contents> check(List<Contents> contents) {
		LocalDateTime now = LocalDateTime.now();
		for (int i = 0; i < this.yatteList.size(); i++) {
			Contents yaLi = this.yatteList.get(i);
			if (yaLi.getNum() > 0 && now.isAfter(yaLi.getLimit()) && yaLi.getFlg() == 0) {
				yaLi.setTime("おわりー！");
				yaLi.setFlg(1);
				yaLi.setYattal("<font color='FF0000'><strong>あかんかった</strong></font>");
				json.contentsList = this.yatteList;
				json.messageType = json.getTypeAkan();
			} else if (yaLi.getNum() <= 0 && yaLi.getFlg() == 0 && now.isAfter(yaLi.getLimit())) {
				yaLi.setFlg(1);
				yaLi.setYattal("<font color='00FF00'><strong>やったった</strong></font>");
			}
		}
		return yatteList;
	}

	/*------------------------------------------------------*/
	/**
	 * Broadcastメソッド
	 */
	private void yo(ContentsMessage comMsg, List<Session> sessions) throws IOException {
		for (int i = 0; i < comMsg.contentsList.size(); i++) {
			comMsg.contentsList.get(i).setLimitText(
					comMsg.contentsList.get(i).getLimit().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
		}
		ObjectMapper mapper = new ObjectMapper();
		String yatte = mapper.writeValueAsString(comMsg).replaceAll("zl", "'");
		System.out.println(yatte);
		sessions.forEach(s -> {
			s.getAsyncRemote().sendText(yatte);
			dao.updateDao(yatteList);
		});
	}

	/*------------------------------------------------------*/
	/* エラー処理 */
	@OnError
	public void onError(Session session, Throwable throwable) {
		throwable.printStackTrace();
	}

	/*------------------------------------------------------*/
	/* セッション重複時にセッション除去 */
	@OnClose
	public void onClose(Session session) {
		ses.remove(session);
	}

	/*------------------------------------------------------*/
	// getter,setter類//

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public long getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getYattal() {
		return yattal;
	}

	public void setYattal(String yattal) {
		this.yattal = yattal;
	}

	public String getMessageType() {
		return msg;
	}

	public void setMessageType(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getLimit() {
		return limit;
	}

	public void setLimit(LocalDateTime limit) {
		this.limit = limit;
	}

	public int getFlg() {
		return flg;
	}

	public void setFlg(int flg) {
		this.flg = flg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
