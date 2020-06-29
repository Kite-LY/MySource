package demo2;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
//		System.out.println("请输入用户名：");
//		String userName = input.next();
		
		
		System.out.println("请输入用户密码：");
		String passWord = input.next();
		System.out.println(StringUtil.valiDatePassword(passWord));
		
//		System.out.println("请输入用户邮箱：");
//		String email = input.next();
		
	}

}
