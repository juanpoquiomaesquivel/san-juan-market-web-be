package pre.juanp.sanjuan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pre.juanp.sanjuan.model.dto.ArticleCardDTO;
import pre.juanp.sanjuan.service.ArticleServ;

@RestController
@RequestMapping("/article/api")
@CrossOrigin(origins = {"http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app"})
public class ArticleCtrl {

	@Autowired
	private ArticleServ serv;

	@GetMapping("/get/card/all")
	public ResponseEntity<List<ArticleCardDTO>> findArticleCardListExcept() throws Exception {
		Optional<List<ArticleCardDTO>> list = Optional.of(serv.findArticleCardListExcept(0));
		
		if (list.isEmpty()) {
			throw new Exception("there is no article card list.");
		}

		return ResponseEntity.ok(list.get());
	}
}
