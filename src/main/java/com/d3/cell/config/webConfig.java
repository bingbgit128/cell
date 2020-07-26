package com.d3.cell.config;

import com.d3.cell.interceptors.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Autowired
    Environment env;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("pages/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String sharePath = env.getProperty("sharePath");

        registry.addResourceHandler("/resource/**").addResourceLocations("file:" + sharePath);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
