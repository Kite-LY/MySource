package test13;

/**
 * interface�ӿ�
 * 1.�ӿ���ֻ�ܳ��ֳ��󷽷�������
 * 2.�ӿ���һ������ĳ����࣬����ȫ�����
 * 3.�ӿ���û�й��췽�������޷���ʵ����
 * 4.�ӿںͽӿ�֮����Զ�̳�
 * 5.һ�������ʵ�ֶ���ӿڣ�ʵ�ֿ��Կ����ɼ̳У�
 * 6.һ���ǳ�����ʵ�ֽӿڣ���Ҫ���ӿ��е����з��� ʵ��/��д/����
 * 
 * interface������
 * 1.��������Ŀ�ֲ㣬����˿���Ч��
 * 2.�ô���֮�����϶Ƚ���
 * */

public class test13 {
	
	public static void main(String[] args) {
//		CustomerService cs = new CustomerServiceImp();
//		cs.logout();
		Engine e = new Yamaha();
		Car c = new Car(e);
		
		c.testEngine();
		
		c.e = new Hoda();
		
		c.testEngine();
		
		
	}
	
	
}

interface Engine{
	void start();
}

class Yamaha implements Engine{
	public void start() {
		System.out.println("���������������");
	}


}

class Hoda implements Engine{
	public void start() {
		System.out.println("hoda����������");
	}	
}

class Car{
	Engine e;
	Car(Engine e){
		this.e = e;
	}
	public void testEngine() {
		e.start();
	}
}


/*
interface CustomerService{
	void logout();
}

//�ӿ�ʵ����
class CustomerServiceImp implements CustomerService{
	public void logout() {
		System.out.println("�����˳���");
	}
}



/*
public interface A{
	//��������ʹ��public static final ���Σ����ǿ���ʡ��
	
	public static final double PI = 3.14;
	String name = "����";
	
	//���󷽷�����ʹ��public abstract,���ǿ���ʡ��
	public abstract void m1();
	void m2(); 
}

interface B{
	void m3();
}

interface C{
	void m4();
	}

interface D{
	void m5();
}


//һ���ӿڿ��Լ̳ж���ӿ�
interface E extends B, C, D{
	
}

//implements��ʵ�ֵ���˼����һ���ؼ�����extends������ͬ

class F implements B, C, D{
	public void m3() {}
	public void m4() {}
	public void m5() {}
}

*/



























