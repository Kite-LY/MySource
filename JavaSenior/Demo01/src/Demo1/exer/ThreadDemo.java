package Demo1.exer;


/**
 * 练习：创建两个线程：其中一个遍历100以内的偶数，还有个遍历100以内的奇数
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 m1 = new MyThread1();
//        MyThread1 m2 = new MyThread1();
//
//        m1.start();
//        m2.start();

        //使用创建匿名类的方式
        new Thread(){
            @Override
            public void run() {
                for(int i = 1; i <= 100; i++){
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+ ":" + i);
                    }
                    if(i % 20 == 0){
                       yield();
                    }
                }
            }
        }.start();

        new Thread(){
            public void run() {
                for(int i = 1; i <= 100; i++){
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+ ":" + i);
                    }
                }
            }
        }.start();
    }

}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ ":" + i);
            }
        }
    }
}


class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+ ":" + i);
            }
        }
    }
}