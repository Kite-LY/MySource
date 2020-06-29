package demo5;


/**
 * 实现了可攻击接口的英雄类-
 * @author 小风筝
 *
 */

public abstract class Hero implements Assailable {

	private long id;
	private String name;
	private int level;
	private int maxHp;
	private int hp;
	private int attack;
	private int x;
	private int y;

	
	public Hero() {
		setMaxHp(100);
		setHp(100);
	}
	
	public Hero(String name,long id ) {
		this();
		setName(name);
		setId(id);
	}
	
	public void PK(Assailable assa) {
		if(canFightByDistance(assa) && hp > 0 && assa.getHp() > 0) {
			fight(assa);
		}else {
			System.out.println("由于攻击距离不够，不能攻击！");
		}
		//3.打印攻击结果
				System.out.println("两名英雄当前的状态：");
				System.out.println("昵称\thp\tx坐标\ty坐标");
				System.out.println(name + "\t" + hp + "\t" + x + "\t" + y);
				System.out.printf("%s\t%d\t%d\t%d",
						assa.getName(), assa.getHp(), assa.getX(), assa.getY());
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
