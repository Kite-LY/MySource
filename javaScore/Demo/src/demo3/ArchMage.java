package demo3;

public class ArchMage extends Hero {
	
	/** 法师的静态属性，每实例化一个新的展示对象Id++ */
	public static int Id = 1;
	
	private int archAttack;
	
	public ArchMage() {
		this.setNickName("默认法师" + Id);
		this.setLevel(1);
		this.setMaxLife(100);
		this.setCurrLife(100);
		this.setArchAttack(99);
		Id++;
	
	}
	
	/**
	 * 重载toString方法
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
		str.append(getArchAttack());
		
		return str.toString();
	}
	
	public ArchMage(String nickName) {
		this();
		setNickName(nickName);
	}
	

	
	public void biubiu() {
		System.out.println("大法师" + getNickName() + "在释放技能！");
	}
	
	public int getArchAttack() {
		return archAttack;
	}

	public void setArchAttack(int archAttack) {
		this.archAttack = archAttack;
	}
	
	
	
	
}
