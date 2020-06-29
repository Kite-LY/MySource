package demo4;
/**
 *演员类
 */
public abstract class Actor {			//创建的为抽象类，不能使用new 来实例化对象
	private String name;
	
	public Actor() {}
	public Actor(String name) {
		setName(name);
	}
	
	/**
	 *演员的表演方法
	 */
	public void performs() {
		System.out.println("演员" + getName() + "正在表演");
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
