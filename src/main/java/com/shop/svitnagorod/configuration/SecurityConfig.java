package com.shop.svitnagorod.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/login", "/logout", "/loginCheck", "/guest/", "/guest/**").permitAll()
        .antMatchers("/user/**").access("hasRole('USER')").antMatchers("/admin/**").access("hasRole('ADMIN')").and()
        .formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
        .passwordParameter("password").successHandler(authenticationHandler()).failureUrl("/login?logout=true").and()
        .csrf().disable();
  }

  @Bean
  public CustomSuccessHandler authenticationHandler() {

    return new CustomSuccessHandler();
  }

}
