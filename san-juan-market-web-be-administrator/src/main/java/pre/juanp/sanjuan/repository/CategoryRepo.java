package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Category;
import pre.juanp.sanjuan.model.dto.CategoryOptionDTO;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Procedure(name = "UpAdmPostAddCategory")
	public void UpAdmPostAddCategory(@Param("Name") String name, @Param("Description") String description,
			@Param("Image") String image);

	@Query(value = "SELECT MAX(ca.id) FROM Category ca")
	public Integer findLastAddedCategoryId();

	@Procedure(name = "UpAdmPutUpdateCategory")
	public void UpAdmPutUpdateCategory(@Param("CategoryId") Integer categoryId, @Param("Name") String name,
			@Param("Description") String description, @Param("Image") String image);

	@Procedure(name = "UpAdmDeleteRemoveCategory")
	public void UpAdmDeleteRemoveCategory(@Param("CategoryId") Integer categoryId);

	@Query(nativeQuery = true)
	public List<CategoryOptionDTO> findCategoryOptionList();
}
