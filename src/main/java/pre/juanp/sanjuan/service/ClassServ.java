package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.repository.ClassRepo;

@Service
public class ClassServ {

	@Autowired
	private ClassRepo repo;

	public List<pre.juanp.sanjuan.model.Class> getAllClasses() {
		return repo.findAll();
	}
	
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(String familyId) {
		return repo.getClassesByFamily(familyId);
	}
	
	public List<pre.juanp.sanjuan.model.Class> getClassesByCategory(String classId) {
		return repo.getClassesByCategory(classId);
	}
}
