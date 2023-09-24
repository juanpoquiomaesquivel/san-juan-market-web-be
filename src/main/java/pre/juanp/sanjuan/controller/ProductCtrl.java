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

import pre.juanp.sanjuan.model.Product;
import pre.juanp.sanjuan.service.ProductServ;

@RestController
@RequestMapping("/product/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCtrl {

	@Autowired
	private ProductServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<Product>> findAllProducts() throws Exception {
		Optional<List<Product>> pros = Optional.ofNullable(serv.findAllProducts());

		if (pros.isEmpty()) {
			throw new Exception("There is no products.");
		}

		return ResponseEntity.ok(pros.get());
	}

	@GetMapping("/get/byname")
	public ResponseEntity<List<Product>> findProductsContainingName(@RequestParam("name") String name)
			throws Exception {
		Optional<List<Product>> pros = Optional.ofNullable(serv.findProductsContainingName(name));

		if (pros.isEmpty()) {
			throw new Exception("There is no product with a name alike.");
		}

		return ResponseEntity.ok(pros.get());
	}

	@GetMapping("/get/bydescription")
	public ResponseEntity<List<Product>> findProductsContainingDescription(
			@RequestParam("description") String description) throws Exception {
		Optional<List<Product>> pros = Optional.ofNullable(serv.findProductsContainingDescription(description));

		if (pros.isEmpty()) {
			throw new Exception("There is no product with a description alike.");
		}

		return ResponseEntity.ok(pros.get());
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") String id) throws Exception {
		Optional<Product> product = Optional.ofNullable(serv.getProductById(id));

		if (product.isEmpty()) {
			throw new Exception("There is no product associated with the provided id.");
		}

		return ResponseEntity.ok(product.get());
	}

	@GetMapping("/get/bycategory/{categoryId}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("categoryId") String categoryId)
			throws Exception {
		Optional<List<Product>> products = Optional.ofNullable(serv.getProductsByCategory(categoryId));

		if (products.isEmpty()) {
			throw new Exception("There is no product associated with the provided category.");
		}

		return ResponseEntity.ok(products.get());
	}

	@PostMapping("/post/newproduct")
	public ResponseEntity<String> saveNewProduct(@RequestParam("name") String name,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "categoryId", required = false) String categoryId) {
		try {
			serv.saveNewProduct(name, description, categoryId);

			return ResponseEntity.ok("[New Product] Insert statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@PutMapping("/put/byid")
	public ResponseEntity<String> updateProductById(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "categoryId", required = false) String categoryId) {
		try {
			serv.updateProductById(id, name, description, categoryId);

			return ResponseEntity.ok("[Product Changes] Update statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}

	@DeleteMapping("/delete/byid/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") String id) {
		try {
			serv.deleteProductById(id);

			return ResponseEntity.ok("[Drop Product] Delete statement executed successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error executing stored procedure: " + e.getMessage());
		}
	}
}
