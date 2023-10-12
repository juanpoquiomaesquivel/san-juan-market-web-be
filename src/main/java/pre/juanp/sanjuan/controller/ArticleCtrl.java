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

import pre.juanp.sanjuan.model.Article;
import pre.juanp.sanjuan.service.ArticleServ;

@RestController
@RequestMapping("/article/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleCtrl {

	@Autowired
	private ArticleServ serv;

	@GetMapping("/all")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> articles = serv.getAllArticles();

		return ResponseEntity.ok(articles);
	}

	@GetMapping("/bycode/{Code}")
	public ResponseEntity<Article> getArticleByCode(@PathVariable("Code") String code) throws Exception {
		Optional<Article> article = Optional.ofNullable(serv.getArticleByCode(code));

		if (article.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(article.get());
	}

	@GetMapping("/byname/{Name}")
	public ResponseEntity<List<Article>> getArticlesByName(@PathVariable("Name") String name) throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getArticlesByName(name));

		if (articles.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(articles.get());
	}

	@GetMapping("/bycategory/{CategoryId}")
	public ResponseEntity<List<Article>> getArticlesByCategory(@PathVariable("CategoryId") Integer categoryId)
			throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getArticlesByCategory(categoryId));

		if (articles.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(articles.get());
	}

	@GetMapping("/byproduct/{ProductId}")
	public ResponseEntity<List<Article>> getArticlesByProduct(@PathVariable("ProductId") Integer productId)
			throws Exception {
		Optional<List<Article>> articles = Optional.ofNullable(serv.getArticlesByProduct(productId));

		if (articles.isEmpty()) {
			throw new Exception("Resource not found.");
		}

		return ResponseEntity.ok(articles.get());
	}
}
