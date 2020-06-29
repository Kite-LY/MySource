package com.kiteYY.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器 读取文件
 */
public class Resources {

    /**
     * 根据传入的参数获取一个字节输入流
     */
    public static InputStream getResourceAsStream(String filePath){
        /*
        分三步：
        1.拿到类的字节码
        2.获取类加载器
        3.读取文件配置
         */
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
