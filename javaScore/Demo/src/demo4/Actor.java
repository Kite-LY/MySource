package demo4;
/**
 *��Ա��
 */
public abstract class Actor {			//������Ϊ�����࣬����ʹ��new ��ʵ��������
	private String name;
	
	public Actor() {}
	public Actor(String name) {
		setName(name);
	}
	
	/**
	 *��Ա�ı��ݷ���
	 */
	public void performs() {
		System.out.println("��Ա" + getName() + "���ڱ���");
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
