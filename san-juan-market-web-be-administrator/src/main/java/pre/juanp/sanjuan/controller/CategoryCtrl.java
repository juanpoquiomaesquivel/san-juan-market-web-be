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
import pre.juanp.sanjuan.model.dto.CategoryOptionDTO;
import pre.juanp.sanjuan.model.dto.util.Message;
import pre.juanp.sanjuan.service.CategoryServ;

@RestController
@RequestMapping("/category/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class CategoryCtrl {

	@Autowired
	private CategoryServ serv;
	
	@GetMapping("/get/category-item/all")
	public ResponseEntity<List<Category>> findCategoryItemList() {
		Optional<List<Category>> list = Optional.of(serv.findCategoryItemList());
		
		return ResponseEntity.ok(list.get());
	} // ok

	@PostMapping("/post/category-item/add")
	public ResponseEntity<Integer> addCategory(@RequestParam("Name") String name,
			@RequestParam(name = "Description") String description, @RequestParam("Image") String image) {
		serv.postAddCategory(name, description, image);

		return ResponseEntity.ok(serv.findLastAddedCategoryId());
	} // ok

	@PutMapping("/put/category-item/{CategoryId}/update")
	public ResponseEntity<Message> updateCategoryById(@PathVariable("CategoryId") Integer categoryId,
			@RequestParam("Name") String name, @RequestParam(name = "Description") String description,
			@RequestParam("Image") String image) {
		serv.putUpdateCategory(categoryId, name, description, image);

		return ResponseEntity.ok(new Message(102, "La categoria ha sido actualizada."));
	} // ok

	@DeleteMapping("/delete/category-item/{CategoryId}/remove")
	public ResponseEntity<Message> deleteCategoryById(@PathVariable("CategoryId") Integer categoryId) {
		serv.deleteRemoveCategory(categoryId);

		return ResponseEntity.ok(new Message(103, "La categoria ha sido eliminada."));
	} // ok

	@GetMapping("/get/category-option/all")
	public ResponseEntity<List<CategoryOptionDTO>> findCategoryOptionList() throws Exception {
		Optional<List<CategoryOptionDTO>> list = Optional.ofNullable(serv.findCategoryOptionList());

		if (list.isEmpty()) {
			throw new Exception("findCategoryOptionList");
		}

		return ResponseEntity.ok(list.get());
	} // ok
}
