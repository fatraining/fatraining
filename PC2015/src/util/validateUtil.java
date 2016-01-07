package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * バリデーションユーティリティやで
 * @author miyamoto
 *
 */
public class validateUtil {

	/**
	 * 引数のemailが<br>
	 * ○○@○○.○○の形になっているかチェックするやで。
	 * @return boolean
	 */
	public static boolean emailValidate(String email){
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
	 * @param inputTime
	 * @return boolean
	 */
	public static boolean inputTimeValidate(String inputTime){
		String regex = "^([0-1][0-9]|2[0-3]):[0-5][0-9]$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inputTime);
		if(m.find()){
			return true;
		} else {
			return false;
		}
	}
}
