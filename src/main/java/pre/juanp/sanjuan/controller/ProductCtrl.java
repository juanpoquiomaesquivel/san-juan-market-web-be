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

import pre.juanp.sanjuan.model.Product;
import pre.juanp.sanjuan.service.ProductServ;

@RestController
@RequestMapping("/product/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductCtrl {

	@Autowired
	private ProductServ serv;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = serv.getAllProducts();

		return ResponseEntity.ok(products);
	}

	@GetMapping("/bycode/{code}")
	public ResponseEntity<Product> getProductByCode(@PathVariable("code") String code) throws Exception {
		Optional<Product> product = Optional.ofNullable(serv.getProductByCode(code));

		if (product.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(product.get());
	}

	@GetMapping("/byname/{name}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable("name") String name) throws Exception {
		Optional<List<Product>> products = Optional.ofNullable(serv.getProductsByName(name));

		if (products.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(products.get());
	}

	@GetMapping("/bycategory/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category)
			throws Exception {
		Optional<List<Product>> products = Optional.ofNullable(serv.getProductsByCategory(category));

		if (products.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(products.get());
	}
}
