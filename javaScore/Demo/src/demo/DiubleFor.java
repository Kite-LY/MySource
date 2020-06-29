package demo;

//双循环

public class DiubleFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i ++) {			//外层循环控制行 换行
			for(int j = 0; j <= 2- i; j++) {		//控制打印内容，列
				System.out.print(" ");
			}
			for (int j = 0; j <= 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 3; i ++) {			//外层循环控制行 换行
			for(int j = 0; j <=i; j++) {		//控制打印内容，列
				System.out.print(" ");
			}
			for (int j = 0; j <=  4 - 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
