package com.koali.util;

import com.koali.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.util.Date;

public class ConvertUtils {
    public static <T> T convert(T t, Object[] objs) {
        Class cs = (Class) t.getClass();
        //获取类中所有属性集合
        Field[] fs = cs.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            //可访问私有属性
            fs[i].setAccessible(true);
            Field field = fs[i];
            //获取属性的完整类名
            String type = field.getGenericType().toString();
            try {
                if (type.equals("class java.lang.String")) {
                    field.set(t, (String) objs[i]);
                } else if (type.equals("class java.lang.Integer")) {
                    field.set(t, (Integer) objs[i]);
                } else if(type.equals("class java.util.Date")){
                    field.set(t, (Date)objs[i]);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
