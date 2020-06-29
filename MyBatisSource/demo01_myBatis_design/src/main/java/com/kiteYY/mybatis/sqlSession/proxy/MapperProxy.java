package com.kiteYY.mybatis.sqlSession.proxy;

import com.kiteYY.mybatis.cfg.Mapper;
import com.kiteYY.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;


public class MapperProxy implements InvocationHandler {

    private Connection conn;
    //map中的key是全限定类名，加方法名
    private Map<String, Mapper> mappers;
    public  MapperProxy(Map<String, Mapper> mappers, Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法进行增强，我们增强其实就是调用selectList
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取参数名
        String methodName = method.getName();
        //2.获取方法所在的类名
        String className = method.getDeclaringClass().getName();
        //3.组合mappers中的key
        String key = className +"."+ methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否含有mapper
        if(mapper == null){
            //运行时错误
            throw new IllegalAccessException("出入的参数有误！");
        }
        return new Executor().selectList(mapper,conn);
    }
}
