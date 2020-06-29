package demo;

public class StaticDemo {
	
	private static StaticDemo me = null;
	private StaticDemo() {
		
		//�����췽��˽�л�
		me = this;
	}
	/**
	 * �õ���ǰʵ��
	 * @return
	 */
	public static StaticDemo getInstance() {
		if(me == null) {
			me = new StaticDemo();			//Ψһ��һ��ʵ����  ˽�з���ֻ���ڱ������е���
		}
		return me;
	}
	
	
	//������
	//��̬�������������ʵ�����ڵ�
	public static int static_number = 1;
	
	public int normal_number = 1;
	
	public void test() {
		static_number++;
		normal_number++;
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		StaticDemo n = new StaticDemo();
//		n.test();
//		System.out.println(static_number);
//		System.out.println(n.normal_number);
//		
//		
//		StaticDemo n1 = new StaticDemo();
//		n.test();
//		System.out.println(static_number);
//		System.out.println(n1.normal_number);
//		
////		StaticDemo n2 = new StaticDemo();
////		n.test();
////		System.out.println(n.static_number);
////		System.out.println(n.normal_number);
//	}

}
