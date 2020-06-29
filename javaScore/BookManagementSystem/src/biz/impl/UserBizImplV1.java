package biz.impl;

import java.util.Map;
import java.util.Set;

import biz.UserBiz;
import entity.User;
import util.FileUtil;

public class UserBizImplV1  implements UserBiz{


	private static final long serialVersionUID = -7632858954250959025L;

	@Override
	public User login(User user) {
		Set<User> userSet = FileUtil.ReadUser();
		if(null == userSet || userSet.size() == 0) return null;
		//在user类中需要重写equal方法 
		for(User temp : userSet) {
			if(temp.equals(user)) {
				return temp;
			}
		}
		
		return null;
	
	}

	@Override
	public boolean del(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
