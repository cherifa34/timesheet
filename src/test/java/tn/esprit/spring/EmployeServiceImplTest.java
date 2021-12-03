package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
class EmployeServiceImplTest {
	@Autowired
	IEmployeService empService;

	@Test
	void TestAjouter() {
		Employe emp = new Employe("test", "test", "test", true, null);
		int i = empService.ajouterEmploye(emp);
		Assert.assertNotEquals(0, i);
	}

}
