package demo;

import java.util.Scanner;


public class Circle {
	//半径
	public double radius;
	//周长
	public double perimeter;
	//面积
	public double area;
	
	public void inputRadius() {
		Scanner input = new Scanner(System.in);
	
		System.out.println("请输入圆的半径：");
		radius = input.nextDouble();
		if(radius == 0) {
			System.out.println("请重新输入半径:");
			inputRadius();			//半径为0的时候重新输入
		}
		input.close();
		input = null;
	}
	
	public void showPrimeter() {
	
		
		perimeter = 2 * Math.PI * radius;
		System.out.println("半径为" + radius + "圆的周长为：" +perimeter);
	}
	
	public void showArea() {
//		if(radius == 0) {
//			System.out.println("请重新输入半径:");
//			inputRadius();			//半径为0的时候重新输入
		//}
		area = Math.pow(radius, 2);
		System.out.println("半径为" + radius + "圆的面积为：" + area);
		
	}
}
