package com.shop.svitnagorod.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

import com.shop.svitnagorod.service.facebookOAuth.FacebookSignInAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;

	@Autowired
	private UsersConnectionRepository usersConnectionRepository;

	@Autowired
	private FacebookSignInAdapter facebookSignInAdapter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select login,password, 1 from user where login=?").authoritiesByUsernameQuery("select login, role from user where login=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/403", "/login", "/logout", "/registration", "/products", "/contactus", "/spring-websocket/**").permitAll().antMatchers("/user/**").access("hasAuthority('CUSTOMER')").antMatchers("/admin/**").access("hasAuthority('ADMIN')").and().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("login").passwordParameter("password").successHandler(authenticationHandler()).failureUrl("/login?error=true").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/resources/**");
	}

	//	@Bean
	//	public PasswordEncoder passwordEncoder() {
	//		return new BCryptPasswordEncoder();
	//	}

	@Bean
	public CustomSuccessHandler authenticationHandler() {
		return new CustomSuccessHandler();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public ProviderSignInController providerSignInController() {
		ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, facebookSignInAdapter);
		controller.setSignUpUrl("/facebook/signup");

		return controller;
	}

}
