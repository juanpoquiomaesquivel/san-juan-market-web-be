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
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.ClassOptionGroupDTO;
import pre.juanp.sanjuan.model.dto.util.Message;
import pre.juanp.sanjuan.service.ClassServ;

@RestController
@RequestMapping("/class/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class ClassCtrl {

	@Autowired
	private ClassServ serv;

	@GetMapping("/get/class-option/available/all")
	public ResponseEntity<List<ClassOptionDTO>> getFindAvailableClassOptionList() throws Exception {
		Optional<List<ClassOptionDTO>> clasz = Optional.ofNullable(serv.getFindAvailableClassOptionList());

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(clasz.get());
	} // ok

	@GetMapping("/get/class-option/unavailable/all")
	public ResponseEntity<List<ClassOptionDTO>> findUnavailableClassOptionList() throws Exception {
		Optional<List<ClassOptionDTO>> clasz = Optional.ofNullable(serv.findUnavailableClassOptionList());

		if (clasz.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(clasz.get());
	} // ok

	@GetMapping("/get/class-tag/of-category/{CategoryId}/all")
	public ResponseEntity<List<Integer>> findClassTagListOfCategory(
			@PathVariable("CategoryId") Integer categoryId) throws Exception {
		Optional<List<Integer>> list = Optional.ofNullable(serv.findClassTagListOfCategory(categoryId));

		if (list.isEmpty()) {
			throw new Exception("There is no class associated with the provided category.");
		}

		return ResponseEntity.ok(list.get());
	} // ok

	@PutMapping("/put/class-tag/of-category/{CategoryId}/add")
	public ResponseEntity<Message> putAddClassTagForCategory(@PathVariable("CategoryId") Integer categoryId,
			@RequestBody String jsonClassTagIdArray) {
		serv.putAddClassTagForCategory(jsonClassTagIdArray, categoryId);

		return ResponseEntity.ok(new Message(101, "Los tags han sido anadidos."));
	} // ok

	@PutMapping("/put/class-tag/remove")
	public ResponseEntity<Message> putRemoveClassTagForCategory(@RequestBody String jsonClassTagIdArray) {
		serv.putRemoveClassTagForCategory(jsonClassTagIdArray);

		return ResponseEntity.ok(new Message(101, "Los tags han sido removidos."));
	} // ok

	@GetMapping("/get/class-option-group/of-category/{CategoryId}/all")
	public ResponseEntity<List<ClassOptionGroupDTO>> findClassOptionGroupListOfCategory(
			@PathVariable("CategoryId") Integer categoryId) throws Exception {
		Optional<List<ClassOptionGroupDTO>> list = Optional
				.ofNullable(serv.findClassOptionGroupListOfCategory(categoryId));

		if (list.isEmpty()) {
			throw new Exception("findClassOptionGroupListOfCategory");
		}

		return ResponseEntity.ok(list.get());
	} // ok
}
