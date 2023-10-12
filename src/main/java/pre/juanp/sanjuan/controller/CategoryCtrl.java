package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<String> addCategory(@RequestParam("Name") String name,
			@RequestParam(name = "Description", required = false) String description) {
		try {
			serv.addCategory(name, description);

			return ResponseEntity.ok("[New Category] Insert statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@PutMapping("/put/byid")
	public ResponseEntity<String> updateCategoryById(@RequestParam("Id") Integer id, @RequestParam("Name") String name,
			@RequestParam(name = "Description", required = false) String description) {
		try {
			serv.updateCategoryById(id, name, description);

			return ResponseEntity.ok("[Category Changes] Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete/byid/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("Id") Integer id) {
		try {
			serv.removeCategoryById(id);

			return ResponseEntity.ok("[Drop Category] Delete statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}
}
