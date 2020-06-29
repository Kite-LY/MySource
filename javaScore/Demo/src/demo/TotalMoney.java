package demo;

import java.util.Scanner;

public class TotalMoney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.循环录入5个玩家的消费金额
		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			System.out.println("请输入第"+ (i + 1) +"消费金额：");
			int money = new Scanner(System.in).nextInt();
//			if(money < 500) {
//				count++;
//			}
			if(money >= 500)
			{
				continue;
			}
			count++;
		}
		System.out.println("小于500的总数为：" + count);
		//2.录入后立刻判断金额是否小于500
		//3.累计小于500的次数
		
		
		
		
	}

}
