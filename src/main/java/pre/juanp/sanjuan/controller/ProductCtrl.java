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

import pre.juanp.sanjuan.model.Product;
import pre.juanp.sanjuan.model.dto.Message;
import pre.juanp.sanjuan.model.dto.ProductFilterDTO;
import pre.juanp.sanjuan.model.dto.administrator.ProductOptionDTO;
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

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<Product> getProductByCode(@PathVariable("Code") String code) throws Exception {
		Optional<Product> product = Optional.ofNullable(serv.getProductByCode(code));

		if (product.isEmpty()) {
			throw new Exception("There is no product associated with the provided code.");
		}

		return ResponseEntity.ok(product.get());
	}

	@GetMapping("/get/bycategory/{CategoryId}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("CategoryId") Integer categoryId)
			throws Exception {
		Optional<List<Product>> products = Optional.ofNullable(serv.getProductsByCategory(categoryId));

		if (products.isEmpty()) {
			throw new Exception("There is no product associated with the provided category.");
		}

		return ResponseEntity.ok(products.get());
	}

	@PostMapping("/post/newproduct")
	public ResponseEntity<Integer> addProduct(@RequestParam("Name") String name,
			@RequestParam(name = "Description", required = false) String description,
			@RequestParam(name = "CategoryId", required = false) Integer categoryId) {
		serv.addProduct(name, description, categoryId);

		return ResponseEntity.ok(serv.getLastAddedProductId());
	}

	@PutMapping("/put/byid/{ProductId}")
	public ResponseEntity<Message> updateProductById(@PathVariable("ProductId") Integer id,
			@RequestParam("Name") String name, @RequestParam(name = "Description", required = false) String description,
			@RequestParam(name = "CategoryId", required = false) Integer categoryId) {
		serv.updateProductById(id, name, description, categoryId);

		return ResponseEntity.ok(new Message(102, "Producto actuaizado."));
	}

	@DeleteMapping("/delete/byid/{ProductId}")
	public ResponseEntity<Message> removeProductById(@PathVariable("ProductId") Integer productId) {
		serv.removeProductById(productId);

		return ResponseEntity.ok(new Message(103, "Producto eliminado."));
	}

	// dto

	@GetMapping("/filters/get/all")
	public ResponseEntity<List<ProductFilterDTO>> findAllProductFilters() throws Exception {
		Optional<List<ProductFilterDTO>> pros = Optional.ofNullable(serv.findAllProductFilters(1));

		if (pros.isEmpty()) {
			throw new Exception("There is no products.");
		}

		return ResponseEntity.ok(pros.get());
	}


	@GetMapping("/get/productoption/all")
	public ResponseEntity<List<ProductOptionDTO>> getProductOptionList() throws Exception {
		Optional<List<ProductOptionDTO>> pros = Optional.ofNullable(serv.getProductOptionList());

		if (pros.isEmpty()) {
			throw new Exception("getProductOptionList");
		}

		return ResponseEntity.ok(pros.get());
	}
}
