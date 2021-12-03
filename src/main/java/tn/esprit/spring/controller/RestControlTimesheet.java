package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControlTimesheet {

	private static final Logger L = Logger.getLogger(RestControlTimesheet.class);
	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;

	// http://localhost:8081/SpringMVC/servlet/ajouterMission
	// {"id":4,"name":"mamission", "description":"c ma mission"}
	@PostMapping("/ajouterMission")
	@ResponseBody
	public int ajouterMission(@RequestBody Mission mission) {
		try {
			itimesheetservice.ajouterMission(mission);
			return mission.getId();
		} catch (Exception e) {
			L.error("there is an error while executing : ajouterMission() : " + e);
		}
		return 0;
	}

	// http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
	@PutMapping(value = "/affecterMissionADepartement/{idmission}/{iddept}")
	public void affecterMissionADepartement(@PathVariable("idmission") int missionId,
			@PathVariable("iddept") int depId) {
		try {
			itimesheetservice.affecterMissionADepartement(missionId, depId);
		} catch (Exception e) {
			L.error("there is an error while executing : affecterMissionADepartement() : " + e);
		}

	}

	// http://localhost:8081/SpringMVC/servlet/ajouterTimesheet
	// {"missionId":1,"employeId":2,"dateDebut":"2020-03-01","dateFin":"2021-03-01"}

	@PostMapping("/ajouterTimesheet/idmission/idemp/dated/datef")
	@ResponseBody
	public void ajouterTimesheet(@PathVariable("idmission") int missionId, @PathVariable("idemp") int employeId,
			@PathVariable("dated") Date dateDebut, @PathVariable("datef") Date dateFin) {

		try {
			itimesheetservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);
		} catch (Exception e) {
			L.error("there is an error while executing : affecterMissionADepartement() : " + e);
		}

	}

	// http://localhost:8081/SpringMVC/servlet/affecterMissionADepartement/4/4
	@PutMapping(value = "/validerTimesheet/{idmission}/{iddept}")
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		try {
			itimesheetservice.validerTimesheet(missionId, employeId, dateDebut, dateFin, validateurId);
		} catch (Exception e) {
			L.error("there is an error while executing : validerTimesheet() : " + e);
		}

	}

	// URL : http://localhost:8081/SpringMVC/servlet/findAllMissionByEmployeJPQL/1
	@GetMapping(value = "findAllMissionByEmployeJPQL/{idemp}")
	@ResponseBody
	public List<Mission> findAllMissionByEmployeJPQL(@PathVariable("idemp") int employeId) {
		try {
			return itimesheetservice.findAllMissionByEmployeJPQL(employeId);
		} catch (Exception e) {
			L.error("there is an error while executing : findAllMissionByEmployeJPQL() : " + e);
		}
		return null;
		
	}

	// URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByMission/1
	@GetMapping(value = "getAllEmployeByMission/{idmission}")
	@ResponseBody
	public List<Employe> getAllEmployeByMission(@PathVariable("idmission") int missionId) {
		try {
			L.info("In getAllEmployeByMission() : ");
			return itimesheetservice.getAllEmployeByMission(missionId);
		} catch (Exception e) {
			L.error("there is an error while executing : getAllEmployeByMission() : " + e);
		}
		return null;
	}
}