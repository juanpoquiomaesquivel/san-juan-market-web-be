package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.ArticleCardDTO;
import pre.juanp.sanjuan.repository.ArticleRepo;

@Service
public class ArticleServ {

	@Autowired
	private ArticleRepo repo;
	public List<ArticleCardDTO> findArticleCardListExcept(Integer articleId) {
		return repo.findArticleCardListExcept(articleId);
	}
}
