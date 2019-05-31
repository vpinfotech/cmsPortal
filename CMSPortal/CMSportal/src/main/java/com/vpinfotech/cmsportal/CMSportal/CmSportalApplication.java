package com.vpinfotech.cmsportal.CMSportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;




@EnableScheduling
@EnableAsync(proxyTargetClass=true)
@SpringBootApplication
@ComponentScan(basePackages="com.vpinfotech.cmsportal.CMSportal.app")
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.spring.app.repository")
public class CmSportalApplication {

	private static final Logger logger = LoggerFactory.getLogger(CmSportalApplication.class);
	
	public static void main(String[] args) {
		logger.info("CmSportal started on port 8772");
		SpringApplication.run(CmSportalApplication.class, args);
	}

}
