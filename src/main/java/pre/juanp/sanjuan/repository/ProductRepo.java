package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import pre.juanp.sanjuan.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query(value = "SELECT p FROM Product p WHERE p.name LIKE %:name%")
	public List<Product> findProductsContainingName(@Param("name") String name);
	
	@Query(value = "SELECT p FROM Product p WHERE p.description LIKE %:description%")
	public List<Product> findProductsContainingDescription(@Param("description") String description);

	@Query(value = "SELECT p FROM Product p WHERE p.code = :Code")
	public Product getProductByCode(@Param("Code") String code);
	
	@Query(value = "SELECT p FROM Product p WHERE p.category.id = :CategoryId")
	public List<Product> getProductsByCategory(@Param("CategoryId") Integer categoryId);
	
	@Procedure(value = "UpAddProduct")
	public void UpAddProduct(@Param("Name") String name, @Nullable @Param("Description") String description, @Nullable @Param("CategoryId") Integer categoryId);
	
	@Procedure(value = "UpUpdateProduct")
	public void UpUpdateProduct(@Param("Id") Integer id, @Param("Name") String name, @Nullable @Param("Description") String description, @Nullable @Param("CategoryId") Integer categoryId);
	
	@Procedure(value = "UpRemoveProduct")
	public void UpRemoveProduct(@Param("Id") Integer id);
}
