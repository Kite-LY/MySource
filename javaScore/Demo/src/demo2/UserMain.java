package demo2;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
//		System.out.println("�������û�����");
//		String userName = input.next();
		
		
		System.out.println("�������û����룺");
		String passWord = input.next();
		System.out.println(StringUtil.valiDatePassword(passWord));
		
//		System.out.println("�������û����䣺");
//		String email = input.next();
		
	}

}
