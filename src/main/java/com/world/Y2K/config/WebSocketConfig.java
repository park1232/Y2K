package com.world.Y2K.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.world.Y2K.handle.EchoHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler(), "/echo");
	}
	
	@Bean
	public WebSocketHandler echoHandler() {
		return new EchoHandler();
	}
	
	@Bean
	public ServletServerContainerFactoryBean configureWebSocketContainer() {
		ServletServerContainerFactoryBean factory = new ServletServerContainerFactoryBean();
		factory.setMaxBinaryMessageBufferSize(16384); //바이너리 버퍼 크기 지정 16KB
		factory.setMaxTextMessageBufferSize(16384);  //텍스트 버퍼 크기 지정 16KB
		factory.setMaxSessionIdleTimeout(TimeUnit.MINUTES.convert(30, TimeUnit.MILLISECONDS)); //비동기 세션 타임아웃 시간 30분
		factory.setAsyncSendTimeout(TimeUnit.SECONDS.convert(5, TimeUnit.MILLISECONDS)); //비동기 전송 타입아웃 시간 5초
		return factory;
	}
	
}
