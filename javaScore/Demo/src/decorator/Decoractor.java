package decorator;

public class Decoractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����Ҫ��װ�ε�ԭʼ����
		Component component = new TrueComponent();
		//Ϊԭʼ�������ӹ���
		ComponentImplA componentA = new ComponentImplA(component);
		//componentA.read();
		
		ComponentImplB componentB = new ComponentImplB(componentA);
		componentB.read();
	}

}
