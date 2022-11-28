package com.world.Y2K.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.service.login.LoginService;
import com.world.Y2K.service.login.auth.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	

//	@Bean
//	public LogoutSuccessHandler logoutSuccessHandler() {
//		return new LogoutSuccessHandler();
//	}
	
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
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
		http.authorizeRequests()
			.antMatchers("/*.lo").permitAll()
			.anyRequest().permitAll()
		.and()
		.addFilter(new LoginService(authenticationManager()))
		.addFilter(corsFilter)
		.formLogin().disable()
//		.loginPage("/loginpage.lo")
//		.loginProcessingUrl("/login")
//		.defaultSuccessUrl("/login-success.lo")
		.userDetailsService(userDetailsService());
			
		
		http.logout()
		       .logoutUrl("/logout")
		       .logoutSuccessUrl("/")
		       .invalidateHttpSession(true);
		
		
	}

	
}


	




