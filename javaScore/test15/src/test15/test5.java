package test15;
/**
 * ���ڷ���Ȩ�����η������η����������࣬���α���
 * private:ֻ���ڱ����з���
 * public���������κ�λ�÷���
 * protected:�����У�ͬһ��������ͬ���²��е��������������
 * default:�����У�ͬһ��������ͬ���²���
 * 
 * */



public class test5 {  //��ֻ����public ��ȱʡ��ʽ
	
	public static void main(String[] args) {
		User u = new User();
		System.out.println(u.age);
		System.out.println(u.name);
	}
	
	
}

class User{
	
	protected String name;
	//ȱʡ
	int age;
	
}


