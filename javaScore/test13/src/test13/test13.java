package test13;

/**
 * interface接口
 * 1.接口中只能出现抽象方法，常量
 * 2.接口是一个特殊的抽象类，是完全抽象的
 * 3.接口中没有构造方法，则无法被实例化
 * 4.接口和接口之间可以多继承
 * 5.一个类可以实现多个接口（实现可以看做成继承）
 * 6.一个非抽象类实现接口，需要将接口中的所有方法 实现/重写/覆盖
 * 
 * interface的作用
 * 1.可以让项目分层，提高了开发效率
 * 2.让代码之间的耦合度降低
 * */

public class test13 {
	
	public static void main(String[] args) {
//		CustomerService cs = new CustomerServiceImp();
//		cs.logout();
		Engine e = new Yamaha();
		Car c = new Car(e);
		
		c.testEngine();
		
		c.e = new Hoda();
		
		c.testEngine();
		
		
	}
	
	
}

interface Engine{
	void start();
}

class Yamaha implements Engine{
	public void start() {
		System.out.println("雅马哈汽车启动！");
	}


}

class Hoda implements Engine{
	public void start() {
		System.out.println("hoda汽车启动！");
	}	
}

class Car{
	Engine e;
	Car(Engine e){
		this.e = e;
	}
	public void testEngine() {
		e.start();
	}
}


/*
interface CustomerService{
	void logout();
}

//接口实现类
class CustomerServiceImp implements CustomerService{
	public void logout() {
		System.out.println("程序退出！");
	}
}



/*
public interface A{
	//常量必须使用public static final 修饰，但是可以省略
	
	public static final double PI = 3.14;
	String name = "刘备";
	
	//抽象方法必须使用public abstract,但是可以省略
	public abstract void m1();
	void m2(); 
}

interface B{
	void m3();
}

interface C{
	void m4();
	}

interface D{
	void m5();
}


//一个接口可以继承多个接口
interface E extends B, C, D{
	
}

//implements是实现的意思，是一个关键字与extends意义相同

class F implements B, C, D{
	public void m3() {}
	public void m4() {}
	public void m5() {}
}

*/



























