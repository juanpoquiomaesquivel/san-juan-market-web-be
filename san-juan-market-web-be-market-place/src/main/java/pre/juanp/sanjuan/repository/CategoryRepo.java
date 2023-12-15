package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Category;
import pre.juanp.sanjuan.model.dto.CategoryFilterDTO;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Query(nativeQuery = true)
	public List<CategoryFilterDTO> findCategoryFilterListExcept(@Param("CategoryId") Integer categoryId);
}
