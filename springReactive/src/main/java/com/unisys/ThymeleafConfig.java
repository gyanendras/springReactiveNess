package com.unisys;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.SpringWebFluxTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.spring6.view.reactive.ThymeleafReactiveViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.DefaultTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;

@Configuration
public class ThymeleafConfig {
	
	
	
	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
		SpringWebFluxTemplateEngine templateEngine = new SpringWebFluxTemplateEngine();
		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
		return templateEngine;
	}

	@Bean
	public SpringResourceTemplateResolver thymeleafTemplateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("templates/"); // Set your template prefix here
		templateResolver.setSuffix(".html"); // Set your template suffix here
		templateResolver.setTemplateMode("HTML"); // Set your template mode here
		return templateResolver;
	}
	
	

}
