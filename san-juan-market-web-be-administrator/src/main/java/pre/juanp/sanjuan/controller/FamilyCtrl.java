package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.FamilyOptionGroupDTO;
import pre.juanp.sanjuan.service.FamilyServ;

@RestController
@RequestMapping("/family/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class FamilyCtrl {

	@Autowired
	private FamilyServ serv;

	@GetMapping("/get/family-option-group/all")
	public ResponseEntity<List<FamilyOptionGroupDTO>> getFindFamilyOptionGroupList() throws Exception {
		Optional<List<FamilyOptionGroupDTO>> list = Optional.ofNullable(serv.getFindFamilyOptionGroupList());

		if (list.isEmpty()) {
			throw new Exception("There is no family associated with the provided segment.");
		}

		return ResponseEntity.ok(list.get());
	}
}
