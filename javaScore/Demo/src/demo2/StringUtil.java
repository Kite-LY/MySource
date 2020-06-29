package demo2;
/**
 * �ַ����Ĺ�����
 * 
 * */
public class StringUtil {
	
	//1.�û������25���ַ����ȣ�����ʹ�������ַ����ո��
	public static boolean isCurrectUesrName(String userName) {
		boolean isCurrect = true;
		if(userName == null) {
			return false;
		}
		if(userName.length() > 25) {
			return false;
		}
		//�жϷǷ��ַ�
		char[] unValidChar = {'!','"','<','>','?','=','+','*','%'};
		for(char ch: unValidChar) {
			if(userName.contains(Character.toString(ch))) {
			isCurrect = false;
			break;
			}
			
		}
		return isCurrect;
	}
	//2.����6-18λ  ֻ�ܰ������֣���ĸ�������ַ�
	/**
	 * ����ֵ��*����λ����ǿ��
	 * @param password
	 * @return
	 */
	
	public static String valiDatePassword(String password) {
		String power = "";     //powerΪ�����ǿ��
		if(password == null) return power;
		if(password.length() < 6 || password.length() > 18) return power;
		String part ="-@#!";
		for (int i = 0; i < password.length(); i++) {
			if(!Character.isLetterOrDigit(password.charAt(i))) {   			//isLetterOrDigit��Character�����ǲ�����ĸ������
				//���������ĸ���־��ǷǷ�����
				if(!part.contains(Character.toString(password.charAt(i)))) {
					return power;
				}
			}
		}
		//�ж�����ǿ��
		 if(isDigit(password) || isLetter(password)) {
			 power = "�������";
		 }else if(isLetterAndDigit(password)) {
			 power = "�������";
		 }else if(isDigitAndaLetterAndSymbol(password)) {
			 power = "�������";
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
	 * �ж��ǲ��Ǵ�����
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
	 * �������ֺ���ĸ
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
	 * �ж��ǲ��Ǵ���ĸ
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
	
	
	//3.������ȷ��Email
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
