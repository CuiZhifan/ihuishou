package com.qianfeng.commons.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class URL {

    public static final String picURL = "http://132.232.213.216:80/ihuishou/";

    public static final String removeOrderURL = "/ihuishou/price/removeCart/";

    public static String baseURL = "/ihuishou/";

    public static final String getBaseURL(HttpServletRequest request){
        String URL = request.getRequestURL().toString();
        String str = URL.substring(0, URL.indexOf("/", 30)+1);
        baseURL = str;
        return str;
    }
}
