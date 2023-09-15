package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = serv.getAllCategories();
		
		//System.out.println(categories.get(0).get);

		return ResponseEntity.ok(categories);
	}

	@GetMapping("/bycode/{code}")
	public ResponseEntity<Category> getCategoryByCode(@PathVariable("code") String code) throws Exception {
		Optional<Category> category = Optional.ofNullable(serv.getCategoryByCode(code));

		if (category.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(category.get());
	}

	@GetMapping("/byname/{name}")
	public ResponseEntity<List<Category>> getCategoriesByName(@PathVariable("name") String name) throws Exception {
		Optional<List<Category>> categories = Optional.ofNullable(serv.getCategoriesByName(name));

		if (categories.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(categories.get());
	}
}
