package decorator;


/**
 * ʹ��װ����ĳ��ϣ�
 * 1.�ڲ�Ӱ���������������£�ʹ�ö�̬��͸���ķ���Ϊ������ӷ���
 * 2.����ʹ�ü̳�ʱ�������ŷ���
 * @author С����
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
		System.out.println("ComponentImplB����չ������extendsReadA!");
	}
	
	public void extendsReadB() {
		System.out.println("ComponentImplB����չ����:extendsReadB!");
	}
}
