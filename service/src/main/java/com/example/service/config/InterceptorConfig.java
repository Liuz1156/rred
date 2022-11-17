package com.example.service.config;

import com.example.service.Interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


/**
 * jwt 后台访问拦截
 * 拦截器配置文件 config
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        List<String> list = new ArrayList<>();
//        list.add("/**/login/**");
//        list.add("/answer/send/**");
//        list.add("/answer/pLogin/**");
//        list.add("/**/register/**");
//        list.add("/**/updatePasswordByPhoneNumber/**");
//        list.add("/answer/updateByMsm/**");
//        list.add("/**/checkId/**");
//        list.add("/**/setInfo/**");
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        registry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns(list);//拦截除登录以外的其他接口
//    }

}


