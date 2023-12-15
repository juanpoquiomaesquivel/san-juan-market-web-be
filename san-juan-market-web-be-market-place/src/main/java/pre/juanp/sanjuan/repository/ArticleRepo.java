package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Article;
import pre.juanp.sanjuan.model.dto.ArticleCardDTO;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

	@Query(nativeQuery = true)
	public List<ArticleCardDTO> findArticleCardListExcept(@Param("ArticleId") Integer articleId);
}
