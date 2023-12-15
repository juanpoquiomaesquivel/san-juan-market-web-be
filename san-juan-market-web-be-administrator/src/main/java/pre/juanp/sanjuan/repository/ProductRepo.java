package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import pre.juanp.sanjuan.model.Product;
import pre.juanp.sanjuan.model.dto.ProductItemDTO;
import pre.juanp.sanjuan.model.dto.ProductOptionDTO;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query(nativeQuery = true)
	public List<ProductItemDTO> findProductItemList();
	
	@Query(value = "SELECT p.categoryId FROM Product p WHERE p.id = :ProductId")
	public Integer findCategoryIdOfProduct(@Param("ProductId") Integer productId);

	@Procedure(value = "UpAdmPostAddProduct")
	public void UpAdmPostAddProduct(@Param("Name") String name, @Param("Description") String description,
			@Param("Image") String image, @Param("CategoryId") Integer categoryId);

	@Query(value = "SELECT MAX(pr.id) FROM Product pr")
	public Integer findLastAddedProductId();

	@Procedure(value = "UpAdmPutUpdateProduct")
	public void UpAdmPutUpdateProduct(@Param("ProductId") Integer productId, @Param("Name") String name,
			@Nullable @Param("Description") String description, @Param("Image") String image,
			@Nullable @Param("CategoryId") Integer categoryId);

	@Procedure(value = "UpAdmDeleteRemoveProduct")
	public void UpAdmDeleteRemoveProduct(@Param("ProductId") Integer productId);

	@Query(nativeQuery = true)
	public List<ProductOptionDTO> findProductOptionList();
}
