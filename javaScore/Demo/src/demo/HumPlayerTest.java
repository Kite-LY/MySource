package demo;

import java.util.Scanner;

public class HumPlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HumPlayer play1 = new HumPlayer();
//		play1.srndMessage(play1.MeeageTypeFist);
		String roomPass = "2500";
		System.out.print("�����뷿�����룺");
		String Secret = new Scanner(System.in).next();
		while(!"2500".equals(Secret)) {
			System.out.print("����������������:");
			Secret = new Scanner(System.in).next();
			
		}
		new HumGameRoom();
	}

}
