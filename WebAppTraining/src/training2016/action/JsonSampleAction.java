package training2016.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.StreamResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON返却サンプル
 * @author harasan
 */
@Result(name="success", value="inputStream", type=StreamResult.class)
public class JsonSampleAction extends AbstractAction {
	/** JSON文字列返却用inputstream */
	private InputStream inputStream;
	/** パラメータ */
	private String name;

	/**
	 * execute
	 * @return 結果
	 */
	@Override
	public String execute() throws JsonProcessingException, UnsupportedEncodingException {
		JsonSampleInnerClass greet = new JsonSampleInnerClass();
		greet.greet = "hello!";
		greet.name = this.name + "!!";
//		String json = "{\"greet\":\"hello! " + this.name + "!!\"}";
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(greet);

		inputStream = new ByteArrayInputStream(json.getBytes("utf-8"));
		return SUCCESS;
	}

	/**
	 * JSON文字列返却用inputstreamを返す
	 * @return
	 */
	public InputStream getInputStream() {
		return this.inputStream;
	}

	/**
	 * nameをセットする
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	private class JsonSampleInnerClass {
		public String greet;
		public String name;
	}
}
