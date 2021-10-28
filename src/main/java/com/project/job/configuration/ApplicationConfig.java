package com.project.job.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;



/**
 * @author Elhem NOURI
 *
 */

@Configuration
public class ApplicationConfig {

	@Bean
	public Jaxb2RootElementHttpMessageConverter xmlMessageConverter(){
		return new Jaxb2RootElementHttpMessageConverter();
	}




	  @Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(0);
		return messageSource;
	}
}
