package com.world.Y2K.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

   private String uploadFolder ="C:/Users/82107/Desktop/upload/";
   
   private String uploadFolderProduct ="C:\\Users\\諛뺤쑀吏 \\Desktop\\uploadFolder/";   
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      
//      WebMvcConfigurer.super.addResourceHandlers(registry);
      
      registry
         .addResourceHandler("/upload/**") //jsp 럹 씠吏  뿉 꽌 /upload/**  씠 윴 二쇱냼 뙣 꽩 씠  굹 삤硫  諛쒕룞 
         .addResourceLocations("file:///"+uploadFolder)
         .setCachePeriod(60*10*6) //1 떆媛   룞 븞 罹먯떛 븳 떎
         .resourceChain(true)
         .addResolver(new PathResourceResolver());
      
//      registry
//      .addResourceHandler("/upload/**") //jsp 럹 씠吏  뿉 꽌 /upload/**  씠 윴 二쇱냼 뙣 꽩 씠  굹 삤硫  諛쒕룞 
//      .addResourceLocations("file:///"+uploadFolderProduct)
//      .setCachePeriod(60*10*6) //1 떆媛   룞 븞 罹먯떛 븳 떎
//      .resourceChain(true)
//      .addResolver(new PathResourceResolver());

   }
   
   
}