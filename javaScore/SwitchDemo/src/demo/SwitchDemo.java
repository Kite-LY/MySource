package demo;

import java.util.Scanner;


public class SwitchDemo {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;			//用于保护用户的选择
		System.out.println("1.登录游戏");
		System.out.println("2.退出游戏");
		
		choice = input.nextInt();
		
		if(choice == 1) {//进入主菜单
			System.out.println("1.传音入室");
			System.out.println("2.举目四望");
			System.out.println("3.会会老友");
			System.out.println("4.自我欣赏");
			System.out.println("5.观察地形");
			System.out.println("6.到此一游");
			System.out.println("请输入你的选择：");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.out.println("笑傲江湖啊>会会老友");
				System.out.println("1.添加老友信息");
				System.out.println("---------");
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
					System.out.println("输入错误！请输入正确的选择:");
					System.exit(0);
			}
			
		}else if(choice == 2) {
			System.exit(0);
		}else {
			System.out.println("输入错误，游戏退出！");
		}
		
	}
}
