package com.myprojectlist.springboot.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
	/**
	 * 设置cookie
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge){
	    Cookie cookie = new Cookie(name,value);
	    cookie.setPath("/");
	    if(maxAge>0){  cookie.setMaxAge(maxAge);}
	    response.addCookie(cookie);
	}
	
	/**
	 * 根据名字获取cookie
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name){
	    Map<String,Cookie> cookieMap = ReadCookieMap(request);
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	} 
	public static String getUserInfo(HttpServletRequest request, String name){
		Cookie[] cookies = request.getCookies();
        String userInfo = "";
        if(cookies!=null){
        	userInfo = "";
            for (int i = 0; i < cookies.length; i++){
               Cookie c = cookies[i];
               if(c.getName().equalsIgnoreCase(name)){
            	   userInfo = c.getValue();
               }
            }
    	}
        return userInfo;
	}
	
	/**
	 * 根据字符串将对应的cookle转成map
	 * names 如 "keys1,keys2" 
	 */
	public static Map<String,String> getCookieMapByNames(HttpServletRequest request, String names){
		Map<String,String> cookieMap = new HashMap<String,String>();
		String dercName = "," + names + ",";
		Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (int i = 0; i < cookies.length; i++){
               Cookie c = cookies[i];
               //即使keys是空，也是false
               if(dercName.indexOf(","+c.getName()+",")!=-1 && StringUtils.isNotBlank(c.getValue())){
            	   cookieMap.put(c.getName(), c.getValue());
               }
            }
    	}
        return cookieMap;
	}
	
	/**
	 * cookie检测 
	 */
	public static boolean checkCookieByNames(HttpServletRequest request, String names){
		String[] arr = names.split(",");
		int num = 0;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i = 0; i < cookies.length; i++){
			    Cookie c = cookies[i];
				for(String str:arr){
					if(str.equals(c.getName()) && StringUtils.isNotBlank(c.getValue())){
						num++;
					}
				}
			}
		}
		return num == arr.length;
	}
	
	/**
	 * cookie删除 
	 */
	
	public static void deleteCookieByNames(HttpServletRequest request, String names, HttpServletResponse resp){
		String dercName = "," + names + ",";
		Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (int i = 0; i < cookies.length; i++){
               Cookie c = cookies[i];
               //即使keys是空，也是false
               if(dercName.indexOf(","+c.getName()+",")!=-1){
            	   Cookie cookie = new Cookie(c.getName(), null);
            	   cookie.setMaxAge(0);
            	   cookie.setPath("/");
            	   resp.addCookie(cookie);
               }
            }
    	}
	}

}
