package Demo1.Java;


/**
 * 创建3个窗口去买票，总票数为100张
 *
 */


class Window extends  Thread{
    /** 指定给100张票 */
    private static int ticket = 100;     //定义为静态变量只会被创建一次

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println("窗口号：" + this.getName() + "\t 出售的票号：" + ticket);
                ticket--;
            }
            if(ticket == 0 ){
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();


    }
}
