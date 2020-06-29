package Demo2_4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：
 *   实现使用Callable
 */

class numThread implements Callable{


    private  int sum = 0;
    @Override
    public Object call() throws Exception {
        for(int i =0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        numThread n = new numThread();
        FutureTask t = new FutureTask(n);
        new Thread(t).start();

        try {

            //get()的返回值是重写的call中的返回值
            Object sum = t.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
