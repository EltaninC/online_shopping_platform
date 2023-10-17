package com.example.online_shopping_platform.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    //控制器方法之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("Uid");
        if(user == null){
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else{
            return true;
        }
    }

    //控制器方法之后，视图数据解析之前
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //请求完成之后，视图渲染完之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
