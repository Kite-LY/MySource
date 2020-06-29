package cn.kitey.proxy;

import java.math.BigDecimal;

/**
 * 生厂商要求
 */
public interface ProducerInterface  {
    /**
     * 销售
     */
    public void saleProduct(double money);

    /**
     * 售后服务
     * @param money
     */
    public void afterService(double money);
}
