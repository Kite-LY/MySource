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
	//构造方法
	public Acount() {
		// TODO Auto-generated constructor stub
		System.out.println("Acount的无参数构造方法");
	}
	
	public Acount(String actno, double balance) {
		this.actno = actno;
		this.balance = balance;
	}
	
	//成员方法get set 方法
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
		super(actno, balance);         //间接的调父类的构造方法 给父类类型数据赋值，此处不会创建对象
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
//		System.out.println("员工在工作！");
//	}
//}
//
//class Manager extends Employee{
//	
//	public void work() {
//		System.out.println("经理在工作！");
//	}
//	
//	public void m1() {
//		//this.work();
//		
//		work();
//		/**
//		 * super 代表的是当前子类中父类的
//		 * */
//		super.work();        //调用了父类的方法
//	}
//	
//	
//}