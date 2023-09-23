package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import pre.juanp.sanjuan.model.Category;

public interface CategoryRepo extends JpaRepository<Category, String> {

	@Query(value = "SELECT ca FROM Category ca WHERE ca.name LIKE '%' + :name + '%'")
	public List<Category> getCategoriesByName(@Param("name") String name);

	@Procedure(name = "UpInsertCategory")
	public void UpInsertCategory(@Param("name") String name, @Nullable @Param("description") String description);

	@Procedure(name = "UpUpdateCategory")
	public void UpUpdateCategory(@Param("id") String id, @Param("name") String name,
			@Nullable @Param("description") String description);

	@Procedure(name = "UpDeleteCategory")
	public void UpDeleteCategory(@Param("id") String id);
}
