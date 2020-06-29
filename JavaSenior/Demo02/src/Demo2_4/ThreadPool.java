package Demo2_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式4：创建线程池
 * 1.提高响应速度
 * 2.降低资源消耗，便于资源的管理
 *
 *
 */

class numberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+ ":" +i);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);     //使用线程池创建10个线程  实现的是一个接口
        //可以进行强转,进行属性的设置
        ThreadPoolExecutor service1 =(ThreadPoolExecutor)service;
        service1.setCorePoolSize(2);
        //在线程池中传入要实现的方法
        service.execute(new numberThread());        //适用于Runnable接口的调用方法

        //关闭线程池
        service.shutdown();
    }
}
