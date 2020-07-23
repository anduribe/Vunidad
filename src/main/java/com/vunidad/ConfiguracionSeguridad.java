package com.vunidad;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	//vamos a encriptar la clave
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("123").password("$2a$10$5.zbF9YwBjPb0zHJKe7m.e.ZrbgGAS7nCb0ENvDCWeSny21W8oT/.").roles("USER")
			.and()
			.withUser("1234").password("$2a$10$6GL9S7zSlvHKXEXpRw0rIe4Le9NIG5hZmuhL3zqp5nWGMtU5DkDea").roles("ADMIN");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/userDashboard").hasAnyRole("USER")
			.antMatchers("/adminDashboard").hasAnyRole("ADMIN")
			.and().formLogin().loginPage("/login")
				.successHandler(successHandler)
			.permitAll()
			.and().logout();
	}
}	