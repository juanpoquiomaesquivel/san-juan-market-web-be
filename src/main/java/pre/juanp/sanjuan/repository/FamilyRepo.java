package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Family;

public interface FamilyRepo extends JpaRepository<Family, String> {

	@Query(value = "SELECT f FROM Family f WHERE f.name LIKE %:name%")
	public List<Family> findFamiliesContainingName(@Param("name") String name);

	@Query(value = "SELECT f FROM Family f WHERE f.segment.id = :segmentId")
	public List<Family> getFamiliesBySegment(@Param("segmentId") String segmentId);
}
