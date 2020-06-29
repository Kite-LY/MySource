package demo;

import java.util.Scanner;

/**
 * 求数组中的最大值，最小值
 * 
 * */
public class MaxMinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[10];
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = (int)((Math.random() * 10000) % 100);
		}
		//打印
		System.out.println("打印全部元素：");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
		/*
		System.out.println();
		//取最大值
		int MaxNums = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > MaxNums)
			{
				MaxNums = nums[i];
			}
		}
		System.out.println("数组的最大值为：" + MaxNums);
		*/
		System.out.print("请输入你想查找的元素：");
		int searchNum = new Scanner(System.in).nextInt();
		int indexNum = -1;
		for (int i = 0; i < nums.length; i++) {		//确定要查找元素的下标   一个循环里面只做一件事
			if(searchNum == nums[i])
			{
				indexNum = i;
				break;
			}
		}
		//循环后的判断
		if(indexNum == -1) {
			System.out.println("很遗憾，没有发现你要找的元素！");
		}else {
			System.out.println("找到了是第" +(indexNum+1)+"位" + nums[indexNum]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
