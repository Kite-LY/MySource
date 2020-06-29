package Demo12_01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 */

interface Human{
    String getBelive();
    void eat(String food);
}

//创建被代理类
class SuperMan implements Human{

    @Override
    public String getBelive() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃：" + food);
    }
}


/**
 * 想要实现动态代理需要实现的问题
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法的时候，如何动态的去调用类中的同名方法
 *
 */

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj :被代理对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }


}

class HumanUtil{

    public void method1(){
        System.out.println("--------------通用方法一 --------------");
    }

    public void method2(){
        System.out.println("--------------通用方法二 --------------");
    }

}

class MyInvocationHandler implements InvocationHandler{

    HumanUtil human = new HumanUtil();
    private Object obj; //需要声明被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj = obj;
    }

    //当我梦通过代理类的对象，调用方法a时，就会自懂的调用如下的方法：invoke()
    //当被代理对象要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        human.method1();
        //method:为代理对象调用的方法，此方法也作为了被代理对象的调用方法
        //obj:被代理的对象
        //上述方法的放回置就作为当前类中的invoke()的返回值
        Object invoke = method.invoke(obj, args);

        human.method2();
        return invoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human  proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelive());
        proxyInstance.eat("安徽火锅！");

        System.out.println("--------------------------------");
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();
    }
}






























