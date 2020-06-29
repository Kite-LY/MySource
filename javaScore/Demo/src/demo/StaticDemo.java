package demo;

public class StaticDemo {
	
	private static StaticDemo me = null;
	private StaticDemo() {
		
		//将构造方法私有化
		me = this;
	}
	/**
	 * 得到当前实例
	 * @return
	 */
	public static StaticDemo getInstance() {
		if(me == null) {
			me = new StaticDemo();			//唯一的一次实例化  私有方法只能在本例子中调用
		}
		return me;
	}
	
	
	//类属性
	//静态属性是先于类的实例存在的
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
