package Chapter7Demo;

public class Cleanser {
	
	private String s = "Cleanser";
	/**
	 * 记住里面的方法必须时public
	 * @param a
	 */
	public void append(String a) {
		s += a;
	}
	public void dilute() {
		append(" dilute() "); 
	}
	public void apply() {
		append(" apply() "); 
	}
	public void scrub() {
		append(" scrub() ");
	}
	public String toString () {
		return s;
	}
	
	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		System.out.println(x.toString());
	}
	
}

