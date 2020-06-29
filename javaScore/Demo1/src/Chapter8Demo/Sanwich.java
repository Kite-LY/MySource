package Chapter8Demo;

class Meal{
	public Meal() {
		System.out.println("Meal()");
	
	}
}

class Bread{
	public Bread() {
		System.out.println("Bread()");
	}
}

class Cheese{	
	public Cheese() {
		System.out.println("Cheese()");
	}
}

class Lettuce{
		public Lettuce() {
			System.out.println("Lettuce");
		}
}

class Lunch extends Meal{
	public Lunch() {
		System.out.println("Lunch()");
		// TODO Auto-generated constructor stub
	}
}

class Portablelunch extends Lunch{
	Portablelunch(){
		System.out.println("Portablelunch()");
	}
}


public class Sanwich extends Portablelunch {

	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	public  Sanwich() {
		System.out.println("Sandwich()");
	}
	
	public static void main(String[] args) {
		new Sanwich();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
