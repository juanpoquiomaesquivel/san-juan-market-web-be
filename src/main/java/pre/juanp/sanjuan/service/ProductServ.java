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

	public Product getProductById(String id) {
		return repo.getReferenceById(id);
	}

	public List<Product> getProductsByCategory(String categoryId) {
		return repo.getProductsByCategory(categoryId);
	}
	
	public void saveNewProduct(String name, String description, String categoryId) {
		repo.UpInsertProduct(name, description, categoryId);
	}

	public void updateProductById(String id, String name, String description, String categoryId) {
		repo.UpUpdateProduct(id, name, description, categoryId);
	}

	public void deleteProductById(String id) {
		repo.UpDeleteProduct(id);
	}
}