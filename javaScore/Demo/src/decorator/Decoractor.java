package decorator;

public class Decoractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建要被装饰的原始对象
		Component component = new TrueComponent();
		//为原始对象怎加功能
		ComponentImplA componentA = new ComponentImplA(component);
		//componentA.read();
		
		ComponentImplB componentB = new ComponentImplB(componentA);
		componentB.read();
	}

}
