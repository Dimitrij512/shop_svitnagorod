package com.shop.svitnagorod.configuration;

import org.springframework.beans.factory.annotation.Autowired;
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
    http.authorizeRequests().antMatchers("/guest/", "/guest/**").permitAll().antMatchers("/user/**")
        .access("hasRole('USER')").antMatchers("/admin/**").access("hasRole('ADMIN')").and().formLogin()
        .defaultSuccessUrl("/guest/", false);
    //
    //

    // http.authorizeRequests().antMatchers("/user/", "/user/login",
    // "/login").permitAll().antMatchers("/admin/**")
    // .access("hasRole('ADMIN')").antMatchers("/user/**").access("hasRole('USER')").and().formLogin()
    // .loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error").usernameParameter("username")
    // .passwordParameter("password").and().logout().logoutSuccessUrl("/loginPage?logout");
    // http.csrf().disable();

  }

}
