package com.koali.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import ognl.DefaultTypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 日期转换器
 */
public class MyDateConverter extends DefaultTypeConverter {
    //日期格式
    final DateFormat[] dfs = {new SimpleDateFormat("yyyy年MM月dd日"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy.MM.dd")};

    @Override
    public Object convertValue(Map context, Object value, Class toType) {
        System.out.println("进入");
        if (toType == Date.class) {
            String dateStr = ((String[]) value)[0];
            System.out.println("form:" + dateStr);
            for (int i = 0; i < dfs.length; i++) {
                try {
                    return dfs[i].parse(dateStr);
                } catch (ParseException e) {
                    continue;
                }
            }

        } else if (toType == String.class) {
            Date date = (Date) value;
            return dfs[0].format(date);
        }
        throw new TypeConversionException();
    }


}
