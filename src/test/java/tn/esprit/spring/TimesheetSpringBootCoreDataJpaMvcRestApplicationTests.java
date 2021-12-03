package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
class TimesheetSpringBootCoreDataJpaMvcRestApplicationTests {

	@Autowired
	IEmployeService empService;

	@Test
	void contextLoads() {
		assertThat(empService).isNotNull();
	}

}
