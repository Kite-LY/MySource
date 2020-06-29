package Demo1_1;
/**
 * 	英雄类 - 父类
 * @author 小风筝
 *
 */
public abstract class Hero {
	private long id;
	private String name;
	private  int level;
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
	
	protected double getDistance(int x1,int y1,int x2, int y2) {
		return Math.abs(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
	}
	
	public void PK(Hero hero) {
		//1.判断攻击距离是否能攻击
		if(canFightByDistance(hero) && hp > 0 && hero.hp > 0 ) {
			//2.如果能攻击酒调用攻击方法
			fight(hero);
		}else {
			System.out.println("由于攻击距离不够，无法攻击！");
		}
		//3.打印攻击结果
		System.out.println("两名英雄当前的状态：");
		System.out.println("昵称\thp\tx坐标\ty坐标");
		System.out.println(name + "\t" + hp + "\t" + x + "\t" + y);
		System.out.printf("%s\t%d\t%d\t%d", hero.getName(),hero.getHp(),hero.getX(), hero.getY());
	}
	
	
	/**
	 * 传入要攻击的对象，默认随机生成攻击力，攻击对方
	 * @param hero
	 */
	public abstract void fight(Hero hero);
	
	
	/**
	 * 判断当前英雄是否能攻击传入的英雄
	 * @param hero 要攻击的英雄
	 * @return 是否能攻击
	 */
	
	public abstract boolean canFightByDistance(Hero hero);
	
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
