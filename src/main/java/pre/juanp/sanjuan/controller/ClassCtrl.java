package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.service.ClassServ;

@RestController
@RequestMapping("/class/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassCtrl {

	@Autowired
	private ClassServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> findAllClasses() throws Exception {
		Optional<List<pre.juanp.sanjuan.model.Class>> clasz = Optional.ofNullable(serv.findAllClasses());

		if (clasz.isEmpty()) {
			throw new Exception("There is no classes.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/byname")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> findClassesContainingName(
			@RequestParam("name") String name) throws Exception {
		Optional<List<pre.juanp.sanjuan.model.Class>> clasz = Optional.ofNullable(serv.findClassesContainingName(name));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class with a name alike.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<pre.juanp.sanjuan.model.Class> getClassById(@PathVariable("id") String id) throws Exception {
		Optional<pre.juanp.sanjuan.model.Class> nclass = Optional.ofNullable(serv.getClassById(id));

		if (nclass.isEmpty()) {
			throw new Exception("There is no class associated with the provided id.");
		}

		return ResponseEntity.ok(nclass.get());
	}

	@GetMapping("/get/byfamily/{familyId}")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> getClassesByFamily(
			@PathVariable("familyId") String familyId) throws Exception {
		Optional<List<pre.juanp.sanjuan.model.Class>> clasz = Optional.ofNullable(serv.getClassesByFamily(familyId));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided family.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/forcategory/{categoryId}")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> getClassTagsForCategory(
			@PathVariable("categoryId") String categoryId) throws Exception {
		Optional<List<pre.juanp.sanjuan.model.Class>> clasz = Optional
				.ofNullable(serv.getClassTagsForCategory(categoryId));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@PutMapping("/put/classtag/add")
	public ResponseEntity<String> addClassTagForCategory(@RequestParam("id") String id,
			@RequestParam("categoryId") String categoryId) {
		try {
			serv.addClassTagForCategory(id, categoryId);

			return ResponseEntity.ok("[Class Tag For Category Added] Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@PutMapping("/put/classtag/remove")
	public ResponseEntity<String> removeClassTagForCategory(@RequestParam("id") String id) {
		try {
			serv.removeClassTagForCategory(id);

			return ResponseEntity.ok("[Class Tag For Category Removed] Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}
}
