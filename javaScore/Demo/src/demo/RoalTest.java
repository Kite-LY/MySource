package demo;

public class RoalTest {

	public static void main(String[] args) {
		
		//使用类实例化对象
		Role r = new Role("haha ", 11, "哈哈" );
		r.show();
		Role R1 = new Role();
		R1.job = "神仙";
		R1.name = "孙悟空";
		R1.level = 99;
		R1.doSkill();
		R1.show();
		
	}

}
