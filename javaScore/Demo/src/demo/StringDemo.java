package demo;

import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String passWord = "123abcdab";
		//System.out.println(passWord.indexOf("ab", 4));
		
		//substring[beginIndex, endIndex)   ��ȡ��ʼ��λ�õ�������λ��
		System.err.println(passWord.substring(1, 4));
		
		System.out.println(passWord.substring(4));
		
		
		
//		System.out.println("�������û�����");
//		String uName = input.nextLine().trim();     //trim()������ȥ���ַ������ߵĿո�
//		System.out.println("---" + uName + "---");

		
		
//		//��ʾ���ֳ��õ�String���췽��
//		String str1 = "�������";
//		String str2 = new String();    
//		String str3 = "";   
//		System.out.println(str2 == str3);  //false ��ַ�����
//		
//		char[] charArray = {'a', 'b', 'c', 'd'};
//		//���ַ�������ת����String����
//		String str4 = new String(charArray);
//		char[] Array = str4.toCharArray();				//�ַ���ת��Ϊ�ַ�����
//		
//		
//		System.out.println(str4);
//		
//		//byte�������ͷ�Χ�� -128~127֮��
//		byte[] byteArray = {76, 79, 86, 69};
//		String str5 = new String(byteArray);
//		System.out.println(str5);
//		
//		
//		
//		
//		String value = "holle";
//		value += "good";			//�ȼ��ڴ�����һ���µ��ڴ��ַƴ����ȥ��
//		String value2 = "hollegood";
//		System.out.println(value == value2);
//		
//		String value3 = "holle";
//		value2 = value3.concat("����");
//		String value4 = "holle";
//		System.out.println(value == value3);
//		System.out.println(value3 == value4);
//		
		

//		String value = "�й���ž�";
//		value += "�¸���ǿ";
//		//�ȼ���
//		value = value.concat("concat");         //concat����ƴ�ӵ���˼������һ���µ��ַ���
//		System.out.println(value);
	}

}
