package pre.juanp.sanjuan.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.ArticleItemDTO;
import pre.juanp.sanjuan.repository.ArticleRepo;

@Service
public class ArticleServ {

	@Autowired
	private ArticleRepo repo;

	public List<ArticleItemDTO> findArticleItemList() {
		return repo.findArticleItemList();
	}
	
	public Integer findProductIdOfArticle(Integer articleId) {
		return repo.findProductIdOfArticle(articleId);
		}

	public void postAddArticle(String name, String description, BigDecimal price, String image, String barCode,
			Integer productId) {
		repo.UpAdmPostAddArticle(name, description, price, image, barCode, productId);
	}

	public void putUpdateArticle(Integer articleId, String name, String description, BigDecimal price, String image,
			String barCode, Integer productId) {
		repo.UpAdmPutUpdateArticle(articleId, name, description, price, image, barCode, productId);
	}

	public void deleteRemoveArticle(Integer articleId) {
		repo.UpAdmDeleteRemoveArticle(articleId);
	}
}
