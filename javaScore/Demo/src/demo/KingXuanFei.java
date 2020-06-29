package demo;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

/**
 * 后宫选妃java版
 * 
 * */

public class KingXuanFei {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/** 创建姓名数组 */
		String[]  NameArray = {"西施", "貂蝉", "王昭君", "杨玉环", "赵飞燕", "", "", "", "", ""};
		/** 级别数组 */
		String[] LevelNames = {"贵人", "嫔妃", "贵妃", "皇贵妃", "皇后"};
		/** 对应的级别 */
		int[] level = new int[5];
		/** 对应的好感度 */
		int[] loves = new int[10];
		/** 初始的数量 */
		int count = 5;
		//设定初始的好感度
		for(int i = 0; i < count; i++) {
			loves[i] = 100;
		}
		
		int gameDay = 0;  //游戏默认工作十天
		
		//游戏大循环
		while(gameDay <= 10) {
			System.out.println("游戏进行到第" + gameDay +"天");
			System.out.println("1.选妃\t\t(增加)");
			System.out.println("2.翻牌\t\t(修改状态)");
			System.out.println("3.冷落\t\t(删除)");
			System.out.println("4.寻欢\t\t(查找，修改状态)");
			System.out.print("请输入你的选择：");
			int choice = new Scanner(System.in).nextInt();
			
			//完善4个选择的功能
			switch (choice) {
			case 1://选妃
				if(count == NameArray.length) {
					System.out.println("后宫人满为患，添加失败！");
					break;
				}
				System.out.print("请输入你要选妃子的名讳：");
				String newName = input.next();
				NameArray[count] = newName;
				loves[count] = 100;			
				//其他妃子的好感度要-10
				for (int i = 0; i < count; i++) {
					loves[i] -= 10;
				}
				count++;
				break;
			case 2://翻牌子
				System.out.print("请输入名讳：");
				String name = input.next();
				//查找
				int searchIndex = -1;
				for (int i = 0; i < count; i++) {
					if(name.equals(NameArray[i])) {
						searchIndex = i;
						break;
					}
				}
				if(searchIndex == -1)
				{
					System.out.println("皇上，现实中没有这个人！");
					break;
				}
				//找到后：好感度+20，等级+1，其他人好感度-10
				loves[searchIndex] += 20;
				if(level[searchIndex]== LevelNames.length) {
					System.out.println(NameArray[searchIndex] + "已经母仪天下，升级失败！");
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
				System.out.println("宠幸" + NameArray[searchIndex] + ",好感度+20，升级为" + LevelNames[level[searchIndex]] + "其他人好感度-10");
				break;
			case 3:
				
			case 4:
				
				

			default:
				System.out.println("请输入正确的选择！");
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
