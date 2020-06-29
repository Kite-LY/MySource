package demo2;
/**
 * 字符串的工具类
 * 
 * */
public class StringUtil {
	
	//1.用户名最多25个字符长度，不能使用特殊字符，空格等
	public static boolean isCurrectUesrName(String userName) {
		boolean isCurrect = true;
		if(userName == null) {
			return false;
		}
		if(userName.length() > 25) {
			return false;
		}
		//判断非法字符
		char[] unValidChar = {'!','"','<','>','?','=','+','*','%'};
		for(char ch: unValidChar) {
			if(userName.contains(Character.toString(ch))) {
			isCurrect = false;
			break;
			}
			
		}
		return isCurrect;
	}
	//2.密码6-18位  只能包括数字，字母，特殊字符
	/**
	 * 返回值的*数量位密码强度
	 * @param password
	 * @return
	 */
	
	public static String valiDatePassword(String password) {
		String power = "";     //power为密码的强度
		if(password == null) return power;
		if(password.length() < 6 || password.length() > 18) return power;
		String part ="-@#!";
		for (int i = 0; i < password.length(); i++) {
			if(!Character.isLetterOrDigit(password.charAt(i))) {   			//isLetterOrDigit是Character类中是不是字母，数字
				//如果不是字母数字就是非法符号
				if(!part.contains(Character.toString(password.charAt(i)))) {
					return power;
				}
			}
		}
		//判读密码强度
		 if(isDigit(password) || isLetter(password)) {
			 power = "★★☆☆☆☆";
		 }else if(isLetterAndDigit(password)) {
			 power = "★★★★☆☆";
		 }else if(isDigitAndaLetterAndSymbol(password)) {
			 power = "★★★★★★";
		 }
		 
		
		return power;
	}
	
	private static boolean isDigitAndaLetterAndSymbol(String value) {
		for (int i = 0; i < value.length(); i++) {
			if((Character.isLetterOrDigit(value.charAt(i)) || "_@#!".contains(Character.toString(value.charAt(i))))){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * 判断是不是纯数字
	 * @param value
	 * @return
	 */
	private static boolean isDigit(String value) {
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 包含数字和字母
	 * @param value
	 * @return
	 */
	
	private static boolean isLetterAndDigit(String value) {
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isLetterOrDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断是不是纯字母
	 * @param value
	 * @return
	 */
	private static boolean isLetter(String value) {
		for (int i = 0; i < value.length(); i++) {
			if(!Character.isLetter(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isContainSysmble(String value) {
		String part = "_@#!";
		for (int i = 0; i < value.length(); i++) {
			if(part.contains(Character.toString(value.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
	
	
	//3.输入正确的Email
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
