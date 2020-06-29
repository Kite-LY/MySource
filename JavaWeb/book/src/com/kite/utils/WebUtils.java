package com.kite.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 将map中的值注入到，bean中，使用map  而不是用httpServletRequest可以让代码的耦合度变高
     * @param value
     * @param bean
     */

    public static <T> T copyParamToBean(Map value, T bean){


        try {
            System.out.println("注入之前：" + bean);
            //把所有的请求参数都注入到bean中

            //这里调用了User类中的set()方法对属性进行赋值的。
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }
        return bean;
    }

    /**
     * 将字符串类型的值转换为Int类型的数值
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue){

        try {
            //转换数据的代码
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
          //  e.printStackTrace();
        }
        //如果转换失败返回默认值
        return defaultValue;

    }
 }
