package demo6;
/**
 * �쳣�������
 * �����������ֵ���
 * @author С����
 *
 */
public class Division {

	public static int division(int num1, int num2) {
		int reslt = Integer.MIN_VALUE;
		System.out.println("�������ǰ��");
		try {
			reslt = num1 /num2;
		} catch (Exception e) {
			System.err.println("�쳣��" + e.getLocalizedMessage() );			//errΪ��׼���������  outΪ��׼����� ��ӡʱֻ����ɫ����
			//��־����
			
		}
		System.out.println("���������");
		return reslt;
	}
	
	
	public static void main(String[] args) {
		int result = division(5, 0);
		System.out.println( "result =" + result);
		
	}

}
