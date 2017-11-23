package com.common.test.demo6_kt.controllerInterceptor;


import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class ControllerInterceptor extends HandlerInterceptorAdapter {

    private final NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("StopWatch-StartTime");

//    @Reference
//    private UserInfoService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        long beginTime = System.currentTimeMillis();//1、开始时间  
        startTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）

        watchRequestParams(request);

        // TODO: 2017/3/21 test 
//        Principal principal = request.getUserPrincipal();
//        if (null != principal && null != principal.getName()) {
//            User user = this.userService.findUserByMobile(principal.getName());
//            if (null != user) {
//                ThreadLocalUserUtils.setUser(UserType.CUSTOMER.name() + "_" + user.getId());
//            }
//        }


        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long endTime = System.currentTimeMillis();//2、结束时间  
        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
        long consumeTime = endTime - beginTime;//3、消耗的时间  
        if (consumeTime > 50) {//此处认为处理时间超过500毫秒的请求为慢请求  
            //TODO 记录到日志文件  
            System.out.println(String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
        }
    }

    private void watchRequestParams(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("requestURI:\t").append(request.getRequestURI())
                .append("\r\n\tuser-agent:\t").append(request.getHeader("user-agent"))
                .append("\r\n\trequestParams:\t");
        Enumeration<String> parameterNames = request.getParameterNames();
        String parameterName;
        while (parameterNames.hasMoreElements()) {
            parameterName = parameterNames.nextElement();
            sb.append(parameterName).append("=").append(request.getParameter(parameterName)).append("\t");
        }

        sb.append("\r\n");
        sb.append("\r\n\theaderParams:\t");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            parameterName = headerNames.nextElement();
            String value = request.getHeader(parameterName);
            if (value.contains("\\u")) {
                value = StringRegExUtil.unicode2Str(value);
            }
            sb.append(parameterName).append("=").append(value).append("\t");
        }
        sb.append("\r\n");
        System.out.println(sb.toString());
    }
}
