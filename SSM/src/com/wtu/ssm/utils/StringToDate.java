package com.wtu.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串转换成Date类型
 * Author menglanyingfei
 * Created on 2018.01.24 14:44
 */
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return format.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
