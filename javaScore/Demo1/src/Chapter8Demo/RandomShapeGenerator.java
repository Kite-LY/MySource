package Chapter8Demo;

import java.util.Random;

public class RandomShapeGenerator {
	private Random rand = new Random(47);
	public Shape next() {
		switch(rand.nextInt(3)) {
		default:
		case 0: return new Circle();				//发生向上转型的位置
		case 1: return new Triangle();
		case 2: return new Square();
		}
		
	}
	
}
