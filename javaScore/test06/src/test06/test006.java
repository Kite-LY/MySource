package test06;


//ʵ�ֵ���ģʽ
public class test006 {
	private static test006 s = null;
	test006(){}
	public static test006 getInstance (){
		if(s == null) {
			s = new test006();
		}
		return s;
	}
	
}
