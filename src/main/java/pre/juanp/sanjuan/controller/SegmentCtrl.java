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

import pre.juanp.sanjuan.model.Segment;
import pre.juanp.sanjuan.service.SegmentServ;

@RestController
@RequestMapping("/segment/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SegmentCtrl {

	@Autowired
	private SegmentServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<Segment>> findAllSegments() throws Exception {
		Optional<List<Segment>> segs = Optional.ofNullable(serv.findAllSegments());

		if (segs.isEmpty()) {
			throw new Exception("There is no segments.");
		}

		return ResponseEntity.ok(segs.get());
	}

	@GetMapping("/get/byname")
	public ResponseEntity<List<Segment>> findSegmentsContainingName(@RequestParam("Name") String name)
			throws Exception {
		Optional<List<Segment>> segs = Optional.ofNullable(serv.findSegmentsContainingName(name));

		if (segs.isEmpty()) {
			throw new Exception("There is no segment with a name alike.");
		}

		return ResponseEntity.ok(segs.get());
	}

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<Segment> getSegmentByCode(@PathVariable("Code") String code)
			throws Exception {
		Optional<Segment> segment = Optional.ofNullable(serv.getSegmentByCode(code));

		if (segment.isEmpty()) {
			throw new Exception("There is no segment associated with the provided code.");
		}

		return ResponseEntity.ok(segment.get());
	}
}
