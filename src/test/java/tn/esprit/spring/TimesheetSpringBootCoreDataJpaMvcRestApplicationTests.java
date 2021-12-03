package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest
class TimesheetSpringBootCoreDataJpaMvcRestApplicationTests {

	@Autowired
	IEmployeService empService;
	@Autowired
	ITimesheetService tmsh;

	@Test
	void contextLoads() {
		assertThat(empService).isNotNull();
		assertThat(tmsh).isNotNull();
	}

	@Test
	void TestAjouter() {
		Employe emp = new Employe("test", "test", "test", true, null);
		int i = empService.ajouterEmploye(emp);
		Assert.assertNotEquals(0, i);
	}

	@Test
	public final void TestajouterMission() {
		Mission m = new Mission("Mission", "JUnit test mission");
		int id = tmsh.ajouterMission(m);
		Assert.assertNotEquals(0, id);
	}

}