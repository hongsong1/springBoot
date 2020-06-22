package com.hs.formatters;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 09:56
 **/
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date parse = null;
        try {
            parse = simpleDateFormat.parse(s);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
