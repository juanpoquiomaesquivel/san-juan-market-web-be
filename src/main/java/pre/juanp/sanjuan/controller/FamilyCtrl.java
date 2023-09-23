package pre.juanp.sanjuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.Family;
import pre.juanp.sanjuan.service.FamilyServ;

@RestController
@RequestMapping("/family/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FamilyCtrl {

	@Autowired
	private FamilyServ serv;
	
	@GetMapping("/all")
	public ResponseEntity<List<Family>> getAllFamilies() {
		List<Family> families = serv.getAllFamilies();
		
		return ResponseEntity.ok(families);
	}
}
