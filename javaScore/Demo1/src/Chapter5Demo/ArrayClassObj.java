package Chapter5Demo;

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.*;

/**
 * ����ĳ�ʼ��
 * @author С����
 *
 */
public class ArrayClassObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random(5);			//�涨�˴�ӡ���ֵĸ���
		Integer[] a= new Integer[random.nextInt(20)];
		print("length of a = " + a.length);
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(50);
			print(Arrays.toString(a));
		}
	}

}
