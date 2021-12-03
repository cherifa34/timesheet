package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest
class TimesheetServiceTest {

	@Autowired
	ITimesheetService timesheet;

	@Test
	void contextLoads() {
		assertThat(timesheet).isNotNull();
	}

	@Test
	public final void TestajouterMission() {
		Mission m = new Mission("Mission test", "JUnit test mission");
		int id = timesheet.ajouterMission(m);
		Assert.assertNotEquals(0, id);
	}

}
