package com.world.Y2K.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

   private String uploadFolder ="C:/upload/";
   
  // private String uploadFolderProduct ="C:\\Users\\獄쏅벡���릯 \\Desktop\\uploadFolder/";   
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      
      WebMvcConfigurer.super.addResourceHandlers(registry);
      
      registry
         .addResourceHandler("/upload/**") 
         .addResourceLocations("file:///"+uploadFolder)
         .setCachePeriod(60*10*6) 
         .resourceChain(true)
         .addResolver(new PathResourceResolver());
      
//      registry
//      .addResourceHandler("/upload/**") //jsp �읂 �뵠�릯  肉� 苑� /upload/**  �뵠 �쑕 雅뚯눘�꺖 �솭 苑� �뵠  援� �궎簾�  獄쏆뮆猷� 
//      .addResourceLocations("file:///"+uploadFolderProduct)
//      .setCachePeriod(60*10*6) //1 �뻻揶�   猷� 釉� 營밸Ŋ�뼓 釉� �뼄
//      .resourceChain(true)
//      .addResolver(new PathResourceResolver());

   }
   
   
}