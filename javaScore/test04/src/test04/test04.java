package test04;



//this不能使用在静态变量中
public class test04 {
	public static void main(String[] args) {
		employee e = new employee( "KOBE", 9527);
		e.work();
		e.m2();
		
		System.out.println("-----------------------------");
		
		Manager m1 = new Manager("刘备");
		Manager m2 = new Manager();
		m2.setName("张飞");
		System.out.println(m1.getName());
		System.out.println(m2.getName());
	}
}

class employee{
	String ename;
	int ennum;
	
	employee() {
		// TODO Auto-generated constructor stub
	}
	employee(String _name, int _num)
	{
		ename = _name;
		ennum = _num; 
	}
	
	public void work() {
		System.out.println(this.ename + "在工作");         //this 表示当前对象
	}
	
	public void m1() {
		System.out.println("TESTING！");
	}
	
	public void m2() {
		this.m1();          //其中的this就是代表e
		m1();
	}
	
	
}
//this可以用于区别成员变量和局部变量

class  Manager{
	private String name;         //成员变量
	
	//constructor  构造方法
	Manager(){}
	Manager(String name){
		this.name = name;         //此时的this就区别成员变量和局部变量
	}
	
	//Method  成员方法
	 
	public void setName(String name) {
		this.name = name;
	}
	//成员方法
	public String getName() {
		//return name;
		return this.name;
	}
}













