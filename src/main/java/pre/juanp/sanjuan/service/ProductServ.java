package pre.juanp.sanjuan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pre.juanp.sanjuan.model.Product;
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

	public void updateProductById(Integer id, String name, String description, Integer categoryId) {
		repo.UpUpdateProduct(id, name, description, categoryId);
	}

	public void removeProductById(Integer id) {
		repo.UpRemoveProduct(id);
	}
}