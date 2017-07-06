package training2016.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.OzakiDao;
import training2016.model.OzakiAlbum;
import training2016.model.OzakiSong;

@Results({ @Result(name = "ozakiSearch", value = "ozakiSearch.action", type = ServletRedirectResult.class) })
public class OzakiUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// タイトル及びボタンの表示名は追加更新ボタンによって変化

	/* タイトル */
	private String title = "曲を追加";

	/* ボタン表示 */
	private String btn = "追加";

	/* id */
	private String id;

	/* アルバム名 */
	private String albumName;

	/* アルバムID */
	private String albumId;

	/* 曲名 */
	private String songName;

	/* 作詞・作曲 */
	private String songWriting;

	/* 年代 */
	private String age;

	/* 歌詞 */
	private String lyrics;

	/*------------- プルダウン用マップ -------------*/

	/* アルバム */
	private Map<String, String> albumMap = new HashMap<>(); // DBからマッピング

	/* 検索リスト */
	public List<OzakiSong> ozakiTable = new ArrayList<>();

	/*------------- 初期値の設定 -------------*/

	/*-- execute --*/
	@Override
	public String execute() {
		this.setAlbumMap();
		// セッションマップから指定のキーでputされた更新対象のIDを取得
		this.id = this.getValueFromSession("updateId");

		OzakiDao dao = new OzakiDao();
		OzakiSong target = null;
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), OzakiSong.class);
			if (target != null) {
				this.albumId = String.valueOf(target.getAlbumId());
				this.songName = target.getSongName();
				this.songWriting = target.getSongWriting();
				this.age = target.getAge();
				this.lyrics = target.getLyrics();
				this.title = "曲更新";
				this.btn = "更新";
			}
		} else {
			this.id = "";
		}
		return "success";
	}

	/*-- 追加or更新ボタンクリック時 --*/

	public String update() {
		this.setAlbumMap();

		// 全ての値が入っているか判定
		if (this.isEmpty(this.albumId) || this.isEmpty(this.songName) || this.isEmpty(this.songWriting)
				|| this.isEmpty(this.age) || this.isEmpty(this.lyrics)) {
			addActionError("全ての項目を入力してください");
			this.title = "曲更新";
			this.btn = "更新";
			return "error";
		}

		OzakiDao dao = new OzakiDao();
		if (StringUtils.isNotEmpty(this.id)) {
			OzakiSong target = dao.select(Integer.parseInt(this.id), OzakiSong.class);
			dao.update(this.updateOzakiModel(target));
			this.sessionMap.put("completeMessage", "更新しました");
		} else {
			dao.insert(this.id, this.songName, this.albumId, this.songWriting, this.age, this.lyrics);
			this.sessionMap.put("completeMessage", "追加しました");
		}
		this.sessionMap.put("from", "update");
		return "ozakiSearch";
	}

	private boolean isEmpty(String param) {
		return StringUtils.isEmpty(param);
	}

	/*-- 追加or更新する値をセットする --*/

	private OzakiSong updateOzakiModel(OzakiSong target) {
		target.setSongName(this.songName);
		target.setAlbumId(Integer.parseInt(this.albumId));
		target.setSongWriting(this.songWriting);
		target.setAge(this.age);
		target.setLyrics(this.lyrics);

		return target;
	}

	/*-- エラーメッセージ --*/

	public boolean getHasActionErrors() {
		if (hasActionErrors()) {
			return true;
		} else {
			return false;
		}
	}

	/*------------- setter&getter -------------*/

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBtn() {
		return this.btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumId() {
		return this.title;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getSongName() {
		return this.songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongWriting() {
		return this.songWriting;
	}

	public void setSongWriting(String songWriting) {
		this.songWriting = songWriting;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLyrics() {
		return this.lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public Map<String, String> getAlbumMap() {
		return this.albumMap;
	}

	public void setAlbumMap() {
		OzakiDao dao = new OzakiDao();
		List<?> resultTable = dao.getAlbumNameList();
		this.albumMap = tableTrans(resultTable);
	}

	/*------------- アルバムプルダウン用マップ -------------*/

	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.albumMap.put("", "");

			for (int i = 0; i < resultTable.size(); i++) {
				OzakiAlbum os = (OzakiAlbum) resultTable.get(i);
				this.albumMap.put(os.getId(), os.getAlbumName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.albumMap;
	}
}
