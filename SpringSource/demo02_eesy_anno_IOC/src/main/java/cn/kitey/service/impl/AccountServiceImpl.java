package cn.kitey.service.impl;


import cn.kitey.service.IAccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 账户的业务层实现类
 *
 * 1.用于创建对象
*          跟xml中的bean标签实现的功能一样
*          @Commponent：
*              作用：用于把当前的对象存入到spring容器中
 *
*              属性：
*              value：指定bean的id，不写的时候为，当前类名首字母小写
*          @Controller:一般用于表现层
*          Service：一般用于业务层
*          Repository：一般用于持久层
*          以上的额三个注解的作用属性跟Component是一模一样的
*          他们三个是spring框架为我梦提供的三层使用的注解，让我们的三层对象更加的清晰
 *
 *
 * 2. 用于注入数据
 *         Autowired：
 *              作用：自动按照类型注入。只要容器有位移的一个bean对象类型和注入的变量类型匹配，就可以注入成功
 *                   如果ioc容器中没有任何bean的类型要和注入的变量类型匹配，则报错
 *                   如果ioc容器中有多个类型匹配时
 *              书写位置：可以在变量上，也可以在方法上
 *              细节：
 *                  在使用注解时，set方法就不是必须的了
 *
 *         Qualifier:
 *             作用：再按照类中注入的基础上再按照名称注入，再给类成员注入的时候不能单独使用。单数再给方法参数注入时可以
 *             属性：
 *                   value：用于指定注入bean的id开
 *
 *         Resource:
 *              作用：直接按照bean的id注入，可以独立使用
 *              属性：
 *                  name：用于指定bean的id
 *          以上三个注入只能注入其他bean类型的数数据，而基本类型和String类型无法使用上述注解实现
 *          而且，集合数据类型只能通过XML来进行注入
 *
 *
 *          value：
 *              作用：用于注入基本数据类型和String类型的数据
 *              属性：
 *                  value：用于指定数据的值。可以使用spring中的spEL表达式，书写方法${表达式}
 *
 *
 * 3.用于改变作用域大小
 *          它们的作用就是跟bean标签中使用scope属性实现的功能一样的
 *          Scope
 *              作用：用于指定bean的作用范围
 *              属性：
 *                  value：指定范围的取值，常用的取值
 *
 *
 *
 * 4.生命周期相关
 *         它们的做几个用就和在bean标签中使用init-method和destroy-method的作用一样
 *          PostConstruct：表示对象初始化
 *          PreDestroy：表示对象被销毁了
 *
 *
 */
@Component
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {


   public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了！");
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。");
    }

    @PostConstruct
    public void init(){
        System.out.println("对象被创建了！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("对象被销毁了");
    }
}












































