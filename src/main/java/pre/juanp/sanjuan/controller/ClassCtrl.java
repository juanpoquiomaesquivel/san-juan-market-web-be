package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.Message;
import pre.juanp.sanjuan.model.dto.administrator.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.administrator.ClassOptionGroupDTO;
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
			@RequestParam("Name") String name) throws Exception {
		Optional<List<pre.juanp.sanjuan.model.Class>> clasz = Optional.ofNullable(serv.findClassesContainingName(name));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class with a name alike.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<pre.juanp.sanjuan.model.Class> getClassByCode(@PathVariable("Code") String code)
			throws Exception {
		Optional<pre.juanp.sanjuan.model.Class> nclass = Optional.ofNullable(serv.getClassByCode(code));

		if (nclass.isEmpty()) {
			throw new Exception("There is no class associated with the provided code.");
		}

		return ResponseEntity.ok(nclass.get());
	}

	@GetMapping("/get/byfamily/{FamilyId}")
	public ResponseEntity<List<pre.juanp.sanjuan.model.Class>> getClassesByFamily(
			@PathVariable("FamilyId") Integer familyId) throws Exception {
		Optional<List<pre.juanp.sanjuan.model.Class>> clasz = Optional.ofNullable(serv.getClassesByFamily(familyId));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided family.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/forcategory/{CategoryId}")
	public ResponseEntity<List<Integer>> getClassTagsForCategory(@PathVariable("CategoryId") Integer categoryId)
			throws Exception {
		Optional<List<Integer>> clasz = Optional.ofNullable(serv.getClassTagsForCategory(categoryId));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/classoption/forcategory/{CategoryId}")
	public ResponseEntity<List<ClassOptionDTO>> getCurrentClassTagOptionsForCategory(
			@PathVariable("CategoryId") Integer categoryId) throws Exception {
		Optional<List<ClassOptionDTO>> clasz = Optional
				.ofNullable(serv.getCurrentClassTagOptionsForCategory(categoryId));

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@GetMapping("/get/classoption/available/all")
	public ResponseEntity<List<ClassOptionDTO>> getAvailableClassOptionList() throws Exception {
		Optional<List<ClassOptionDTO>> clasz = Optional.ofNullable(serv.getAvailableClassOptionList());

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(clasz.get());
	}

	@PutMapping("/put/classtag/forcategory/{CategoryId}/add")
	public ResponseEntity<Message> addClassTagForCategory(@PathVariable("CategoryId") Integer categoryId,
			@RequestBody String jsonArrayId) {
		serv.addClassTagForCategory(jsonArrayId, categoryId);

		return ResponseEntity.ok(new Message(101, "Los tags han sido anadidos."));
	}

	@PutMapping("/put/classtag/remove")
	public ResponseEntity<Message> removeClassTagForCategory(@RequestBody String jsonArrayId) {
		serv.removeClassTagForCategory(jsonArrayId);

		return ResponseEntity.ok(new Message(101, "Los tags han sido removidos."));
	}

	@GetMapping("/get/classoptiongroup/forcategory/{CategoryId}/all")
	public ResponseEntity<List<ClassOptionGroupDTO>> getClassOptionGroupDTO(
			@PathVariable("CategoryId") Integer categoryId) throws Exception {
		Optional<List<ClassOptionGroupDTO>> list = Optional.ofNullable(serv.getClassOptionGroupList(categoryId));

		if (list.isEmpty()) {
			throw new Exception("getClassOptionGroupDTO");
		}

		return ResponseEntity.ok(list.get());
	}
}
