package demo;

public class StringBufferDemo {

	public static void main(String[] args) {
		
		StringBuffer str1 = new StringBuffer("��ã����磡");
		
		//str1.reverse();   //������������     ���ַ�����ת
		str1.insert(3, "����-");

		System.out.println(str1);
		str1.deleteCharAt(3);
		System.out.println(str1);
		str1.delete(2, 4);    //ɾͷ�Ĳ�ɾβ
		System.out.println(str1);
		str1.setCharAt(2, '��');
		System.out.println(str1);
		
		System.out.println("�����С��" + str1.capacity());
		
		str1.setLength(0);   //�ȼ�������ַ���
		
		
		
		
		
		
		
		
		
		
		
		
//		final int N = 100000;
//		
//		//+= ƴ���ַ���
//		long stratTime = System.currentTimeMillis();
//
//		String str = "*";
//		for (int i = 0; i < N; i++) {
//			str += "*";
//		}
//
	//long endTime = System.currentTimeMillis();
//		System.out.println("Str += ����Ҫ��ʱ�䣺" + (endTime - stratTime) + "����");

		//StringBufferƴ���ַ���
//		stratTime = System.currentTimeMillis();
//		
//		StringBuffer str1 = new StringBuffer("*");
//		for (int i = 0; i < N; i++) {
//			str1.append("*");
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println("StringBuffer��append ����Ҫ��ʱ�䣺" + (endTime - stratTime) + "����");
//		
//		//StringBuilderƴ���ַ���
//		stratTime = System.currentTimeMillis();
//		
//		StringBuilder str2 = new StringBuilder("*");
//		for (int i = 0; i < N; i++) {
//			str2.append("*");
//		}
//		endTime = System.currentTimeMillis();
//		System.out.println("StringBuilder ����Ҫ��ʱ�䣺" + (endTime - stratTime) + "����");
		
		
		
		
		
		
//		String str1 = "a";
//		String str2 = "b";
//		String str3 = str1 + str2;
//		
//		//�ײ�ԭ��
//		String str4 =  new StringBuffer(String.valueOf(str1)).append(str2).toString();   //append�ȼ���׷��ƴ�ӵ���˼
//		
//		System.out.println(str4);
	} 

}
