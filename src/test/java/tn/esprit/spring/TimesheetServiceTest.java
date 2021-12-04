package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest
class TimesheetServiceTest {

	@Autowired
	ITimesheetService timesheet;
	
	@Autowired
	DepartementRepository deptRepoistory;

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

	/*@Test
	public final void affecterMissionADepartementTest() {
		Mission m = new Mission("Mission test for department", "Mission test for department");
		int id_mission = timesheet.ajouterMission(m);
		affecterMissionADepartementTest(); 
		Departement d = new Departement("Departement test for mission");
		deptRepoistory.save(d);
		int id_departement = d.getId();
		timesheet.affecterMissionADepartement(id_mission, id_departement);

		Assert.assertEquals(id_mission, m.getDepartement().getId());
	}*/

}
