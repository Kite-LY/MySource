package Chapter5Demo;
/**
 * 5.7.1��ʼ������˳��
 * @author С����
 *
 */
import static net.mindview.util.Print.*;



public class OrderOfInitialtion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House h = new House();
		h.f();
	
	}	

}


class Wundow{
	public Wundow(int marker) {
		print("Window(" + marker + ")");
		
	}
}

class House{
	
	Wundow w1 = new Wundow(1);
	public House() {
		//show that we're in the constructor
		print("House()");
		w3 = new Wundow(33);
	}
	
	Wundow w2 = new Wundow(2);
	void f() {						//���ִ��
		print("void f()");
	}
	Wundow w3 = new Wundow(3);
	
}