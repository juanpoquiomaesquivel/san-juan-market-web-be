package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Category;
import pre.juanp.sanjuan.model.dto.CategoryOptionDTO;
import pre.juanp.sanjuan.repository.CategoryRepo;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo repo;
	
	public List<Category> findCategoryItemList() {
		return repo.findAll();
	}

	public void postAddCategory(String name, String description, String image) {
		repo.UpAdmPostAddCategory(name, description, image);
	}

	public Integer findLastAddedCategoryId() {
		return repo.findLastAddedCategoryId();
	}

	public void putUpdateCategory(Integer categoryId, String name, String description, String image) {
		repo.UpAdmPutUpdateCategory(categoryId, name, description, image);
	}

	public void deleteRemoveCategory(Integer categoryId) {
		repo.UpAdmDeleteRemoveCategory(categoryId);
	}

	public List<CategoryOptionDTO> findCategoryOptionList() {
		return repo.findCategoryOptionList();
	}
}