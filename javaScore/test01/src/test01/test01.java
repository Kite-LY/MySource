package test01;

public class test01 {
	//����
	
	//ѧ��
	int id;
	//����
	private String name;
	
	//��ֵ
	public void setName(String _name) {
		name =_name;
	}
	//��ȡ
	public String getName() {
		return name;
	}
	//�Ա�
	boolean sex;
	//����
	int age;
	//��ֵ
	public	void setAge(int _age) {
		if(_age < 0 || _age > 100)
		{
			System.out.println("����������䲻�Ϸ���");
		}
		age = _age;
	}
	//��ȡ
	public int getAge() {
		return age;
	}
	
	
	//סַ
	String addr;
	//����
	
	
	
	
}
