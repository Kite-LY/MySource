package demo;

import java.util.Scanner;


public class Circle {
	//�뾶
	public double radius;
	//�ܳ�
	public double perimeter;
	//���
	public double area;
	
	public void inputRadius() {
		Scanner input = new Scanner(System.in);
	
		System.out.println("������Բ�İ뾶��");
		radius = input.nextDouble();
		if(radius == 0) {
			System.out.println("����������뾶:");
			inputRadius();			//�뾶Ϊ0��ʱ����������
		}
		input.close();
		input = null;
	}
	
	public void showPrimeter() {
	
		
		perimeter = 2 * Math.PI * radius;
		System.out.println("�뾶Ϊ" + radius + "Բ���ܳ�Ϊ��" +perimeter);
	}
	
	public void showArea() {
//		if(radius == 0) {
//			System.out.println("����������뾶:");
//			inputRadius();			//�뾶Ϊ0��ʱ����������
		//}
		area = Math.pow(radius, 2);
		System.out.println("�뾶Ϊ" + radius + "Բ�����Ϊ��" + area);
		
	}
}
