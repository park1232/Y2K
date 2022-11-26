package com.world.Y2K.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

   private String uploadFolder ="C:/upload/";
   
  // private String uploadFolderProduct ="C:\\Users\\�뛾�룆踰∽옙占쏙옙由� \\Desktop\\uploadFolder/";   
   
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
//      .addResourceHandler("/upload/**") //jsp 占쎌쓡 占쎈턄占쎈┓  �굢占� �땻占� /upload/**  占쎈턄 占쎌몧 �썒�슣�닔占쎄틬 占쎌넮 �땻占� 占쎈턄  �뤃占� 占쎄텕癲�占�  �뛾�룇裕녺뙴占� 
//      .addResourceLocations("file:///"+uploadFolderProduct)
//      .setCachePeriod(60*10*6) //1 占쎈뻣�뤆占�   �뙴占� �뇡占� �뇾諛매딉옙堉� �뇡占� 占쎈펲
//      .resourceChain(true)
//      .addResolver(new PathResourceResolver());

   }
   
   @Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
   
}