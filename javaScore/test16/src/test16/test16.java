package test16;


/**
 * �ڲ��ࣺ
 * 1.��Ա�ڲ��ࣺ
 * 2.��̬�ڲ��ࣺ
 * 3.�ֲ��ڲ��ࣺ
 * 4.�����ڲ��ࣺ
 * */

/**
 * �ֲ��ڲ��ࣺ
 * 1.����ʹ�÷���Ȩ�����η�����
 * 2.�ص㣺���ʾֲ�����ʱ��i���ո�ֵ
 * */

public class test16 {
	public static void main(String[] args) {
		//����m1����
		oterClass o1 = new oterClass();
		o1.m1();
	}
}

class oterClass{
	public void m1() {
		final int i = 10;
		
		//�ֲ��ڲ��ࡣ
		class InnerClass{
			public void m2() {
				System.out.println(i);
			}
		}
	//��m1�������ȵ���
		InnerClass i1 = new InnerClass();
		i1.m2();
		
		
	}
}


/*
 * ��Ա�ڲ���
 * 1.���в����о�̬����
 * 


public class test16 {
	public static void main(String[] args) {
		//�ȴ����ⲿ��Ա
		Oterclass o1 = new Oterclass();
		
		InnerClass	i1 = o1.new InnerClass();
		i1.m3();
		i1.m4();
	}
}

class Oterclass{
	//��̬����
	private static String s1 = "A";
	//��Ա����
	private String s2 = "B";
	//��̬����
	private static void m1() {
		System.out.println("static.m1()");
	}
	//��Ա����
	private void m2() {
		System.out.println("��Ա.m2()");
	}
	class InnerClass{
		
		//��̬����
		public void m3() {
			System.out.println(s1);
		}
		
		//��Ա����
		public void m4() {
			System.out.println(s2);
		}
	}

}


/*
 * ���ھ�̬�ڲ���
 * 1.���Կ�����̬����
 * 2.���Է����ⲿ���˽�б���
 * 3.��̬�ڲ���ֻ�ܷ����ⲿ��̬�࣬����ֱ�ӷ��ʳ�Ա����
 * 
 * 
public class test16 {
	public static void main(String[] args) {
		//ִ��m3.���������������
		Oterclass.InnerClass.m3();
		//ִ��m4����Ա��������Ҫ��������
		InnerClass o1 = new Oterclass.InnerClass();
		o1.m4();
		o1.m3();
	}
}



class Oterclass{
	//��̬����
	private static String s1 = "A";
	//��Ա����
	private String s2 = "B";
	//��̬����
	private static void m1() {
		System.out.println("static.m1()");
	}
	//��Ա����
	private void m2() {
		System.out.println("��Ա.m2()");
	}
	static class InnerClass{
		
		//��̬����
		public static void m3() {
			System.out.println("test16.InnerClass.m3()");
		}
		
		//��Ա����
		public void m4() {
			System.out.println("test16.InnerClass.m4()");
		}
	}

}
*/