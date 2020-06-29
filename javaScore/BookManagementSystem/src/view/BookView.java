package view;

import java.util.Scanner;

import auth.Role;
import entity.User;

public class BookView {
	private Scanner input = null;
	private User loginUser = null;				//当前已经登录的用户对象
	private Role role = null;					//当前已经登录用户的对应角色，用来调用业务 方法
	
	public BookView() {
		input = new Scanner(System.in);
		showWelcome();
	}
	
	
	
	/**
	 * 显示欢迎界面
	 */
	public void showWelcome() {
		System.out.println("=============   欢迎使用Kite图书管理系统   ==============");
		System.out.println("\t1.登录系统\n\t2.注册\n\t3.退出系统");
		System.out.println("=======================================================");
		System.out.print("请选择：");
		String choice = input.next();
		if("1".equals(choice)) {
			//登录
			showLoginView();
			System.out.println("当前角色：" + this.role.getKey());
			switch (this.role.getKey()) {
			case "administrator":
					showMainView_Adminstrator();
				break;
			case "oparator":
				showMainView_Oparator();
			default:
				break;
			}
			
		}else if("2".equals(choice)) {
			//注册
			System.out.println("注册方法！");
		}else {
			System.out.println("系统成功退出!");
		}
		
	}
	
	public User showLoginView() {
		User loginUser = new User();
		System.out.print("用户名：");
		loginUser.setUserName(input.next());
		System.out.print("密码：");
		loginUser.setPassword(input.next());
		//需要通过业务方法验证当前录入的用户对象是否合法
		//如果合法，将当前登录用户保存到this.loginUser中备用，在设置当前登录用户的角色，以便显示相应的菜单及调用相应的方法
		this.loginUser = loginUser.getRole().login(loginUser);
		if(this.loginUser == null) {
			return null;
		}else {
			//this.loginUser = loginUser;
			this.role = this.loginUser.getRole();
			return this.loginUser;
		}
		
	
	}
	
	
	/**
	 * 显示管理员主菜单
	 */
	public void showMainView_Adminstrator() {
		System.out.println("管理员主菜单");
	}
	
	/**
	 * 显示操做员主菜单
	 */
	public void showMainView_Oparator() {
		System.out.println("操做员主菜单");
	}
	
}




















