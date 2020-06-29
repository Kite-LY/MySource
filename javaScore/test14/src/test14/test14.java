package test14;


/**
 * hashcode���������ص�Ϊ��ϣ��ֵ
 * */
public class test14 {
	public static void main(String[] args) {
		test14 t = new test14();
		System.out.println(t.hashCode());   //118352462

		
	}
	
}

/*
 * ����Object��finalize����
 * 1.����Ҫ����Ա���ã�ϵͳ�Լ�����
 *

public class test14 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1 = null;
		System.gc();  //��������������
	
	}
	
}

class Person{
	public void finalize() throws Throwable{
		System.out.println(this + "�������������գ�");
	}
	
	//�������ٴ�ָ��ö�����ö�������������
	//Person p = this;
}

/*
 * ����java����αȽ������ַ����Ƿ�һ��
 * 1.java�Ƚ������ַ����Ƿ���ȣ�����ʹ��"=="
 * 

public class test14 {
	public static void main(String[] args) {
		 String s1 = new String();
		 String s2 = new String();
		 System.out.println(s1 == s2);
		 
		 
		 //String ��д��object��д��equals����
		 System.out.println(s1.equals(s2));
	}
}

/*

/**
 * ����Object��equals�ķ���
 * 1.�ж��������ڴ��ַ�ǲ�����ͬ��
 * 


public class test14 {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		
		boolean b1 = o1.equals(o2);
		System.out.println(b1);   //false
		
		Star s1 = new Star("����", 011);
		Star s2 = new Star("����", 011);
		System.out.println(s1.equals(s2));//false
	}
}

class Star{
	String name;
	int id;
	public Star(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof Star) {   //���obj��Starʱ�Ž����ж�
			Star s = (Star)obj;
			if(s.id == id && s.name == name) {
				return true;
			}
		}
		return false;
		
		
	}
	
	
}







/**
 * ����object���е�tostring�÷�
 * */
/*
public class test14 {
	public static void main(String[] args) {
		//����һ��object��
		Object o1 = new Object();
		
		//����tostring�÷�
		String oStr = o1.toString();
		System.out.println(oStr);
		
		Person p1 = new Person("����", 31);
		//����toString����
		String pStr = p1.toString();
		System.out.println(pStr);
		
		Person p2  = new Person("�ŷ�", 21);
		System.out.println(p2);
	}
}

class Person{
	String name;
	int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	//��дtoString����
	public String toString() {
		return "Person[name = "+name+", age = "+age+"]";
	}
	
	
}
*/






















