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
	 * ���ݾ����жϣ��Ƿ��ܹ��ɹ�������һ���߱����������Ķ���
	 * @param assa
	 * @return
	 */
	boolean canFightByDistance(Assailable assa);
	
	void fight(Assailable assa);
	
}
