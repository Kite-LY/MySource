package demo;
/**
 * ��ӡ��������֪��һ��Ϊ���ڶ�
 * */
public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����һ\t���ڶ�\t������\t������\t������\t������\t������\t");
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
