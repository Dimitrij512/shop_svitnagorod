package com.shop.svitnagorod.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  DataSource dataSource;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
        .usersByUsernameQuery("select username,password, 1 from user where username=?")
        .authoritiesByUsernameQuery("select username, role from user where username=?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/403", "/login", "/logout", "/products", "/contactus").permitAll()
        .antMatchers("/user/**").access("hasAuthority('USER')").antMatchers("/admin/**").access("hasAuthority('ADMIN')")
        .and().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
        .passwordParameter("password").successHandler(authenticationHandler()).failureUrl("/login?error=true").and()
        .exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {

    web.ignoring().antMatchers("/resources/**");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CustomSuccessHandler authenticationHandler() {
    return new CustomSuccessHandler();
  }

}
