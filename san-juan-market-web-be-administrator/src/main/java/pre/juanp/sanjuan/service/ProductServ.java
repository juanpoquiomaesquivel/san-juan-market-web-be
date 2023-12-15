package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.dto.ProductItemDTO;
import pre.juanp.sanjuan.model.dto.ProductOptionDTO;
import pre.juanp.sanjuan.repository.ProductRepo;

@Service
public class ProductServ {

	@Autowired
	private ProductRepo repo;

	public List<ProductItemDTO> findProductItemList() {
		return repo.findProductItemList();
	}
	
	public Integer findCategoryIdOfProduct(Integer productId) {
		return repo.findCategoryIdOfProduct(productId);
	}

	public void postAddProduct(String name, String description, String image, Integer categoryId) {
		repo.UpAdmPostAddProduct(name, description, image, categoryId);
	}

	public Integer findLastAddedProductId() {
		return repo.findLastAddedProductId();
	}

	public void putUpdateProduct(Integer productId, String name, String description, String image, Integer categoryId) {
		repo.UpAdmPutUpdateProduct(productId, name, description, image, categoryId);
	}

	public void deleteRemoveProduct(Integer productId) {
		repo.UpAdmDeleteRemoveProduct(productId);
	}

	public List<ProductOptionDTO> findProductOptionList() {
		return repo.findProductOptionList();
	}
}