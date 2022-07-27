package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/19 20:59
 * @Description: 定义一个拦截器
 */
@SuppressWarnings({"all"})
public class LoginInterceptor implements HandlerInterceptor {
    /**在调用所有处理请求的方法之前被自动调用执行的方法*/
    /**
     * 检测全局session对象中是否有uid数据,如果有则放行,如果没有重定向到登入页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler   处理器(url + Controller:映射)
     * @return 如果返回值未true表示放行请求,如果返回值未false表示拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //HttpServletRequest对象来获取session对象
        Object uid = request.getSession().getAttribute("uid");
        if (uid == null){ //重定向到login.html页面
            response.sendRedirect("login.html");
            // 结束后续调用
            return false;
        }
        //放行
       return  true;
    }
//    /**在ModelAndView对象返回之后被调用的方法*/
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//    /**在整个请求所有关联资源被执行完毕后所执行的方法*/
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
}
