package Demo1_1;

public class Warrior extends Hero {

	public Warrior() {
		super();
		setName("默认英雄");
		
	}
	
	public Warrior(long id, String name, int x, int y){
		super(name, id);
		setX(x);
		setY(y);
	}
	
	
	@Override
	public void fight(Hero hero) {
		// TODO Auto-generated method stub
		int attack = ((int)(Math.random() * 1000)) % 51 + 20;  //战士的攻击力在20 到50 之间
		setAttack(attack);
		hero.setHp(hero.getHp() - getAttack());
		
	}

	@Override
	public boolean canFightByDistance(Hero hero) {

		double distance = getDistance(getX(), getY(), hero.getX(), hero.getY());
		return distance <= 100;			//战士的默认攻击距离为100，小于100 则为true
	}

}
