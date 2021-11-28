package com.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;


import tn.esprit.spring.services.ITimesheetService;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(classes= {com.esprit.spring.TimesheetSpringBootCoreDataJpaMvcRestApplicationTests.class})
class TimesheetSpringBootCoreDataJpaMvcRestApplicationTests {

	@Autowired
	ITimesheetService ts;
	
	@Test
	void contextLoads() {
		int id = ts.ajouterMission(null);
		Assert.assertEquals(12, id);
		ts.affecterMissionADepartement(0, 0);
		ts.ajouterTimesheet(0, 0, null, null);
		ts.validerTimesheet(0, 0, null, null, 0);
		ts.findAllMissionByEmployeJPQL(0);
		ts.getAllEmployeByMission(0);
		
	}

}
