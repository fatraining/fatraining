package endpoint;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@ServerEndpoint("/cyo")
public class CyatteMain {

	private String name;
	private String msg;
	private String who;
	private String time;
	private String ex;
	private String yattal;

	private static List<Session> ses = new ArrayList<Session>();
	public static List<CContents> yatteList = new ArrayList<>();
	private CyatteDao dao = new CyatteDao();

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

		System.out.println("現在のyatteListのサイズ :  " + yatteList.size());
		yo(yatteList, ses);

	}

	/*------------------------------------------------------*/
	/**
	 * メッセージ受信時の処理 JSON文字列をJacksonで処理 flgを見て true ならyo() false なら
	 * No をチェック
	 */
	@SuppressWarnings("static-access")
	@JsonIgnoreProperties(ignoreUnknown = true)
	@OnMessage
	public void OnMessage(String message, Session session)
			throws IOException, NumberFormatException, InterruptedException {
		ObjectMapper mapper = new ObjectMapper();
		CContents cContents = new CContents();

		cContents = mapper.readValue(message, CContents.class);
		if (cContents.getFlg() == 0) {

		cContents.setNo(yatteList.size() + 1);
		System.out.println(yatteList.size());

		// yattalをセット
		cContents.setYattal("<button class=zlbtn btn-danger btn-lgzl ID=zlyattalzl onclick=yattal(" + cContents.getNo()
				+ ")>いいね !" + cContents.getFavNum() + "</button>");
		cContents.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		yatteList =  dao.addDao(cContents);
		yo(yatteList, ses);
		} else if (cContents.getFlg() == 1) {
			check(cContents.getNo());
			// やってオブジェクト再利用
			yo(this.yatteList, ses);
		}
	}



	private void check(int No) {
		for (int i = 0; i < yatteList.size(); i++) {
			CContents yaLi = yatteList.get(i);
			if (yaLi.getNo() == No) {
				yaLi.setFavNum(yaLi.getFavNum() + 1);
			}
		}

	}

	/*------------------------------------------------------*/
	/**
	 * Broadcastメソッド
	 */
	private void yo(List<CContents> yatteList, List<Session> sessions) throws IOException {
		yatteList.get(yatteList.size() - 1).setFlg(1);;
		ObjectMapper mapper = new ObjectMapper();
		String yatte = mapper.writeValueAsString(yatteList).replaceAll("zl", "'");
		System.out.println(yatte);
		sessions.forEach(s -> {
			s.getAsyncRemote().sendText(yatte);
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
