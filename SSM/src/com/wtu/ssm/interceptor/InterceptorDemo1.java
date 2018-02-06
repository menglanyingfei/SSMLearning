package com.wtu.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * Author menglanyingfei
 * Created on 2018.01.25 9:41
 */
public class InterceptorDemo1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /**
         * 在执行Handler方法前调用该方法, 真正实现拦截的方法
         * return true: 表示将该请求放行
         * return false: 表示不让请求继续往下执行
         */
        System.out.println("InterceptorDemo1 拦截请求! preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        /**
         * 在进入Handler以后, 返回ModelAndView之前执行
         */
        System.out.println("InterceptorDemo1 postHandle ");
    }

    /**
     * 该方法是在Handler执行完毕以后再调用该方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("InterceptorDemo1 afterCompletion");
    }
}
