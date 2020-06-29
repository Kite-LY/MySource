package Demo8;
/**
 * 初识泛型
 * @author 小风筝
 *
 */
public class ElementDemo<E> {
	
	Object[] obj = new Object[999];
	
	public static void main(String[] args) {
		//运行时给定数据类型
		ElementDemo<Integer>  demo = new ElementDemo<>();
		demo.add(12);			//使用泛型后，数据类型不匹配时，会产生错误
		
		 
		
	}
	
	/**
	 * 向对象数组中添加给定的类型的元素 — 泛型
	 * @param e
	 */
	public void add(E  e) {
		
	}

}
