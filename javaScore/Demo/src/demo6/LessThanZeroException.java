package demo6;
/**
 * �Զ����쳣��  - С����ʱ
 * @author С����
 *
 */
public class LessThanZeroException extends Exception {
	
	private int value;
	
	public LessThanZeroException(){
		super();
	}
	public LessThanZeroException(int value)
	{
		super("���������Ϊ��" + value + ",����С����" );
	}
}
