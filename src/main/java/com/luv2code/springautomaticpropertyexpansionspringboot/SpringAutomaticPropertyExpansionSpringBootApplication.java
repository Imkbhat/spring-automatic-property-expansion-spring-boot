package com.luv2code.springautomaticpropertyexpansionspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAutomaticPropertyExpansionSpringBootApplication {
	
	@Bean
	CustomBean customBean() {
		return new CustomBean(); 
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication application = new SpringApplication(SpringAutomaticPropertyExpansionSpringBootApplication.class);
		application.setBannerMode(Mode.OFF);
		ConfigurableApplicationContext ctx = application.run(args);
		CustomBean bean = ctx.getBean(CustomBean.class);
		bean.printProjectInfo();
	}
	
	 private static class CustomBean {
		 
	        @Value("${project-name}")
	        private String projectName;
	 
	        @Value("${spring-version}")
	        private String springVersion;
	 
	        @Value("${app-title}")
	        private String appTitle;
	 
	        public void printProjectInfo() {
	            System.out.printf("Project name: %s%n"
	                            + "Spring version: %s%n"
	                            + "App title: %s%n",
	                    projectName, springVersion, appTitle);
	        }
	    }
}
