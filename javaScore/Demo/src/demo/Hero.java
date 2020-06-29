package demo;

public class Hero {
	private  long id;
	private String name;
	private int level;
	private long exp;
	
	private long currExp;
	
	
	public Hero() {
		super();
	}
	
	public Hero(long id, String name, int level, long exp) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.exp = exp;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(id <= 0) {
			id = 1;
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	
	public long getCurrExp() {
		return currExp;
	}

	public void setCurrExp(long currExp) {
		this.currExp = currExp;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getExp() {
		exp = ((long)Math.pow(level - 1, 3)+60) / 5 * ((level - 1)*2+60);
		return exp;
	}
//
//	public void setExp(long exp) {
//		this.exp = exp;
//	}
	
	 
	
}
