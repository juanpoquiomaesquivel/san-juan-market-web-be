package pre.juanp.sanjuan.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import pre.juanp.sanjuan.model.Article;
import pre.juanp.sanjuan.model.dto.ArticleCardDTO;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT a FROM Article a WHERE a.name LIKE '%' + :name + '%'")
	public List<Article> getArticlesByName(@Param("name") String name);

	@Query(value = "SELECT a FROM Article a WHERE a.code = :Code")
	public Article getArticleByCode(@Param("Code") String code);

	@Query(value = "SELECT a FROM Article a JOIN Product p ON a.productId = p.id AND p.categoryId = :CategoryId")
	public List<Article> getArticlesByCategory(@Param("CategoryId") Integer categoryId);

	@Query(value = "SELECT a FROM Article a WHERE a.productId = :ProductId")
	public List<Article> getArticlesByProduct(@Param("ProductId") Integer productId);

	@Procedure(value = "UpAddArticle")
	public void UpAddArticle(@Param("Name") String name, @Nullable @Param("Description") String description,
			@Param("Price") BigDecimal price, @Param("Stock") Integer stock, @Param("Img") String img,
			@Param("BarCode") String barCode, @Nullable @Param("ProductId") Integer productId);

	@Procedure(value = "UpUpdateArticle")
	public void UpUpdateArticle(@Param("ArticleId") Integer articleId, @Param("Name") String name,
			@Nullable @Param("Description") String description, @Param("Price") BigDecimal price,
			@Param("Stock") Integer stock, @Param("Img") String img, @Param("BarCode") String barCode,
			@Nullable @Param("ProductId") Integer productId);

	@Procedure(value = "UpRemoveArticle")
	public void UpRemoveArticle(@Param("ArticleId") Integer articleId);

	// dto

	@Query(nativeQuery = true)
	public List<ArticleCardDTO> findAllCardArticles(@Param("Id") Integer id);
}
