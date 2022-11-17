package com.example.service.Interceptor;



import com.example.red.commonutils.JwtUtils;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JWTInterceptor implements HandlerInterceptor {
    private static String[] IGNORE_URI = {"/user/login"};
    private static Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("---------------------开始进入请求地址拦截----------------------------");
        boolean flag = false;
        String url = httpServletRequest.getRequestURL().toString();

        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            String token = httpServletRequest.getHeader("token");
            //System.out.println(token);
            if(!"".equals(token)||!token.isEmpty()) {
                try {
                    JwtUtils.getUserPhoneNumber(token);
                }catch(Exception e) {
//                    log.error("token失效，当前url：" + url);
                    System.out.println("token失效，当前url：" + url);
                    e.printStackTrace();
                    httpServletResponse.setHeader("tokenstatus", "timeout");//在响应头设置token状态
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.setContentType("text/html;charset=utf-8");
                    httpServletResponse.getWriter().print("this token is time out");
                    return false;
                }
            }else {

            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("---------------视图渲染之后的操作-------------------------");
    }
}
