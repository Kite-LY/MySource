package demo;

import java.util.Scanner;

/**
 * 游戏的房间类
 *
 */


public class HumGameRoom {
	//属性：记分牌，道具，玩家
	private HumPlayer p1 = null;
	private HumComPlayer2 p2 = null;
	/** 房间id*/
	private int roomId;
	private String roomName = "Kite的猜拳";
	/** 房间密码*/


	
	public HumGameRoom() {
		Scanner input = new Scanner(System.in);
	
		
		String [] quan = {"剪刀", "布", "石头"};
		initGame();   	//初始化游戏
		showMenu();		//显示菜单
		choiceRole();  
		//双方出拳
		while(true) {
		gaming(input, quan);
			System.out.print("是否结束游戏（y/n）");
			String answer = input.next();
			if(!"y".equalsIgnoreCase(answer)) {
				break;
			}
		
		}
		System.out.println("游戏结束了，最终比分如下：");
		System.out.println(p1.getName() + ":" + p1.getScore());
		System.out.println(p2.getName() + ":" + p2.getScore());
		
	}

	private void gaming(Scanner input, String[] quan) {
		System.out.print(p1.getName() + "请出拳：");
		p1.setFist(input.nextInt());
		int fist1 = p1.getFist();  	//玩家出拳
		int fist2 = p2.getFist();	//电脑出拳
		System.out.println();
		System.out.println(p1.getName() + "出拳：" + quan[fist1-1] );
		System.out.println(p2.getName() + "出拳：" + quan[fist2-1] );
		//判断输赢     : 返回0为平局。返回-1p1赢，返回1则p2赢
		int result = judge(fist1, fist2);
		//打印结果
		if(result == 0) {
			System.out.println("双方打成平手；");
			p1.sendMessage(p1.MeeageTypeFist);
			System.out.print(p2.getName());
			p2.sendMessage(p2.MeeageTypeFist);
		}else if(result == 1) {
			System.out.println(p1.getName() + "取得胜利！");
			p1.sendMessage(p1.MeeageTypeWin);
			System.out.print(p2.getName());
			p2.sendMessage(p2.MeeageTypelose);
		}else if(result == -1) {
			System.out.println(p2.getName() + "取得胜利！");
			p1.sendMessage(p1.MeeageTypelose);
			System.out.print(p2.getName());
			p2.sendMessage(p2.MeeageTypeWin);
		}
	}
	
	public void showMenu() {
		//显示菜单
		System.out.println("欢迎进入《"+ roomName +"》游戏房间！");
		System.out.println("出拳规则：1-剪刀；2-布；3-石头");
	}
	
	
	//方法： 开始游戏，初始化游戏，显示菜单，选择人物，判断输赢
	public void initGame() {
			//实例化对象
		p1 = new HumPlayer();
		p2 = new HumComPlayer2();
		//打印其他属性
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
		System.out.println("      游戏加载成功");
	}
	
	public void startGame() {
		
	}
	
	public void choiceRole() {
		Scanner input = new Scanner(System.in);
		System.out.println("请选对方的角色：1-风间；2-妮妮；3-正南；3-呆呆 ");
		int chioce = input.nextInt();
		String[] role = {"风间", "妮妮", "正南", "呆呆" };
		p1.setName("小新");
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
