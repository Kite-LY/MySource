package demo3;

public class Warriors extends Hero {
	/** 战士的静态属性，每实例化一个新的展示对象Id++ */
	public static int Id = 1;
	
	
	/** 战士的物理攻击力*/
	private int pysicalAttack;

	public Warriors() {
		super();     //子类会默认调用父类构造的
		//System.out.println("子类默认构造！");
		this.setNickName("默认战士" + Id);
		this.setLevel(1);
		this.setMaxLife(100);
		this.setCurrLife(100);
		this.setPysicalAttack(99);
		Id++;
	}
	
	
	public int compareTo(Hero p) {
		if(this.getLevel() == p.getLevel()) {
			return 0;
		}
		if(this.getLevel() > p.getLevel()) {
			return 1;
		}
		return -1;
	}
	
	
	
	//重写父类的move（）方法
//	public void move() {
//		System.out.println(getNickName() + "战士的移动！");
//	}
	
	/**
	 * 重写toString方法
	 */
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(getNickName());
		str.append("\t");
		str.append(getLevel());
		str.append("\t");
		str.append(getMaxLife());
		str.append("\t");
		str.append(getCurrLife());
		str.append("\t");
		str.append(getPysicalAttack());
		
		return str.toString();
	}
	
	
	/**
	 * 重写object类中的equals方法
	 * */
	@Override
	public boolean equals(Object obj) {
		//先判断传进来的数据是不是warriors类的实例
		if(!(obj instanceof Warriors)) {      //instanceof返回值为boolean类型，用来判断A是否是B的实例对象或者B子类的实例对象。如果是则返回true,否则返回false
			return false;
		}
		Warriors newWarriors = (Warriors)obj;
		if(getNickName().equals(newWarriors.getNickName()) && getPysicalAttack() == newWarriors.pysicalAttack){
			return true;
		}
		
		
		
		return false;
	}

	@Override			//注解重写，避免书写错误
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		
		System.out.println(getNickName() + "战士的移动！");
	}
	
	public Warriors(String nickName, int pysicalAttack) {
		setNickName(nickName);
		setPysicalAttack(pysicalAttack);
		
	}
	
	public int getPysicalAttack() {
		return pysicalAttack;
	}

	public void setPysicalAttack(int pysicalAttack) {
		this.pysicalAttack = pysicalAttack;
	}
	
	
}
