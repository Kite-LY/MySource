package Demo2_4;

/**
 * 生产者消费之问题
 */

/**
 * c产品类
 */
class Clerk{

    private int prodectCount = 0;
    //生产
    public synchronized void produceProdect() {
        if(prodectCount <  20){
            prodectCount++;
            System.out.println(Thread.currentThread().getName() + "，开始生产第：" + prodectCount +" 个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费
    public synchronized void consumeProdect() {
        if(prodectCount > 0){
            System.out.println(Thread.currentThread().getName() + "，开始消费第：" + prodectCount +" 个产品");
            prodectCount--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Prodect extends Thread{
    private Clerk clerk;
    public Prodect(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":" + "开始生产产品！");
        while(true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProdect();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;
    public Customer(Clerk clerk){

        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":" + "开始消费产品！");
        while(true){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProdect();
        }
    }
}


public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Prodect p1 = new Prodect(clerk);
        Customer c1 = new Customer(clerk);
        Customer c2 = new Customer(clerk);
        p1.setName("生产者1");
        c1.setName("消费者1");
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }

}
