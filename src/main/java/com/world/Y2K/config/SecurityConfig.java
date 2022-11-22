package com.world.Y2K.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.world.Y2K.service.login.auth.UserDetailsServiceImpl;
import com.world.Y2K.service.login.oauth.AuthenticationStore;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.userDetailsService(userDetailsService());
	
		http.csrf().disable();
		http.formLogin().disable();
		
		http.authorizeRequests()
			.antMatchers("/*.lo").permitAll()
			.anyRequest().permitAll()
		.and()
			.addFilter(new AuthenticationStore(authenticationManager()));
			

	}
	
	

	

	
	
	
}


	




