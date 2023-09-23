package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Segment;
import pre.juanp.sanjuan.repository.SegmentRepo;

@Service
public class SegmentServ {

	@Autowired
	private SegmentRepo repo;

	public List<Segment> getAllSegments() {
		return repo.findAll();
	}
}
