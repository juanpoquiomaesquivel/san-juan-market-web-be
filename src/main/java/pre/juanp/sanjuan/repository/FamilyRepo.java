package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Family;

public interface FamilyRepo extends JpaRepository<Family, Integer> {

	@Query(value = "SELECT f FROM Family f WHERE f.name LIKE %:Name%")
	public List<Family> findFamiliesContainingName(@Param("Name") String name);
	
	@Query(value = "SELECT f FROM Family f WHERE f.code = :Code")
	public Family getFamilyByCode(@Param("Code") String code);

	@Query(value = "SELECT f FROM Family f WHERE f.segment.id = :SegmentId")
	public List<Family> getFamiliesBySegment(@Param("SegmentId") Integer segmentId);
}
