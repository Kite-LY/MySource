package test08;

/**
 * �˻���
 * ���࣬���࣬ ����
 * */
public class Acount {
	
	//�˺�
	private String actno;
	double balance;
	
	Acount(){}
	
	Acount(String actno, int balance){
		this.actno = actno;
		this.balance = balance;
	}
	
	public void setActno(String actno) {   //��ӷ���
		this.actno = actno;
	}
	
	public String getActno() {
		return actno; 
	}
	
	
	
}
