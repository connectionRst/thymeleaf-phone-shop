package com.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "";
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            path = System.getProperty("user.dir") + "/src/main/resources/static";
        } else {
            path = System.getProperty("user.dir") +"/img";
        }
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + path + "/images/");
    }



}
