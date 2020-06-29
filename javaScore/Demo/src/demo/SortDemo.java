package demo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ð������
 * 
 * */
public class SortDemo {

	public static void main(String[] args) {
		//�������� 
		final int N = 10000000;
		int[] sortNums = new int[N];
		for (int i = 0; i < sortNums.length; i++) {
			sortNums[i] = (int)(Math.random() * 10000000);
		}
		
		long stratTime = System.currentTimeMillis();
		
		Arrays.sort(sortNums);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("ѡ�������ܺ�ʱ��" + (endTime - stratTime) + "����");//ѡ�������ܺ�ʱ��1335����

		/*
		//ѡ������
		for(int i = 0; i < sortNums.length; i++) {
			//�����һ��Ϊ��Сֵ
			int minNum = sortNums[0];
			int index = i;
			for(int j = i + 1; j < sortNums.length; j ++) {  //�ҳ���Сֵ�±�
				if(minNum > sortNums[j])
				{
					//λ�ã���ֵ���н���
					minNum = sortNums[j];
					index = j;
				}
			}
			//��ֵ����
			int temp = sortNums[i];
			sortNums[i] = sortNums[index];
			sortNums[index] = temp;
		}
		
		long endTime = System.currentTimeMillis();
		
		//��ӡ
		
		for (int i = 0; i < sortNums.length; i++) {
			System.out.print(sortNums[i] + "\t");
			if(i % 2 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		System.out.println("ѡ�������ܺ�ʱ��" + (endTime - stratTime) + "����");//ѡ�������ܺ�ʱ��1335����
	
	

		 * ð������
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
		
		System.out.println("ð�������ܺ�ʱ��" + (endTime - stratTime) + "����");//ð�������ܺ�ʱ��7820����
	*/
	}

	

}
