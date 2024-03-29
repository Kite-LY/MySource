 package auth;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import biz.BizFactory;
import biz.BookInfoBiz;
import biz.UserBiz;
import entity.User;
import exception.NoSuchOptPermissionException;

/**
  * 角色类
  * @author 小风筝
  *
  */
public class Role implements Serializable{


	private static final long serialVersionUID = 2849053597745407687L;
	private String name;				//角色名称
	private String key;					//对应权限配置文件中的权限key
	private List<String> permisstions;	//权限集合 - 保存在配置文件中：Role_Permisstion.properties
	private BookInfoBiz bookInfoBiz;
	private UserBiz userBiz;
	
	public Role() {
		setName("默认角色");
		setKey("default");
		createPermisstions(key);
		//bookinfoBiz = new BookInfoBizImplV1();		//直接代码实现，可以改为工厂模式来获得子类实现
		//工厂模式
		bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("bookinfoBiz");
		userBiz = (UserBiz)BizFactory.getBiz("userbiz");
	}
	
	/**
	 * 创建一个给定角色和权限key的角色对象
	 * 权限key对应的一个字符串，我梦将这个字符串分割成数组，逐个赋值给permisstions集合
	 * @param name
	 * @param key
	 */
	public Role(String name, String key) {
		
		setName(name);
		setKey(key);
		
		createPermisstions(key);
		bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("bookinfoBiz");
	}

	private void createPermisstions(String key) {
		//读取配置文件，获得当前角色的权限集合
		Properties props = new Properties();
		try {
			props.load(Role.class.getResourceAsStream("Role_Permisstions.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//通过权限key拿到对应的权限字符串（以逗号分割）
		//左边事权限key，右边事对应的权限字符串
		String strPermisstoin = props.getProperty(key);			//administrator = bookinfo.*, userbiz.*
		
		if(null == permisstions) {
			permisstions = new ArrayList<String>();
		}
		permisstions.clear();  									//确保为空的集合
		String[] permisstionArray = strPermisstoin.split(",");
		for(String permisstion : permisstionArray) {
			if("".equals(permisstion)) continue;
			permisstions.add(permisstion.trim());		//trim() 去点空格
		}
	}
	
	
	/**
	 * 验证当前的校色是否有权执行传入的操作名(业务方法名) bookinfobiz.add | bookinfobiz.instore
	 * @param optName
	 * @return
	 */
	private boolean checkPermisstion(String optName) {
		if(permisstions == null || permisstions.size() == 0) {
			return false;
		}
		//1.administrator = bookinfobiz.add,  bookinfobiz.findall,  bookinfobiz.finsbyisbn,  bookinfobiz.instroe,  bookinfobiz.outstroe
		//2.administrator = bookinfo.*, userbiz.*
		for(String permisstion : permisstions) {
			if(optName.equals(permisstion)) {
				return true;
			}
			if(permisstion.equals("bookinfobiz.*") && optName.startsWith("bookinfobiz")) {
				return true;
			}
			if(permisstion.equals("userbiz.*") && optName.startsWith("userbiz")) {
				return true;
			}
			//其他情况待定
		}
		return false;

		
	}
	
	
	public User login(User user) {
		if(checkPermisstion("userbiz.login")) {
			return userBiz.login(user);
		}
		throw new NoSuchOptPermissionException(name + "没有操作<userbiz.login>的权限！");
	}
	
	public boolean inStore(String isbn, int inCount) {
		//验证当前的角色有没有权限执行入库操作
		if(checkPermisstion("bookinfobiz.instore")) {
			return bookInfoBiz.inStroe(isbn, inCount);
		}else {
			//抛出一个异常或打印异常信息
			throw new NoSuchOptPermissionException(name + "没有操作< bookinfobiz.instore>的权限！");
		}
	}
	
	
	public boolean OutStore(String isbn, int inCount) {
		//验证当前的角色有没有权限执行入库操作
		if(checkPermisstion("bookinfobiz.outstore")) {
			return bookInfoBiz.outStore(isbn, inCount);
		}else {
			//抛出一个异常或打印异常信息
			throw new NoSuchOptPermissionException(name + "没有操作< bookinfobiz.outstore>的权限！");
		}
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<String> getPermisstions() {
		return permisstions;
	}
	public void setPermisstions(List<String> permisstions) {
		this.permisstions = permisstions;
	}
	public BookInfoBiz getBookinfoBiz() {
		return bookInfoBiz;
	}
	public void setBookinfoBiz(BookInfoBiz bookinfoBiz) {
		this.bookInfoBiz = bookinfoBiz;
	}
	
	
	
}
