package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"com.ecommerce"})
public class AppConfig extends WebMvcConfigurationSupport{
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**","images/**","js/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/images/","classpath:/static/js/");
    }
    
    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        System.out.println("--->ViewResolver");
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/jsp/");
        jspViewResolver.setSuffix(".jsp");
        jspViewResolver.setViewClass(JstlView.class);
        System.out.println("--->SetViewClass");
        return jspViewResolver;
    }
    // End of View Resolver
}

