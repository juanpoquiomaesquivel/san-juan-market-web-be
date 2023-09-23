package pre.juanp.sanjuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.Segment;
import pre.juanp.sanjuan.service.SegmentServ;

@RestController
@RequestMapping("/segment/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SegmentCtrl {

	@Autowired
	private SegmentServ serv;
	
	@GetMapping("/all")
	public ResponseEntity<List<Segment>> getAllSegments() {
		List<Segment> segments = serv.getAllSegments();
		
		return ResponseEntity.ok(segments);
	}
}
