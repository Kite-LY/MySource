package Demo8.opmpareDemo;

public class RoleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleBiz biz = new RoleBiz();
		biz.add(new Role("����1", "�ʵ�", 100, 123));
		biz.add(new Role("����2", "�ʵ�", 102, 123));
		biz.add(new Role("����3", "�ʵ�", 15, 123));
		biz.add(new Role("����4", "�ʵ�", 1330, 123));
		biz.add(new Role("����5", "�ʵ�", 1013, 123));
		biz.show();
		
//		Role role4 = new Role("����4", "�ʵ�", 100, 123);
//		biz.delete(role4);
//		biz.show();
		
//		Role role1 = new Role("����4", "ة��", 1000, 123);
//		biz.upDate(role1);
//		biz.show();
		
		biz.sort();
		biz.show();
	}

}
