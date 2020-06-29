package demo;

import java.util.Scanner;

public class HumPlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HumPlayer play1 = new HumPlayer();
//		play1.srndMessage(play1.MeeageTypeFist);
		String roomPass = "2500";
		System.out.print("请输入房间密码：");
		String Secret = new Scanner(System.in).next();
		while(!"2500".equals(Secret)) {
			System.out.print("密码输入重新输入:");
			Secret = new Scanner(System.in).next();
			
		}
		new HumGameRoom();
	}

}
