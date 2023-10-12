package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Article;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT a FROM Article a WHERE a.name LIKE '%' + :name + '%'")
	public List<Article> getArticlesByName(@Param("name") String name);

	@Query(value = "SELECT a FROM Article a WHERE a.code = :Code")
	public Article getArticleByCode(@Param("Code") String code);
	
	@Query(value = "SELECT a FROM Article a JOIN Product p ON a.product.id = p.id AND p.category.id = :CategoryId")
	public List<Article> getArticlesByCategory(@Param("CategoryId") Integer categoryId);
	
	@Query(value = "SELECT a FROM Article a WHERE a.product.id = :ProductId")
	public List<Article> getArticlesByProduct(@Param("ProductId") Integer productId);
}
