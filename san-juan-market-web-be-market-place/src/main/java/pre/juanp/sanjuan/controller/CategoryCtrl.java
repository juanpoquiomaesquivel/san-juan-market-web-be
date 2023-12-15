package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.CategoryFilterDTO;
import pre.juanp.sanjuan.service.CategoryServ;

@RestController
@RequestMapping("/category/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class CategoryCtrl {

	@Autowired
	private CategoryServ serv;

	@GetMapping("/get/filter/all")
	public ResponseEntity<List<CategoryFilterDTO>> findCategoryFilterListExcept() throws Exception {
		Optional<List<CategoryFilterDTO>> list = Optional.ofNullable(serv.findCategoryFilterListExcept(0));

		if (list.isEmpty()) {
			throw new Exception("There is no category filters.");
		}

		return ResponseEntity.ok(list.get());
	}
}
