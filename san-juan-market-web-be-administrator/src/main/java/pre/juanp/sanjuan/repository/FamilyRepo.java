package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pre.juanp.sanjuan.model.Family;
import pre.juanp.sanjuan.model.dto.FamilyOptionGroupDTO;

public interface FamilyRepo extends JpaRepository<Family, Integer> {

	@Query(nativeQuery = true)
	public List<FamilyOptionGroupDTO> UpAdmGetFindFamilyOptionGroupList();
}
