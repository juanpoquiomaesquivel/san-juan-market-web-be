package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Family;
import pre.juanp.sanjuan.repository.FamilyRepo;

@Service
public class FamilyServ {

	@Autowired
	private FamilyRepo repo;

	public List<Family> findAllFamilies() {
		return repo.findAll();
	}

	public List<Family> findFamiliesContainingName(String name) {
		return repo.findFamiliesContainingName(name);
	}

	public Family getFamilyById(String id) {
		return repo.getReferenceById(id);
	}

	public List<Family> getFamiliesBySegment(String segmentId) {
		return repo.getFamiliesBySegment(segmentId);
	}
}
