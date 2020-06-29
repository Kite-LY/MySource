package demo;

import java.util.Scanner;

/**
 * ��Ϸ�ķ�����
 *
 */


public class HumGameRoom {
	//���ԣ��Ƿ��ƣ����ߣ����
	private HumPlayer p1 = null;
	private HumComPlayer2 p2 = null;
	/** ����id*/
	private int roomId;
	private String roomName = "Kite�Ĳ�ȭ";
	/** ��������*/


	
	public HumGameRoom() {
		Scanner input = new Scanner(System.in);
	
		
		String [] quan = {"����", "��", "ʯͷ"};
		initGame();   	//��ʼ����Ϸ
		showMenu();		//��ʾ�˵�
		choiceRole();  
		//˫����ȭ
		while(true) {
		gaming(input, quan);
			System.out.print("�Ƿ������Ϸ��y/n��");
			String answer = input.next();
			if(!"y".equalsIgnoreCase(answer)) {
				break;
			}
		
		}
		System.out.println("��Ϸ�����ˣ����ձȷ����£�");
		System.out.println(p1.getName() + ":" + p1.getScore());
		System.out.println(p2.getName() + ":" + p2.getScore());
		
	}

	private void gaming(Scanner input, String[] quan) {
		System.out.print(p1.getName() + "���ȭ��");
		p1.setFist(input.nextInt());
		int fist1 = p1.getFist();  	//��ҳ�ȭ
		int fist2 = p2.getFist();	//���Գ�ȭ
		System.out.println();
		System.out.println(p1.getName() + "��ȭ��" + quan[fist1-1] );
		System.out.println(p2.getName() + "��ȭ��" + quan[fist2-1] );
		//�ж���Ӯ     : ����0Ϊƽ�֡�����-1p1Ӯ������1��p2Ӯ
		int result = judge(fist1, fist2);
		//��ӡ���
		if(result == 0) {
			System.out.println("˫�����ƽ�֣�");
			p1.sendMessage(p1.MeeageTypeFist);
			System.out.print(p2.getName());
			p2.sendMessage(p2.MeeageTypeFist);
		}else if(result == 1) {
			System.out.println(p1.getName() + "ȡ��ʤ����");
			p1.sendMessage(p1.MeeageTypeWin);
			System.out.print(p2.getName());
			p2.sendMessage(p2.MeeageTypelose);
		}else if(result == -1) {
			System.out.println(p2.getName() + "ȡ��ʤ����");
			p1.sendMessage(p1.MeeageTypelose);
			System.out.print(p2.getName());
			p2.sendMessage(p2.MeeageTypeWin);
		}
	}
	
	public void showMenu() {
		//��ʾ�˵�
		System.out.println("��ӭ���롶"+ roomName +"����Ϸ���䣡");
		System.out.println("��ȭ����1-������2-����3-ʯͷ");
	}
	
	
	//������ ��ʼ��Ϸ����ʼ����Ϸ����ʾ�˵���ѡ������ж���Ӯ
	public void initGame() {
			//ʵ��������
		p1 = new HumPlayer();
		p2 = new HumComPlayer2();
		//��ӡ��������
		for(int i = 0; i < 60; i++) {
			if(i % 20 == 0) {
				System.out.println();
			}
			System.out.print("*");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("      ��Ϸ���سɹ�");
	}
	
	public void startGame() {
		
	}
	
	public void choiceRole() {
		Scanner input = new Scanner(System.in);
		System.out.println("��ѡ�Է��Ľ�ɫ��1-��䣻2-���ݣ�3-���ϣ�3-���� ");
		int chioce = input.nextInt();
		String[] role = {"���", "����", "����", "����" };
		p1.setName("С��");
		p2.setName(role[chioce - 1]);
		System.out.println(p1.getName() + "\tVS\t" + p2.getName());
	}
	
	public int judge(int fist1, int fist2) {
		if(fist1 == fist2) {
			return 0;
		}else if(fist1 == 1 && fist2 == 2 || fist1 == 2 && fist2 == 3 || fist1 == 3 &&  fist2 == 1){
			p1.setScore(p1.getScore() + 1);
			p2.setScore(p2.getScore() - 1);
			return 1;
		}else {
			p2.setScore(p2.getScore() + 1);
			p1.setScore(p1.getScore() - 1);
			return -1;
		}
		
	}
	
	public void endGame(){
		
	}
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
//	public String getRoomPass() {
//		return roomPass;
//	}
//	public void setRoomPass(String roomPass) {
//		this.roomPass = roomPass;
//	}
//	
	
	
}
