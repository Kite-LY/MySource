package test09;
/**
 * 关于方法的覆盖：
 * 1.重写的方法应该比重写的方法具有更高的访问权限
 * 2.静态。私有的方法不能进行重写
 * */
public class test09 {
	public static void main(String[] argd) {
		//创建子类对象
//		Animal a = new Animal();
//		a.Move();
//		
//		Dog d = new Dog();
//		d.Move();
//		
//		Cat c = new Cat();
//		//调用方法
//		c.Move();
//		
//		
//		//程序运行阶段调用的为堆中的cat类容
//		Animal a2 = new Cat();     //向上转型
//		a2.Move();
//		
//		Cat c1 = (Cat)a2;          //强制类型转换
//		c1.Eat();
//		
//		/**
//		 * instanceof    结果时turn  则表示对象指向的是类的成员
//		 * */
		
//		Animal a3 = new Dog();
//		if(a3 instanceof Cat) {
//			Cat c2 = (Cat)a3;
//		}
//		
		
		Person zhang = new Person();
		
		Cat a3 = new Cat();
		zhang.Feed(a3);
		
		Animal j = new Cat();      //静态方法执行不需要对象
		j.m1();
		
		Animal.m1();
		Cat.m1(); 
	}
}

class Person{
	public void Feed(Animal d) {
		d.Eat();
	}

}

class Animal{
	
	//成员方法
	public void Move() {
		System.out.println("Animal.Move()");
	}
	
	public void Eat() {
		System.out.println("Animal.Eat()");
	}
	
	//静态方法
	public static void m1() {
		System.out.println("Animal.m1()");
	}
}

class Cat extends Animal{
	public void Move() {        //方法耳朵覆盖
		System.out.println("Cat.Move()");
	}
	
	public void Eat() {
		System.out.println("Cat.Eat()");
	}
	
	public static void m1() {
		System.out.println("Cat.m1()");
	}
	
}


class Dog extends Animal{
	public void Move() {        //方法耳朵覆盖
		System.out.println("Dog.Move()");
	}
	public void Eat() {
		System.out.println("Dog.Eat()");
	}
}








