package Chapter8Demo;

class Characteristic{
	private String s;
	public Characteristic(String s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		
		System.out.println("Create Characteristic");
	}
	protected void dispose() {
		System.out.println("disposing Charcteristic");
	}
	
}

class Description{
	private String s;
	public Description(String s) {
		// TODO Auto-generated constructor stub
		System.out.println("Creating Description" + s);
	}
	
	protected void dispose() {
		System.out.println("dispose Description" + s);
	}
	
}

class LivingCreature{
	private Characteristic p = new Characteristic("is alive");
	private Description t = new Description("Basic Living Creature");
	public LivingCreature() {
		// TODO Auto-generated constructor stub
		System.out.println("LivingCreaturn()");
		
	}
	protected void dispose() {
		System.out.println("LivingCreature dispose");
		t.dispose();
		p.dispose();
	}
	
}

class Animal extends LivingCreature{
	
	private Characteristic p = new Characteristic("has herat");
	private Description t = new Description("Animal not Vegetable");
	public Animal() {
		// TODO Auto-generated constructor stub
		System.out.println("Animal()");
		
	}
	
	protected void dispose() {
		System.out.println("Animal dipose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	
	
}

class Amphibian extends Animal{
	private Characteristic p = new Characteristic("can live water");
	private Description t = new Description("Both water and land");
	public Amphibian() {
		// TODO Auto-generated constructor stub
		System.out.println("Amphibian()");
	}
	
	protected void dispose() {
		System.out.println("Amphibian dispose()");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	
	
}








public class Frog extends Amphibian{
	private Characteristic p = new Characteristic("Croaks");
	private Description t = new Description("Eats Bugs");
	public Frog() {
		System.out.println("Forg()");
	}
	protected void dispose() {
		System.out.println("Frog dispose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	
	public static void main(String[] args) {
		Frog frog = new Frog();
		System.out.println("Bye!");
		frog.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}














