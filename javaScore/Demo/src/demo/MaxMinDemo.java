package demo;

import java.util.Scanner;

/**
 * �������е����ֵ����Сֵ
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
		//��ӡ
		System.out.println("��ӡȫ��Ԫ�أ�");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
		/*
		System.out.println();
		//ȡ���ֵ
		int MaxNums = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > MaxNums)
			{
				MaxNums = nums[i];
			}
		}
		System.out.println("��������ֵΪ��" + MaxNums);
		*/
		System.out.print("������������ҵ�Ԫ�أ�");
		int searchNum = new Scanner(System.in).nextInt();
		int indexNum = -1;
		for (int i = 0; i < nums.length; i++) {		//ȷ��Ҫ����Ԫ�ص��±�   һ��ѭ������ֻ��һ����
			if(searchNum == nums[i])
			{
				indexNum = i;
				break;
			}
		}
		//ѭ������ж�
		if(indexNum == -1) {
			System.out.println("���ź���û�з�����Ҫ�ҵ�Ԫ�أ�");
		}else {
			System.out.println("�ҵ����ǵ�" +(indexNum+1)+"λ" + nums[indexNum]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
