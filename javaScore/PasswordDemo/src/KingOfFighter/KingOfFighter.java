package KingOfFighter;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Scanner;import javax.jws.soap.SOAPBinding.Use;

public class KingOfFighter {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
//		File sound1 = new File("Biscuits - Let Her Go.mps");
//		AudioClip sound_choose = Applet.newAudioClip(sound1.toURL());
//		sound_choose.play();  
		
		Scanner input = new Scanner(System.in);
		//1.让双方选名字：（让用户选名字）
		System.out.println("请输入玩家姓名：");
		String UserName = input.next();
		String comName = "大蛇";
		System.out.println(UserName + "VS" + comName);
		//2.初始化双方体力值
		int hp1 = 100, hp2 = 100;      //双方血量
		int attack1 = 0, attack2 = 0;
		//3.循环模拟对战过程
		while(hp1 > 0 && hp2 > 0) {
			//生成双方攻击了
			attack1 = (int)(Math.random() * 10000) % 11 + 5; 
			attack2 = (int)(Math.random() * 10000) % 11 + 5; 
			hp2 -= attack1;  		//玩家先攻击
			System.out.println(UserName+"打出伤害大蛇掉血" + attack1 );
			
			hp1 -= attack2;
			System.out.println(comName+"打出伤害" + UserName + "掉血" + attack2 );
		}
		
		//4.打印最终结果
		System.out.println("KO");
		System.out.println("玩家姓名\t血量");
		System.out.println(UserName + "\t" + hp1);
		System.out.println(comName + "\t" + hp2);
		
		input.close();
	}

}
