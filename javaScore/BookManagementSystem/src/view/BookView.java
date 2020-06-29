package view;

import java.util.Scanner;

import auth.Role;
import entity.User;

public class BookView {
	private Scanner input = null;
	private User loginUser = null;				//��ǰ�Ѿ���¼���û�����
	private Role role = null;					//��ǰ�Ѿ���¼�û��Ķ�Ӧ��ɫ����������ҵ�� ����
	
	public BookView() {
		input = new Scanner(System.in);
		showWelcome();
	}
	
	
	
	/**
	 * ��ʾ��ӭ����
	 */
	public void showWelcome() {
		System.out.println("=============   ��ӭʹ��Kiteͼ�����ϵͳ   ==============");
		System.out.println("\t1.��¼ϵͳ\n\t2.ע��\n\t3.�˳�ϵͳ");
		System.out.println("=======================================================");
		System.out.print("��ѡ��");
		String choice = input.next();
		if("1".equals(choice)) {
			//��¼
			showLoginView();
			System.out.println("��ǰ��ɫ��" + this.role.getKey());
			switch (this.role.getKey()) {
			case "administrator":
					showMainView_Adminstrator();
				break;
			case "oparator":
				showMainView_Oparator();
			default:
				break;
			}
			
		}else if("2".equals(choice)) {
			//ע��
			System.out.println("ע�᷽����");
		}else {
			System.out.println("ϵͳ�ɹ��˳�!");
		}
		
	}
	
	public User showLoginView() {
		User loginUser = new User();
		System.out.print("�û�����");
		loginUser.setUserName(input.next());
		System.out.print("���룺");
		loginUser.setPassword(input.next());
		//��Ҫͨ��ҵ�񷽷���֤��ǰ¼����û������Ƿ�Ϸ�
		//����Ϸ�������ǰ��¼�û����浽this.loginUser�б��ã������õ�ǰ��¼�û��Ľ�ɫ���Ա���ʾ��Ӧ�Ĳ˵���������Ӧ�ķ���
		this.loginUser = loginUser.getRole().login(loginUser);
		if(this.loginUser == null) {
			return null;
		}else {
			//this.loginUser = loginUser;
			this.role = this.loginUser.getRole();
			return this.loginUser;
		}
		
	
	}
	
	
	/**
	 * ��ʾ����Ա���˵�
	 */
	public void showMainView_Adminstrator() {
		System.out.println("����Ա���˵�");
	}
	
	/**
	 * ��ʾ����Ա���˵�
	 */
	public void showMainView_Oparator() {
		System.out.println("����Ա���˵�");
	}
	
}




















