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
		//1.��˫��ѡ���֣������û�ѡ���֣�
		System.out.println("���������������");
		String UserName = input.next();
		String comName = "����";
		System.out.println(UserName + "VS" + comName);
		//2.��ʼ��˫������ֵ
		int hp1 = 100, hp2 = 100;      //˫��Ѫ��
		int attack1 = 0, attack2 = 0;
		//3.ѭ��ģ���ս����
		while(hp1 > 0 && hp2 > 0) {
			//����˫��������
			attack1 = (int)(Math.random() * 10000) % 11 + 5; 
			attack2 = (int)(Math.random() * 10000) % 11 + 5; 
			hp2 -= attack1;  		//����ȹ���
			System.out.println(UserName+"����˺����ߵ�Ѫ" + attack1 );
			
			hp1 -= attack2;
			System.out.println(comName+"����˺�" + UserName + "��Ѫ" + attack2 );
		}
		
		//4.��ӡ���ս��
		System.out.println("KO");
		System.out.println("�������\tѪ��");
		System.out.println(UserName + "\t" + hp1);
		System.out.println(comName + "\t" + hp2);
		
		input.close();
	}

}
