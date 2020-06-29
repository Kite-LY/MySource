package cn.kitey.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换为日期
 */
public class StringToDate implements Converter<String, Date> {

    /**
     *
     * @param source 传入的要转换的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        //进行判断
        if(source == null){
            throw new RuntimeException("您输入的数据为空");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转为时间类型
        try {
            return df.parse(source);
        } catch (Exception e) {
           throw new RuntimeException("数据转换失败！");
        }



    }
}
