package demo;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {

		
		
		//�ֶ���¼5λѧ���ĳɼ�
		Scanner input = new Scanner(System.in);
		final int N = 5;
		double sum1 = 0;
		double[] score = new double[N];
		for(int i = 0; i < score.length; i++)
		{
			System.out.print("������� " +(i + 1)+ " λѧ���ĳɼ���");
			score[i] = input.nextDouble();
		}
		System.out.println("-------------");
		//��ӡ
//		for(int i = 0; i < score.length; i++)
//		{
//			System.out.print("�� " +(i + 1)+ " λѧ���ĳɼ���");
//			System.out.println(score[i]);
//		}
		//�����ܳɼ�
		for(int i = 0; i < score.length; i++)
		{
			sum1 += score[i];
		}
		System.out.println("ѧ�����ܳɼ�Ϊ��" + sum1);
		
		
//		int[] nums = new int[5];			//������Ϊ����ռ���׵�ַ
//		System.out.println(nums);
//		
	}

}
