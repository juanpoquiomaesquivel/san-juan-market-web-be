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

	public List<Category> getAllCategories() {
		return repo.findAll();
	}

	public Category getCategoryById(String id) {
		return repo.getReferenceById(id);
	}

	public List<Category> getCategoriesByName(String name) {
		return repo.getCategoriesByName(name);
	}

	public void insertCategory(String name, String description) {
		repo.UpInsertCategory(name, description);
	}

	public void updateCategory(String id, String name, String description) {
		repo.UpUpdateCategory(id, name, description);
	}

	public void deleteCategory(String id) {
		repo.UpDeleteCategory(id);
	}
}