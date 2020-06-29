package demo6;
/**
 * �ֶ����׳��쳣
 * @author С����
 *
 */
public class ThrowDemo {

	public static void main(String[] args) {
		
		Hero hero = new Hero("����");
		try {
			hero.setExp(1000);
			hero.setHealth(40);
			hero.rideHorse();
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("�����þ���ʱ�����쳣��" + e.getMessage());
			
		}
		System.out.println("��ǰӢ�۵ľ���ֵ��" + hero.getExp());
	}

}

class Hero{
	private int health;
	private String name;
	private long exp;
	
	
	/**
	 * Ӣ�۵������� - ��Ӣ�۵�Ѫ������50	ʱ������������
	 * @throws LessThanZeroException 
	 * @throws RideHorseException 
	 */
	public void rideHorse() throws LessThanZeroException, RideHorseException {
		if(health >= 50)
			System.out.println(getName() + "��������");
		else
			throw new RideHorseException(health);
	}
	
	public Hero(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) throws Exception {
		
		if(exp >= 0) {
			this.exp = exp;
		}else
		throw new LessThanZeroException((int)exp);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
}