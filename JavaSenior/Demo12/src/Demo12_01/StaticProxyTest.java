package Demo12_01;

/**
 * 静态代理举例：
 *
 * 特点：代理类喝被代理对象都被指定了
 *
 */

interface ClothFactory{
    void produceCloth();
}
//代理类

class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;   //用被代理类进行实例化


    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作！");
        factory.produceCloth();
        System.out.println("代理工厂做了一些收尾工作！");
    }
}


//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("NIke生产运动服！");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory prxyClothFactory = new ProxyClothFactory(nike);

        prxyClothFactory.produceCloth();
    }
    }
























