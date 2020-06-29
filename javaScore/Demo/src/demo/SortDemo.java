package demo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * */
public class SortDemo {

	public static void main(String[] args) {
		//定义数组 
		final int N = 10000000;
		int[] sortNums = new int[N];
		for (int i = 0; i < sortNums.length; i++) {
			sortNums[i] = (int)(Math.random() * 10000000);
		}
		
		long stratTime = System.currentTimeMillis();
		
		Arrays.sort(sortNums);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("选择排序总耗时：" + (endTime - stratTime) + "毫秒");//选择排序总耗时：1335毫秒

		/*
		//选择排序
		for(int i = 0; i < sortNums.length; i++) {
			//假设第一个为最小值
			int minNum = sortNums[0];
			int index = i;
			for(int j = i + 1; j < sortNums.length; j ++) {  //找出最小值下标
				if(minNum > sortNums[j])
				{
					//位置，数值进行交换
					minNum = sortNums[j];
					index = j;
				}
			}
			//数值交换
			int temp = sortNums[i];
			sortNums[i] = sortNums[index];
			sortNums[index] = temp;
		}
		
		long endTime = System.currentTimeMillis();
		
		//打印
		
		for (int i = 0; i < sortNums.length; i++) {
			System.out.print(sortNums[i] + "\t");
			if(i % 2 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		System.out.println("选择排序总耗时：" + (endTime - stratTime) + "毫秒");//选择排序总耗时：1335毫秒
	
	

		 * 冒泡排序
		long stratTime = System.currentTimeMillis();
		for(int i = 0; i < sortNums.length; i++) {
			for(int j = 0; j < sortNums.length - j; j++) {
				if(sortNums[j] < sortNums[j + 1])
				{
					int temp = sortNums[j];
					sortNums[j] = sortNums[j + 1];
					sortNums[j + 1] = temp;
				}
		
			}
		}
		long endTime = System.currentTimeMillis();

		for (int i = 0; i < sortNums.length; i++) {
			System.out.print(sortNums[i] + "\t");
			if(i % 15 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		System.out.println("冒泡排序总耗时：" + (endTime - stratTime) + "毫秒");//冒泡排序总耗时：7820毫秒
	*/
	}

	

}
