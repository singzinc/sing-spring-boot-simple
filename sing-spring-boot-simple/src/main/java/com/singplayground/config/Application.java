package com.singplayground.config;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;

import com.gemstone.gemfire.cache.GemFireCache;

@Configuration
@EnableAutoConfiguration
@EnableCaching
//@ComponentScan
@ComponentScan(basePackages = { "com.singplayground.controller" })
public class Application extends SpringBootServletInitializer {

	@Bean
	QuoteService quoteService() {
		return new QuoteService();
	}

	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "DataGemFireCachingApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}

	@Bean
	CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	LocalRegionFactoryBean<Integer, Integer> quotesRegion(GemFireCache cache) {
		LocalRegionFactoryBean<Integer, Integer> quotesRegion = new LocalRegionFactoryBean<>();
		quotesRegion.setCache(cache);
		quotesRegion.setClose(false);
		quotesRegion.setName("Quotes");
		quotesRegion.setPersistent(false);
		return quotesRegion;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
