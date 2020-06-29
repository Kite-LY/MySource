package decorator;


/**
 * 使用装饰类的场合：
 * 1.在不影响其他对象的情况下，使用动态，透明的方法为对象添加方法
 * 2.不能使用继承时，想扩张方法
 * @author 小风筝
 *
 */
public class ComponentImplB extends Decorator {

	public ComponentImplB(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void read() {

		this.extendsReadA();
		super.read();
		this.extendsReadB();
	}
	
	public void extendsReadA() {
		System.out.println("ComponentImplB的扩展方法：extendsReadA!");
	}
	
	public void extendsReadB() {
		System.out.println("ComponentImplB的扩展方法:extendsReadB!");
	}
}
