package demo4;

public class Dancer extends Actor {

	public Dancer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dancer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performs() {
		
		System.out.println("�赸��Ա" + getName() + "���ڱ������裡");
		
	}
}
