package demo;
/**
 * ʾ��finalize()���ܵ�ʹ�÷���
 * @author С����
 *
 */


public class TerminationCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book novel = new Book(true);
		novel.checkIn();
		new Book(true);
		System.gc();
		
	}

}


class Book{
	boolean checkOut = false;
	Book(boolean checkOut){
		this.checkOut = checkOut;
	}
	
	void checkIn() {
		this.checkOut = false;
	}
	
	protected void finalize() {
		if(checkOut) {
			System.out.println("Error:checked out ");
		}
	}
}