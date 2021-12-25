package io.mtech.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("mahadi").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("arisha").password("test012").roles("MANAGER"))
				.withUser(users.username("ariba").password("test012").roles("ADMIN"));
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
http.authorizeRequests()
.anyRequest().authenticated()
.and()
.formLogin()
//.loginPage("/loginPage") //normal login page
.loginPage("/fancyLogin") //Bootstrap Login form
.loginProcessingUrl("/authenticatedTheUser")
.permitAll()
.and()
.logout()
.permitAll();

	}

	
}
