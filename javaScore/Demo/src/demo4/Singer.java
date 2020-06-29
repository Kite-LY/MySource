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
		
		System.out.println("歌手演员" + getName() + "正在表演唱歌！");
		 
	}
}
