package test01;

public class test01 {
	//属性
	
	//学号
	int id;
	//姓名
	private String name;
	
	//赋值
	public void setName(String _name) {
		name =_name;
	}
	//读取
	public String getName() {
		return name;
	}
	//性别
	boolean sex;
	//年龄
	int age;
	//赋值
	public	void setAge(int _age) {
		if(_age < 0 || _age > 100)
		{
			System.out.println("您输入的年龄不合法！");
		}
		age = _age;
	}
	//读取
	public int getAge() {
		return age;
	}
	
	
	//住址
	String addr;
	//方法
	
	
	
	
}
