package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GuraburuDao;
import training2016.model.GuraburuCharacter;
import training2016.model.GuraburuRace;



@Results({
	@Result(name ="guraburuCharacterSearch" , value ="guraburuCharacterSearch.action" , type = ServletRedirectResult.class)
})
public class GuraburuCharacterUpdateAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "グラブルキャラ追加";
	/* ボタン表示 */
	private String btn = "追加" ;
	/* id */
	private String id;
	/* 名前 */
	private String name;
	/* 性別 */
	private String sex;
	/* 属性 */
	private String attribute;
	/* 種族 */
	private String raceId;
	/* 画像参照URL */
	private String dataUrl;
	/* メッセージ */
	private String message;
	/* コメント */
	private String comment;
	/* 種族プルダウン用マップ */
	private Map<String, String> raceMap = new LinkedHashMap<>();
	/*------------------------------------------------*/
	// execute
	/*------------------------------------------------*/
	@Override
	public String execute() {
		this.setRaceMap();

		//セッションマップから指定のキーでputされた更新対象のIDを取得
		this.id = this.getValueFromSession("updateId");

		GuraburuDao dao = new GuraburuDao();
		GuraburuCharacter target = null;
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), GuraburuCharacter.class);
			if(target != null) {
				this.name = target.getName();
				this.sex =  target.getSex();
				this.attribute = target.getAttribute();
				this.raceId = String.valueOf(target.getRaceId());
				this.dataUrl = target.getDataUrl();
				this.comment = target.getComment();
				this.title = "グラブルキャラ更新";
				this.btn = "更新";
			}
		} else {
			this.id = "";
		}
		return "success";
	}
	// 追加or更新ボタンクリック時
	public String update() {
		this.setRaceMap();

		//名前が入っているかの判定
		if (this.isBlank(this.name)) {
			addActionError("名前を入力してください");
			if(StringUtils.isNotBlank(this.id)) {
				this.title = "グラブルキャラ更新";
				this.btn = "更新";
			}
			return "error";
		}
		//名前にスペースが入ってる場合に取り除く
		name = trim(name);
		GuraburuDao dao = new GuraburuDao();
		if (StringUtils.isNotEmpty(this.id)) {
			GuraburuCharacter target = dao.select(Integer.parseInt(this.id), GuraburuCharacter.class);
			dao.update(this.updateGuraburuModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.name, this.sex, this.attribute, this.raceId, this.dataUrl, this.comment);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}
		return "guraburuCharacterSearch";
	}

	private GuraburuCharacter updateGuraburuModel(GuraburuCharacter target) {
		target.setName(this.name);
		target.setSex(this.sex);
		target.setAttribute(this.attribute);
		target.setRaceId(Integer.parseInt(this.raceId));
		target.setDataUrl(this.dataUrl);
		target.setComment(this.comment);

		return target;
	}

	private boolean isBlank(String param) {
		return StringUtils.isBlank(param);
	}

	/*------------------------------------------------*/
	// getter,setter
	/*------------------------------------------------*/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBtn() {
		return btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Map<String, String> getRaceMap() {
		return raceMap;
	}

	public void setRaceMap(Map<String, String> raceMap) {
		this.raceMap = raceMap;
	}

	private void setRaceMap() {
		GuraburuDao dao = new GuraburuDao();
		List<?> resultTable = dao.getRaceList();
		this.raceMap = tableTrans(resultTable);

	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/*------------------------------------------------*/
	// 全角スペースを除去(trim()だと半角スペースのみ
	/*------------------------------------------------*/
	public static String trim(String value) {
	    int st = 0;
	    int len = value.length();
	    char[] val = value.toCharArray();
	    while ((st < len) && ((val[st] <= ' ') || (val[st] == '　'))) {
	        st++;
	    }
	    while ((st < len) && ((val[len - 1] <= ' ') || (val[len - 1] == '　'))) {
	        len--;
	    }
	    return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;
	}
	/*------------------------------------------------*/
	// エラーメッセージ
	/*------------------------------------------------*/
	public boolean getHasActionErrors() {
		if (hasActionErrors()) {
			return true;
		} else {
			return false;
		}
	}
	/*------------------------------------------------*/
	// 種族プルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.raceMap.put("6", "");

			for (int i = 0; i < resultTable.size()-1; i++) {
				GuraburuRace r = (GuraburuRace) resultTable.get(i);
				this.raceMap.put(r.getId(), r.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.raceMap;
	}


}
