package test08;

/**
 * 账户类
 * 父类，超类， 基类
 * */
public class Acount {
	
	//账号
	private String actno;
	double balance;
	
	Acount(){}
	
	Acount(String actno, int balance){
		this.actno = actno;
		this.balance = balance;
	}
	
	public void setActno(String actno) {   //间接访问
		this.actno = actno;
	}
	
	public String getActno() {
		return actno; 
	}
	
	
	
}
