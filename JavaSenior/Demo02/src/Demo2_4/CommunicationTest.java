package Demo2_4;


/**\
 * 线程通信的案例：使用两个线程答应1-100.线程1，线程2 交替打印
 * 1.wait():一旦使用此方法，线程就会进入到阻塞状态，并且释放同步监视器
 * 2.notify:唤醒一个wait（）的线程，如果是多个的话，则唤醒优先级高的线程
 * 3.notityAll()：唤醒多个wait()的线程
 *
 * 注意：1.wait().notify(),notityAll().三个方法必须在一个同步代码块中
 *      2.wait(),notify(),notifyAll(),三个方法必须是同步代码块中的同步监视器进行调用
 *
 *
 * 常见的面试题：
 *          sleep（）和 wait（） 的异同：
 *          相同点：两个一旦被使用，都会让当前的线程进入睡眠状态
 *          不同点：1.两个方法声明的位置不同，一个在Thread中，一个sleeo（）中
 *                 2.调用的要求不同，sleep在任何时刻都可以调用，wait（）必须在声明的代码块中调用
 *                 3，如果都在同步代码块中，调用了sleep方法则不会释放同步监视器，而wait（）则会释放同步代码块中的同步监视器
 */

class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {                   //生成代码块ctrl+alt+t

                notify();           //线程唤醒
                if(number <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：" +number);
                    number++;
                }else{
                    break;
                }
                try {
                    wait();             //可以释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
public class CommunicationTest {

    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }


}
