package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.ClassOptionGroupDTO;
import pre.juanp.sanjuan.repository.ClassRepo;

@Service
public class ClassServ {

	@Autowired
	private ClassRepo repo;
	
	public List<ClassOptionDTO> getFindAvailableClassOptionList() {
		return repo.UpAdmGetFindAvailableClassOptionList();
	}
	
	public List<ClassOptionDTO> findUnavailableClassOptionList() {
		return repo.findUnavailableClassOptionList();
	}

	public List<Integer> findClassTagListOfCategory(Integer categoryId) {
		return repo.findClassTagListOfCategory(categoryId);
	}
	
	public void putAddClassTagForCategory(String jsonClassTagIdArray, Integer categoryId) {
		repo.UpAdmPutAddClassTagForCategory(jsonClassTagIdArray, categoryId);
	}
	
	public void putRemoveClassTagForCategory(String jsonClassTagIdArray) {
		repo.UpAdmPutRemoveClassTagForCategory(jsonClassTagIdArray);
	}
	
	
	
	public List<ClassOptionGroupDTO> findClassOptionGroupListOfCategory(Integer categoryId) {
		return repo.findClassOptionGroupListOfCategory(categoryId);
	}
}
