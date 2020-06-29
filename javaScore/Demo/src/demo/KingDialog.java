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
		//参数1；父框信息
		//参数2；对话框的提示信息
		//参数3；对话框的标题信息
		//参数4；消息类型
		//JOptionPane.showMessageDialog(null, "今天你吃了哈", "我的标题哦 ", JOptionPane.ERROR_MESSAGE);
		//参数5：图片信息
		//JOptionPane.showMessageDialog(null, "今天你吃了哈", "我的标题哦 ", JOptionPane.ERROR_MESSAGE, new ImageIcon("images/timg.jpg"));
		Scanner input = new Scanner(System.in);
		/** 创建姓名数组 */
		String[]  NameArray = {"西施", "貂蝉", "王昭君", "杨玉环", "赵飞燕", "", "", "", "", ""};
		
		/** 其他妃子 */
		String[] newNameArray = {"褒姒", "陈圆圆", "苏小小", "甄嬛", "钟无艳"};
		int newNameCount = newNameArray.length;
		
		/** 级别数组 */
		String[] LevelNames = {"贵人", "嫔妃", "贵妃", "皇贵妃", "皇后"};
		/** 对应的级别 */
		int[] level = new int[10];
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
		JOptionPane.showMessageDialog(null, "陛下！您来了！", "欢迎来的此游戏！", 1, new ImageIcon("images/title.jpg"));
		while(gameDay <= 10) {
//			System.out.println("游戏进行到第" + gameDay +"天");
//			System.out.println("1.选妃\t\t(增加)");
//			System.out.println("2.翻牌\t\t(修改状态)");
//			System.out.println("3.冷落\t\t(删除)");
//			System.out.println("4.寻欢\t\t(查找，修改状态)");
//			System.out.print("请输入你的选择：");
//			int choice = new Scanner(System.in).nextInt();
			String strMenu = "1.选妃\n";
			strMenu +="2.翻牌\n";
			strMenu +="3.冷落\n";
			strMenu +="4.寻欢\n";
			strMenu +="请输入你的选择";
			Object objResult =JOptionPane.showInputDialog(null, strMenu, "游戏进行到第" + gameDay +"天", 1, new ImageIcon("images/宝座.jpg"), 
					new String[] {"1", "2", "3", "4"}, 4);
			//完善4个选择的功能
			switch (objResult.toString()) {
			case "1"://选妃
				if(count == NameArray.length) {
					System.out.println("后宫人满为患，添加失败！");
					break;
				}
//				System.out.print("请输入你要选妃子的名讳：");
//				String newName = input.next();
				
				objResult = JOptionPane.showInputDialog(null, "请选择妃子", "选妃", 0,
						new ImageIcon("images/选妃.jpg"),newNameArray, null);
				if(objResult == null) {  //用户选择了取消
					continue;
				}
				JOptionPane.showMessageDialog(null, objResult.toString(),
						"选中的妃子", 0, new ImageIcon("images/"+objResult.toString()+".jpg"));
				NameArray[count] = objResult.toString();
				loves[count] = 100;			
				//其他妃子的好感度要-10
				for (int i = 0; i < count; i++) {
					loves[i] -= 10;
				}
				count++;
				break;
			case "2"://翻牌子
//				System.out.print("请输入名讳：");
//				String name = input.next();
				objResult = JOptionPane.showInputDialog(null, "请选择妃子", "翻牌", 0,
						new ImageIcon("images/选妃翻牌.jpg"),NameArray, null);
				if(objResult == null) {  //用户选择了取消
					continue;
				}
				
				String name = objResult.toString();
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
				//System.out.println("宠幸" + NameArray[searchIndex] + ",好感度+20，升级为" + LevelNames[level[searchIndex]] + "其他人好感度-10");
				JOptionPane.showMessageDialog(null,
						"宠幸" + NameArray[searchIndex] + ",好感度+20，升级为" + LevelNames[level[searchIndex]] + "其他人好感度-10", "翻牌结果"
						, 0, new ImageIcon("images/"+NameArray[searchIndex]+".jpg"));
				break;
			case "3":
				
			case "4" :
				
				

			default:
				System.out.println("请输入正确的选择！");
				continue;
			}
			
			
			//如果3个妃子的好感度低于60 则游戏结束
			int count1 = 0;
			for(int i = 0; i < count; i++)
			{
				if(loves[i] < 60) {
					count1++;
				}
			}
			String resultvalue ="好感度低于60，3人，暴乱\n";
			resultvalue += new Date().toLocaleString();
			if(count1 >= 3) {
				JOptionPane.showMessageDialog(null,resultvalue , "暴乱", 0,
						new ImageIcon("images/皇上被害.jpg"));
				System.exit(0); //系统退出
			}
			
				
			
			//每日结算
			String value = "一天后，后宫的状态！\n";
			for(int i = 0; i < count; i++) {
				value += String.format("%s   %s   %d\n", NameArray[i], LevelNames[level[i]], loves[i]);
			}
			
			JOptionPane.showMessageDialog(null, value, "每日结算", 0, new ImageIcon("images/嬉戏.jpg"));			
			
			
			
			
			
			
			
			
			
			
			
			gameDay++;
		}
	}

}
