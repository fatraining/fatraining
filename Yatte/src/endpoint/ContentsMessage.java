package endpoint;

import java.util.ArrayList;
import java.util.List;

public class ContentsMessage {
	private static final String TYPE_YATTE = "yatte";
	private static final String TYPE_YATTAL = "yattal";
	private static final String TYPE_AKAN = "akan";
	
	public String messageType;
	public List<Contents> contentsList = new ArrayList<>();
	public static String getTypeYatte() {
		return TYPE_YATTE;
	}
	public static String getTypeYattal() {
		return TYPE_YATTAL;
	}
	public static String getTypeAkan() {
		return TYPE_AKAN;
	}
}
