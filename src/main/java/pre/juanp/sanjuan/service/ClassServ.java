package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.repository.ClassRepo;

@Service
public class ClassServ {

	@Autowired
	private ClassRepo repo;

	public List<pre.juanp.sanjuan.model.Class> findAllClasses() {
		return repo.findAll();
	}

	public List<pre.juanp.sanjuan.model.Class> findClassesContainingName(String name) {
		return repo.findClassesContainingName(name);
	}
	
	public pre.juanp.sanjuan.model.Class getClassById(String id) {
		return repo.getReferenceById(id);
	}
	
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(String familyId) {
		return repo.getClassesByFamily(familyId);
	}
	
	public List<pre.juanp.sanjuan.model.Class> getClassTagsForCategory(String categoryId) {
		return repo.getClassTagsForCategory(categoryId);
	}
	
	public void addClassTagForCategory(String id, String categoryId) {
		repo.UpAddClassTagForCategory(id, categoryId);
	}
	
	public void removeClassTagForCategory(String id) {
		repo.UpRemoveClassTagForCategory(id);
	}
}
