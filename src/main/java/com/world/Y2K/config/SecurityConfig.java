package com.world.Y2K.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.world.Y2K.service.login.auth.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		System.out.println("½ÇÇàµÊ?");
		
		http.userDetailsService(userDetailsService());
		
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/*.lo").permitAll()
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/loginpage.lo")
			.loginProcessingUrl("/auth/login")
			.defaultSuccessUrl("/login-success.lo")
			.usernameParameter("username")
			.passwordParameter("password");
			
		http.headers().frameOptions().sameOrigin();
		
		return http.build();
	}
	

	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return new WebSecurityCustomizer() {
				@Override
				public void customize(WebSecurity web) {
					web.ignoring().antMatchers("/resources/**");
				}
			};
	    }
	
	
}




