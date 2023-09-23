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

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductById(String id) {
		return repo.getReferenceById(id);
	}

	public List<Product> getProductsByName(String name) {
		return repo.getProductsByName(name);
	}

	public List<Product> getProductsByCategory(String category) {
		return repo.getProductsByCategory(category);
	}
}