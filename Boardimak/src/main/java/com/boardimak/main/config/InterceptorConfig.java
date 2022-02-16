package com.boardimak.main.config;

import com.boardimak.main.constant.Constant;
import com.boardimak.main.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean(name = "AuthorizationBean")
    AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authorizationInterceptor())
                .addPathPatterns(
                        Constant.AUTH_API_PATTERNS.DUMMIES,
                        Constant.AUTH_API_PATTERNS.USERS,
                        Constant.AUTH_API_PATTERNS.TICKET);
    }
}
