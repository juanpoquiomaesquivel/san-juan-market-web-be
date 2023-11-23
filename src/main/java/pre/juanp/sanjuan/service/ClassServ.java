package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.administrator.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.administrator.ClassOptionGroupDTO;
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
	
	public pre.juanp.sanjuan.model.Class getClassByCode(String code) {
		return repo.getClassByCode(code);
	}
	
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(Integer familyId) {
		return repo.getClassesByFamily(familyId);
	}
	
	public List<Integer> getClassTagsForCategory(Integer categoryId) {
		return repo.getClassTagsForCategory(categoryId);
	}
	
	public List<ClassOptionDTO> getCurrentClassTagOptionsForCategory(Integer categoryId) {
		return repo.getCurrentClassTagOptionsForCategory(categoryId);
	}
	
	public List<ClassOptionDTO> getAvailableClassOptionList() {
		return repo.UpGetAvailableClassOptionList();
	}
	
	public void addClassTagForCategory(String jsonArrayId, Integer categoryId) {
		repo.UpAddClassTagForCategory(jsonArrayId, categoryId);
	}
	
	public void removeClassTagForCategory(String jsonArrayId) {
		repo.UpRemoveClassTagForCategory(jsonArrayId);
	}
	
	
	
	public List<ClassOptionGroupDTO> getClassOptionGroupList(Integer categoryId) {
		return repo.getClassOptionGroupList(categoryId);
	}
}
