package demo4;

public class Singer extends Actor {

	public Singer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Singer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void performs() {
		
		System.out.println("������Ա" + getName() + "���ڱ��ݳ��裡");
		 
	}
}
