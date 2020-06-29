package Demo02_1;


/**
 * 使用同步的方法剞劂实现Runnable接口线程安全问题
 *
 * 关于同步方法的总结：
 *  1.同步方法仍然涉及到同步监视器，只是不需要我们显示声明
 *  2.非静态的同步方法，同步监视器是：this
 *      静态的同步方法，同步监视器是：当前的类
 *
 *
 */







class Window1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    //同步方法
    public synchronized void show() {//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "\t 票号：" + ticket);
            ticket--;
        }

    }
}




public class WindowTest3  {
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
