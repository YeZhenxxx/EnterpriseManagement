package com.oioip.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *
 * 字符串转日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s!=null){
            try {
                SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
                return sf.parse(s);
            } catch (ParseException e) {
                throw new RuntimeException("日期转换失败");
            }
        }else {
            throw new RuntimeException("日期不能未空");
        }
    }
}
