package entity;

import java.io.Serializable;
import java.sql.Date;

import auth.Role;

/**
 * 用户对象 - 包含角色
 * @author 小风筝
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = -3363120264501521428L;

	private String userName;
	private String password;
	private Role role;					//当前用户的角色
	private Date lastedLoignTime;		//用户上次登录时间
	
	public User() {
		role = new Role();	//默认
	}
	
	public User(Role role) {
		if(null == role) {
			role = new Role();
		}
		setRole(role);
 	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(null == obj) return false;
		if(!(obj instanceof User)) return false;
		User user = (User)obj;
		return userName.equals(user.getUserName()) && password.equals(user.getPassword());
	
	}
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Date getLastedLoignTime() {
		return lastedLoignTime;
	}
	public void setLastedLoignTime(Date lastedLoignTime) {
		this.lastedLoignTime = lastedLoignTime;
	}

	
	
}
