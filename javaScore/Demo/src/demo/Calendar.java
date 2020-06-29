package demo;
/**
 * 打印月历，已知第一天为星期二
 * */
public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日\t");
		System.out.print("\t");
		int day = 31;
		for(int i = 1; i <= day; i++)
		{
			System.out.print(i);
			if( (i + 1) % 7 == 0) {
				System.out.print("\n");
			}else {
				System.out.print("\t");
			}
		}
	}

}
