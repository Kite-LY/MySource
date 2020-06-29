package Demo1.Java;

/**
 * 多线程的创建 方式一：继承于Thread 类
 * 1.创建一个继承于Thread 类的子类
 * 2.重写  Thread类的run()      -->j将要执行的操作声明放在run（）中
 * 3.创建Thread类的子类对象
 * 4.通过对象调用start（）
 *
 * 案例：遍历100以内的偶数
 *
 */

//1.创建一个子类继承Thread类
class MyThread extends Thread{
    //2.重写run（）方法

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if( i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":"+i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3.创建子类对象
        MyThread t1 = new MyThread();
        //4.使用对象调用方法
        t1.start();

        //重新new一个线程
        MyThread t2 = new MyThread();
        t2.start();

        //t1.run();   调用的是方法
        for(int i = 1; i <= 100; i++){
            if( i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i );

            }
        }

    }

}
