package test09;
/**
 * ���ڷ����ĸ��ǣ�
 * 1.��д�ķ���Ӧ�ñ���д�ķ������и��ߵķ���Ȩ��
 * 2.��̬��˽�еķ������ܽ�����д
 * */
public class test09 {
	public static void main(String[] argd) {
		//�����������
//		Animal a = new Animal();
//		a.Move();
//		
//		Dog d = new Dog();
//		d.Move();
//		
//		Cat c = new Cat();
//		//���÷���
//		c.Move();
//		
//		
//		//�������н׶ε��õ�Ϊ���е�cat����
//		Animal a2 = new Cat();     //����ת��
//		a2.Move();
//		
//		Cat c1 = (Cat)a2;          //ǿ������ת��
//		c1.Eat();
//		
//		/**
//		 * instanceof    ���ʱturn  ���ʾ����ָ�������ĳ�Ա
//		 * */
		
//		Animal a3 = new Dog();
//		if(a3 instanceof Cat) {
//			Cat c2 = (Cat)a3;
//		}
//		
		
		Person zhang = new Person();
		
		Cat a3 = new Cat();
		zhang.Feed(a3);
		
		Animal j = new Cat();      //��̬����ִ�в���Ҫ����
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
	
	//��Ա����
	public void Move() {
		System.out.println("Animal.Move()");
	}
	
	public void Eat() {
		System.out.println("Animal.Eat()");
	}
	
	//��̬����
	public static void m1() {
		System.out.println("Animal.m1()");
	}
}

class Cat extends Animal{
	public void Move() {        //�������串��
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
	public void Move() {        //�������串��
		System.out.println("Dog.Move()");
	}
	public void Eat() {
		System.out.println("Dog.Eat()");
	}
}








