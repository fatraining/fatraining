package action;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String str = "remember";
		String md5_str = "";
		try {
		    byte[] str_bytes = str.getBytes("UTF-8");
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] md5_bytes = md.digest(str_bytes);
		    BigInteger big_int = new BigInteger(1, md5_bytes);
		    md5_str = big_int.toString(16);
		}catch(Exception e){
		    // 略
		}

		System.out.println(md5_str);
		
	}

}
