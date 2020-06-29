package exception;
/**
 * 自定义异常： 此操作为没有权限异常
 * @author 小风筝
 *
 */


public class NoSuchOptPermissionException extends RuntimeException{


	
	private static final long serialVersionUID = 8432854948066583587L;


	public NoSuchOptPermissionException() {
		super();
		System.err.println("此操作没有权限异常！");
	}
	public NoSuchOptPermissionException(String message) {
		super(message);
	}

}
