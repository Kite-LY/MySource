package demo;

import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String passWord = "123abcdab";
		//System.out.println(passWord.indexOf("ab", 4));
		
		//substring[beginIndex, endIndex)   读取开始的位置到结束的位置
		System.err.println(passWord.substring(1, 4));
		
		System.out.println(passWord.substring(4));
		
		
		
//		System.out.println("请输入用户名：");
//		String uName = input.nextLine().trim();     //trim()方法是去点字符串两边的空格
//		System.out.println("---" + uName + "---");

		
		
//		//演示几种常用的String构造方法
//		String str1 = "你好世界";
//		String str2 = new String();    
//		String str3 = "";   
//		System.out.println(str2 == str3);  //false 地址不相等
//		
//		char[] charArray = {'a', 'b', 'c', 'd'};
//		//将字符串类型转换成String对象
//		String str4 = new String(charArray);
//		char[] Array = str4.toCharArray();				//字符串转换为字符数组
//		
//		
//		System.out.println(str4);
//		
//		//byte数据类型范围： -128~127之间
//		byte[] byteArray = {76, 79, 86, 69};
//		String str5 = new String(byteArray);
//		System.out.println(str5);
//		
//		
//		
//		
//		String value = "holle";
//		value += "good";			//等价于创建了一个新的内存地址拼接上去的
//		String value2 = "hollegood";
//		System.out.println(value == value2);
//		
//		String value3 = "holle";
//		value2 = value3.concat("哈哈");
//		String value4 = "holle";
//		System.out.println(value == value3);
//		System.out.println(value3 == value4);
//		
		

//		String value = "中国解放军";
//		value += "勇敢自强";
//		//等价于
//		value = value.concat("concat");         //concat代表拼接的意思，创建一个新的字符串
//		System.out.println(value);
	}

}
