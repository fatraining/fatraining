package training2016.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 画像をアップロードする場合のサンプル
 *
 * @author harasan
 */
public class ImageUploadSampleAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/** アップロードファイル */
	private File image;
	/** アップロードファイルのコンテンツタイプ */
	private String imageContentType;
	/** アップロードファイルの元ファイル名 */
	private String imageFileName;
	/** 保存先 */
	private static final String IMG_SAVE_BASE = "\\assets\\images\\temp";

	/**
	 * execute
	 * @return 結果
	 */
	@Override
	public String execute() {
		try {
			// 画像
			if (this.image != null) {
				BufferedImage img = ImageIO.read(image);
				String expansionName = this.imageContentType.split("/")[1];
				String dateString =  new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String tempFileName = this.imageFileName + "_" + dateString + "." + expansionName;
				// Eclipse+Tomcat環境で動かしているので、普通に保存じゃだめ
				ImageIO.write(img, expansionName, new File(ServletActionContext.getServletContext().getRealPath("") + IMG_SAVE_BASE + "\\" + tempFileName));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			this.addActionError("画像の保存に失敗しました");
		}
		return SUCCESS;
	}

	/**
	 * imageをセットする
	 * @param imgFile
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * imageContentTypeをセットする
	 * @param imageContentType セットする imageContentType
	 */
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**
	 * imageFileNameをセットする
	 * @param imageFileName セットする imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}
