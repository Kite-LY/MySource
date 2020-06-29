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
  * ��ɫ��
  * @author С����
  *
  */
public class Role implements Serializable{


	private static final long serialVersionUID = 2849053597745407687L;
	private String name;				//��ɫ����
	private String key;					//��ӦȨ�������ļ��е�Ȩ��key
	private List<String> permisstions;	//Ȩ�޼��� - �����������ļ��У�Role_Permisstion.properties
	private BookInfoBiz bookInfoBiz;
	private UserBiz userBiz;
	
	public Role() {
		setName("Ĭ�Ͻ�ɫ");
		setKey("default");
		createPermisstions(key);
		//bookinfoBiz = new BookInfoBizImplV1();		//ֱ�Ӵ���ʵ�֣����Ը�Ϊ����ģʽ���������ʵ��
		//����ģʽ
		bookInfoBiz = (BookInfoBiz)BizFactory.getBiz("bookinfoBiz");
		userBiz = (UserBiz)BizFactory.getBiz("userbiz");
	}
	
	/**
	 * ����һ��������ɫ��Ȩ��key�Ľ�ɫ����
	 * Ȩ��key��Ӧ��һ���ַ��������ν�����ַ����ָ�����飬�����ֵ��permisstions����
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
		//��ȡ�����ļ�����õ�ǰ��ɫ��Ȩ�޼���
		Properties props = new Properties();
		try {
			props.load(Role.class.getResourceAsStream("Role_Permisstions.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//ͨ��Ȩ��key�õ���Ӧ��Ȩ���ַ������Զ��ŷָ
		//�����Ȩ��key���ұ��¶�Ӧ��Ȩ���ַ���
		String strPermisstoin = props.getProperty(key);			//administrator = bookinfo.*, userbiz.*
		
		if(null == permisstions) {
			permisstions = new ArrayList<String>();
		}
		permisstions.clear();  									//ȷ��Ϊ�յļ���
		String[] permisstionArray = strPermisstoin.split(",");
		for(String permisstion : permisstionArray) {
			if("".equals(permisstion)) continue;
			permisstions.add(permisstion.trim());		//trim() ȥ��ո�
		}
	}
	
	
	/**
	 * ��֤��ǰ��Уɫ�Ƿ���Ȩִ�д���Ĳ�����(ҵ�񷽷���) bookinfobiz.add | bookinfobiz.instore
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
			//�����������
		}
		return false;

		
	}
	
	
	public User login(User user) {
		if(checkPermisstion("userbiz.login")) {
			return userBiz.login(user);
		}
		throw new NoSuchOptPermissionException(name + "û�в���<userbiz.login>��Ȩ�ޣ�");
	}
	
	public boolean inStore(String isbn, int inCount) {
		//��֤��ǰ�Ľ�ɫ��û��Ȩ��ִ��������
		if(checkPermisstion("bookinfobiz.instore")) {
			return bookInfoBiz.inStroe(isbn, inCount);
		}else {
			//�׳�һ���쳣���ӡ�쳣��Ϣ
			throw new NoSuchOptPermissionException(name + "û�в���< bookinfobiz.instore>��Ȩ�ޣ�");
		}
	}
	
	
	public boolean OutStore(String isbn, int inCount) {
		//��֤��ǰ�Ľ�ɫ��û��Ȩ��ִ��������
		if(checkPermisstion("bookinfobiz.outstore")) {
			return bookInfoBiz.outStore(isbn, inCount);
		}else {
			//�׳�һ���쳣���ӡ�쳣��Ϣ
			throw new NoSuchOptPermissionException(name + "û�в���< bookinfobiz.outstore>��Ȩ�ޣ�");
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
