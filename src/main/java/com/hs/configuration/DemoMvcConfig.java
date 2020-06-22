package com.hs.configuration;

import com.hs.formatters.StringToDate;
import com.hs.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 09:53
 **/
@Configuration
public class DemoMvcConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册一个地址和视图的绑定  urlpath 是你访问的地址，setViewName 是绑定的地址  这个写 多个 路径绑定视图。
        registry.addViewController("/shou").setViewName("goods.html");

    }

    //用来定义自动时间格式转换类
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //注册一个全局日期转换类
        registry.addConverter(new StringToDate());
    }

//    自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor());
    }
}
