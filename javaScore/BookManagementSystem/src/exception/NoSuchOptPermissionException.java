package exception;
/**
 * �Զ����쳣�� �˲���Ϊû��Ȩ���쳣
 * @author С����
 *
 */


public class NoSuchOptPermissionException extends RuntimeException{


	
	private static final long serialVersionUID = 8432854948066583587L;


	public NoSuchOptPermissionException() {
		super();
		System.err.println("�˲���û��Ȩ���쳣��");
	}
	public NoSuchOptPermissionException(String message) {
		super(message);
	}

}
