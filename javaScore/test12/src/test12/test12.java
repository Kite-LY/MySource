package test12;
/**
 * 1.final���ε����޷����̳�
 * 2.final���εķ����޷�������
 * 3.final���εĳ�Ա����һ������ֵ�����޷����и���
 * 4.�����಻�ܱ�final����
 * */
public class test12 {
	public static void main(String[] args) {
		//�������޷���������
		//A a = new A();
		A a = new B();
		
	}
}


abstract class A{
	
	
	public abstract void m1();
	A(){
		System.out.println("A--------");
	}
}

class B extends A{
	public void m1() {
		
	}
	
	B(){
		super();		//����Ĺ��췽����Ȼ�������ˣ�����û�д�������
		System.out.println("B--------");
	}
}


/*  final ���ε����޷����̳�
final class a{
	
}

class b extends a {
	
}
*/
/*final ���εķ����޷�������
class a{
	public final void m1() {
		
	}
}

class b extends a{
	public void m1() {}
}
*/

//class a{	
//		//final �����Ա�������и�ֵ,finalһ����static����
//		public  static final int a = 10;
//		//a = 21;
//	
//}


/**
 * 1.abstract: �������޷���ʵ����������Ҳ�����й��췽�� ���ù��췽���Ǹ����ഴ�������õ�
 * */













