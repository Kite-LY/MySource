package KingOfFighter;

import java.util.Scanner;

/**
 * 模拟武侠世世界创造人物
 * 
 * */


public class MyWuxiaWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	input = new Scanner(System.in);
		String answer = "y";
		String name = null;
		
		do {
			System.out.println("欢迎进入武侠世界，请给自己起一个名讳："); 
			name = input.nextLine();
			System.out.println("江湖名号： " + name);
			
			System.out.println(name + "是否对自己的名讳满意(y/n)");
			answer = input.nextLine();
		}while(! "y".equalsIgnoreCase(answer));
			
		System.out.println(name + "初入江湖，请多多指教！" );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		input.close();
	}

}
