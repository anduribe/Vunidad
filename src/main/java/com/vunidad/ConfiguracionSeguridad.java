package com.vunidad;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


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
			.withUser("1234").password("$2a$10$6GL9S7zSlvHKXEXpRw0rIe4Le9NIG5hZmuhL3zqp5nWGMtU5DkDea").roles("ADMIN")
			.and()
			.withUser("12345").password("$2a$10$uEQKxVwPo5hQ2YWGsK7l/.58FfV9xzjS4Pg7RVvvRl/c7orW2B1yW").roles("PRO");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/display").hasRole("USER")
			.antMatchers("/admindashboard","/logs","/displaymejoras","/displayasesorias","/displaychecklist","/displaypvisitas","/displayiclientes","/displayprofesionales","/displayaccidentabilidad").hasRole("ADMIN")
			.antMatchers("/adminprofesional","/displaymejoras","/displayasesorias","/displaychecklist","/displaypvisitas","/displayiclientes").hasAnyRole("ADMIN","PRO")
			.and().formLogin().loginPage("/login")
				.successHandler(successHandler)
			.permitAll()
			.and()
		     .exceptionHandling().accessDeniedPage("/fuera")
			.and().logout();
	}
}
