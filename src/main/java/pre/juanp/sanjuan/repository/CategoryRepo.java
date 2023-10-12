package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import pre.juanp.sanjuan.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT ca FROM Category ca WHERE ca.name LIKE %:name%")
	public List<Category> findCategoriesContainingName(@Param("name") String name);

	@Query(value = "SELECT ca FROM Category ca WHERE ca.description LIKE %:Description%")
	public List<Category> findCategoriesContainingDescription(@Param("Description") String description);

	@Query(value = "SELECT ca FROM Category ca WHERE ca.code = :Code")
	public Category getCategoryByCode(@Param("Code") String code);

	@Procedure(name = "UpAddCategory")
	public void UpAddCategory(@Param("Name") String name, @Nullable @Param("Description") String description);

	@Procedure(name = "UpUpdateCategory")
	public void UpUpdateCategory(@Param("Id") Integer id, @Param("Name") String name,
			@Nullable @Param("Description") String description);

	@Procedure(name = "UpRemoveCategory")
	public void UpRemoveCategory(@Param("Id") Integer id);
}
