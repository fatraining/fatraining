package training2016.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 画像をアップロードする場合のサンプル
 * 
 * @author harasan
 */
public class ImageUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/** アップロードファイル */
	private File image;
	/** アップロードファイルのコンテンツタイプ */
	private String imageContentType;
	/** アップロードファイルの元ファイル名 */
	private String imageFileName;

	/**
	 * execute
	 * @return 結果
	 */
	public String execute() {
		System.out.println(this.image);
		return SUCCESS;
	}

	/**
	 * imageを返す
	 * @return
	 */
	public File getImage() {
		return this.image;
	}

	/**
	 * imageをセットする
	 * @param imgFile
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * imageContentTypeを返す
	 * @return imageContentType
	 */
	public String getImageContentType() {
		return this.imageContentType;
	}

	/**
	 * imageContentTypeをセットする
	 * @param imageContentType セットする imageContentType
	 */
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**
	 * imageFileNameを返す
	 * @return imageFileName
	 */
	public String getImageFileName() {
		return this.imageFileName;
	}

	/**
	 * imageFileNameをセットする
	 * @param imageFileName セットする imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}
