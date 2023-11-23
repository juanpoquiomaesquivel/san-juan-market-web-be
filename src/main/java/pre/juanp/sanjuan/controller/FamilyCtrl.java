package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.Family;
import pre.juanp.sanjuan.model.dto.administrator.FamilyOptionGroupDTO;
import pre.juanp.sanjuan.service.FamilyServ;

@RestController
@RequestMapping("/family/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FamilyCtrl {

	@Autowired
	private FamilyServ serv;
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Family>> findAllFamilies() throws Exception {
		Optional<List<Family>> fams = Optional.ofNullable(serv.findAllFamilies());
		
		if (fams.isEmpty()) {
			throw new Exception("There is no families.");
		}
		
		return ResponseEntity.ok(fams.get());
	}
	
	@GetMapping("/get/byname")
	public ResponseEntity<List<Family>> findFamiliesContainingName(@RequestParam("Name") String name)
			throws Exception {
		Optional<List<Family>> fams = Optional.ofNullable(serv.findFamiliesContainingName(name));

		if (fams.isEmpty()) {
			throw new Exception("There is no family with a name alike.");
		}

		return ResponseEntity.ok(fams.get());
	}

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<Family> getFamilyByCode(@PathVariable("Code") String code) throws Exception {
		Optional<Family> family = Optional.ofNullable(serv.getFamilyByCode(code));

		if (family.isEmpty()) {
			throw new Exception("There is no product associated with the provided code.");
		}

		return ResponseEntity.ok(family.get());
	}

	@GetMapping("/get/bysegment/{SegmentId}")
	public ResponseEntity<List<Family>> getFamiliesBySegment(@PathVariable("SegmentId") Integer segmentId)
			throws Exception {
		Optional<List<Family>> fams = Optional.ofNullable(serv.getFamiliesBySegment(segmentId));

		if (fams.isEmpty()) {
			throw new Exception("There is no family associated with the provided segment.");
		}

		return ResponseEntity.ok(fams.get());
	}

	@GetMapping("/get/familyoptiongroup")
	public ResponseEntity<List<FamilyOptionGroupDTO>> getFamilyOptionGroupList()
			throws Exception {
		Optional<List<FamilyOptionGroupDTO>> fams = Optional.ofNullable(serv.getFamilyOptionGroupList());

		if (fams.isEmpty()) {
			throw new Exception("There is no family associated with the provided segment.");
		}

		return ResponseEntity.ok(fams.get());
	}
}
