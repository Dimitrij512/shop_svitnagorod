package com.shop.svitnagorod.configuration;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan(basePackages = "com.shop.svitnagorod")
@PropertySource("classpath:application.properties")
@EnableWebMvc

public class AppConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private Environment environment;

  @Bean(name = "multipartResolver")
  public CommonsMultipartResolver getResolver() throws IOException {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();

    // Set the maximum allowed size (in bytes) for each individual file.
    resolver.setMaxUploadSizePerFile(20971520);// 5MB

    // You may also set other available properties.

    return resolver;
  }

  /** Configure TilesConfigurer. */
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml", "/WEB-INF/views/**/guest.xml",
        "/WEB-INF/views/**/user.xml", "/WEB-INF/views/**/admin.xml", "/WEB-INF/views/**/order.xml" });
    tilesConfigurer.setCheckRefresh(true);
    return tilesConfigurer;
  }

  /** Configure ViewResolvers to deliver preferred views. */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    TilesViewResolver viewResolver = new TilesViewResolver();
    registry.viewResolver(viewResolver);
  }

  /** Configure ResourceHandlers to serve static resources like CSS/ Javascript
   * etc... */

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
  }

  // @Override
  // public void
  // configureHandlerExceptionResolvers(List<HandlerExceptionResolver>
  // exceptionResolvers) {
  //
  // super.configureHandlerExceptionResolvers(exceptionResolvers);
  // SimpleMappingExceptionResolver exceptionResolver = new
  // SimpleMappingExceptionResolver();
  // exceptionResolver.setDefaultErrorView("error");
  // exceptionResolvers.add(exceptionResolver);
  //
  // }

  /** Configure MessageSource to lookup any validation/error message in
   * internationalized property files */
  @Bean
  public MessageSource messageSource() {

    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("validationMessage");
    return messageSource;
  }

  @Bean
  public JavaMailSenderImpl javaMailSenderImpl() {

    JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
    mailSenderImpl.setHost(environment.getRequiredProperty("mail.server.host"));
    mailSenderImpl.setPort(Integer.parseInt(environment.getRequiredProperty("mail.server.port")));
    mailSenderImpl.setUsername(environment.getRequiredProperty("mail.sender.setUsername"));
    mailSenderImpl.setPassword(environment.getRequiredProperty("mail.sender.setPassword"));
    return mailSenderImpl;
  }

  @Bean
  public MimeMessage mimeMessage(JavaMailSenderImpl javaMailSenderImpl) {

    MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
    return mimeMessage;
  }

}
