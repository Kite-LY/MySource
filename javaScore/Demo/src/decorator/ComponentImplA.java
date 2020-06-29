package decorator;
/**
 * 装饰的实现类：用类扩展方法
 * @author 小风筝
 *
 */
public class ComponentImplA extends Decorator{

	public ComponentImplA(Component component) {
		
		super(component);
	}
	
	@Override
	public void read() {

		this.extendsReadA();
		super.read();
		this.extendsReadB();
	}
	
	public void extendsReadA() {
		System.out.println("ComponentImplA的扩展方法：extendsReadA!");
	}
	
	public void extendsReadB() {
		System.out.println("ComponentImplA的扩展方法:extendsReadB!");
	}
	
}
