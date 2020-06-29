package Demo1_1;

public class Warrior extends Hero {

	public Warrior() {
		super();
		setName("Ĭ��Ӣ��");
		
	}
	
	public Warrior(long id, String name, int x, int y){
		super(name, id);
		setX(x);
		setY(y);
	}
	
	
	@Override
	public void fight(Hero hero) {
		// TODO Auto-generated method stub
		int attack = ((int)(Math.random() * 1000)) % 51 + 20;  //սʿ�Ĺ�������20 ��50 ֮��
		setAttack(attack);
		hero.setHp(hero.getHp() - getAttack());
		
	}

	@Override
	public boolean canFightByDistance(Hero hero) {

		double distance = getDistance(getX(), getY(), hero.getX(), hero.getY());
		return distance <= 100;			//սʿ��Ĭ�Ϲ�������Ϊ100��С��100 ��Ϊtrue
	}

}
