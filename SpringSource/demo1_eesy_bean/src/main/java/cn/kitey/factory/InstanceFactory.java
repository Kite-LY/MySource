package cn.kitey.factory;

import cn.kitey.service.IAccountService;
import cn.kitey.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（可能是存在jar包中，无法进行更改）
 */
public class InstanceFactory {
    public IAccountService getAccountService(){
        return  new AccountServiceImpl();
    }
}
