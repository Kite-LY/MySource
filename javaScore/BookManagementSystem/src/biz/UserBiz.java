package biz;

/**
 * 用户类接口
 */

import entity.User;

public interface UserBiz extends Biz<User>{ 
	public User login(User user);
}
