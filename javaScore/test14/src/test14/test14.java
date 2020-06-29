package test14;


/**
 * hashcode方法，返回的为哈希码值
 * */
public class test14 {
	public static void main(String[] args) {
		test14 t = new test14();
		System.out.println(t.hashCode());   //118352462

		
	}
	
}

/*
 * 关于Object中finalize方法
 * 1.不需要程序员调用，系统自己调用
 *

public class test14 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1 = null;
		System.gc();  //运行垃圾回收器
	
	}
	
}

class Person{
	public void finalize() throws Throwable{
		System.out.println(this + "垃圾回收器回收！");
	}
	
	//让引用再次指向该对象，则该对象不是垃圾数据
	//Person p = this;
}

/*
 * 关于java中如何比较两个字符串是否一致
 * 1.java比较两个字符串是否相等，不能使用"=="
 * 

public class test14 {
	public static void main(String[] args) {
		 String s1 = new String();
		 String s2 = new String();
		 System.out.println(s1 == s2);
		 
		 
		 //String 重写了object重写了equals方法
		 System.out.println(s1.equals(s2));
	}
}

/*

/**
 * 关于Object中equals的方法
 * 1.判断两个的内存地址是不是相同的
 * 


public class test14 {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		
		boolean b1 = o1.equals(o2);
		System.out.println(b1);   //false
		
		Star s1 = new Star("刘备", 011);
		Star s2 = new Star("刘备", 011);
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
		if(obj instanceof Star) {   //如果obj是Star时才进行判断
			Star s = (Star)obj;
			if(s.id == id && s.name == name) {
				return true;
			}
		}
		return false;
		
		
	}
	
	
}







/**
 * 关于object类中的tostring用法
 * */
/*
public class test14 {
	public static void main(String[] args) {
		//创建一个object类
		Object o1 = new Object();
		
		//调用tostring用法
		String oStr = o1.toString();
		System.out.println(oStr);
		
		Person p1 = new Person("刘备", 31);
		//调用toString方法
		String pStr = p1.toString();
		System.out.println(pStr);
		
		Person p2  = new Person("张飞", 21);
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
	//重写toString方法
	public String toString() {
		return "Person[name = "+name+", age = "+age+"]";
	}
	
	
}
*/






















