package Demo2_2;


/**
 * 使用同步机制将单例模式中的懒汉式改写成线程安全的
 *
 */
public class BankTest {
}
class Bank{

    private Bank(){}
    private static Bank instance = null;
    public static Bank getInstance(){
        //方式一：效率比检差
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：
        if(instance == null){
            synchronized (Bank.class){
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
    return instance;
    }
}