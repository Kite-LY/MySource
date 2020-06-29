package cn.kitey.proxy;


/**
 * 一个生产厂家
 */
public class Producer implements ProducerInterface{

    /**
     * 销售
     */
    public void saleProduct(double money){
        System.out.println("销售产品，获取金钱：" + money);
    }

    /**
     * 售后服务
     * @param money
     */
    public void afterService(double money){
        System.out.println("提供售后服务：" + money);
    }
}
