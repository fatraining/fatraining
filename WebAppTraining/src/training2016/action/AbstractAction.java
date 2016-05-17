package training2016.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import training2016.annotations.ActionField;
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

	/** 入力値退避用マップ */
	private Map<String, Object> fieldsMap = new HashMap<String, Object>();

	/** 検索したかフラグ */
	@ActionField(name="isSearched")
	protected boolean isSearched;

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
	@SuppressWarnings("unchecked")
	public <C> C getValueFromSession(String key) {
		return (C) this.sessionMap.get(key);
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
	 * セッションマップにない場合は「ログインしろよ豚野郎！」を返す。
	 *
	 * @return userId ユーザーID
	 */
	public String getUserId() {
		return this.sessionMap.containsKey(Constants.SESSION_KEY_USERID) ?
			(String)this.getValueFromSession(Constants.SESSION_KEY_USERID) :
			"ログインしろよ豚野郎！";
	}

	/**
	 * 検索済フラグを返す
	 * @return isSearched
	 */
	public boolean getIsSearched() {
		return this.isSearched;
	}

	/**
	 * 検索済フラグをセットする
	 * @param isSearched セットする isSearched
	 */
	public void setIsSearched(boolean isSearched) {
		this.isSearched = isSearched;
	}

	/**
	 * 渡されたアクションの保持しているフィールドの値を自身のMapに保持し、
	 * 自身のインスタンスごと渡されたアクションのセッションマップに保持する。
	 * ただし、ActionFieldアノテーションが付与されているフィールドに限る。
	 * セッションマップ退避時のkeyは backUpFieldValue。
	 *
	 * @param action
	 * @param isSearch
	 */
	protected void backUp(AbstractAction action) {
		this.fieldsMap = new HashMap<String, Object>();
		Class<?> clazz = action.getClass();
		// AbstractActionまで再帰的にクラスを取得して処理していく
		while (clazz != null) {
			Arrays.stream(clazz.getDeclaredFields()).forEach(f -> {
				f.setAccessible(true);
				if (f.getAnnotation(ActionField.class) != null) {
					ActionField element = f.getAnnotation(ActionField.class);
					try {
						this.fieldsMap.put(element.name(), f.get(action));
					} catch (IllegalAccessException iae) {
						iae.printStackTrace();
						// ここでは特に何もしない
					}
				}
			});
			// AbstractActionを処理し終えたらbreak
			if (clazz.getName().equals("AbstractAction")) {
				break;
			}
			clazz = clazz.getSuperclass();
		}
		// セッションマップに退避
		this.putValueToSession("backUpFieldValue", this.fieldsMap);
	}

	/**
	 * backUpメソッドで退避した値を復元する
	 *
	 * @param action
	 */
	protected void restore(AbstractAction action) {
		if (!action.getSession().containsKey("backUpFieldValue")) {
			return;
		}
		this.fieldsMap = this.getValueFromSession("backUpFieldValue");
		Class<?> clazz = action.getClass();
		// AbstractActionまで再帰的にクラスを取得して処理していく
		while (clazz != null) {
			Arrays.stream(clazz.getDeclaredFields()).forEach(f -> {
				f.setAccessible(true);
				if (f.getAnnotation(ActionField.class) != null) {
					ActionField element = f.getAnnotation(ActionField.class);
					try {
						f.set(action, this.fieldsMap.get(element.name()));
					} catch (IllegalAccessException iae) {
						iae.printStackTrace();
						// ここでは特に何もしない
					}
				}
			});
			// AbstractActionを処理し終えたらbreak
			if (clazz.getName().equals("AbstractAction")) {
				break;
			}
			clazz = clazz.getSuperclass();
		}
		// 復元完了したらセッションマップから削除
		this.sessionMap.remove("backUpFieldValue");
	}
}
