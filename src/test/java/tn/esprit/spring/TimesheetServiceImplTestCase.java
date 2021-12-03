package tn.esprit.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { tn.esprit.spring.TimesheetServiceImplTestCase.class })
class TimesheetServiceImplTestCase {

@Autowired
ITimesheetService itimesheetservice;


@Test
	public final void ajouterMissionTest() {
		Mission m = new Mission("Mission TestU", "ajouterMissionTest");
		int id = itimesheetservice.ajouterMission(m);
		Assert.assertNotEquals(0, id);
	}
}