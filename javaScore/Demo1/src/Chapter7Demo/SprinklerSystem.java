package Chapter7Demo;

public class SprinklerSystem {
	
	private String valve1, valve2, valve3, valve4;
	private WaterSource source  = new WaterSource();
	private int i;
	private float f;
	public String toString() {
		return
				"valve1 = " + valve1 + " " +
				"valve2 = " + valve1 + " " +
				"valve3 = " + valve1 + " " +
				"valve4 = " + valve1 + " \n " +
				" i = " + i + " " + "f = " + f + " " +
						 "source = " + source;
	}
	
	
	public static void main(String[] args) {
		
		SprinklerSystem sprinklers = new SprinklerSystem();
		System.out.println(sprinklers);
		
	}

}


class WaterSource{
	private String s = "1";
	public WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	
	}
	public String toString() {
		return s;
	}
}