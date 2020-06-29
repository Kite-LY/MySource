package demo3;

public class Warriors extends Hero {
	/** սʿ�ľ�̬���ԣ�ÿʵ����һ���µ�չʾ����Id++ */
	public static int Id = 1;
	
	
	/** սʿ����������*/
	private int pysicalAttack;

	public Warriors() {
		super();     //�����Ĭ�ϵ��ø��๹���
		//System.out.println("����Ĭ�Ϲ��죡");
		this.setNickName("Ĭ��սʿ" + Id);
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
	
	
	
	//��д�����move��������
//	public void move() {
//		System.out.println(getNickName() + "սʿ���ƶ���");
//	}
	
	/**
	 * ��дtoString����
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
	 * ��дobject���е�equals����
	 * */
	@Override
	public boolean equals(Object obj) {
		//���жϴ������������ǲ���warriors���ʵ��
		if(!(obj instanceof Warriors)) {      //instanceof����ֵΪboolean���ͣ������ж�A�Ƿ���B��ʵ���������B�����ʵ������������򷵻�true,���򷵻�false
			return false;
		}
		Warriors newWarriors = (Warriors)obj;
		if(getNickName().equals(newWarriors.getNickName()) && getPysicalAttack() == newWarriors.pysicalAttack){
			return true;
		}
		
		
		
		return false;
	}

	@Override			//ע����д��������д����
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		
		System.out.println(getNickName() + "սʿ���ƶ���");
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
