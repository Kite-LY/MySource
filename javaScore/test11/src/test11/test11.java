package test11;

public class test11 {
	public static void main(String[] args) {
//		Manager m = new Manager();
//		m.m1();
		
		Acount a = new DebitAcount();
		
	}
}



class Acount{
	private String actno;
	private double balance;
	//���췽��
	public Acount() {
		// TODO Auto-generated constructor stub
		System.out.println("Acount���޲������췽��");
	}
	
	public Acount(String actno, double balance) {
		this.actno = actno;
		this.balance = balance;
	}
	
	//��Ա����get set ����
	public void setActno(String actno) {
		this.actno = actno;
	}
	
	public String getActno() {
		return this.actno;
	}
	
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	
}


class DebitAcount extends Acount{
	private double debit;
	
	public DebitAcount(){
		//super("001", 222);
	}
	public DebitAcount(String actno, double balance, double debit) {
		super(actno, balance);         //��ӵĵ�����Ĺ��췽�� �������������ݸ�ֵ���˴����ᴴ������
		this.debit = debit;
	}
	
	public void seDdebit(double debit) {
		this.debit = debit;
	}
	
	public double getDebit() {
		return this.debit;
	}
}



//class Employee{
//	public void work() {
//		System.out.println("Ա���ڹ�����");
//	}
//}
//
//class Manager extends Employee{
//	
//	public void work() {
//		System.out.println("�����ڹ�����");
//	}
//	
//	public void m1() {
//		//this.work();
//		
//		work();
//		/**
//		 * super ������ǵ�ǰ�����и����
//		 * */
//		super.work();        //�����˸���ķ���
//	}
//	
//	
//}