package Demo1.Java;

/**
 * 案例：创建三个窗口卖票，总票数为100张，使用runnable接口的方式
 * 存在线程的安全问题：待解决
 *
 *
 *
 * 比较创建两个线程的的两种方式：
 * 开发中：优先选择实行Runnable接口的方式
 * 原因：1.实现的方式没有类的单继承的局限性
 *      2.实现的方式更适合来处理多个线程由共享数据的情况
 *
 * 联系：都是有接口Runnable
 * 相同点：两种方式都需要重写run（），将线程要执行的逻辑声明在run()中
 */

class Window1 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println("窗口" + Thread.currentThread().getName() + "\t 票号：" +ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();

        //三个都是使用的window1

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口一：");
        t2.setName("窗口二：");
        t3.setName("窗口三：");

        t1.start();
        t2.start();
        t3.start();

    }
}
