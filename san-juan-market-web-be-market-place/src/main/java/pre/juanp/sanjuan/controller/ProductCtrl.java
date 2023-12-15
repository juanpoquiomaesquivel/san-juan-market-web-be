package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.ProductFilterDTO;
import pre.juanp.sanjuan.service.ProductServ;

@RestController
@RequestMapping("/product/api")
@CrossOrigin(origins = { "http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app" })
public class ProductCtrl {

	@Autowired
	private ProductServ serv;

	@GetMapping("/get/filter/all")
	public ResponseEntity<List<ProductFilterDTO>> findProductFilterListExcept() throws Exception {
		Optional<List<ProductFilterDTO>> list = Optional.ofNullable(serv.findProductFilterListExcept(0));

		if (list.isEmpty()) {
			throw new Exception("There is no products.");
		}

		return ResponseEntity.ok(list.get());
	}
}
