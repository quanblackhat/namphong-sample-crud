package com.namephong.samplecrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * The class for application configuration.
 */
@Configuration
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript/Images etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/assets/**")) {
            registry.addResourceHandler("/static/assets/**").addResourceLocations("classpath:/static/assets/");
        }
    }

}
