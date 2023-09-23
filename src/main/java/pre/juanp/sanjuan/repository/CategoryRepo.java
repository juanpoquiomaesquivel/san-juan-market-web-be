package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Category;

public interface CategoryRepo extends JpaRepository<Category, String> {

	@Query(value = "SELECT c FROM Category c WHERE c.name LIKE '%' + :name + '%'")
	public List<Category> getCategoriesByName(@Param("name") String name);
	
	@Procedure(name = "UpInsertCategory")
	public void UpInsertCategory(@Param("name") String name, @Param("description") String description);
}
