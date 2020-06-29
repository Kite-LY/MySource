package Demo8.opmpareDemo;

public class RoleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleBiz biz = new RoleBiz();
		biz.add(new Role("Αυ±Έ1", "»ΚµΫ", 100, 123));
		biz.add(new Role("Αυ±Έ2", "»ΚµΫ", 102, 123));
		biz.add(new Role("Αυ±Έ3", "»ΚµΫ", 15, 123));
		biz.add(new Role("Αυ±Έ4", "»ΚµΫ", 1330, 123));
		biz.add(new Role("Αυ±Έ5", "»ΚµΫ", 1013, 123));
		biz.show();
		
//		Role role4 = new Role("Αυ±Έ4", "»ΚµΫ", 100, 123);
//		biz.delete(role4);
//		biz.show();
		
//		Role role1 = new Role("Αυ±Έ4", "Ψ©Οΰ", 1000, 123);
//		biz.upDate(role1);
//		biz.show();
		
		biz.sort();
		biz.show();
	}

}
