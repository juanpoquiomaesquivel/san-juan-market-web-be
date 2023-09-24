package pre.juanp.sanjuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pre.juanp.sanjuan.model.Segment;

public interface SegmentRepo extends JpaRepository<Segment, String> {

	@Query(value = "SELECT s FROM Segment s WHERE s.name LIKE %:name%")
	public List<Segment> findSegmentsContainingName(@Param("name") String name);
}
