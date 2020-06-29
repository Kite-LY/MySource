package Chapter5Demo;

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.*;

/**
 * 数组的初始化
 * @author 小风筝
 *
 */
public class ArrayClassObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random(5);			//规定了打印数字的个数
		Integer[] a= new Integer[random.nextInt(20)];
		print("length of a = " + a.length);
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(50);
			print(Arrays.toString(a));
		}
	}

}
