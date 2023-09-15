package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Article;

public interface ArticleRepo extends JpaRepository<Article, String> {

	@Query(value = "SELECT a FROM Article a WHERE a.name LIKE '%' + :name + '%'")
	public List<Article> getArticlesByName(@Param("name") String name);
	
	@Query(value = "SELECT a FROM Article a JOIN Product p ON a.product = p.code AND p.category = :category")
	public List<Article> getArticlesByCategory(@Param("category") String category);
	
	@Query(value = "SELECT a FROM Article a WHERE a.product = :product")
	public List<Article> getArticlesByProduct(@Param("product") String product);
}
