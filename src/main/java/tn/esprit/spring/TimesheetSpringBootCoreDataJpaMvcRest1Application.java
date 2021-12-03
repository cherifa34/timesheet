package tn.esprit.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimesheetSpringBootCoreDataJpaMvcRest1Application {
	private static final Logger LOG = LoggerFactory.getLogger(TimesheetSpringBootCoreDataJpaMvcRest1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(TimesheetSpringBootCoreDataJpaMvcRest1Application.class, args);
		LOG.error(" Log Test error");
		LOG.trace(" Log Test trace");
		LOG.info(" Log Test info");
		LOG.warn(" Log Test warn");
		LOG.debug(" Log Test debug");

	}

}