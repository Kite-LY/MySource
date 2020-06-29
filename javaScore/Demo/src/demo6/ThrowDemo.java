package demo6;
/**
 * 手动的抛出异常
 * @author 小风筝
 *
 */
public class ThrowDemo {

	public static void main(String[] args) {
		
		Hero hero = new Hero("刘备");
		try {
			hero.setExp(1000);
			hero.setHealth(40);
			hero.rideHorse();
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("在设置经验时出现异常：" + e.getMessage());
			
		}
		System.out.println("当前英雄的经验值：" + hero.getExp());
	}

}

class Hero{
	private int health;
	private String name;
	private long exp;
	
	
	/**
	 * 英雄的骑马方法 - 当英雄的血量低于50	时，不允许骑马
	 * @throws LessThanZeroException 
	 * @throws RideHorseException 
	 */
	public void rideHorse() throws LessThanZeroException, RideHorseException {
		if(health >= 50)
			System.out.println(getName() + "正在骑马！");
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