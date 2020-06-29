package test02;

public class test02 {
	public static void m1(Animal a)
	{
		a.age++;
		System.out.println("m1---->" + a.age);
	}
	
	//Èë¿Ú
	public static void main(String [] args)
	{
		Animal a = new Animal(10);
		m1(a);
		System.out.println("main---->" + a.age);
	}
}



class Animal{
	int age;
	public Animal(int _age) {
		age = _age;
	}
}
