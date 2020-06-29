package Demo8.opmpareDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 软件的业务类
 * @author 小风筝
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
	 * 修改
	 * @param role
	 */
	public void upDate(Role role) {
		//1.先找到元素
		//2.修改元素
		int index = RoleList.indexOf(role);
		if(index != -1) {
			RoleList.set(index, role);
		}
		
		
	}
	
	
	
	/**
	 * 添加
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
		System.out.println("角色\t\t称号\t\t血量\t\t攻击力");
		System.out.println("------------------------------------");
		Iterator<Role> RoleIt = RoleList.iterator();
		while(RoleIt.hasNext()) {
			Role role = RoleIt.next();
			System.out.println(role.getName() + "\t\t" + role.getTitle() + 
								"\t" + role.getHp() + "\t" + role.getAttack());
		}
		
	}
}
