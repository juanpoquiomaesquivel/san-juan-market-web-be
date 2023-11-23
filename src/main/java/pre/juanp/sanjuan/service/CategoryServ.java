package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Category;
import pre.juanp.sanjuan.model.dto.CategoryFilterDTO;
import pre.juanp.sanjuan.model.dto.administrator.CategoryOptionDTO;
import pre.juanp.sanjuan.repository.CategoryRepo;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo repo;

	public List<Category> findAllCategories() {
		return repo.findAll();
	}

	public List<Category> findCategoriesContainingName(String name) {
		return repo.findCategoriesContainingName(name);
	}

	public List<Category> findCategoriesContainingDescription(String description) {
		return repo.findCategoriesContainingDescription(description);
	}

	public Category getCategoryByCode(String code) {
		return repo.getCategoryByCode(code);
	}

	public void addCategory(String name, String description) {
		repo.UpAddCategory(name, description);
	}
	
	public Integer getLastAddedCategoryId() {
		return repo.getLastAddedCategoryId();
	}

	public void updateCategoryById(Integer id, String name, String description) {
		repo.UpUpdateCategory(id, name, description);
	}

	public void removeCategoryById(Integer id) {
		repo.UpRemoveCategory(id);
	}
	
	// dto
	public List<CategoryFilterDTO> findAllCategoryFilters(Integer id) {
		return repo.findAllCategoryFilters(id);
	}
	
	// admin product
	public List<CategoryOptionDTO> getCategoryOptionList() {
		return repo.getCategoryOptionList();
	}
}