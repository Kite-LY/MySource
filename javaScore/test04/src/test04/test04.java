package test04;



//this����ʹ���ھ�̬������
public class test04 {
	public static void main(String[] args) {
		employee e = new employee( "KOBE", 9527);
		e.work();
		e.m2();
		
		System.out.println("-----------------------------");
		
		Manager m1 = new Manager("����");
		Manager m2 = new Manager();
		m2.setName("�ŷ�");
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
		System.out.println(this.ename + "�ڹ���");         //this ��ʾ��ǰ����
	}
	
	public void m1() {
		System.out.println("TESTING��");
	}
	
	public void m2() {
		this.m1();          //���е�this���Ǵ���e
		m1();
	}
	
	
}
//this�������������Ա�����;ֲ�����

class  Manager{
	private String name;         //��Ա����
	
	//constructor  ���췽��
	Manager(){}
	Manager(String name){
		this.name = name;         //��ʱ��this�������Ա�����;ֲ�����
	}
	
	//Method  ��Ա����
	 
	public void setName(String name) {
		this.name = name;
	}
	//��Ա����
	public String getName() {
		//return name;
		return this.name;
	}
}













