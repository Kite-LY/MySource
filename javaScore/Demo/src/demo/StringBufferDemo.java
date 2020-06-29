package demo;

public class StringBufferDemo {

	public static void main(String[] args) {
		
		StringBuffer str1 = new StringBuffer("你好，世界！");
		
		//str1.reverse();   //！界世，好你     让字符串反转
		str1.insert(3, "安徽-");

		System.out.println(str1);
		str1.deleteCharAt(3);
		System.out.println(str1);
		str1.delete(2, 4);    //删头的不删尾
		System.out.println(str1);
		str1.setCharAt(2, '哈');
		System.out.println(str1);
		
		System.out.println("缓存大小：" + str1.capacity());
		
		str1.setLength(0);   //等价于清空字符串
		
		
		
		
		
		
		
		
		
		
		
		
//		final int N = 100000;
//		
//		//+= 拼接字符串
//		long stratTime = System.currentTimeMillis();
//
//		String str = "*";
//		for (int i = 0; i < N; i++) {
//			str += "*";
//		}
//
	//long endTime = System.currentTimeMillis();
//		System.out.println("Str += 所需要的时间：" + (endTime - stratTime) + "毫秒");

		//StringBuffer拼接字符串
//		stratTime = System.currentTimeMillis();
//		
//		StringBuffer str1 = new StringBuffer("*");
//		for (int i = 0; i < N; i++) {
//			str1.append("*");
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println("StringBuffer的append 所需要的时间：" + (endTime - stratTime) + "毫秒");
//		
//		//StringBuilder拼接字符串
//		stratTime = System.currentTimeMillis();
//		
//		StringBuilder str2 = new StringBuilder("*");
//		for (int i = 0; i < N; i++) {
//			str2.append("*");
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println("StringBuilder 所需要的时间：" + (endTime - stratTime) + "毫秒");
		
		
		
		
		
		
//		String str1 = "a";
//		String str2 = "b";
//		String str3 = str1 + str2;
//		
//		//底层原理
//		String str4 =  new StringBuffer(String.valueOf(str1)).append(str2).toString();   //append等价于追加拼接的意思
//		
//		System.out.println(str4);
	} 

}
