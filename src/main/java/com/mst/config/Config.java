package com.mst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mst.aspect.LoggingAspect;
import com.mst.beans.*;

@EnableAspectJAutoProxy
@Configuration
//@ComponentScan({"com.mst"})
public class Config {

	@Bean //another way to declare bean
	public Account account() {
		return new Account("111110",1234.1);
	}
	
	@Bean LoggingAspect aspect() {
		return new LoggingAspect();
	}
}
