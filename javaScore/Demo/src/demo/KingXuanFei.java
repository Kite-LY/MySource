package demo;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

/**
 * ��ѡ��java��
 * 
 * */

public class KingXuanFei {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/** ������������ */
		String[]  NameArray = {"��ʩ", "����", "���Ѿ�", "����", "�Է���", "", "", "", "", ""};
		/** �������� */
		String[] LevelNames = {"����", "����", "����", "�ʹ���", "�ʺ�"};
		/** ��Ӧ�ļ��� */
		int[] level = new int[5];
		/** ��Ӧ�ĺøж� */
		int[] loves = new int[10];
		/** ��ʼ������ */
		int count = 5;
		//�趨��ʼ�ĺøж�
		for(int i = 0; i < count; i++) {
			loves[i] = 100;
		}
		
		int gameDay = 0;  //��ϷĬ�Ϲ���ʮ��
		
		//��Ϸ��ѭ��
		while(gameDay <= 10) {
			System.out.println("��Ϸ���е���" + gameDay +"��");
			System.out.println("1.ѡ��\t\t(����)");
			System.out.println("2.����\t\t(�޸�״̬)");
			System.out.println("3.����\t\t(ɾ��)");
			System.out.println("4.Ѱ��\t\t(���ң��޸�״̬)");
			System.out.print("���������ѡ��");
			int choice = new Scanner(System.in).nextInt();
			
			//����4��ѡ��Ĺ���
			switch (choice) {
			case 1://ѡ��
				if(count == NameArray.length) {
					System.out.println("������Ϊ�������ʧ�ܣ�");
					break;
				}
				System.out.print("��������Ҫѡ���ӵ����䣺");
				String newName = input.next();
				NameArray[count] = newName;
				loves[count] = 100;			
				//�������ӵĺøж�Ҫ-10
				for (int i = 0; i < count; i++) {
					loves[i] -= 10;
				}
				count++;
				break;
			case 2://������
				System.out.print("���������䣺");
				String name = input.next();
				//����
				int searchIndex = -1;
				for (int i = 0; i < count; i++) {
					if(name.equals(NameArray[i])) {
						searchIndex = i;
						break;
					}
				}
				if(searchIndex == -1)
				{
					System.out.println("���ϣ���ʵ��û������ˣ�");
					break;
				}
				//�ҵ��󣺺øж�+20���ȼ�+1�������˺øж�-10
				loves[searchIndex] += 20;
				if(level[searchIndex]== LevelNames.length) {
					System.out.println(NameArray[searchIndex] + "�Ѿ�ĸ�����£�����ʧ�ܣ�");
					break;
				}
				level[searchIndex]++;
				for (int i = 0; i < count; i++) {
					if(searchIndex == i)
					{
						continue;
					}
					loves[i] -= 10;
				}
				System.out.println("����" + NameArray[searchIndex] + ",�øж�+20������Ϊ" + LevelNames[level[searchIndex]] + "�����˺øж�-10");
				break;
			case 3:
				
			case 4:
				
				

			default:
				System.out.println("��������ȷ��ѡ��");
				continue;
			}
			
			for(int i = 0; i < count; i++)
			{
				System.out.println(NameArray[i] + "\t" + LevelNames[level[i]] + "\t" + loves[i]);
			}
			
			gameDay++;
		}
		
		
		
		
	}

}
