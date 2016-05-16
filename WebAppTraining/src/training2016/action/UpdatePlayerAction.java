package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.PlayerDao;
import training2016.model.Players;
import training2016.model.Team;

@Result(name = "search", value = "playerFinder.action", type = ServletRedirectResult.class)
public class UpdatePlayerAction extends AbstractAction {
	/** 画面タイトル */
	private String title = "選手登録/削除";

	/** チームID */
	private String teamID;
	/** チーム名 */
	private String teamName;
	/** 選手ID */
	private String playerID;
	/** 選手名 */
	private String playerName;
	/** ポジション */
	private String position;
	/** 年齢 */
	private String age;
	/** コメント */
	private String comment;
	/** 削除ID */
	private String delete;
	/** チーム名プルダウン用マップ */
	private Map<String, String> teamMap;
	/** ポジションプルダウン用マップ */
	private Map<String,String> positionMap = new LinkedHashMap<String, String>();
	/** エラーメッセージ */
	private String errorMsg;
	/** 普通のメッセージ */
	private String msg;

	/** アップロードファイル */
	 private File image;
	 /** アップロードファイルのコンテンツタイプ */
	 private String imageContentType;
	 /** アップロードファイルの元ファイル名 */
	 private String imageFileName;
	 /** アップロードファイルの保存ファイル名 */
	 private String tempFileName;

	 /** 保存先 */
	 private static final String IMG_SAVE_BASE = "\\assets\\images\\temp";

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	@Override
	public String execute() throws Exception {
		// deleteを取り出し
		this.setDelete((String)this.sessionMap.get("deleteID"));
		this.setTeamMap();
		this.setPositionMap();
		return "success";
	}

	/**
	 * insertメソッド。
	 * 画面の初期表示に戻す。
	 *
	 * @return 結果
	 */
	public String insert() {
		this.setTeamMap();
		this.setPositionMap();

		// ファイル入力があれば、/assets/images/temp に書き込み
		try {
			if (this.image != null) {
				BufferedImage img = ImageIO.read(image);
				String expansionName = this.imageContentType.split("/")[1];
				String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				tempFileName = this.imageFileName + "_" + dateString + "." + expansionName;
				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("") + IMG_SAVE_BASE + "\\" + tempFileName));
			}
		} catch (IOException ioe) {
				ioe.printStackTrace();
				this.addActionError("画像の保存に失敗しました");
			}

		// 未入力の項目があるときにエラーを返す
		if (!this.isValidate()) {
			this.errorMsg = "必須項目(※)を入力してください。";
			return "error";
		}

		PlayerDao dao = new PlayerDao();
		dao.save(this.generatePlayersModel());
		this.msg = "登録しました";
		sessionMap.put("msg", this.msg);
		return "search";
	}

	/**
	 * 今フィールドに保持している値でPlayersModelを生成して返す
	 *
	 * @return Players
	 */
	private Players generatePlayersModel() {
		Players model = new Players();
		model.setPlayerID(this.playerID);
		model.setTeamID(this.teamID);
		model.setTeamName(this.teamName);
		model.setPlayerName(this.playerName);
		model.setPosition(this.position);
		model.setAge(Integer.parseInt(this.age));
		if (this.comment.indexOf("\r\n") != -1) {
			System.out.println("あったよ");
			this.comment = comment.replaceAll("\r\n", "<br />");
		}
		model.setComment(this.comment);
		model.setImagePath(this.tempFileName);

		return model;
	}

	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 * @return 無問題ならtrue,ダメならfalse
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(this.teamID) ||
				StringUtils.isEmpty(this.playerName) ||
				StringUtils.isEmpty(this.position) ||
				StringUtils.isEmpty(this.age)) {
			return false;
		}
		return true;
	}

	/**
	 * 削除メソッド
	 *
	 * @return search
	 */
	public String delete() {
		this.setDelete((String)this.sessionMap.get("deleteID"));
		PlayerDao dao = new PlayerDao();
		dao.delete(this.getDelete());
		this.msg = "削除が完了しました";
		this.sessionMap.put("msg",this.msg);
		return "search";
	}

	// チーム名プルダウン用マップを返す //
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "チームを選択");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Team team = (Team) resultTable.get(i);
				tempMap.put(team.getID(), team.getTeamName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}

	// せったーとげったー //
	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return positionMap
	 */
	public Map<String, String> getPositionMap() {
		return positionMap;
	}

	/**
	 * @param positionMap セットする positionMap
	 */
	public void setPositionMap() {
		this.positionMap.put("","ポジションを選択");
		this.positionMap.put("FW","FW");
		this.positionMap.put("MF","MF");
		this.positionMap.put("DF","DF");
		this.positionMap.put("GK","GK");
	}

	/**
	 * @return teamMap
	 */
	public Map<String, String> getTeamMap() {
		return teamMap;
	}

	/**
	 * @param teamMap
	 *            セットする teamMap
	 */
	public void setTeamMap() {
		PlayerDao dao = new PlayerDao();
		List<?> resultTable = dao.getTeamList();
		this.teamMap = tableTrans(resultTable);
	}

	/**
	 * @return delete
	 */
	public String getDelete() {
		return delete;
	}

	/**
	 *
	 * @param セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return teamID
	 */
	public String getTeamID() {
		return teamID;
	}

	/**
	 *
	 * @param teamID セットするteamID
	 */
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	/**
	 * @return teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName セットする teamName
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName セットする playerName
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position セットする position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age セットする age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * errorMsgを返す
	 *
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}
