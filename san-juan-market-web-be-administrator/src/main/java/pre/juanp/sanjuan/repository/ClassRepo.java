package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.dto.ClassOptionDTO;
import pre.juanp.sanjuan.model.dto.ClassOptionGroupDTO;

public interface ClassRepo extends JpaRepository<pre.juanp.sanjuan.model.Class, Integer> {

	@Query(nativeQuery = true)
	public List<ClassOptionDTO> UpAdmGetFindAvailableClassOptionList();
	
	@Query(nativeQuery = true)
	public List<ClassOptionDTO> findUnavailableClassOptionList();

	@Query(value = "SELECT c.id FROM Class c WHERE c.categoryId = :CategoryId")
	public List<Integer> findClassTagListOfCategory(@Param("CategoryId") Integer categoryId);

	@Procedure(name = "UpAdmPutAddClassTagForCategory")
	public void UpAdmPutAddClassTagForCategory(@Param("JsonClassTagIdArray") String jsonClassTagIdArray,
			@Param("CategoryId") Integer categoryId);

	@Procedure(name = "UpAdmPutRemoveClassTagForCategory")
	public void UpAdmPutRemoveClassTagForCategory(@Param("JsonClassTagIdArray") String jsonClassTagIdArray);
	
	@Query(nativeQuery = true)
	public List<ClassOptionGroupDTO> findClassOptionGroupListOfCategory(@Param("CategoryId") Integer categoryId);
}
