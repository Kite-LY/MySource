package demo5;

public interface Assailable {
	
	String getName();
	
	int getX();
	void setX(int x);
	
	int getY();
	void setY(int y);
	
	int getHp();
	void setHp(int hp);
	
	
	/**
	 * 根据距离判断，是否能够成功攻击另一个具备攻击能力的对象
	 * @param assa
	 * @return
	 */
	boolean canFightByDistance(Assailable assa);
	
	void fight(Assailable assa);
	
}
