package decorator;

public class Decorator extends Component {
	
	
	private Component component;
	
	public Decorator(Component component) {
		
		this.component = component;
		
	}
	@Override
	public void read() {
		// TODO Auto-generated method stub
		//观察：谁真正的实现了read方法
		
		component.read();
	}

}
