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
class TimesheetServiceImplTest {

	
	@Autowired
	ITimesheetService tmsh;

	@Test
	void contextLoads() {
		assertThat(tmsh).isNotNull();
	}

	@Test
	public final void ajouterMissionTest() {
		Mission m = new Mission("Mission TestU", "ajouterMissionTest");
		int id = tmsh.ajouterMission(m);
		Assert.assertNotEquals(0, id);
	}
}

