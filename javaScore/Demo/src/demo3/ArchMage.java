package demo3;

public class ArchMage extends Hero {
	
	/** ��ʦ�ľ�̬���ԣ�ÿʵ����һ���µ�չʾ����Id++ */
	public static int Id = 1;
	
	private int archAttack;
	
	public ArchMage() {
		this.setNickName("Ĭ�Ϸ�ʦ" + Id);
		this.setLevel(1);
		this.setMaxLife(100);
		this.setCurrLife(100);
		this.setArchAttack(99);
		Id++;
	
	}
	
	/**
	 * ����toString����
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
		System.out.println("��ʦ" + getNickName() + "���ͷż��ܣ�");
	}
	
	public int getArchAttack() {
		return archAttack;
	}

	public void setArchAttack(int archAttack) {
		this.archAttack = archAttack;
	}
	
	
	
	
}
