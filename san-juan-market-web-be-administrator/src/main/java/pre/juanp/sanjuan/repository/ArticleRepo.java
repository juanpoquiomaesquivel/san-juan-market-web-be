package pre.juanp.sanjuan.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Article;
import pre.juanp.sanjuan.model.dto.ArticleItemDTO;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

	@Query(nativeQuery = true)
	public List<ArticleItemDTO> findArticleItemList();
	
	@Query(value = "SELECT a.productId FROM Article a WHERE a.id = :ArticleId")
	public Integer findProductIdOfArticle(@Param("ArticleId") Integer articleId);
	
	@Procedure(value = "UpAdmPostAddArticle")
	public void UpAdmPostAddArticle(@Param("Name") String name, @Param("Description") String description,
			@Param("Price") BigDecimal price, @Param("Image") String image, @Param("BarCode") String barCode,
			@Param("ProductId") Integer productId);

	@Procedure(value = "UpAdmPutUpdateArticle")
	public void UpAdmPutUpdateArticle(@Param("ArticleId") Integer articleId, @Param("Name") String name,
			@Param("Description") String description, @Param("Price") BigDecimal price,
			@Param("Image") String image, @Param("BarCode") String barCode,
			@Param("ProductId") Integer productId);

	@Procedure(value = "UpAdmDeleteRemoveArticle")
	public void UpAdmDeleteRemoveArticle(@Param("ArticleId") Integer articleId);
}
