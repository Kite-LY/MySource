package demo;

import java.util.Scanner;

/**
 * ���ֲ��ң�ǰ��������ǰ����
 * 
 * 
 * */
public class BinarySerchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
		System.out.print("��������Ҫ���ҵ����֣�");
		int searchNum = input.nextInt();
		//��ͨ����
		for(int i = 0; i < array.length; i++) {
			if(searchNum == array[i]) {
				System.out.println("��ϲ���ҵ��ˣ�λ���ǣ�" + i);
				break;
			}else {
				System.out.println("û���ҵ�");
				break;
			}
		}
		
		
		//���ֲ���
		int indexDelete = -1;
		int high = array.length - 1;		//�����Ͻ�
		int low = 0;						//�����½�
		while(high >= low) {
			int mid = (high + low) / 2;		//�����м�λ��
			if(searchNum < array[mid]) {	//����ֵС���м�ֵʱ
				high = mid - 1;
			}else if(searchNum > array[mid]) {
				low = mid + 1;
			}else {
				System.out.println("��ϲ���ҵ��ˣ�λ���ǣ�" + mid);
				indexDelete = mid;
				break;
			}
			indexDelete = mid;
		}
		if( low > high) {
			System.out.println("û����Ҫ���ҵ����֣�");
		}
		System.out.println(indexDelete);
		//ɾ���㷨
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
