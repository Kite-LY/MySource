package demo;

public class RoalTest {

	public static void main(String[] args) {
		
		//ʹ����ʵ��������
		Role r = new Role("haha ", 11, "����" );
		r.show();
		Role R1 = new Role();
		R1.job = "����";
		R1.name = "�����";
		R1.level = 99;
		R1.doSkill();
		R1.show();
		
	}

}
