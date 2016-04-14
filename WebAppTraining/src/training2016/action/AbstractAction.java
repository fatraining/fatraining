package training2016.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import training2016.constant.Constants;

/**
 * アクションクラスの基本的な動きを実装する抽象クラス。
 * 作成するアクションクラスは当クラスを必ず継承すること。
 *
 * @author harasan
 */
public abstract class AbstractAction extends ActionSupport implements
		ServletResponseAware, SessionAware {

	private static final long serialVersionUID = 1L;

	/** ServletResponseAware */
	public HttpServletResponse response;

	/** セッションマップ */
	public Map<String, Object> sessionMap;

	/**
	 * ServletResponseAwareを実装することにより、
	 * HttpServletResponseオブジェクトを扱えるようにする
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * SessionAwareを実装することにより、
	 * HttpSessionに格納されるオブジェクトを扱えるようにする
	 */
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * セッションマップを返す
	 *
	 * @return Map<String, Object> セッションマップ
	 */
	public Map<String, Object> getSession() {
		return this.sessionMap;
	}

	/**
	 * セッションマップから指定のキーでputされたValueを返す
	 *
	 * @return Object セッションバリュー
	 */
	public Object getValueFromSession(String key) {
		return this.sessionMap.get(key);
	}

	/**
	 * セッションマップに指定されたキーでValueをputする
	 *
	 * @param key セッションマップにputする際キーとなる文字列
	 * @param value セッションマップにputするバリューオブジェクト
	 */
	public void putValueToSession(String key, Object value) {
		this.sessionMap.put(key, value);
	}

	/**
	 * セッションマップから指定されたキーのValueを削除する
	 *
	 * @param key セッションマップから削除する値のキー文字列
	 */
	public void removeFromSession(String key) {
		this.sessionMap.remove(key);
	}

	/**
	 * ユーザーIDをセッションマップから返す。<br>
	 * セッションマップにない場合は 豚野郎 を返す。
	 *
	 * @return userId ユーザーID
	 */
	public String getUserId() {
		return this.sessionMap.containsKey(Constants.SESSION_KEY_USERID) ?
			(String)this.getValueFromSession(Constants.SESSION_KEY_USERID) :
			"豚野郎";
	}
}
