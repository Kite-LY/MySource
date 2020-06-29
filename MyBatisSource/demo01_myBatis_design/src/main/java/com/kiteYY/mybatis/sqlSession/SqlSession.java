package com.kiteYY.mybatis.sqlSession;

/**
 * 自定义MyBatis中和数据库见交互的核心类
 *  它里面可以创建dao接口的代理对象
 */
public interface  SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao接口的字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();

}
