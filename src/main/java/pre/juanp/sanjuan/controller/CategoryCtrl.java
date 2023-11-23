package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.Category;
import pre.juanp.sanjuan.model.dto.CategoryFilterDTO;
import pre.juanp.sanjuan.model.dto.Message;
import pre.juanp.sanjuan.model.dto.administrator.CategoryOptionDTO;
import pre.juanp.sanjuan.service.CategoryServ;

@RestController
@RequestMapping("/category/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryCtrl {

	@Autowired
	private CategoryServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<Category>> findAllCategories() throws Exception {
		Optional<List<Category>> cats = Optional.ofNullable(serv.findAllCategories());

		if (cats.isEmpty()) {
			throw new Exception("There is no categories.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@GetMapping("/get/byname")
	public ResponseEntity<List<Category>> findCategoriesContainingName(@RequestParam("Name") String name)
			throws Exception {
		Optional<List<Category>> cats = Optional.ofNullable(serv.findCategoriesContainingName(name));

		if (cats.isEmpty()) {
			throw new Exception("There is no category with a name alike.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@GetMapping("/get/bydescription")
	public ResponseEntity<List<Category>> findCategoriesContainingDescription(
			@RequestParam("Description") String description) throws Exception {
		Optional<List<Category>> cats = Optional.ofNullable(serv.findCategoriesContainingDescription(description));

		if (cats.isEmpty()) {
			throw new Exception("There is no category with a description alike.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<Category> getCategoryByCode(@PathVariable("Code") String code) throws Exception {
		Optional<Category> cats = Optional.ofNullable(serv.getCategoryByCode(code));

		if (cats.isEmpty()) {
			throw new Exception("There is no category associated with the provided code.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@PostMapping("/post/newcategory")
	public ResponseEntity<Integer> addCategory(@RequestParam("Name") String name,
			@RequestParam(name = "Description", required = false) String description) {
		serv.addCategory(name, description);

		return ResponseEntity.ok(serv.getLastAddedCategoryId());
	}

	@PutMapping("/put/byid/{CategoryId}")
	public ResponseEntity<Message> updateCategoryById(@PathVariable("CategoryId") Integer categoryId,
			@RequestParam("Name") String name,
			@RequestParam(name = "Description", required = false) String description) {
		serv.updateCategoryById(categoryId, name, description);

		return ResponseEntity.ok(new Message(102, "La categoria ha sido actualizada."));
	}

	@DeleteMapping("/delete/byid/{CategoryId}")
	public ResponseEntity<Message> deleteCategoryById(@PathVariable("CategoryId") Integer categoryId) {
		serv.removeCategoryById(categoryId);

		return ResponseEntity.ok(new Message(103, "La categoria ha sido eliminada."));
	}

	// dto

	@GetMapping("/filters/get/all")
	public ResponseEntity<List<CategoryFilterDTO>> findAllCategoryFilters() throws Exception {
		Optional<List<CategoryFilterDTO>> cats = Optional.ofNullable(serv.findAllCategoryFilters(1));

		if (cats.isEmpty()) {
			throw new Exception("There is no category filters.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@GetMapping("/get/categoryoption/all") // ok
	public ResponseEntity<List<CategoryOptionDTO>> getCategoryOptionList() throws Exception {
		Optional<List<CategoryOptionDTO>> list = Optional.ofNullable(serv.getCategoryOptionList());

		if (list.isEmpty()) {
			throw new Exception("There is no category filters.");
		}

		return ResponseEntity.ok(list.get());
	}
}
