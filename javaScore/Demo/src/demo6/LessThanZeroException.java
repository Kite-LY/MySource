package demo6;
/**
 * 自定义异常类  - 小于零时
 * @author 小风筝
 *
 */
public class LessThanZeroException extends Exception {
	
	private int value;
	
	public LessThanZeroException(){
		super();
	}
	public LessThanZeroException(int value)
	{
		super("输入的数字为：" + value + ",不能小于零" );
	}
}
