package cn.kitey.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  模拟消费者
 */
public class Client {

    public static void main(String[] args) {
        //匿名内部类访问时要求是最终的
        final Producer producer = new Producer();



        /**
         * 动态代理：
         *  特点：字节码随意创建，随用随加载
         *  作用：不修改源码的基础上，对方法进行加强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *
         *  基于接口的动态代理；
         *      涉及的类：Proxy
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance
         *  创建代理对象的要求：
         *      被代理的对象至少实现一个接口，如果没有，则不能进行实现
         *   newProxyInstance中的方法参数
         *      ClassLoader:类加载器
         *          适用于加载代理对象的字节码，和被带你的对象使用相同的类加载器(固定写法)
         *      Class[]:字节码数组
         *          是用于代理对象和被代理对象拥有相同的方法（固定的写法）
         *      InvocationHandler:用于提供增强的代码
         *          让我们写如何代理，一般都是些一个接口的实现类，通常情况下是匿名类，但不是必须的
         *          此接口的实现类谁用谁写
         */
        //(近似于经销商)
         ProducerInterface producerInterface  = (ProducerInterface) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy     代理对象的引用（一般不用）
                     * @param method    当前执行的方法
                     * @param args      当前执行方法所需要的参数
                     * @return          和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //获取以前的金钱数据
                        double oldMoney = (Double) args[0];
                        //提供增强代码
                        Object newMoney = null;
                        //判断是不是销售产品
                        if("saleProduct".equals(method.getName())){
                            newMoney = method.invoke(producer, oldMoney * 0.8);
                        }
                        return  newMoney;
                    }
                });


        /**
         * 现在存在一个需求，经过了经销商，产家只能获取百分之八十的钱
         */
        producerInterface.saleProduct(1000);





    }


}





















