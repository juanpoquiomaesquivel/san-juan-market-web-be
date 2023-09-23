package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRepo extends JpaRepository<pre.juanp.sanjuan.model.Class, String> {

	@Query(value = "SELECT c FROM Class c WHERE c.category.id = :classId")
	public List<pre.juanp.sanjuan.model.Class> getClassesByCategory(@Param("classId") String classId);
	
	@Query(value = "SELECT c FROM Class c WHERE c.family.id = :familyId")
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(@Param("familyId") String familyId);
}
