package decorator;
/**
 * װ�ε�ʵ���ࣺ������չ����
 * @author С����
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
		System.out.println("ComponentImplA����չ������extendsReadA!");
	}
	
	public void extendsReadB() {
		System.out.println("ComponentImplA����չ����:extendsReadB!");
	}
	
}
