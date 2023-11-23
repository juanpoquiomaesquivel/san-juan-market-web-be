package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.dto.administrator.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.administrator.ClassOptionGroupDTO;

public interface ClassRepo extends JpaRepository<pre.juanp.sanjuan.model.Class, Integer> {

	@Query(value = "SELECT c FROM Class c WHERE c.name LIKE %:Name%")
	public List<pre.juanp.sanjuan.model.Class> findClassesContainingName(@Param("Name") String name);

	@Query(value = "SELECT c FROM Class c WHERE c.code = :Code")
	public pre.juanp.sanjuan.model.Class getClassByCode(@Param("Code") String code);

	@Query(value = "SELECT * FROM [Class] Cl WHERE Cl.[FamilyId] = :FamilyId", nativeQuery = true)
	public List<pre.juanp.sanjuan.model.Class> getClassesByFamily(@Param("FamilyId") Integer familyId);

	@Query(value = "SELECT c.id FROM Class c WHERE c.categoryId = :CategoryId")
	public List<Integer> getClassTagsForCategory(@Param("CategoryId") Integer categoryId);
	
	@Query(nativeQuery = true)
	public List<ClassOptionDTO> getCurrentClassTagOptionsForCategory(@Param("CategoryId") Integer categoryId);

	@Query(nativeQuery = true)
	public List<ClassOptionDTO> UpGetAvailableClassOptionList();

	@Procedure(name = "UpAddClassTagForCategory")
	public void UpAddClassTagForCategory(@Param("JsonArrayId") String jsonArrayId,
			@Param("CategoryId") Integer categoryId);

	@Procedure(name = "UpRemoveClassTagForCategory")
	public void UpRemoveClassTagForCategory(@Param("JsonArrayId") String jsonArrayId);
	
	
	@Query(nativeQuery = true)
	public List<ClassOptionGroupDTO> getClassOptionGroupList(@Param("CategoryId") Integer categoryId);
}
