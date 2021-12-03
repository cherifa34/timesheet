package com.esprit.spring;

import javax.management.relation.Role;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.TimesheetServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = { com.esprit.spring.TimesheetServiceImplTest.class })
public class TimesheetServiceImplTest {

	@Autowired
	TimesheetServiceImpl itimesheetservice;

	@Test
	public final void ajouterMissionTest() {
		Mission m = new Mission("Mission", "JUnit test mission");
		int id = itimesheetservice.ajouterMission(m);
		Assert.assertNotEquals(0, id);
	}

	/*
	 * @Test public final void affecterMissionADepartementTest() { Mission m =
	 * new Mission("Mission test for department",
	 * "Mission test for department"); int id_mission = ts.ajouterMission(m);
	 * Departement d = new Departement("Departement test for mission");
	 * deptRepoistory.save(d); int id_departement = d.getId();
	 * ts.affecterMissionADepartement(id_mission,id_departement);
	 * 
	 * Assert.assertEquals(id_mission, m.getDepartement().getId()); }
	 */

	/*
	 * @Test public final void ajouterTimesheetTest() { Employe e = new
	 * Employe("Nermine", "Ayeb", "ayeb.nermin@esprit.tn", true,
	 * tn.esprit.spring.entities.Role.ADMINISTRATEUR);
	 * employeRepository.save(e); int id_employe = e.getId(); Mission m = new
	 * Mission("Mission ajout timesheet", "ajouterTimesheetTest"); int
	 * id_mission = ts.ajouterMission(m);
	 * 
	 * TimesheetPK t = new TimesheetPK(id_mission, id_employe, null, null);
	 * 
	 * }
	 */
}
