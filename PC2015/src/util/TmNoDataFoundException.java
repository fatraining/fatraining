package util;

/**
 * ショッピングでの該当データなし例外
 * （マスタのセットアップエラー）
 * @author t.makino
 *
 */
public class TmNoDataFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public TmNoDataFoundException() {
		super();
	}

	public TmNoDataFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
