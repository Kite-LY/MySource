package demo;

import java.util.Scanner;

/**
 * ��������Ϸ
 * */
public class GuessNumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = (int)((Math.random() * 1000) % 10);
		//System.err.println(num);
		
		
		for(int i = 0; i < 20; i++)
		{
			System.out.println("��������� " + (i+1) +"�βµ����֣�");
			int guessNum = input.nextInt();
			if(guessNum == num)
			{	
				if( i == 1)
				{
					System.err.println("��ϲ�����" + i + " �δ�ԣ� һ�Ƚ�!");
				break;
				}else if( i > 1 && i < 4) {
					System.err.println("��ϲ�����" + i  + " �δ�ԣ� ���Ƚ�!");
					break;
				}else if( i >= 4  && i < 7) {
					System.err.println("��ϲ�����" + i  + " �δ�ԣ� ���Ƚ�!");
					break;
				}else if( i >= 7) {
					System.err.println("��ϲ�����" + i  + " �δ�ԣ� лл���룡");
					break;
				}
				
			}else if(guessNum < num)
			{
				System.out.println("���С�ˣ�");
			}else{
				System.out.println("��´��ˣ�");
			}
			
			
			
		}
	
		

		
		input.close();
	}

}
