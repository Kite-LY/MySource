package demo;

import java.util.Scanner;


public class SwitchDemo {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;			//���ڱ����û���ѡ��
		System.out.println("1.��¼��Ϸ");
		System.out.println("2.�˳���Ϸ");
		
		choice = input.nextInt();
		
		if(choice == 1) {//�������˵�
			System.out.println("1.��������");
			System.out.println("2.��Ŀ����");
			System.out.println("3.�������");
			System.out.println("4.��������");
			System.out.println("5.�۲����");
			System.out.println("6.����һ��");
			System.out.println("���������ѡ��");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.out.println("Ц��������>�������");
				System.out.println("1.���������Ϣ");
				System.out.println("---------");
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
					System.out.println("���������������ȷ��ѡ��:");
					System.exit(0);
			}
			
		}else if(choice == 2) {
			System.exit(0);
		}else {
			System.out.println("���������Ϸ�˳���");
		}
		
	}
}
