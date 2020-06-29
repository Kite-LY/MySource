package Demo8.opmpareDemo;

public class Role implements Comparable<Role>{
	
	private String name;
	private String title;
	private int hp;
	private int attack;
	
	
	public Role(String name, String title, int hp, int attack) {
		this.name = name;
		this.title = title;
		this.hp = hp;
		this.attack = attack;
	}

	
	/**
	 * 重写比较方法
	 */
	@Override
	public boolean equals(Object obj) {
	
		if(!(obj instanceof Role)) {
			return false;
		}
		Role role = (Role)obj;
		return name.equals(role.getName());
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}


	@Override
	public int compareTo(Role o) {
	if(hp > o.hp) return 1;
	if(hp < o.hp) return -1;
	return 0;
	}
	
	
	
	
}
