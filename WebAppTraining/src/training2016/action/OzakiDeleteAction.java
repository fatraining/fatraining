package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.OzakiDao;
import training2016.model.OzakiAlbum;
import training2016.model.OzakiSong;

@Results({ @Result(name = "ozakiSearch", value = "ozakiSearch.action", type = ServletRedirectResult.class) })

public class OzakiDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "削除画面";

	/* 削除ID */
	private String delete;

	/* メッセージ */
	private String message;

	private List<OzakiSong> ozakiTable = new ArrayList<>();

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	public String getUserId() {
		return (String) this.sessionMap.get("userId");
	}

	/*-- executeメソッド --*/
	public String execute() throws Exception {
		this.delete = (String) this.sessionMap.get("deleteId");
		String[] deleteId = this.delete.split(",");

		OzakiDao dao = new OzakiDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.ozakiTable.addAll(resultTrans(resultTable));

		if (this.ozakiTable.size() == 1) {
			this.message = "この曲を削除します";
		} else {
			this.message = "これらの曲を削除します";
		}
		sessionMap.put("message", this.message);

		return "success";
	}

	/*-- テーブル作成 --*/
	private List<OzakiSong> resultTrans(List<?> resultTable) {
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
				temp.setAlbumName(oa.getAlbumName());
				temp.setSongName(os.getSongName());
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

	/*-- リセットボタンクリック時 --*/
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteId");

		OzakiDao dao = new OzakiDao();
		dao.delete(delete);

		this.sessionMap.put("completeMessage", "削除完了しました");

		this.sessionMap.put("from", "delete");

		return "ozakiSearch";
	}

	/*-- setter&getter --*/
	public String getTitle() {
		return title;
	}

	public List<OzakiSong> getOzakiTable() {
		return ozakiTable;
	}
}
