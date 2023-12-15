package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Product;
import pre.juanp.sanjuan.model.dto.ProductFilterDTO;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query(nativeQuery = true)
	public List<ProductFilterDTO> findProductFilterListExcept(@Param("ProductId") Integer productId);
}
