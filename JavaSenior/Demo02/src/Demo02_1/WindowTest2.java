package Demo02_1;



class Window extends Thread{
    private static int ticket =100;
    private static Object obj = new Object();
    @Override
    public void run() {
        synchronized (obj){
            while(true){
                if(ticket > 0){
                    System.out.println("窗口：" + this.currentThread().getName() + "\t 票号：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window o1 = new Window();
        Window o2 = new Window();
        Window o3 = new Window();

        o1.setName("窗口1：");
        o2.setName("窗口2：");
        o3.setName("窗口3：");

        o1.start();
        o2.start();
        o3.start();

    }
}















