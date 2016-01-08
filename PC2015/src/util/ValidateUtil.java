package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * バリデーションユーティリティやで
 * @author miyamoto
 *
 */
public class ValidateUtil {

	/**
	 * 引数のemailが<br>
	 * ○○@○○.○○の形になっているかチェックするやで。
	 * @return boolean
	 */
	public static boolean isValidEmail(String email){
		String str = email;
		String regex = "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if(m.find()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 引数のinputTimeがHH:mmの形式になっているかチェックするやで。
	 * @param time
	 * @return boolean
	 */
	public static boolean isValidTime(String time){
		String regex = "^([0-1][0-9]|2[0-3]):[0-5][0-9]$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		if(m.find()){
			return true;
		} else {
			return false;
		}
	}
}
