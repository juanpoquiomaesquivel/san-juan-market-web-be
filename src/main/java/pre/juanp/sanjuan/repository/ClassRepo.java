package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface ClassRepo extends JpaRepository<pre.juanp.sanjuan.model.Class, Integer> {

	@Query(value = "SELECT c FROM Class c WHERE c.name LIKE %:Name%")
	public List<pre.juanp.sanjuan.model.Class> findClassesContainingName(@Param("Name") String name);

	@Query(value = "SELECT c FROM Class c WHERE c.code = :Code")
	public pre.juanp.sanjuan.model.Class getClassByCode(@Param("Code") String code);
	
	@Query(value = "SELECT c FROM Class c WHERE c.family.id = :FamilyId")
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(@Param("FamilyId") Integer familyId);

	@Query(value = "SELECT c FROM Class c WHERE c.category.id = :CategoryId")
	public List<pre.juanp.sanjuan.model.Class> getClassTagsForCategory(@Param("CategoryId") Integer categoryId);
	
	@Procedure(name = "UpAddClassTagForCategory")
	public void UpAddClassTagForCategory(@Param("Id") Integer id, @Param("CategoryId") Integer categoryId);
	
	@Procedure(name = "UpRemoveClassTagForCategory")
	public void UpRemoveClassTagForCategory(@Param("Id") Integer id);
}
