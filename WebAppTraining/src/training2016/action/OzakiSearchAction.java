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

import training2016.dao.OzakiDao;
import training2016.model.OzakiAlbum;
import training2016.model.OzakiSong;

@Results({ @Result(name = "update", value = "ozakiUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "ozakiDelete.action", type = ServletRedirectResult.class) })

public class OzakiSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*-- タイトル --*/
	private String title = "尾崎豊 曲検索";

	/*----------- ブラウザーからの入力項目 -----------*/

	/* アルバム名 */
	private String albumName;

	/* 曲名 */
	private String songName;

	/* 更新ID */
	private String updateId;

	/* 削除ID */
	private String deleteId;

	/*----------- プルダウン用マップ -----------*/

	/* アルバム */
	private Map<String, String> albumMap = new HashMap<>();

	/* 検索リスト */
	public List<OzakiSong> ozakiTable = new ArrayList<>();

	/* 完了メッセージ取得 */
	public String getCompleteMessage() {
		return (String) this.sessionMap.get("completeMessage");
	}

	/* ユーザーID */
	public String getUserId() {
		return (String) this.sessionMap.get("userId");
	}

	/*----------- 初期値の設定 -----------*/

	private String getDefaultAlbumName() {
		return "";
	}

	private String getDefaultSongName() {
		return "";
	}

	/*-- executeメソッド --*/
	@Override
	public String execute() {
		this.albumName = getDefaultAlbumName();
		this.songName = getDefaultSongName();
		return "success";
	}

	/*----------- 各種ボタンクリック時の処理 -----------*/

	/*-- テーブル作成 --*/

	public List<OzakiSong> resultTrans(List<?> resultTable) {
		List<OzakiSong> table = new ArrayList<>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				OzakiSong temp = new OzakiSong();
				obj = (Object[]) resultTable.get(i);
				OzakiSong os = (OzakiSong) obj[0];
				OzakiAlbum oa = (OzakiAlbum) obj[1];
				temp.setId(os.getId());
				temp.setAlbumId(os.getAlbumId());
				temp.setSongName(os.getSongName());
				temp.setAlbumName(oa.getAlbumName());
				temp.setSongWriting(os.getSongWriting());
				temp.setAge(os.getAge());
				temp.setLyrics(os.getLyrics());
				table.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	/*-- 検索ボタンクリック時 --*/

	public String search() {
		OzakiDao dao = new OzakiDao();
		List<?> resultTable = null; // ワイルドカード（特殊文字）

		if (StringUtils.isEmpty(albumName) && StringUtils.isEmpty(songName)) {
			resultTable = dao.songList(); // nullの時
		} else {
			albumName = this.albumName.trim();
			songName = this.songName.trim();
			resultTable = dao.resultList(albumName, songName);
		}
		this.ozakiTable.addAll(resultTrans(resultTable));
		this.setAlbumMap();
		this.sessionMap.put("message", null);
		this.sessionMap.put("completeMessage", null);
		return "success";

	}

	/*-- リセットボタンクリック時 --*/

	public String reset() {
		this.albumName = getDefaultAlbumName();
		this.songName = getDefaultSongName();
		this.sessionMap.put("completeMessage", null);
		this.setAlbumMap();
		return "success";
	}

	/*-- 追加ボタンクリック時 --*/

	public String update() {
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("ozakiUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*-- 削除ボタンクリック時 --*/

	public String delete() {
		this.sessionMap.put("deleteId", this.deleteId);
		if (deleteId == null) {
			addActionError("削除する曲を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("ozakiDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*----------- 各種メッセージ判定 -----------*/

	/*-- エラーメッセージ --*/

	public boolean getHasActionErrors() {
		if (hasActionErrors()) {
			return true;
		} else {
			return false;
		}
	}

	/*-- 完了メッセージ --*/

	public boolean getHasCompleteMessage() {
		if ((String) this.sessionMap.get("completeMessage") != null) {
			return true;
		} else {
			return false;
		}
	}

	/*----------- setter&getter -----------*/

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSongName() {
		return this.songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getUpdateId() {
		return this.updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getDelete() {
		return this.deleteId;
	}

	public void setDelete(String deleteId) {
		this.deleteId = deleteId;
	}

	public Map<String, String> getAlbumMap() {
		return this.albumMap;
	}

	private void setAlbumMap() {
		OzakiDao dao = new OzakiDao();
		List<?> resultTable = dao.getAlbumNameList();
		this.albumMap = tableTrans(resultTable);
	}

	/*----------- アルバムプルダウン用マップ -----------*/

	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.albumMap.put("", "");

			for (int i = 0; i < resultTable.size(); i++) {
				OzakiAlbum oa = (OzakiAlbum) resultTable.get(i);
				this.albumMap.put(oa.getId(), oa.getAlbumName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.albumMap;

	}
}
