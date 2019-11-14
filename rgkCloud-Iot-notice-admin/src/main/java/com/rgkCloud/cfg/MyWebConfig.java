package com.rgkCloud.cfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rgkCloud.interceptor.LoginInterceptor;



/**
 * WebMvc配置
 *
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    
    // 默认页
    @Override
	public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("redirect:home");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		WebMvcConfigurer.super.addViewControllers(registry);
	}

//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("classpath:/META-INF/resources").addResourceLocations("classpath:/META-INF/resources");
//		WebMvcConfigurer.super.addResourceHandlers(registry);
//	}


	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("---------addInterceptors---------");
        
        // 登录拦截器
//        registry.addInterceptor(loginInterceptor())
//        		// 不需要拦截的接口
//        		.excludePathPatterns("/js/**",
//        				"/tjs/**",
//        				"/img/**",
//        				"/images/**",
//        				"/fonts/**",
//        				"/css/**",
//        				"/avatars/**",
//        				"/repair/report",
//        				"/category/all")
//        		//其他接口
//        		.addPathPatterns("/**");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
    
    
    @Bean
    public LoginInterceptor loginInterceptor() {
    	return new LoginInterceptor();
    }
    

}
