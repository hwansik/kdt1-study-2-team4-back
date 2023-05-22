package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://127.0.0.1:8080",
                        "http://localhost:8080",
                        "http://3.38.61.219", // 다운
                        "http://ec2-3-38-61-219.ap-northeast-2.compute.amazonaws.com/",
                        "http://43.200.129.17", // 여울
                        "http://ec2-43-200-129-17.ap-northeast-2.compute.amazonaws.com/",
                        "http://43.202.26.168", // 주아
                        "http://ec2-43-202-26-168.ap-northeast-2.compute.amazonaws.com/",
                        "http://3.37.12.230",
                        "http://ec2-3-37-12-230.ap-northeast-2.compute.amazonaws.com")

                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
