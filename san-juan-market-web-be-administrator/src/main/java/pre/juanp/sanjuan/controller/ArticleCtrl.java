package pre.juanp.sanjuan.controller;

import java.math.BigDecimal;
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

import pre.juanp.sanjuan.model.dto.ArticleItemDTO;
import pre.juanp.sanjuan.model.dto.util.Message;
import pre.juanp.sanjuan.service.ArticleServ;

@RestController
@RequestMapping("/article/api")
@CrossOrigin(origins = {"http://localhost:4200", "https://teaching-usable-chicken.ngrok-free.app"})
public class ArticleCtrl {

	@Autowired
	private ArticleServ serv;

	@GetMapping("/get/article-item/all")
	public ResponseEntity<List<ArticleItemDTO>> findArticleItemList() throws Exception {
		Optional<List<ArticleItemDTO>> articles = Optional.ofNullable(serv.findArticleItemList());

		if (articles.isEmpty()) {
			throw new Exception("There is no products.");
		}

		return ResponseEntity.ok(articles.get());
	} // ok
	
	@GetMapping("/get/article-item/{ArticleId}/product-id")
	public ResponseEntity<Integer> findProductIdOfArticle(@PathVariable("ArticleId") Integer articleId) {
		Optional<Integer> opt = Optional.of(serv.findProductIdOfArticle(articleId));
		
		return ResponseEntity.ok(opt.get());
	} // ok

	@PostMapping("/post/article-item/add")
	public ResponseEntity<Message> postAddArticle(@RequestParam("Name") String name,
			@RequestParam("Description") String description, @RequestParam("Price") BigDecimal price,
			@RequestParam("Image") String image,
			@RequestParam("BarCode") String barCode, @RequestParam("ProductId") Integer productId) {
		serv.postAddArticle(name, description, price, image, barCode, productId);

		return ResponseEntity.ok(new Message(101, "Articulo ingresado."));
	}

	@PutMapping("/put/article-item/{ArticleId}/update")
	public ResponseEntity<Message> updateArticleById(@PathVariable("ArticleId") Integer articleId,
			@RequestParam("Name") String name, @RequestParam("Description") String description,
			@RequestParam("Price") BigDecimal price,
			@RequestParam("Image") String image, @RequestParam("BarCode") String barCode,
			@RequestParam("ProductId") Integer productId) {
		serv.putUpdateArticle(articleId, name, description, price, image, barCode, productId);

		return ResponseEntity.ok(new Message(102, "Articulo actualizado."));
	} // ok

	@DeleteMapping("/delete/article-item/{ArticleId}/remove")
	public ResponseEntity<Message> removeArticleById(@PathVariable("ArticleId") Integer articleId) {
		serv.deleteRemoveArticle(articleId);

		return ResponseEntity.ok(new Message(103, "Articulo eliminado."));
	}
}
