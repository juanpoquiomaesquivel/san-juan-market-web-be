package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Category;
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

	public Category getCategoryById(String id) {
		return repo.getReferenceById(id);
	}

	public void saveNewCategory(String name, String description) {
		repo.UpInsertCategory(name, description);
	}

	public void updateCategoryById(String id, String name, String description) {
		repo.UpUpdateCategory(id, name, description);
	}

	public void deleteCategoryById(String id) {
		repo.UpDeleteCategory(id);
	}
}