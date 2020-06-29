package demo;

import java.util.Scanner;

/**
 * 二分查找，前提数组提前有序
 * 
 * 
 * */
public class BinarySerchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
		System.out.print("请输入你要查找的数字：");
		int searchNum = input.nextInt();
		//普通查找
		for(int i = 0; i < array.length; i++) {
			if(searchNum == array[i]) {
				System.out.println("恭喜你找到了，位置是：" + i);
				break;
			}else {
				System.out.println("没有找到");
				break;
			}
		}
		
		
		//二分查找
		int indexDelete = -1;
		int high = array.length - 1;		//定义上界
		int low = 0;						//定义下界
		while(high >= low) {
			int mid = (high + low) / 2;		//定义中间位置
			if(searchNum < array[mid]) {	//查找值小于中间值时
				high = mid - 1;
			}else if(searchNum > array[mid]) {
				low = mid + 1;
			}else {
				System.out.println("恭喜你找到了，位置是：" + mid);
				indexDelete = mid;
				break;
			}
			indexDelete = mid;
		}
		if( low > high) {
			System.out.println("没有你要查找的数字！");
		}
		System.out.println(indexDelete);
		//删除算法
		int count = array.length;
		count--;
		for (int i = indexDelete; i < count; i++) {
			array[i] = array[i + 1];
		}
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

}
