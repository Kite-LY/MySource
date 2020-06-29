package PasswordDemo;
import java.util.Scanner;

public class PasswordDemo {
	public static void main(String[] args) {
		final String PASSWORD = "123456";    //常量
		
		Scanner input = new Scanner(System.in);
		String password = null;      //密码
		
		String userName = "";
		//循环条件
		int i = 0;
		while(i < 3) {
			System.out.println("请输入密码：");
			password = input.next();
			i++;
			if(!"PASSWORD".equals(password)) {
				System.out.println("密码输入错误，请重新输入！（剩余" + (3 -i) + " 次）");
				if(i == 3) {
					System.out.println("你输入的密码错误三次！系统自动退出。");
					System.exit(0);
				}
			}else {
				//i = 5;
				i = Integer.MAX_VALUE;    //整型中最大的值
			}
	
		}
		System.out.println("密码正确，成功登录此系统！");
	}
}