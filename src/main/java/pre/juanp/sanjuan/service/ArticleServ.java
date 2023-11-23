package pre.juanp.sanjuan.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Article;
import pre.juanp.sanjuan.model.dto.ArticleCardDTO;
import pre.juanp.sanjuan.repository.ArticleRepo;

@Service
public class ArticleServ {

	@Autowired
	private ArticleRepo repo;

	public List<Article> getAllArticles() {
		return repo.findAll();
	}
	
	public Article getArticleByCode(String code) {
		return repo.getArticleByCode(code);
	}

	public List<Article> getArticlesByName(String name) {
		return repo.getArticlesByName(name);
	}

	public List<Article> getArticlesByCategory(Integer categoryId) {
		return repo.getArticlesByCategory(categoryId);
	}

	public List<Article> getArticlesByProduct(Integer productId) {
		return repo.getArticlesByProduct(productId);
	}

	public List<ArticleCardDTO> findAllCardArticles(Integer id) {
		return repo.findAllCardArticles(id);
	}

	//

	public void addArticle(String name, String description, BigDecimal price, Integer stock, String img,
			String barCode, Integer productId) {
		repo.UpAddArticle(name, description, price, stock, img, barCode, productId);
	}

	public void updateArticle(Integer articleId, String name, String description, BigDecimal price, Integer stock,
			String img, String barCode, Integer productId) {
		repo.UpUpdateArticle(articleId, name, description, price, stock, img, barCode, productId);
	}

	public void removeArticle(Integer articleId) {
		repo.UpRemoveArticle(articleId);
	}
}
