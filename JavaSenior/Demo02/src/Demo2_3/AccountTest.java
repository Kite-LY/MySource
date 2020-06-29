package Demo2_3;

/**
 * 银行有两个储户同时向一个账户存3000元，每次存100，存三次。每次存完打印账户余额
 *
 *  分析：
 *  1.是否是多线程问题 ： 是，两个储户线程
 *  2.是否共享数据：共享账户的余额
 *
 *
 */

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void desposit(double amt){
        if(amt > 0){
            balance += amt;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 存钱成功， 余额为：" + balance);
        }
    }

}

class Customer extends Thread{

    private Account acct;
    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {

        for (int i = 0; i <3 ; i++) {
            acct.desposit(1000);
        }

    }
}



public class AccountTest {

    public static void main(String[] args) {
        Account acct = new Account(0);

        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();





    }

}
