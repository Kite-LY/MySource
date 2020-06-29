package cn.kitey.ui;


        import cn.kitey.service.impl.AccountServiceImFuzai;
        import cn.kitey.service.impl.AccountServiceImpl;
        import cn.kitey.service.impl.AccountServiceImplSet;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountServiceImpl service = context.getBean("accountService", AccountServiceImpl.class);
        AccountServiceImplSet service1 = context.getBean("accountServiceSet", AccountServiceImplSet.class);
        AccountServiceImFuzai fuzai = context.getBean("accountServiceFuzai", AccountServiceImFuzai.class);
//

        fuzai.saveAccount();

        //service.saveAccount();
        // service1.saveAccount();

    }
}
