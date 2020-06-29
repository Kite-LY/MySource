package cn.kitey.service;

/**
 * 一个业务层的接口
 */
public interface AccountService {

    /**
     * 模拟账户的保存
     */
    void saveAccount();

    /**
     * 模拟账户的更新
     * @param i
     * @return
     */
    void updateAccount(int i);

    /**
     * 模拟账户的删除
     * @return
     */
    int deleteAccount();
}
