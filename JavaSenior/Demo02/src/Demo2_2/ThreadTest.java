package Demo2_2;

/**
 * 演示线程的死锁问题
 *
 */

public class ThreadTest {
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){

            @Override
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }.start();

        new Thread(                 //实现runnable接口
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (s2){
                            s1.append("c");
                            s2.append("3");

                            try {
                                Thread.currentThread().sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            synchronized (s1){
                                s1.append("d");
                                s2.append("4");
                                System.out.println(s1);
                                System.out.println(s2);
                            }
                        }
                    }
                }
        ).start();

    }

}
