package pre.juanp.sanjuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.service.ClassServ;

@RestController
@RequestMapping("/class/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassCtrl {

	@Autowired
	private ClassServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> getAllClasses() {
		List<pre.juanp.sanjuan.model.Class> classes = serv.getAllClasses();

		return ResponseEntity.ok(classes);
	}

	@GetMapping("/get/byfamily/{familyId}")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> getClassesByFamily(
			@PathVariable("familyId") String familyId) {
		List<pre.juanp.sanjuan.model.Class> classes = serv.getClassesByFamily(familyId);

		return ResponseEntity.ok(classes);
	}

	@GetMapping("/get/bycategory/{classId}")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> getClassesByCategory(
			@PathVariable("classId") String classId) {
		List<pre.juanp.sanjuan.model.Class> classes = serv.getClassesByCategory(classId);

		return ResponseEntity.ok(classes);
	}
}
