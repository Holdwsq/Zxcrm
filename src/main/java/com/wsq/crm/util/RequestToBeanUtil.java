package com.wsq.crm.util;

/**
 * Created by admin on 2017/7/27.
 */

import com.sun.javafx.webkit.prism.PrismInvoker;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

/**
 * 这是一个接受表单的参数，并将得到的参数封装为一个Bean对象
 */
public class RequestToBeanUtil {
    /**
     * turn方法的核心思想是找相同：req 和 tClass 一定用相同的部分，因为要将req中的参数值和cls的属性值进行自动设置
     * @param req
     * @param tClass
     * @return
     */
    public static final Object turn(HttpServletRequest req,Class tClass) throws InvocationTargetException {

        Object obj = null;
        try {
            obj = tClass.newInstance();
            Enumeration<String> em = req.getParameterNames();
            while (em.hasMoreElements()){
                String key = em.nextElement();
                String val = req.getParameter(key);
                //查找class中对应的setXXX方法
                Method[] methods = tClass.getDeclaredMethods();
                for (Method m: methods){
                    //忽略大小写
                    if(m.getName().equalsIgnoreCase("set"+key)){
                        Class pc[] = m.getParameterTypes();
                        if(pc[0].getName().equalsIgnoreCase("float")){
                            m.invoke(obj,Float.parseFloat(val));
                            break;
                        }else if (pc[0].getSimpleName().equalsIgnoreCase("int")){
                            m.invoke(obj,Integer.parseInt(val));
                            break;
                        }else if (pc[0].getSimpleName().equalsIgnoreCase("boolean")){
                            m.invoke(obj,Boolean.parseBoolean(val));
                            break;
                        }else if (pc[0].getSimpleName().equalsIgnoreCase("byte")){
                            m.invoke(obj,Byte.parseByte(val));
                            break;
                        }else if (pc[0].getSimpleName().equalsIgnoreCase("timestamp")){
                            m.invoke(obj, Timestamp.valueOf(val));
                            break;
                        }else{
                            m.invoke(obj,val);
                            break;
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
