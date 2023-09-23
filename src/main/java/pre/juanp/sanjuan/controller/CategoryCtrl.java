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

	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategories() throws Exception {
		Optional<List<Category>> cats = Optional.ofNullable(serv.getAllCategories());

		if (cats.isEmpty()) {
			throw new Exception("There is no categories.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@GetMapping("/byid/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") String id) throws Exception {
		Optional<Category> cats = Optional.ofNullable(serv.getCategoryById(id));

		if (cats.isEmpty()) {
			throw new Exception("There is no category associated with the provided id.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@GetMapping("/byname/{name}")
	public ResponseEntity<List<Category>> getCategoriesByName(@PathVariable("name") String name) throws Exception {
		Optional<List<Category>> cats = Optional.ofNullable(serv.getCategoriesByName(name));

		if (cats.isEmpty()) {
			throw new Exception("There is no category alike.");
		}

		return ResponseEntity.ok(cats.get());
	}

	@PostMapping("/insert")
	public ResponseEntity<String> insertCategory(@RequestParam("name") String name,
			@RequestParam(name = "description", required = false) String description) {
		try {
			serv.insertCategory(name, description);

			return ResponseEntity.ok("Insert statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam(name = "description", required = false) String description) {
		try {
			serv.updateCategory(id, name, description);

			return ResponseEntity.ok("Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") String id) {
		try {
			serv.deleteCategory(id);

			return ResponseEntity.ok("Delete statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}
}
