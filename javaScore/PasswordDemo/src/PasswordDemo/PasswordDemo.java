package PasswordDemo;
import java.util.Scanner;

public class PasswordDemo {
	public static void main(String[] args) {
		final String PASSWORD = "123456";    //����
		
		Scanner input = new Scanner(System.in);
		String password = null;      //����
		
		String userName = "";
		//ѭ������
		int i = 0;
		while(i < 3) {
			System.out.println("���������룺");
			password = input.next();
			i++;
			if(!"PASSWORD".equals(password)) {
				System.out.println("��������������������룡��ʣ��" + (3 -i) + " �Σ�");
				if(i == 3) {
					System.out.println("�����������������Σ�ϵͳ�Զ��˳���");
					System.exit(0);
				}
			}else {
				//i = 5;
				i = Integer.MAX_VALUE;    //����������ֵ
			}
	
		}
		System.out.println("������ȷ���ɹ���¼��ϵͳ��");
	}
}