package demo;

import java.awt.Image;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.omg.CORBA.DATA_CONVERSION;

public class KingDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null,"gaga");
		//����1��������Ϣ
		//����2���Ի������ʾ��Ϣ
		//����3���Ի���ı�����Ϣ
		//����4����Ϣ����
		//JOptionPane.showMessageDialog(null, "��������˹�", "�ҵı���Ŷ ", JOptionPane.ERROR_MESSAGE);
		//����5��ͼƬ��Ϣ
		//JOptionPane.showMessageDialog(null, "��������˹�", "�ҵı���Ŷ ", JOptionPane.ERROR_MESSAGE, new ImageIcon("images/timg.jpg"));
		Scanner input = new Scanner(System.in);
		/** ������������ */
		String[]  NameArray = {"��ʩ", "����", "���Ѿ�", "����", "�Է���", "", "", "", "", ""};
		
		/** �������� */
		String[] newNameArray = {"���", "��ԲԲ", "��СС", "���", "������"};
		int newNameCount = newNameArray.length;
		
		/** �������� */
		String[] LevelNames = {"����", "����", "����", "�ʹ���", "�ʺ�"};
		/** ��Ӧ�ļ��� */
		int[] level = new int[10];
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
		JOptionPane.showMessageDialog(null, "���£������ˣ�", "��ӭ���Ĵ���Ϸ��", 1, new ImageIcon("images/title.jpg"));
		while(gameDay <= 10) {
//			System.out.println("��Ϸ���е���" + gameDay +"��");
//			System.out.println("1.ѡ��\t\t(����)");
//			System.out.println("2.����\t\t(�޸�״̬)");
//			System.out.println("3.����\t\t(ɾ��)");
//			System.out.println("4.Ѱ��\t\t(���ң��޸�״̬)");
//			System.out.print("���������ѡ��");
//			int choice = new Scanner(System.in).nextInt();
			String strMenu = "1.ѡ��\n";
			strMenu +="2.����\n";
			strMenu +="3.����\n";
			strMenu +="4.Ѱ��\n";
			strMenu +="���������ѡ��";
			Object objResult =JOptionPane.showInputDialog(null, strMenu, "��Ϸ���е���" + gameDay +"��", 1, new ImageIcon("images/����.jpg"), 
					new String[] {"1", "2", "3", "4"}, 4);
			//����4��ѡ��Ĺ���
			switch (objResult.toString()) {
			case "1"://ѡ��
				if(count == NameArray.length) {
					System.out.println("������Ϊ�������ʧ�ܣ�");
					break;
				}
//				System.out.print("��������Ҫѡ���ӵ����䣺");
//				String newName = input.next();
				
				objResult = JOptionPane.showInputDialog(null, "��ѡ������", "ѡ��", 0,
						new ImageIcon("images/ѡ��.jpg"),newNameArray, null);
				if(objResult == null) {  //�û�ѡ����ȡ��
					continue;
				}
				JOptionPane.showMessageDialog(null, objResult.toString(),
						"ѡ�е�����", 0, new ImageIcon("images/"+objResult.toString()+".jpg"));
				NameArray[count] = objResult.toString();
				loves[count] = 100;			
				//�������ӵĺøж�Ҫ-10
				for (int i = 0; i < count; i++) {
					loves[i] -= 10;
				}
				count++;
				break;
			case "2"://������
//				System.out.print("���������䣺");
//				String name = input.next();
				objResult = JOptionPane.showInputDialog(null, "��ѡ������", "����", 0,
						new ImageIcon("images/ѡ������.jpg"),NameArray, null);
				if(objResult == null) {  //�û�ѡ����ȡ��
					continue;
				}
				
				String name = objResult.toString();
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
					continue;
				}
				level[searchIndex]++;
				for (int i = 0; i < count; i++) {
					if(searchIndex == i)
					{
						continue;
					}
					loves[i] -= 10;
				}
				//System.out.println("����" + NameArray[searchIndex] + ",�øж�+20������Ϊ" + LevelNames[level[searchIndex]] + "�����˺øж�-10");
				JOptionPane.showMessageDialog(null,
						"����" + NameArray[searchIndex] + ",�øж�+20������Ϊ" + LevelNames[level[searchIndex]] + "�����˺øж�-10", "���ƽ��"
						, 0, new ImageIcon("images/"+NameArray[searchIndex]+".jpg"));
				break;
			case "3":
				
			case "4" :
				
				

			default:
				System.out.println("��������ȷ��ѡ��");
				continue;
			}
			
			
			//���3�����ӵĺøжȵ���60 ����Ϸ����
			int count1 = 0;
			for(int i = 0; i < count; i++)
			{
				if(loves[i] < 60) {
					count1++;
				}
			}
			String resultvalue ="�øжȵ���60��3�ˣ�����\n";
			resultvalue += new Date().toLocaleString();
			if(count1 >= 3) {
				JOptionPane.showMessageDialog(null,resultvalue , "����", 0,
						new ImageIcon("images/���ϱ���.jpg"));
				System.exit(0); //ϵͳ�˳�
			}
			
				
			
			//ÿ�ս���
			String value = "һ��󣬺󹬵�״̬��\n";
			for(int i = 0; i < count; i++) {
				value += String.format("%s   %s   %d\n", NameArray[i], LevelNames[level[i]], loves[i]);
			}
			
			JOptionPane.showMessageDialog(null, value, "ÿ�ս���", 0, new ImageIcon("images/��Ϸ.jpg"));			
			
			
			
			
			
			
			
			
			
			
			
			gameDay++;
		}
	}

}
