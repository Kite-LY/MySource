package demo;

import java.util.Scanner;

/**
 * 猜数字游戏
 * */
public class GuessNumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = (int)((Math.random() * 1000) % 10);
		//System.err.println(num);
		
		
		for(int i = 0; i < 20; i++)
		{
			System.out.println("请输入你第 " + (i+1) +"次猜的数字：");
			int guessNum = input.nextInt();
			if(guessNum == num)
			{	
				if( i == 1)
				{
					System.err.println("恭喜你猜了" + i + " 次答对！ 一等奖!");
				break;
				}else if( i > 1 && i < 4) {
					System.err.println("恭喜你猜了" + i  + " 次答对！ 二等奖!");
					break;
				}else if( i >= 4  && i < 7) {
					System.err.println("恭喜你猜了" + i  + " 次答对！ 三等奖!");
					break;
				}else if( i >= 7) {
					System.err.println("恭喜你猜了" + i  + " 次答对！ 谢谢参与！");
					break;
				}
				
			}else if(guessNum < num)
			{
				System.out.println("你猜小了！");
			}else{
				System.out.println("你猜大了！");
			}
			
			
			
		}
	
		

		
		input.close();
	}

}
