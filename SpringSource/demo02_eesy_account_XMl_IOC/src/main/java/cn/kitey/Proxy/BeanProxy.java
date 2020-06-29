package cn.kitey.Proxy;

import cn.kitey.service.AccountService;
import cn.kitey.service.impl.AccountServiceImpl;
import cn.kitey.utils.TransactionManger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象
 */
public class BeanProxy {
    AccountService accountService;
    private TransactionManger tManger;

    public void settManger(TransactionManger tManger) {
        this.tManger = tManger;
    }

    /**
     * 通过注入的方式注入数据
     */
    public final void setAccountService(AccountService accountService) {

    }

    /**
     * 获取service的代理对象
     * @return
     */
    public AccountService getAccountService() {
       return(AccountServiceImpl) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object value = null;
                        //实现到方法增强
                        try {
                            //1.开启事务
                            tManger.beginTransaction();
                            //2.执行操作
                            value = method.invoke(accountService, args);
                            //3.提交事务
                            tManger.commitTransaction();
                            //返回结果
                            return value;
                        } catch (Exception e) {
                            //5.回滚操作
                            tManger.rollbackTransaction();
                            //产生错误了，程序就不在继续运行
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            tManger.relaseTransaction();
                        }
                    }
                }
        );

    }

}
