package com.example.springboot.config;

import com.example.springboot.Filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Autowired
    private MyFilter myFilter;

    public FilterRegistrationBean initFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setName("测试拦截器");
        filterRegistrationBean.addUrlPatterns("/user/test/*");

        return filterRegistrationBean;
    }
}
