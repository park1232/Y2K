package com.world.Y2K.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.CorsFilter;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.service.login.auth.UserDetailsServiceImpl;
import com.world.Y2K.service.login.oauth.AuthenticationStore;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	private final CorsFilter corsFilter;
	
	
	@Bean
	public LoginDAO loginDAO() {
		return new LoginDAO();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.addFilter(corsFilter);
		http.formLogin().disable();
//				.loginPage("/loginpage.lo")
//				.loginProcessingUrl("/login")
//				.defaultSuccessUrl("/success-login.lo");
		

       
		
		
		
		http.userDetailsService(userDetailsService());
	
		
		
		http.authorizeRequests()
			.antMatchers("/*.lo").permitAll()
			.anyRequest().permitAll()
		.and()
		.addFilter(new AuthenticationStore(authenticationManager()));
	//	 .addFilterBefore(new OAuthLoginFilter(),SecurityContextPersistenceFilter.class);
	
		
		
	}
	
	

	

	
	
	
}


	




