package decorator;

public class Decorator extends Component {
	
	
	private Component component;
	
	public Decorator(Component component) {
		
		this.component = component;
		
	}
	@Override
	public void read() {
		// TODO Auto-generated method stub
		//�۲죺˭������ʵ����read����
		
		component.read();
	}

}
