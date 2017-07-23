package com.wsq.crm.util;

/**
 * Created by admin on 2017/7/23.
 */

import javax.servlet.http.HttpServletRequest;

/**
 * 通用工具类
 *
 */
public final class Global {
    public static String getLoginURL(HttpServletRequest request){
        return request.getContextPath()+getLoginURL();
    }
    public static String getLoginURL(){
        return "/index.jsp";
    }
}
