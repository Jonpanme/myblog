package com.mp.interceptor;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author meipeng
 * @date 2019-11-4 10:20
 * @function 登录拦截，相当于一张网，主要通过request获取到session，看session里面有没用户信息
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if(request.getSession().getAttribute("user")==null){ //没有登录
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
