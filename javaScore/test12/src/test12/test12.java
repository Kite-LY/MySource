package test12;
/**
 * 1.final修饰的类无法被继承
 * 2.final修饰的方法无法被覆盖
 * 3.final修饰的成员变量一旦被赋值，就无法进行更改
 * 4.抽象类不能被final修饰
 * */
public class test12 {
	public static void main(String[] args) {
		//抽象类无法创建对象
		//A a = new A();
		A a = new B();
		
	}
}


abstract class A{
	
	
	public abstract void m1();
	A(){
		System.out.println("A--------");
	}
}

class B extends A{
	public void m1() {
		
	}
	
	B(){
		super();		//父类的构造方法虽然被调用了，但是没有创建对象
		System.out.println("B--------");
	}
}


/*  final 修饰的类无法被继承
final class a{
	
}

class b extends a {
	
}
*/
/*final 修饰的方法无法被覆盖
class a{
	public final void m1() {
		
	}
}

class b extends a{
	public void m1() {}
}
*/

//class a{	
//		//final 定义成员变量进行赋值,final一般与static连用
//		public  static final int a = 10;
//		//a = 21;
//	
//}


/**
 * 1.abstract: 抽象类无法被实例化，但是也可以有构造方法 ，该构造方法是给子类创建对象用的
 * */













