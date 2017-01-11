package com.shop.svitnagorod.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.shop.svitnagorod")
public class AppConfig extends WebMvcConfigurerAdapter {

  /** Configure TilesConfigurer. */
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml", "/WEB-INF/views/**/guest.xml",
        "/WEB-INF/views/**/user.xml", "/WEB-INF/views/**/admin.xml" });
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

  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    super.configureHandlerExceptionResolvers(exceptionResolvers);
    SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
    exceptionResolver.setDefaultErrorView("error");
    exceptionResolvers.add(exceptionResolver);

  }

}
