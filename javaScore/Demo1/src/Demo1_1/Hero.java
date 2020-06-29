package Demo1_1;
/**
 * 	Ӣ���� - ����
 * @author С����
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
		//1.�жϹ��������Ƿ��ܹ���
		if(canFightByDistance(hero) && hp > 0 && hero.hp > 0 ) {
			//2.����ܹ����Ƶ��ù�������
			fight(hero);
		}else {
			System.out.println("���ڹ������벻�����޷�������");
		}
		//3.��ӡ�������
		System.out.println("����Ӣ�۵�ǰ��״̬��");
		System.out.println("�ǳ�\thp\tx����\ty����");
		System.out.println(name + "\t" + hp + "\t" + x + "\t" + y);
		System.out.printf("%s\t%d\t%d\t%d", hero.getName(),hero.getHp(),hero.getX(), hero.getY());
	}
	
	
	/**
	 * ����Ҫ�����Ķ���Ĭ��������ɹ������������Է�
	 * @param hero
	 */
	public abstract void fight(Hero hero);
	
	
	/**
	 * �жϵ�ǰӢ���Ƿ��ܹ��������Ӣ��
	 * @param hero Ҫ������Ӣ��
	 * @return �Ƿ��ܹ���
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
