package com.esprit.spring;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.ITimesheetService;

@SpringBootTest(classes= {com.esprit.spring.TimesheetServiceImplTest.class})
public class TimesheetServiceImplTest {

	@Autowired
	ITimesheetService ts;
	
	@Autowired
	DepartementRepository deptRepoistory;
	
	@Test
	public final void ajouterMissionTest() {
		
		Mission m = new Mission("Mission testU","ajouterMissionTest");
		int id = ts.ajouterMission(m);
		Assert.assertNotEquals(0, id);
	}
	
	@Test
	public final void affecterMissionADepartementTest() {
		
		Mission m = new Mission("Mission testU", "affecterMissionADepartementTest");
		Departement d = new Departement("Departement testU");
		int idm = ts.ajouterMission(m);
		deptRepoistory.save(d);
		int idd= d.getId();
		
		ts.affecterMissionADepartement(idm,idd);
		
		Assert.assertEquals(idd, m.getDepartement().getId());
	}
}
