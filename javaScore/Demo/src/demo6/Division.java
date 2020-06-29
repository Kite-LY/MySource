package demo6;
/**
 * 异常处理机制
 * 计算两个数字的商
 * @author 小风筝
 *
 */
public class Division {

	public static int division(int num1, int num2) {
		int reslt = Integer.MIN_VALUE;
		System.out.println("计算除法前！");
		try {
			reslt = num1 /num2;
		} catch (Exception e) {
			System.err.println("异常：" + e.getLocalizedMessage() );			//err为标准错误输出流  out为标准输出流 打印时只有颜色区别
			//日志处理
			
		}
		System.out.println("计算除法后！");
		return reslt;
	}
	
	
	public static void main(String[] args) {
		int result = division(5, 0);
		System.out.println( "result =" + result);
		
	}

}
