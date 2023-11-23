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

import pre.juanp.sanjuan.model.Article;
import pre.juanp.sanjuan.model.dto.ArticleCardDTO;
import pre.juanp.sanjuan.model.dto.Message;
import pre.juanp.sanjuan.service.ArticleServ;

@RestController
@RequestMapping("/article/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleCtrl {

	@Autowired
	private ArticleServ serv;

	@GetMapping("/get/all")
	public ResponseEntity<List<Article>> getAllArticles() throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getAllArticles());

		if (articles.isEmpty()) {
			throw new Exception("There is no products.");
		}

		return ResponseEntity.ok(articles.get());
	}

	@GetMapping("/get/bycode/{Code}")
	public ResponseEntity<Article> getArticleByCode(@PathVariable("Code") String code) throws Exception {
		Optional<Article> article = Optional.ofNullable(serv.getArticleByCode(code));

		if (article.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(article.get());
	}

	@GetMapping("/get/byname/{Name}")
	public ResponseEntity<List<Article>> getArticlesByName(@PathVariable("Name") String name) throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getArticlesByName(name));

		if (articles.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(articles.get());
	}

	@GetMapping("/get/bycategory/{CategoryId}")
	public ResponseEntity<List<Article>> getArticlesByCategory(@PathVariable("CategoryId") Integer categoryId)
			throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getArticlesByCategory(categoryId));

		if (articles.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(articles.get());
	}

	@GetMapping("/get/byproduct/{ProductId}")
	public ResponseEntity<List<Article>> getArticlesByProduct(@PathVariable("ProductId") Integer productId)
			throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getArticlesByProduct(productId));

		if (articles.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(articles.get());
	}

	@PostMapping("/post/newarticle")
	public ResponseEntity<Message> addArticle(@RequestParam("Name") String name,
			@RequestParam("Description") String description, @RequestParam("Price") BigDecimal price,
			@RequestParam("Stock") Integer stock, @RequestParam("Img") String img,
			@RequestParam("BarCode") String barCode, @RequestParam("ProductId") Integer productId) {
		serv.addArticle(name, description, price, stock, img, barCode, productId);

		return ResponseEntity.ok(new Message(101, "Articulo ingresado."));
	}

	@PutMapping("/put/byid/{ArticleId}")
	public ResponseEntity<Message> updateArticleById(@PathVariable("ArticleId") Integer articleId,
			@RequestParam("Name") String name, @RequestParam("Description") String description,
			@RequestParam("Price") BigDecimal price, @RequestParam("Stock") Integer stock,
			@RequestParam("Img") String img, @RequestParam("BarCode") String barCode,
			@RequestParam("ProductId") Integer productId) {
		serv.updateArticle(articleId, name, description, price, stock, img, barCode, productId);

		return ResponseEntity.ok(new Message(102, "Articulo actualizado."));
	}

	@DeleteMapping("/delete/byid/{ArticleId}")
	public ResponseEntity<Message> removeArticleById(@PathVariable("ArticleId") Integer articleId) {
		serv.removeArticle(articleId);

		return ResponseEntity.ok(new Message(103, "Articulo eliminado."));
	}

	// dto

	@GetMapping("/card/get/all")
	public ResponseEntity<List<ArticleCardDTO>> findAllCardArticles() {
		List<ArticleCardDTO> articles = serv.findAllCardArticles(1);

		return ResponseEntity.ok(articles);
	}
}
