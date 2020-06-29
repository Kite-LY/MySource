package Demo02_1;

/**
 * 案例：创建三个窗口卖票，总票数为100张，使用runnable接口的方式
 * 存在线程的安全问题：待解决                （一定存在共享数据）
 *  1.问题：会出现重票，错票的问题
 *  2.解决方法：当a线程在操作的ticket的时候，其他的线程也不能进入。只能当a线程执行完毕后，其他的线程才可以进行操作
 *  3.在java中通过同步机制进行解决
 *      方式一：同步代码块
 *       synchronized（同步监视器）{
 *           //需要被同步的代码
 *       }
 *       1.同步监视器：锁，任何一个类的对象都可充当监视器
 *              要求：多个线程必须使用同一把锁
 *
 *
 *
 *
 *
 *  4.同步的方式，解决了线程的安全问题   好处
 *      操作同步代码时，只能有一个线程参与，其他的线程等待。相当于一个单线程的过程，效率比较低
 */

class Window2 implements Runnable{
    private int ticket = 100;
   // Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (Window.class                      ) {                            //添加的同步监视器：锁
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("窗口:" + Thread.currentThread().getName() + "\t 票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window2 i1 = new Window2();

        //三个都是使用的window1

        Thread t1 = new Thread(i1);
        Thread t2 = new Thread(i1);
        Thread t3 = new Thread(i1);

        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");

        t1.start();
        t2.start();
        t3.start();

    }
}
