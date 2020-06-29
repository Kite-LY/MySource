package cn.kitey.cglib;

import cn.kitey.proxy.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于子类的动态代理
 */
public class ClientCglib {


    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         *  基于子类的动态代理；
         *      涉及的类：Enhancer
         *      提供者：第三方cglib类库
         *  如何创建代理对象：
         *      使用Enhancer类中的create方法
         *  创建代理对象的要求：
         *      被代理的对象不能是最终实现类
         *   create方法中的方法参数
         *      Class:字节码
         *           用于指定被代理对象的字节码
         *   Callback：提供增强代码
         *          一般书写的为该接口的实现类：MethodInterceptor（方法拦截）
         *
         */
        Producer proEnhancer= (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy   当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //这里提供增强方法
                Object newMoney = null;
                //获取被代理对象的参数
                double oldMoney = (Double) args[0];
                //判断执行的方法
                if("saleProduct".equals(method.getName())){
                    newMoney = method.invoke(producer, oldMoney * 0.5);
                }
                return newMoney;
            }
        });

        proEnhancer.saleProduct(1000);
    }
}
