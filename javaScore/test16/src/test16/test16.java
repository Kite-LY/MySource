package test16;


/**
 * 内部类：
 * 1.成员内部类：
 * 2.静态内部类：
 * 3.局部内部类：
 * 4.匿名内部类：
 * */

/**
 * 局部内部类：
 * 1.不能使用访问权限修饰符修饰
 * 2.重点：访问局部变量时，i最终赋值
 * */

public class test16 {
	public static void main(String[] args) {
		//调用m1方法
		oterClass o1 = new oterClass();
		o1.m1();
	}
}

class oterClass{
	public void m1() {
		final int i = 10;
		
		//局部内部类。
		class InnerClass{
			public void m2() {
				System.out.println(i);
			}
		}
	//在m1方法中先调用
		InnerClass i1 = new InnerClass();
		i1.m2();
		
		
	}
}


/*
 * 成员内部类
 * 1.其中不能有静态方法
 * 


public class test16 {
	public static void main(String[] args) {
		//先创建外部成员
		Oterclass o1 = new Oterclass();
		
		InnerClass	i1 = o1.new InnerClass();
		i1.m3();
		i1.m4();
	}
}

class Oterclass{
	//静态变量
	private static String s1 = "A";
	//成员变量
	private String s2 = "B";
	//静态方法
	private static void m1() {
		System.out.println("static.m1()");
	}
	//成员方法
	private void m2() {
		System.out.println("成员.m2()");
	}
	class InnerClass{
		
		//静态方法
		public void m3() {
			System.out.println(s1);
		}
		
		//成员方法
		public void m4() {
			System.out.println(s2);
		}
	}

}


/*
 * 关于静态内部类
 * 1.可以看作静态变量
 * 2.可以访问外部类的私有变量
 * 3.静态内部类只能访问外部静态类，不能直接访问成员方法
 * 
 * 
public class test16 {
	public static void main(String[] args) {
		//执行m3.可以用类名点调用
		Oterclass.InnerClass.m3();
		//执行m4，成员方法，需要创建对象
		InnerClass o1 = new Oterclass.InnerClass();
		o1.m4();
		o1.m3();
	}
}



class Oterclass{
	//静态变量
	private static String s1 = "A";
	//成员变量
	private String s2 = "B";
	//静态方法
	private static void m1() {
		System.out.println("static.m1()");
	}
	//成员方法
	private void m2() {
		System.out.println("成员.m2()");
	}
	static class InnerClass{
		
		//静态方法
		public static void m3() {
			System.out.println("test16.InnerClass.m3()");
		}
		
		//成员方法
		public void m4() {
			System.out.println("test16.InnerClass.m4()");
		}
	}

}
*/