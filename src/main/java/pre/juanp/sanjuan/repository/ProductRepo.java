package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import pre.juanp.sanjuan.model.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
	
	@Query(value = "SELECT p FROM Product p WHERE p.name LIKE %:name%")
	public List<Product> findProductsContainingName(@Param("name") String name);
	
	@Query(value = "SELECT p FROM Product p WHERE p.description LIKE %:description%")
	public List<Product> findProductsContainingDescription(@Param("description") String description);
	
	@Query(value = "SELECT p FROM Product p WHERE p.category.id = :categoryId")
	public List<Product> getProductsByCategory(@Param("categoryId") String categoryId);
	
	@Procedure(value = "UpInsertProduct")
	public void UpInsertProduct(@Param("name") String name, @Nullable @Param("description") String description, @Nullable @Param("categoryId") String categoryId);
	
	@Procedure(value = "UpUpdateProduct")
	public void UpUpdateProduct(@Param("id") String id, @Param("name") String name, @Nullable @Param("description") String description, @Nullable @Param("categoryId") String categoryId);
	
	@Procedure(value = "UpDeleteProduct")
	public void UpDeleteProduct(@Param("id") String id);
}
