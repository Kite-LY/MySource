package Demo1.Java;

/**
 * 测试Thread中的常用方法
 * 1.start（）：启动当前的线程：调用当前线程的run（）方法
 * 2.run（）：通常需要重写线程中的run的方法，将创建的线程要执行的操作声明放在此方法中
 * 3.currentThread（）：静态方法，返回执行当前的代码的线程
 * 4.getName（）：获取当前线程的名字
 * 5.setName（）：设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join（）：在线程a中调用调用线程b 的join（）方法，则此时线程a进入到阻塞状态，一直到线程b执行完成后，a才开始执行。
 * 8.sleep(long millitime):让线程阻塞一定的时间
 * 9.isAlive():判断线程是否存活
 *
 *  说明：高优先级的线程被执行的概率比较大，并不意味着高优先级的执行完，低优先级的执行
 *
 *
 * 线程的优先级：
 * 1.
 *  MAX_PRIORITY : 10
 *  MIN_PRIORITY : 1
 *  NORM_PRIORITY : 5    ---》默认的优先级
 * 2. 如何获取和设置线程的优先级
 *  getPriority（）：获取当前的线程
 *  setPriority（int p） ： 设置线程的优先级
 *
 *
 *
 */


class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <100 ; i++) {
            if(i % 2 == 0){
//                try {
//                    this.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ": 优先级：" + this.getPriority() + ":" +i);
            }
//            if(i % 20 == 0) {
//                this.yield();     // 这里的this 相当于Thread.currentThread()
//            }
    }
    }

    //同各国构造器对thread进行命名
    public  HelloThread(String name){
        super(name);
    }

}

public class ThreadMethodTest {

    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("构造器线程1");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        System.out.println(h1.isAlive());
//        h1.setName("线程1");
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 1; i <100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "优先级：" + Thread.currentThread().getPriority() + ":" +i);
            }
//            if(i == 10){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
//        System.out.println(h1.isAlive());


    }

}
