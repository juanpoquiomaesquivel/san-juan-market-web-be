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

import pre.juanp.sanjuan.model.dto.ProductItemDTO;
import pre.juanp.sanjuan.model.dto.ProductOptionDTO;
import pre.juanp.sanjuan.model.dto.util.Message;
import pre.juanp.sanjuan.service.ProductServ;

@RestController
@RequestMapping("/product/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class ProductCtrl {

	@Autowired
	private ProductServ serv;

	@GetMapping("/get/product-item/all")
	public ResponseEntity<List<ProductItemDTO>> findProductItemList() {
		Optional<List<ProductItemDTO>> list = Optional.of(serv.findProductItemList());
		
		return ResponseEntity.ok(list.get());
	} // ok
	
	@GetMapping("/get/product-item/{ProductId}/category-id")
	public ResponseEntity<Integer> findCategoryIdOfProduct(@PathVariable("ProductId") Integer productId) {
		Optional<Integer> opt = Optional.of(serv.findCategoryIdOfProduct(productId));
		
		return ResponseEntity.ok(opt.get());
	} // ok
	
	@PostMapping("/post/product-item/add")
	public ResponseEntity<Integer> postAddProduct(@RequestParam("Name") String name,
			@RequestParam(name = "Description") String description, @RequestParam(name = "Image") String image,
			@RequestParam(name = "CategoryId") Integer categoryId) {
		serv.postAddProduct(name, description, image, categoryId);

		return ResponseEntity.ok(serv.findLastAddedProductId());
	} // ok

	@PutMapping("/put/product-item/{ProductId}/update")
	public ResponseEntity<Message> putUpdateProduct(@PathVariable("ProductId") Integer productId,
			@RequestParam("Name") String name, @RequestParam(name = "Description") String description,
			@RequestParam(name = "Image") String image, @RequestParam(name = "CategoryId") Integer categoryId) {
		serv.putUpdateProduct(productId, name, description, image, categoryId);

		return ResponseEntity.ok(new Message(102, "Producto actuaizado."));
	} // ok

	@DeleteMapping("/delete/product-item/{ProductId}/remove")
	public ResponseEntity<Message> deleteRemoveProduct(@PathVariable("ProductId") Integer productId) {
		serv.deleteRemoveProduct(productId);

		return ResponseEntity.ok(new Message(103, "Producto eliminado."));
	} // ok

	@GetMapping("/get/product-option/all")
	public ResponseEntity<List<ProductOptionDTO>> findProductOptionList() throws Exception {
		Optional<List<ProductOptionDTO>> pros = Optional.ofNullable(serv.findProductOptionList());

		if (pros.isEmpty()) {
			throw new Exception("getProductOptionList");
		}

		return ResponseEntity.ok(pros.get());
	}
}
