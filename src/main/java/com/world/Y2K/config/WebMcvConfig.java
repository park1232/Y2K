package com.world.Y2K.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class WebMcvConfig implements WebMvcConfigurer{

	
	private String uploadFolder ="C:/Users/82107/Desktop/upload/";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry
			.addResourceHandler("/upload/**") //jsp페이지에서 /upload/** 이런 주소패턴이 나오면 발동 
			.addResourceLocations("file:///"+uploadFolder)
			.setCachePeriod(60*10*6) //1시간 동안 캐싱한다
			.resourceChain(true)
			.addResolver(new PathResourceResolver());
	
		
	}
}
