package Demo2_2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁    --JDK5.0新增的方法
 *
 *1.synchronized与Lock的异同
 * 相同：二者都可以解决线程的安全问题
 * Lock需要手动的启动同步（LOck），同时也需要手动昂的实现（nuLocke（））
 */

class Window implements Runnable{

    private static int ticket = 100;

    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){

            try {
                //2.调用Lock方法
                lock.lock();

                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("窗口号：" + Thread.currentThread().getName() + "\t 票号：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.调用lock的解锁方法
                lock.unlock();
            }

        }
    }
}

public class LockTest  {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
