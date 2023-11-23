package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Product;
import pre.juanp.sanjuan.model.dto.ProductFilterDTO;
import pre.juanp.sanjuan.model.dto.administrator.ProductOptionDTO;
import pre.juanp.sanjuan.repository.ProductRepo;

@Service
public class ProductServ {

	@Autowired
	private ProductRepo repo;

	public List<Product> findAllProducts() {
		return repo.findAll();
	}

	public List<Product> findProductsContainingName(String name) {
		return repo.findProductsContainingName(name);
	}

	public List<Product> findProductsContainingDescription(String description) {
		return repo.findProductsContainingDescription(description);
	}

	public Product getProductByCode(String code) {
		return repo.getProductByCode(code);
	}

	public List<Product> getProductsByCategory(Integer categoryId) {
		return repo.getProductsByCategory(categoryId);
	}

	public void addProduct(String name, String description, Integer categoryId) {
		repo.UpAddProduct(name, description, categoryId);
	}

	public Integer getLastAddedProductId() {
		return repo.getLastAddedProductId();
	}

	public void updateProductById(Integer productId, String name, String description, Integer categoryId) {
		repo.UpUpdateProduct(productId, name, description, categoryId);
	}

	public void removeProductById(Integer productId) {
		repo.UpRemoveProduct(productId);
	}

	// dto

	public List<ProductFilterDTO> findAllProductFilters(Integer id) {
		return repo.findAllProductFilters(id);
	}
	
	public List<ProductOptionDTO> getProductOptionList() {
		return repo.getProductOptionList();
	}
}