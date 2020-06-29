package Demo8.opmpareDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * �����ҵ����
 * @author С����
 *
 */

public class RoleBiz {
	List<Role> RoleList = null;
	
	public RoleBiz() {
		RoleList = new ArrayList<Role>();
	}
	
	
	
	
	
	
	
	
	
	
	
	public void sort() {
		 Collections.sort(RoleList);
	}
	
	
	
	/**
	 * �޸�
	 * @param role
	 */
	public void upDate(Role role) {
		//1.���ҵ�Ԫ��
		//2.�޸�Ԫ��
		int index = RoleList.indexOf(role);
		if(index != -1) {
			RoleList.set(index, role);
		}
		
		
	}
	
	
	
	/**
	 * ���
	 * @param role
	 */
	public void add(Role role) {
		if(RoleList != null) {
			RoleList.add(role);
		}
	}
	
	
	public void delete(Role role) {
		RoleList.remove(role);
	}
	
	public void show() {
		System.out.println("��ɫ\t\t�ƺ�\t\tѪ��\t\t������");
		System.out.println("------------------------------------");
		Iterator<Role> RoleIt = RoleList.iterator();
		while(RoleIt.hasNext()) {
			Role role = RoleIt.next();
			System.out.println(role.getName() + "\t\t" + role.getTitle() + 
								"\t" + role.getHp() + "\t" + role.getAttack());
		}
		
	}
}
