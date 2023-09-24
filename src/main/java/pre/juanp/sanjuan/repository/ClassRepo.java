package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface ClassRepo extends JpaRepository<pre.juanp.sanjuan.model.Class, String> {

	@Query(value = "SELECT c FROM Class c WHERE c.name LIKE %:name%")
	public List<pre.juanp.sanjuan.model.Class> findClassesContainingName(@Param("name") String name);
	
	@Query(value = "SELECT c FROM Class c WHERE c.family.id = :familyId")
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(@Param("familyId") String familyId);

	@Query(value = "SELECT c FROM Class c WHERE c.category.id = :categoryId")
	public List<pre.juanp.sanjuan.model.Class> getClassTagsForCategory(@Param("categoryId") String categoryId);
	
	@Procedure(name = "UpAddClassTagForCategory")
	public void UpAddClassTagForCategory(@Param("id") String id, @Param("categoryId") String categoryId);
	
	@Procedure(name = "UpRemoveClassTagForCategory")
	public void UpRemoveClassTagForCategory(@Param("id") String id);
}
