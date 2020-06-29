package test15;
/**
 * 关于访问权限修饰符：修饰方法，修饰类，修饰变量
 * private:只能在本类中访问
 * public：可以在任何位置访问
 * protected:本类中，同一个包，不同包下不行但是子类下面可以
 * default:本类中，同一个包，不同包下不行
 * 
 * */



public class test5 {  //类只能用public 和缺省方式
	
	public static void main(String[] args) {
		User u = new User();
		System.out.println(u.age);
		System.out.println(u.name);
	}
	
	
}

class User{
	
	protected String name;
	//缺省
	int age;
	
}


